package MVPGame.game.states;

import MVPGame.entities.Entity;
import MVPGame.entities.creatures.Creature;
import MVPGame.entities.player.Player;
import MVPGame.events.battle.BattleInitiator;
import MVPGame.game.Game;

import java.util.Random;
import java.util.Scanner;



/**
 * Created by 20305 on 25.05.2017.
 */
public class WorldState implements StateInterface{
    private Game game;
    private boolean finished;

    public WorldState(Game game){
        this.game = game;
    }

    private void pickEvent(Player player){
        String tmp = listenToPlayer();
        if(tmp.equals(PlayerChoice.HEAL.value)) {
            healPlayer(player);
        }else if(tmp.equals(PlayerChoice.FIGHT.value)) {
            if(player.isAlive()) {
                findBattle(player);
            }else{
                System.out.println("You can't fight now. You have to heal first");
            }
        }else if (tmp.equals(PlayerChoice.SAVE.value)){
            player.savePlayer();
        }else if (tmp.equals(PlayerChoice.EXIT.value)){
            finished = true;
            System.out.println("Game has ended.");
        }
    }

    private void healPlayer(Player player){
        player.setHealth(player.getMaxHealth());
        System.out.println("Player fully healed");
        System.out.println(player);
    }
    private void findBattle(Player player){
        Random r = new Random();
        Entity creature = new Creature("Hiena Cmentarna", 100);
        BattleInitiator battleInitiator = new BattleInitiator(player, creature);
        battleInitiator.initiateBattle();
    }

    private String listenToPlayer(){
        Scanner sc = new Scanner(System.in);
        displayOptions();
        return sc.nextLine();
    }

    private void displayOptions(){
        System.out.println("Choose action:");
        System.out.println("1. Heal");
        System.out.println("2. Fight");
        System.out.println("3. Save");
        System.out.println("4. Exit");
    }

    public void run() {
        pickEvent(game.getPlayer());
    }

    public boolean isFinished() {
        return finished;
    }

    private enum PlayerChoice{
        HEAL ("1"),
        FIGHT ("2"),
        SAVE ("3"),
        EXIT("4");

        private String value;

        private PlayerChoice(String value){
            this.value = value;
        }

        public String toString(){
            return value;
        }

    }
}
