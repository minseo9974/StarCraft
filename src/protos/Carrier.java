package protos;

import unit.AirUnit;
import unit.Attackable;
import unit.Unit;

public class Carrier extends AirUnit {

    public Carrier() {
        super("Carrier", 40, 25);
    }

    @Override
    public void attack(Attackable unit) {
        Unit enemy = (Unit) unit;
        int curHP = enemy.getHP() - super.getAD();
        enemy.setHP(curHP);
    }


}
