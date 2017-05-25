package MVPGame.events.battle;

import MVPGame.entities.Entity;
import MVPGame.entities.fightInterface.Fight;

/**
 * Created by nazwa on 2017-05-21.
 */
public class BattleInitiator {
    private Entity e1;
    private Entity e2;

    public BattleInitiator(Entity e1, Entity e2){
        if(e1.getFightingInterface() instanceof Fight && e2.getFightingInterface() instanceof Fight){
            this.e1 = e1;
            this.e2 = e2;
        }
    }

    public void initiateBattle(){
        if(e1!=null && e2!=null){
            executeBattle(new Battle(this));
        }else{
            System.out.println("You can't attack this entity");
        }
    }

    private void executeBattle(Battle battle){
        battle.resolveBattle();
    }

    public Entity getE1() {
        return e1;
    }

    public Entity getE2() {
        return e2;
    }
}
