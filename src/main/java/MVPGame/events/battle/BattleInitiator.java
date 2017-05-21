package MVPGame.events.battle;

import MVPGame.entities.Entity;
import MVPGame.entities.fightInterface.Fight;

/**
 * Created by nazwa on 2017-05-21.
 */
public class BattleInitiator {
    private Entity e1;
    private Entity e2;
    Battle battle;

    public BattleInitiator(Entity e1, Entity e2){
        if(e1.getFightingInterface() instanceof Fight && e2.getFightingInterface() instanceof Fight){
            this.e1 = e1;
            this.e2 = e2;
            battle = new Battle(this);
            executeBattle();
        }else{
            System.out.println("You can't attack this entity");
        }
    }

    private void executeBattle(){
        battle.resolveBattle();
    }

    public Entity getE1() {
        return e1;
    }

    public Entity getE2() {
        return e2;
    }

    public Battle getBattle() {
        return battle;
    }
}
