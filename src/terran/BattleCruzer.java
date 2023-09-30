package terran;

import unit.AirUnit;
import unit.Attackable;
import unit.Unit;

public class BattleCruzer extends AirUnit {

    public BattleCruzer() {
        super("BattleCruzer", 30, 20);
    }

    @Override
    public void attack(Attackable unit) {
        Unit enemy = (Unit) unit;
        int curHP = enemy.getHP() - super.getAD();
        enemy.setHP(curHP);
    }

}
