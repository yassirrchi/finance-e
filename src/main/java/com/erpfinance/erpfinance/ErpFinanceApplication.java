package com.erpfinance.erpfinance;

import com.erpfinance.erpfinance.Entities.Enumerations.OperationType;
import com.erpfinance.erpfinance.Entities.Enumerations.Status;
import com.erpfinance.erpfinance.Entities.Fund;
import com.erpfinance.erpfinance.Entities.Menu.MenuItem;
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
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class ErpFinanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpFinanceApplication.class, args);


	}
	@Bean
	CommandLineRunner init(MenuRepository menuRepository,ThirdPartyEntityRepository thirdPartyEntityRepository,UserRepository userRepository, UserServicesImpl userServices, WalletRepository walletRepository, FundRepository fundRepository, OperationNoteRepository operationNoteRepository){

		return args -> {
			User user=new User();
			user.setUsername("yassir");
			user.setPassword("123");
			userRepository.save(user);


			Wallet portefeuille=new Wallet();
			portefeuille.setCode("PORTF_TEST");
			portefeuille.setName("PORTF_CODE_TEST");
			portefeuille.setExternal_code("PORTF_EXT_TEST");

			portefeuille.setStatus(Status.DRAFT);
			portefeuille.setActive(false);

			walletRepository.save(portefeuille);
			userRepository.save(user);
			portefeuille=new Wallet();
			portefeuille.setCode("PORTF2_TEST");
			portefeuille.setName("PORTF2_CODE_TEST");
			portefeuille.setExternal_code("PORTF_EXT_TEST");
			portefeuille.setActive(true);
			portefeuille.setStatus(Status.SUBMIT);


			walletRepository.save(portefeuille);
			user=new User();
			user.setUsername("omar");
			user.setPassword("123");
			userRepository.save(user);

			Fund fund=new Fund();
			fund.setActive(false);
			fund.setCode("FOND_TEST");
			fund.setStatus(Status.DRAFT);
			fundRepository.save(fund);
			Fund fund2=new Fund();
			fund2.setActive(true);
			fund2.setCode("FOND2_TEST");
			fund2.setStatus(Status.SUBMIT);
			fundRepository.save(fund2);
			OperationNote operationNote=new OperationNote();
			operationNote.setWallet(portefeuille);
			operationNote.setFund(fund);

			ThirdPartyEntity tp=new ThirdPartyEntity();
			tp.setName("E_TIERS_TEST_1_TYPE_CONTRP");
			tp.setCounterparty(true);

			List<ThirdPartyEntity> op= new ArrayList<>();
			//thirdPartyEntityRepository.save(tp);
			op.add(thirdPartyEntityRepository.save(tp));
			tp=new ThirdPartyEntity();
			tp.setName("E_TIERS_TEST_2_type_deposi_intermed");
			tp.setBank(true);
			tp.setCustodian(true);
			op.add(thirdPartyEntityRepository.save(tp));
			operationNote.setQuantity(20);
			operationNote.setGross_amount(2000);
			operationNote.setPrice(100);

			operationNote.setThirdPartyEntities(op);
			operationNote.setCreatedby(user);
			operationNote.setType(OperationType.BUY_EQUITY);
			operationNote.setStatus(Status.SUBMIT);
			operationNoteRepository.save(operationNote);

			//menu init




			MenuItem menuItem=new MenuItem();
			menuItem.setRoute("/portefeuille");
			menuItem.setPath("autres>portefeuilles");
			menuItem.setName("PorteFeuille");
			menuItem.setActive(true);
			menuRepository.save(menuItem);


			MenuItem menuItem2=new MenuItem();
			menuItem2.setRoute("/operation");
			menuItem2.setPath("Transactions à Placements / Financements à Action à Opérations sur titre");
			menuItem2.setName("Action");
			menuItem2.setActive(true);
			List<MenuItem> menuItems=List.of(menuItem,menuItem2);


			menuRepository.save(menuItem2);

			MenuItem menuItem3=new MenuItem();
			menuItem3.setRoute("/fond");
			menuItem3.setPath("autres>config");
			menuItem3.setName("Fond");
			menuItem3.setActive(true);
			menuItem3.setSubMenu(menuItems);
			menuRepository.save(menuItem3);

			MenuItem menuItem4=new MenuItem();
			menuItem4.setRoute("/");
			menuItem4.setPath("autres>config");
			menuItem4.setName("Dashboard");
			menuItem4.setActive(true);





			menuRepository.save(menuItem4);

			MenuItem menuItem5=new MenuItem();
			menuItem5.setRoute("/tiersa");
			menuItem5.setPath("utres>config");
			menuItem5.setName("Entite Tiers");
			menuItem5.setActive(true);
			menuRepository.save(menuItem5);













		};


	}

}
