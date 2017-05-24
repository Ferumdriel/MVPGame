package MVPGame.entities;

import MVPGame.entities.fightInterface.Fight;
import MVPGame.entities.fightInterface.FightingInterface;
import MVPGame.entities.fightInterface.NotFight;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by nazwa on 2017-05-17.
 */
public abstract class Entity {
    private int health;
    private int maxHealth;
    private String name;
    private FightingInterface fightingInterface; //Fighter by default


    public Entity(String name, int health){
        this.name = name;
        maxHealth = health;
        this.health = maxHealth;
        fightingInterface = new Fight();

    }

    public abstract int resolveFight();

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive(){
        return health > 0;
    }



    public void setHealth(int health) {
        this.health = health;
    }

    public String toString(){
        return name + ", health: " + health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    @XmlElements({
            @XmlElement(type=NotFight.class),
            @XmlElement(type=Fight.class)
            })
    public FightingInterface getFightingInterface() {
        return fightingInterface;
    }

    public void setFightingInterface(FightingInterface fightingInterface) {
        this.fightingInterface = fightingInterface;
    }

    public void setName(String name) {
        this.name = name;
    }
}
