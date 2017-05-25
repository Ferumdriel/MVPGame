package MVPGame.entities.player;

/**
 * Created by 20305 on 25.05.2017.
 */
public class Level {
    private static final int[] expRange = {0,100,200,300,400,500,600};

    private int exp;
    private int expToNextLevel;
    private int level;

    public Level(){
        exp = 0;
        level = 1;
        expToNextLevel = findExpToNextLevel();
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
    }

    private int findExpToNextLevel(){
        return expRange[level];
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public int getExpToNextLevel() {
        return expToNextLevel;
    }

    public Level copy(){
        Level tmp = new Level();
        tmp.exp = this.exp;
        tmp.expToNextLevel = this.expToNextLevel;
        tmp.level = this.level;
        return tmp;
    }





}
