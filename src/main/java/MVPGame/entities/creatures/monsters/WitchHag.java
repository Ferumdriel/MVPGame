package MVPGame.entities.creatures.monsters;

import MVPGame.entities.creatures.NpcHostile;
import MVPGame.entities.fightInterface.Fight;

/**
 * Created by nazwa on 2017-05-22.
 */
public class WitchHag extends NpcHostile {

    public WitchHag(){
        setStartingHealth(150);
        setFightingInterface(new Fight(8));
    }
}
