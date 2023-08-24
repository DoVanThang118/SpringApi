package winho.springapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class GirlFriend {

    @Autowired
    @Qualifier("dress")
    public Outfit outfit;

    public GirlFriend(){
//        this.outfit = new Dress();
    }

    public GirlFriend(Outfit outfit) {
        this.outfit = outfit;
    }

    public Outfit getOutfit() {
        return outfit;
    }

    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }
}
