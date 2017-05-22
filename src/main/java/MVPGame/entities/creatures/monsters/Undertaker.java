package MVPGame.entities.creatures.monsters;

import MVPGame.entities.creatures.NpcHostile;
import MVPGame.entities.fightInterface.Fight;
import MVPGame.entities.fightInterface.FightingInterface;

/**
 * Created by nazwa on 2017-05-22.
 */
public class Undertaker extends NpcHostile{

    public Undertaker(){
//        setName(getClass().getSimpleName());
        setStartingHealth(50);
        setFightingInterface(new Fight(20));
    }

//    public Undertaker(String name, int health) {
//        super("Undertaker", 50);
//        setFightingInterface(new Fight(20));
//    }


}
