package winho.springapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class SpringApiApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringApiApplication.class, args);

        GirlFriend girlFriend = context.getBean(GirlFriend.class);
        System.out.println("Instance girl friend "+ girlFriend);
        System.out.println("Outfit of girl friend "+ girlFriend.outfit);
    }

}
