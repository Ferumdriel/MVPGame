package MVPGame.entities.fightInterface;

/**
 * Created by nazwa on 2017-05-21.
 */
public class NotFight implements FightingInterface{
    private int dmg;

    public NotFight(){
        dmg = 0;
    }

    public int fight() {
        System.out.println("I don't want to fightInterface.");
        return dmg;
    }
}
