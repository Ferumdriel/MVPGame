package MVPGame.entities;

/**
 * Created by 20305 on 24.06.2017.
 */
public class ExtraActions {

    public static void healUnit(Entity e){
        e.setHealth(e.getMaxHealth());
        System.out.println(e.getClass().getSimpleName() + " fully healed.");
        System.out.println(e);
    }
}
