package MVPGame.battle;

import MVPGame.entities.creatures.Creature;
import MVPGame.entities.Entity;
import MVPGame.entities.creatures.NpcFriendly;
import MVPGame.entities.player.Player;
import MVPGame.events.battle.Battle;
import MVPGame.events.battle.BattleInitiator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by nazwa on 2017-05-21.
 */
public class BattleInitiatorTest {
    private Entity player;
    private Entity creature;
    private Battle battle;
    private BattleInitiator battleInitiator;

    @Before
    public void setUp(){
        player = new Player("Player", 100);
        creature = new Creature();
        battleInitiator = new BattleInitiator(player,creature);
    }

    @Test
    public void whenInstantiatedAndBothPlayersAreFightersThenNewBattleIsSet(){
        assertNotNull(battleInitiator.getBattle());
    }

    @Test
    public void whenInstantiatedAndAtLeastOnePlayerIsNotAFighterThenBattleIsNotSet(){
        Entity pacifistCreature = new NpcFriendly();
        BattleInitiator pacifistBattle = new BattleInitiator(player, pacifistCreature);
        assertNull(pacifistBattle.getBattle());
    }
}