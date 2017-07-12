package MVPGame.entities.player;

import MVPGame.entities.Entity;
import MVPGame.parser.json.CreateJsonFromObject;
import MVPGame.parser.json.CreatePlayerFromJson;
import MVPGame.parser.xml.CreateXmlFromObject;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by nazwa on 2017-05-17.
 */
@XmlRootElement(name="player")
public class Player extends Entity {
    public static final int healthGain = 50;

//    private int exp;
//    private int level;
//    private int[] expRange = {0,100,200,300,400,500,600};
    private Level currentLevel;

    public Player(String name, int health){
        setName(name);
        setHealth(health);
//        exp = 0;
//        level = 1;
        currentLevel = new Level();
    }

    public void addExp(int newExp){
        Level tmpLevel = currentLevel.copy();
        currentLevel.addExp(newExp);
        int levelDiff = currentLevel.getLevel() - tmpLevel.getLevel();
        for(int i = 0; i < levelDiff; i++){
            addStatsFromLevelUp();
        }
    }

    private void addStatsFromLevelUp(){
        setMaxHealth(getMaxHealth() + healthGain);
        setHealth(getMaxHealth());
    }

    public void savePlayer(){
        CreateJsonFromObject.create(this,getName());
        System.out.println("Player saved.");
    }

    public static Player loadPlayer(String name){
        Player tmp = CreatePlayerFromJson.create(name);
        if(tmp==null || !tmp.areAllAttributesInstantiated()){
            tmp = null;
        }
        return tmp;
    }

    private boolean areAllAttributesInstantiated(){
        boolean attInstant;
        try{
            attInstant = getName()!=null && getMaxHealth()!=0 && currentLevel!=null;
        }catch(NullPointerException e){
            e.printStackTrace();
            return false;
        }
        return attInstant;
    }

//    @Override
//    public int resolveHit() {
//        int hit = getFightingInterface().fight();
//        System.out.println(getName() + " hit for: " + hit);
//        return hit;
//    }

    public static int getHealthGain() {
        return healthGain;
    }


    public Level getCurrentLevel() {
        return currentLevel;
    }
}
