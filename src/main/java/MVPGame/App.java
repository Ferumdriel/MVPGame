package MVPGame;

import MVPGame.events.battle.BattleInitiator;
import MVPGame.entities.Entity;
import MVPGame.entities.creatures.NpcFriendly;
import MVPGame.entities.player.Player;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Entity player = new Player("Player", 100);
        Entity creature = new NpcFriendly("Creature", 100);
        BattleInitiator initiator = new BattleInitiator(player,creature);

    }
}
