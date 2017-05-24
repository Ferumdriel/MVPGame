package MVPGame.entities.fightInterface;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.Random;

/**
 * Created by nazwa on 2017-05-17.
 */
public class Fight implements FightingInterface, InstanceCreator<FightingInterface> {
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

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public FightingInterface createInstance(Type type) {
        return new Fight();
    }
}
