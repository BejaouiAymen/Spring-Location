package org.location;



import org.location.dao.ClientDAO;
import org.location.dao.LogementDAO;
import org.location.entities.Client;
import org.location.entities.Logement;
import org.location.entities.TypeLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;





@SpringBootApplication
public class SpringLocationApplication {
	

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringLocationApplication.class, args);
	
		

		
	}


}

