package MVPGame.events.battle;

import MVPGame.entities.Entity;
import MVPGame.entities.fightInterface.Fight;

import java.util.Scanner;

/**
 * Created by nazwa on 2017-05-21.
 */
public class BattleInitiator {
    private Entity player; //player
    private Entity enemy; //enemy
    enum battleType {AUTO, MANUAL}


    public BattleInitiator(Entity player, Entity enemy){
        if(player.getFightingInterface() instanceof Fight && enemy.getFightingInterface() instanceof Fight){
            this.player = player;
            this.enemy = enemy;
        }
    }

    public void initiateBattle(){
        if(player !=null && enemy !=null){
            System.out.println("Pick fight type: \n1. Manual \n2. Auto");
            Scanner sc = new Scanner(System.in);
            executeBattle(pickBattleType(sc.nextInt()));
        }else{
            System.out.println("You can't attack this entity");
        }
    }

    public BattleType pickBattleType(int battleType){
        BattleType type;
        if(battleType == 1){
            type = new ManualBattle();
        }else{
            type = new AutoBattle();
        }
        return type;
    }

    void executeBattle(BattleType type){
        Battle battle = new Battle(this, type);
        battle.resolveBattle();
    }

    public Entity getPlayer() {
        return player;
    }

    public Entity getEnemy() {
        return enemy;
    }
}
