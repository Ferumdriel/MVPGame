package MVPGame.entities.fightInterface;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by nazwa on 2017-05-21.
 */
public class NotFight implements FightingInterface, InstanceCreator<FightingInterface> {
    private int dmg;

    public NotFight(){
        dmg = 0;
    }

    public int fight() {
        System.out.println("I don't want to fightInterface.");
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public FightingInterface createInstance(Type type) {
        return new NotFight();
    }

    public int getDmg() {
        return dmg;
    }
}
