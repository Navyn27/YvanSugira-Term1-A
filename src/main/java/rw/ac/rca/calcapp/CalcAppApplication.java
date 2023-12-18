package rw.ac.rca.calcapp;

import org.springframework.context.annotation.ComponentScan;
import rw.ac.rca.calcapp.services.MathOperator;
import rw.ac.rca.calcapp.servicesImpl.MathOperatorImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@ComponentScan(basePackages = "rw.ac.rca.calcapp")
public class CalcAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(CalcAppApplication.class, args);
    }

    @Bean
    public MathOperator mathOperator() {
        return new MathOperatorImpl();
    }
}
