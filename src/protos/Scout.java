package protos;

import unit.AirUnit;
import unit.Attackable;
import unit.Unit;

public class Scout extends AirUnit {

    public Scout() {
        super("Scout", 10, 5);
    }

    @Override
    public void attack(Attackable unit) {
        Unit enemy = (Unit) unit;
        int curHP = enemy.getHP() - super.getAD();
        enemy.setHP(curHP);
    }
}
