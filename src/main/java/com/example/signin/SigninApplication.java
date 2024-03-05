// package com.example.signin;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class SigninApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(SigninApplication.class, args);
// 	}

// }
package com.example.signin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "App Title", version = "1.1.2", description = "App Description", contact = @Contact(name = "Author Name", email = "Author Email")))
@SpringBootApplication
public class SigninApplication {

	public static void main(String[] args) {
		SpringApplication.run(SigninApplication.class, args);
	}

}