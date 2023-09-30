package zerg;

import unit.AirUnit;
import unit.Attackable;
import unit.Unit;

public class Mutalisk extends AirUnit {

    public Mutalisk() {
        super("Mutalisk", 8, 2);
    }

    @Override
    public void attack(Attackable unit) {
        Unit enemy = (Unit) unit;
        int curHP = enemy.getHP() - super.getAD();
        enemy.setHP(curHP);
    }
}
