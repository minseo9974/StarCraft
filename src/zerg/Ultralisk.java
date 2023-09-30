package zerg;

import unit.AirUnit;
import unit.Attackable;
import unit.GroundUnit;
import unit.Unit;

public class Ultralisk extends GroundUnit {

    public Ultralisk() {
        super("Ultralisk", 15, 5);
    }

    @Override
    public void attack(Attackable unit) {
        if (unit instanceof AirUnit) {
            throw new IllegalArgumentException("can not attack AirUnit");
        }
        Unit enemy = (Unit) unit;
        int curHP = enemy.getHP() - super.getAD();
        enemy.setHP(curHP);
    }
}
