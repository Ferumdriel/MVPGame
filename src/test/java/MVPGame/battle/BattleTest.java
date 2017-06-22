package MVPGame.battle;

import MVPGame.entities.creatures.Creature;
import MVPGame.entities.Entity;
import MVPGame.entities.creatures.monsters.MonsterPicker;
import MVPGame.entities.player.Player;
import MVPGame.events.battle.Battle;
import MVPGame.events.battle.BattleInitiator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by nazwa on 2017-05-20.
 */
public class BattleTest {
    private Entity player;
    private Entity creature;
    private Battle battle;
    private BattleInitiator battleInitiator;


    @Before
    public void setUp(){
        player = new Player("Player", 100);
        creature = new MonsterPicker().pickMonster();
        battleInitiator = new BattleInitiator(player,creature);
        battle = new Battle(battleInitiator);
    }

    @Test
    public void whenFightEndsThenOneIsAlive(){
        battle.resolveBattle();
        assertFalse(battle.areBothPlayersAlive());
    }

}