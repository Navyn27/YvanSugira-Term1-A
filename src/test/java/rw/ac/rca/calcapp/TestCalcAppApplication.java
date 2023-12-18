package rw.ac.rca.calcapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestCalcAppApplication {

    public static void main(String[] args) {
        SpringApplication.from(CalcAppApplication::main).with(TestCalcAppApplication.class).run(args);
    }

}
