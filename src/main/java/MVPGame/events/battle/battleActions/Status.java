package MVPGame.events.battle.battleActions;

import MVPGame.entities.Entity;

/**
 * Created by 20305 on 12.07.2017.
 */
public class Status extends Action{
    private Entity e1;

    public Status(Entity e1){
        this.e1 = e1;
    }

    public String toString(){
        return e1.toString();
    }
}
