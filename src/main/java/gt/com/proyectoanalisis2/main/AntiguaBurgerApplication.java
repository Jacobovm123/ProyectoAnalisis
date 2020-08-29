package gt.com.proyectoanalisis2.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 *
 * @author jacob
 */
@SpringBootApplication
@ComponentScan(basePackages = {"gt.com.proyectoanalisis2.controller", "gt.com.proyectoanalisis2.model"})
public class AntiguaBurgerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntiguaBurgerApplication.class, args);
    }

}
