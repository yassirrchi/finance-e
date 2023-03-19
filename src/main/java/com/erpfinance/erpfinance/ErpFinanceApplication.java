package com.erpfinance.erpfinance;

import com.erpfinance.erpfinance.Entities.UserAndRoles.User;
import com.erpfinance.erpfinance.Entities.Wallet;
import com.erpfinance.erpfinance.Repositories.UserRepository;
import com.erpfinance.erpfinance.Repositories.WalletRepository;
import com.erpfinance.erpfinance.Services.UserServicesImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ErpFinanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpFinanceApplication.class, args);


	}
	@Bean
	CommandLineRunner init(UserRepository userRepository, UserServicesImpl userServices, WalletRepository walletRepository){

		return args -> {
			User user=new User();
			user.setUsername("yassir");
			user.setPassword("123");


			Wallet portefeuille=new Wallet();
			portefeuille.setCode("CDG_BDT");
			portefeuille.setName("CDG_BDT_NAME");
			portefeuille.setExternal_code("MA787493");
			portefeuille.setActive(false);

			walletRepository.save(portefeuille);
			userRepository.save(user);



		};


	}

}
