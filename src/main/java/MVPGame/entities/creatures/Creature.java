package MVPGame.entities.creatures;

import MVPGame.entities.Entity;
import MVPGame.entities.fightInterface.Fight;
import MVPGame.entities.fightInterface.FightingInterface;

/**
 * Created by nazwa on 2017-05-17.
 */
public abstract class Creature extends Entity {

    public Creature(){
//        setName("DefaultCreature");
    }

//    public Creature(String name, int health){
//        super(name,health);
//    }

//    @Override
//    public int resolveHit() {
//        FightingInterface currentInterface = getFightingInterface();
//        int hit = currentInterface.fight();
//        if(currentInterface instanceof Fight) {
//            System.out.println(getName() + " hit for: " + hit);
//        }
//        return hit;
//    }
}
