package MVPGame.battle;

import MVPGame.entities.Entity;
import MVPGame.entities.creatures.friendly.Merchant;
import MVPGame.entities.creatures.monsters.MonsterPicker;
import MVPGame.entities.player.Player;
import MVPGame.events.battle.AutoBattle;
import MVPGame.events.battle.BattleInitiator;
import MVPGame.events.battle.ManualBattle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by nazwa on 2017-05-21.
 */
public class BattleInitiatorTest {
    private Entity player;
    private Entity creature;
    private BattleInitiator battleInitiator;

    @Before
    public void setUp(){
        player = new Player("Player", 100);
        creature = new MonsterPicker().pickMonster();
        battleInitiator = new BattleInitiator(player,creature);
    }

    @Test
    public void whenInstantiatedAndBothPlayersAreFightersThenPlayersAreSet(){
        assertNotNull(battleInitiator.getPlayer());
        assertNotNull(battleInitiator.getEnemy());
    }

    @Test
    public void whenInstantiatedAndAtLeastOnePlayerIsNotAFighterThenPlayersAreNotSet(){
        Entity pacifistCreature = new Merchant();
        BattleInitiator pacifistBattle = new BattleInitiator(player, pacifistCreature);
        assertNull(pacifistBattle.getPlayer());
        assertNull(pacifistBattle.getEnemy());
    }

    @Test
    public void whenPlayerPicksNumberOneThenReturnManualBattle(){
        assertTrue(battleInitiator.pickBattleType(1) instanceof ManualBattle);
    }

    @Test
    public void whenPlayerPicksNumberTwoThenReturnAutoBattle(){
        assertTrue(battleInitiator.pickBattleType(2) instanceof AutoBattle);
    }
}