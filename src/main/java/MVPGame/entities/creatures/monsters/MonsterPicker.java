package MVPGame.entities.creatures.monsters;

import MVPGame.entities.Entity;
import MVPGame.entities.creatures.NpcHostile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by nazwa on 2017-05-22.
 */
public class MonsterPicker {
    public ArrayList<NpcHostile> monsterList = new ArrayList<NpcHostile>();

    public NpcHostile pickMonster(){
        monsterList.add(new Undertaker());
        monsterList.add(new Wasp());
        monsterList.add(new WitchHag());
        Collections.shuffle(monsterList);

        return monsterList.get(0);
    }

}
