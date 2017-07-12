package MVPGame.events.battle;

import MVPGame.entities.Entity;
import MVPGame.entities.player.Player;
import MVPGame.events.battle.battleActions.Action;
import MVPGame.events.battle.battleActions.Status;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by nazwa on 2017-05-20.
 */
public class Battle {
    private Entity player;
    private Entity enemy;
    private List<Action> battleLog = new LinkedList<Action>();
    private BattleType battleType;

    public Battle(BattleInitiator battleInitiator, BattleType battleType){
        this.player = battleInitiator.getPlayer();
        this.enemy = battleInitiator.getEnemy();
        this.battleType = battleType;
    }

    public void resolveBattle(){
        int k = 1;
        while(areBothPlayersAlive()){
            System.out.println("-------ROUND " + k++ + " -------");
            resolveRound();
        }
        announceWinner();
        addExpToWinner();
    }

    public void resolveRound(){
        //Player's action
        if(areBothPlayersAlive()){
            performAndAddAction(player,enemy);
        }
        if(areBothPlayersAlive()){
            performAndAddAction(enemy,player);
        }
        addStatuses();
    }

    void performAndAddAction(Entity actionMaker, Entity actionWitness){
        battleLog.add(battleType.performAction(actionMaker, actionWitness));
    }



    void addStatuses(){
        battleLog.add(new Status(player));
        battleLog.add(new Status(enemy));
    }

    protected void printPlayersHealth(){
        System.out.println("-------STATS AFTER ROUND-------");
        System.out.println(player);
        System.out.println(enemy);
    }

    private void addExpToWinner(){
        if(findWinner() instanceof Player){
            Player tmp = (Player) findWinner();
            tmp.addExp(findLoser().getMaxHealth()/2);
        }
    }

    private Entity findWinner(){
        if(player.isAlive()) return player;
        else return enemy;
    }

    private Entity findLoser(){
        if(player.isAlive()) return enemy;
        else return player;
    }

    private void announceWinner(){
        Entity e;
        if(player.isAlive()){e = player;}
        else{e = enemy;}
        System.out.println(e.getName() + " is a winner.");
    }

    public boolean areBothPlayersAlive(){
        return player.isAlive() && enemy.isAlive();
    }

    public Entity getPlayer() {
        return player;
    }

    public Entity getEnemy() {
        return enemy;
    }

    public void setBattleType(BattleType battleType) {
        this.battleType = battleType;
    }

    public void displayLogFights(){
        battleLog.forEach(System.out::println);
    }
}
