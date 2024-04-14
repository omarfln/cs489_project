package org.example.project.configuration;

import org.example.project.model.*;
import org.example.project.repository.AccountRepository;
import org.example.project.repository.AddressRepository;
import org.example.project.repository.TransactionRepository;
import org.example.project.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;

@Configuration
public class DataSetup {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, AccountRepository accountRepository, TransactionRepository transactionRepository, AddressRepository addressRepository) {
        return args -> {

            Address address1 = new Address();
            address1.setCity("Fairfield");
            address1.setState("IA");
            address1.setStreet("W B Ave");
            address1.setZipCode("52556");
            addressRepository.save(address1);

            Address address2 = new Address();
            address2.setCity("Willowbrook");
            address2.setState("IL");
            address2.setStreet("72nd St.");
            address2.setZipCode("60527");
            addressRepository.save(address2);

            User user1 = new User();
            user1.setUsername("john_doe");
            user1.setPassword("password123");
            user1.setFirstName("John");
            user1.setLastName("Doe");
            user1.setAddress(address1);

            userRepository.save(user1);

            User user2 = new User();
            user2.setUsername("jane_doe");
            user2.setPassword("password456");
            user2.setFirstName("Jane");
            user2.setLastName("Doe");
            user2.setAddress(address2);
            userRepository.save(user2);

            CheckingAccount checkingAccount = new CheckingAccount();
            checkingAccount.setAccountNumber("CHK123");
            checkingAccount.setBalance(new BigDecimal("1500.00"));
            checkingAccount.setUser(user1);
            accountRepository.save(checkingAccount);

            SavingsAccount savingsAccount = new SavingsAccount();
            savingsAccount.setAccountNumber("SAV456");
            savingsAccount.setBalance(new BigDecimal("3000.00"));
            savingsAccount.setUser(user1);
            accountRepository.save(savingsAccount);

            Transaction transaction1 = new Transaction();
            transaction1.setType("DEPOSIT");
            transaction1.setAmount(new BigDecimal("1500.00"));
            transaction1.setAccount(checkingAccount);
            transactionRepository.save(transaction1);

            Transaction transaction2 = new Transaction();
            transaction2.setType("WITHDRAWAL");
            transaction2.setAmount(new BigDecimal("200.00"));
            transaction2.setAccount(savingsAccount);
            transactionRepository.save(transaction2);
        };
    }
}
