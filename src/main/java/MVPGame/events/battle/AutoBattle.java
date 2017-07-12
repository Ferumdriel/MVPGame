package MVPGame.events.battle;

import MVPGame.entities.Entity;
import MVPGame.entities.player.Player;
import MVPGame.events.battle.battleActions.Action;
import MVPGame.events.battle.battleActions.Hit;

/**
 * Created by 20305 on 22.06.2017.
 */
public class AutoBattle implements BattleType{


    public Action performAction(Entity entityHitting, Entity entityHit) {
        int dmgDone = entityHitting.hitEntity(entityHit);
        return new Hit(entityHitting, entityHit, dmgDone);
    }

//    @Override
//    public void resolveRound() {
//
//        //E1 action, assuming E1 is player
//        if(areBothPlayersAlive()) {
//            getPlayer().hitEntity(getEnemy());
//        }
//
//        //E2 action
//        if(areBothPlayersAlive()) {
//            getEnemy().hitEntity(getPlayer());
//        }
//        printPlayersHealth();
//    }
}
