
import java.util.*;

public class Timing extends TimerTask{

    public void run(){

        Main.userCity.changeYear();
        System.out.println(Main.userCity);

        if(CityGame.endGame){
            this.cancel();
            System.exit(0);
        }

    }

}
