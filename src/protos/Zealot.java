package protos;

import unit.AirUnit;
import unit.Attackable;
import unit.GroundUnit;
import unit.Unit;

public class Zealot extends GroundUnit {

    public Zealot() {
        super("Zealot", 20, 5);
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
