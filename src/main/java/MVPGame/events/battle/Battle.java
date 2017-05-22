package MVPGame.events.battle;

import MVPGame.entities.Entity;
import MVPGame.entities.player.Player;

/**
 * Created by nazwa on 2017-05-20.
 */
public class Battle {
    private Entity e1;
    private Entity e2;

    public Battle(BattleInitiator battleInitiator){
        this.e1 = battleInitiator.getE1();
        this.e2 = battleInitiator.getE2();
    }

    public void resolveBattle(){
        int k = 1;
        while(areBothPlayersAlive()){
            System.out.println("-------ROUND " + k++ + " -------");
            if(areBothPlayersAlive()) {
               hitPlayer(e1,e2);
            }
            if(areBothPlayersAlive()) {
                hitPlayer(e2,e1);
            }
            printPlayersHealth();
        }
        announceWinner();
        addExpToWinner();
    }

    private void printPlayersHealth(){
        System.out.println("-------STATS AFTER ROUND-------");
        System.out.println(e1);
        System.out.println(e2);
    }

    private void addExpToWinner(){
        if(findWinner() instanceof Player){
            Player tmp = (Player) findWinner();
            tmp.addExp(findLoser().getMaxHealth()/2);
        }
    }

    private Entity findWinner(){
        if(e1.isAlive()) return e1;
        else return e2;
    }

    private Entity findLoser(){
        if(e1.isAlive()) return e2;
        else return e1;
    }

    private void announceWinner(){
        Entity e;
        if(e1.isAlive()){e = e1;}
        else{e = e2;}
        System.out.println(e.getName() + " is a winner.");
    }

    public boolean areBothPlayersAlive(){
        return e1.isAlive() && e2.isAlive();
    }

    private void hitPlayer(Entity e1, Entity e2){
        e1.setHealth(e1.getHealth() - e2.resolveFight());
    }

}
