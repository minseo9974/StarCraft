package zerg;

import unit.Attackable;
import unit.GroundUnit;
import unit.Unit;

public class Hydralisk extends GroundUnit {

    public Hydralisk() {
        super("Hydralisk", 7, 3);
    }

    @Override
    public void attack(Attackable unit) {
        Unit enemy = (Unit) unit;
        int curHP = enemy.getHP() - super.getAD();
        enemy.setHP(curHP);
    }
}
