package winho.springapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import winho.springapi.fashion_package.Bikini;

// @ComponentScan("winho.springapi.fashion_package")
//@SpringBootApplication(scanBasePackages = "winho.springapi.fashion_package")
@SpringBootApplication
public class SpringApiApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringApiApplication.class, args);

//        Outfit outfit = context.getBean(Outfit.class);
//        System.out.println("Outfit" + outfit);
//        outfit.wear();
//
//        Bikini bikini = context.getBean(Bikini.class);
//        System.out.println("Bikini" + bikini);
//
//        Dress dress = context.getBean(Dress.class);
//        System.out.println("Dress" + dress);

//        GirlFriend girlFriend = context.getBean(GirlFriend.class);
//        System.out.println("Instance girl friend "+ girlFriend);
//        System.out.println("Outfit of girl friend "+ girlFriend.outfit);
//        girlFriend.outfit.wear();

        Dress dress1 = context.getBean(Dress.class);
        Dress dress2 = context.getBean(Dress.class);

        System.out.println("Dress 1 "+ dress1);
        System.out.println("Dress 2 "+ dress2);
    }

}
