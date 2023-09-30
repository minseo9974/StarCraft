package terran;

import unit.AirUnit;
import unit.Attackable;
import unit.GroundUnit;
import unit.Unit;

public class Tank extends GroundUnit {

    public Tank() {
        super("Tank", 15, 7);
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
