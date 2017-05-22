package MVPGame.entities.player;

import MVPGame.entities.Entity;

/**
 * Created by nazwa on 2017-05-17.
 */
public class Player extends Entity {
    public static final int healthGain = 50;

    private int exp;
    private int level;
    private int[] expRange = {0,100,200,300,400,500,600};


    public Player(String name, int health){
        setName(name);
        setHealth(health);
        exp = 0;
        level = 1;
    }

    public void addExp(int newExp){
        System.out.println("Added " + newExp + " exp");
        exp += newExp;
        while(exp >= expRange[level]){
            addLevel();
        }
    }

    private void addLevel(){
        System.out.println("Congratulations you have advanced from level " + level + " to " + (level + 1));
        exp = exp - expRange[level];
        level++;
        setMaxHealth(getMaxHealth() + healthGain);
        setHealth(getMaxHealth());
    }


    @Override
    public int resolveFight() {
        int hit = getFightingInterface().fight();
        System.out.println(getName() + " hit for: " + hit);
        return hit;
    }

    public int getLevel() {
        return level;
    }

    public int[] getExpRange() {
        return expRange;
    }
}
