package MVPGame.events.battle;

import MVPGame.entities.Entity;
import MVPGame.entities.ExtraActions;
import MVPGame.entities.player.Player;
import MVPGame.events.battle.battleActions.Action;
import MVPGame.events.battle.battleActions.Hit;

import java.util.Scanner;

/**
 * Created by 20305 on 22.06.2017.
 */
public class ManualBattle implements BattleType{

    public Action performAction(Entity entityHitting, Entity entityHit) {
        int dmgDone = 0;
        if(entityHitting instanceof Player){
            //actions other than attack
            System.out.println("Choose action:\n1. Heal\n2. Attack");
            if(new Scanner(System.in).nextInt() == 1){
                ExtraActions.healUnit(entityHitting);
            }else{
                dmgDone = entityHitting.hitEntity(entityHit);
            }
        }else {
            dmgDone = entityHitting.hitEntity(entityHit);
        }
        return new Hit(entityHitting, entityHit, dmgDone);
    }
}
