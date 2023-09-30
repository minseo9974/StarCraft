package protos;

import unit.AirUnit;
import unit.Attackable;
import unit.GroundUnit;
import unit.Unit;

public class HighTempler extends GroundUnit {

    public HighTempler() {
        super("HighTempler", 2, 10);
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
