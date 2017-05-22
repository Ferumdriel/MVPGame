package MVPGame.entities.creatures.monsters;

import MVPGame.entities.creatures.NpcHostile;
import MVPGame.entities.fightInterface.Fight;

/**
 * Created by nazwa on 2017-05-22.
 */
public class Wasp extends NpcHostile{

    public Wasp(){
        setStartingHealth(20);
        setFightingInterface(new Fight(40));
    }
}
