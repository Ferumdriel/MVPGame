package MVPGame.game.states;

import MVPGame.entities.Entity;
import MVPGame.entities.ExtraActions;
import MVPGame.entities.creatures.Creature;
import MVPGame.entities.creatures.monsters.MonsterPicker;
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
    private EventPicker picker;

    public WorldState(Game game){
        this.game = game;
        picker = new EventPicker();
    }

    public void run() {
        picker.pickEvent(game.getPlayer(), picker.listenToPlayer());
    }

    public boolean isFinished() {
        return finished;
    }

/** EVENT PICKER **/
class EventPicker {
    void pickEvent(Player player, int option){
            if(option == PlayerChoice.HEAL.getNumber()) {
                healPlayer(player);
            }else if(option == PlayerChoice.FIGHT.getNumber()) {
                if(player.isAlive()) {
                    findBattle(player);
                }else{
                    System.out.println("You can't fight now. You have to heal first");
                }
            }else if (option == PlayerChoice.SAVE.getNumber()){
                player.savePlayer();
            }else if (option == PlayerChoice.EXIT.getNumber()){
                finished = true;
                System.out.println("Game has ended.");
            }
        }

        private void healPlayer(Player player){
            ExtraActions.healUnit(player);
//            player.setHealth(player.getMaxHealth());
//            System.out.println("Player fully healed");
//            System.out.println(player);
        }
        private void findBattle(Player player){
            Random r = new Random();
            Entity creature = new MonsterPicker().pickMonster();
            BattleInitiator battleInitiator = new BattleInitiator(player, creature);
            battleInitiator.initiateBattle();
        }

        private int listenToPlayer(){
            Scanner sc = new Scanner(System.in);
            displayOptions();
            return sc.nextInt();
        }

        private void displayOptions(){
            System.out.println("Choose action:");
            System.out.println(PlayerChoice.HEAL);
            System.out.println(PlayerChoice.FIGHT);
            System.out.println(PlayerChoice.SAVE);
            System.out.println(PlayerChoice.EXIT);
        }

        public boolean isFinished() {
            return finished;
        }
    }

    EventPicker getPicker() {
        return picker;
    }
}
