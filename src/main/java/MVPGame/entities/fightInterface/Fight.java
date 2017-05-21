package MVPGame.entities.fightInterface;

import java.util.Random;

/**
 * Created by nazwa on 2017-05-17.
 */
public class Fight implements FightingInterface{
    private int dmg;

    public Fight(){
        dmg = 10;
    }

    public Fight(int dmg){
        this.dmg = dmg;
    }





    public int fight() {
        Random r = new Random();
        return r.nextInt(dmg);
    }
}
