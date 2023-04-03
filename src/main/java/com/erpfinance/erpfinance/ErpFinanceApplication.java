package com.erpfinance.erpfinance;

import com.erpfinance.erpfinance.Entities.Enumerations.Status;
import com.erpfinance.erpfinance.Entities.Fund;
import com.erpfinance.erpfinance.Entities.OperationNote;
import com.erpfinance.erpfinance.Entities.ThirdPartyEntity;
import com.erpfinance.erpfinance.Entities.UserAndRoles.User;
import com.erpfinance.erpfinance.Entities.Wallet;
import com.erpfinance.erpfinance.Repositories.*;
import com.erpfinance.erpfinance.Services.UserServicesImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class ErpFinanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpFinanceApplication.class, args);


	}
	@Bean
	CommandLineRunner init(ThirdPartyEntityRepository thirdPartyEntityRepository,UserRepository userRepository, UserServicesImpl userServices, WalletRepository walletRepository, FundRepository fundRepository, OperationNoteRepository operationNoteRepository){

		return args -> {
			User user=new User();
			user.setUsername("yassir");
			user.setPassword("123");
			userRepository.save(user);


			Wallet portefeuille=new Wallet();
			portefeuille.setCode("CDG_BDT");
			portefeuille.setName("CDG_BDT_NAME");
			portefeuille.setExternal_code("MA787493");

			portefeuille.setStatus(Status.DRAFT);
			portefeuille.setActive(false);

			walletRepository.save(portefeuille);
			userRepository.save(user);
			portefeuille=new Wallet();
			portefeuille.setCode("TEST_TEST");
			portefeuille.setName("TEST_NAME");
			portefeuille.setExternal_code("TEST_EXTCODE");
			portefeuille.setActive(true);
			portefeuille.setStatus(Status.SUBMIT);


			walletRepository.save(portefeuille);
			user=new User();
			user.setUsername("omar");
			user.setPassword("123");
			userRepository.save(user);

			Fund fund=new Fund();
			fund.setActive(false);
			fund.setCode("hdjhdjd");
			fund.setStatus(Status.DRAFT);
			fundRepository.save(fund);
			Fund fund2=new Fund();
			fund2.setActive(true);
			fund2.setCode("424sffs");
			fund2.setStatus(Status.SUBMIT);
			fundRepository.save(fund2);
			OperationNote operationNote=new OperationNote();
			operationNote.setWallet(portefeuille);
			operationNote.setFund(fund);

			ThirdPartyEntity tp=new ThirdPartyEntity();
			tp.setName("krrna");
			tp.setCounterparty(true);

			List<ThirdPartyEntity> op= new ArrayList<>();
			//thirdPartyEntityRepository.save(tp);
			op.add(thirdPartyEntityRepository.save(tp));
			tp=new ThirdPartyEntity();
			tp.setName("eeeeeeee");
			tp.setCounterparty(false);
			op.add(thirdPartyEntityRepository.save(tp));
			operationNote.setQuantity(20);
			operationNote.setGross_amount(2000);
			operationNote.setPrice(100);

			operationNote.setThirdPartyEntities(op);
			operationNote.setCreatedby(user);
			operationNoteRepository.save(operationNote);








		};


	}

}
