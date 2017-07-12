package MVPGame.events.battle;

import MVPGame.entities.Entity;
import MVPGame.events.battle.battleActions.Action;
import MVPGame.events.battle.battleActions.Hit;

/**
 * Created by 20305 on 12.07.2017.
 */
public interface BattleType {

    public Action performAction(Entity entityHitting, Entity entityHit);
}
