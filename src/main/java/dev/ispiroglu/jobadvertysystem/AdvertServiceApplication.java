package dev.ispiroglu.jobadvertysystem;

// import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(exclude = LiquibaseAutoConfiguration.class)
public class AdvertServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(AdvertServiceApplication.class, args);
  }

//  @Bean
//  Faker faker() {
//    return new Faker();
//  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  
}
