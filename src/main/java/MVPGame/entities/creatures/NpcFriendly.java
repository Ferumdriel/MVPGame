package MVPGame.entities.creatures;

import MVPGame.entities.fightInterface.NotFight;

/**
 * Created by nazwa on 2017-05-21.
 */
public abstract class NpcFriendly extends Creature {

    public NpcFriendly(){
//        setName("DefaultNpcFriendly");
        setFightingInterface(new NotFight());
    }

//    public NpcFriendly(String name, int health) {
//        super(name, health);
//        setFightingInterface(new NotFight());
//    }
}
