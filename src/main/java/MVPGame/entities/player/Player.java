package MVPGame.entities.player;

import MVPGame.entities.Entity;
import MVPGame.parser.json.CreateJsonFromObject;
import MVPGame.parser.xml.CreateXmlFromObject;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by nazwa on 2017-05-17.
 */
@XmlRootElement(name="player")
public class Player extends Entity {
    public static final int healthGain = 50;

    private int exp;
    private int level;
    private int[] expRange = {0,100,200,300,400,500,600};

    public Player(String name, int health){
        super(name,health);
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

    public void savePlayer(){
        CreateJsonFromObject.create(this,getName());
//        CreateXmlFromObject.create(this,getName());
        System.out.println("Player saved.");
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

    public static int getHealthGain() {
        return healthGain;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExpRange(int[] expRange) {
        this.expRange = expRange;
    }
}
