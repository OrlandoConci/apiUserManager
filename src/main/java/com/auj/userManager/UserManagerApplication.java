package com.auj.userManager;

import com.auj.userManager.models.Client;
import com.auj.userManager.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserManagerApplication {

	public static void main(String[] args) {SpringApplication.run(UserManagerApplication.class, args);}

    /// Ejecución de la aplicación
    @Bean
    public CommandLineRunner initData(ClientRepository clientRepository) {
        return (args) -> {
            Client client1 = new Client("Guille", "Lopez", "guillelopez@auj.com");
            clientRepository.save(client1);

            Client client2 = new Client("Martha", "Diaz", "marthadiaz@auj.com");
            clientRepository.save(client2);

            Client client3 = new Client("Elsa", "Vega", "elsavega@auj.com");
            clientRepository.save(client3);
        };
    }

}
