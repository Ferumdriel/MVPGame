package MVPGame.entities;

import MVPGame.entities.fightInterface.Fight;
import MVPGame.entities.fightInterface.FightingInterface;
import MVPGame.events.battle.battleActions.Hit;

/**
 * Created by nazwa on 2017-05-17.
 */
public abstract class Entity {
    private int health;
    private int maxHealth;
    private String name;
    private FightingInterface fightingInterface; //Fighter by default

    public Entity(){
        name = getClass().getSimpleName();
        maxHealth = 100;
        health = maxHealth;
        fightingInterface = new Fight();
    }

//    public Entity(String name, int health){
//        this.name = name;
//        maxHealth = health;
//        this.health = maxHealth;
//        fightingInterface = new Fight();
//    }

    public int hitEntity(Entity e){
        int dmgDone = resolveHit();
        e.setHealth(e.getHealth() - dmgDone);
        return dmgDone;
    }

    public int resolveHit(){
        FightingInterface currentInterface = getFightingInterface();
        int hit = currentInterface.fight();
        if(currentInterface instanceof Fight) {
            System.out.println(getName() + " hit for: " + hit);
        }
        return hit;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive(){
        return health > 0;
    }

    public FightingInterface getFightingInterface() {
        return fightingInterface;
    }

    public void setFightingInterface(FightingInterface fightingInterface) {
        this.fightingInterface = fightingInterface;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setStartingHealth(int health){
        this.maxHealth = health;
        this.health = maxHealth;
    }
}
