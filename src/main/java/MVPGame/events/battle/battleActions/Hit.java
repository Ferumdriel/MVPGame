package MVPGame.events.battle.battleActions;

import MVPGame.entities.Entity;

/**
 * Created by 20305 on 12.07.2017.
 */
public class Hit extends Action{
    private Entity entityHitting;
    private Entity entityHit;
    private int dmg;

    public Hit(Entity entityHitting, Entity entityHit, int dmg){
        this.entityHit = entityHit;
        this.entityHitting = entityHitting;
        this.dmg = dmg;
    }

    public String toString(){
        return entityHitting + " hit " + entityHit + " for: " + dmg;
    }
}
