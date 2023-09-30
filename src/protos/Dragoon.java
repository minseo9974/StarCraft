package protos;

import unit.Attackable;
import unit.GroundUnit;
import unit.Unit;

public class Dragoon extends GroundUnit {

    public Dragoon() {
        super("Dragoon", 15, 3);
    }

    @Override
    public void attack(Attackable unit) {
        Unit enemy = (Unit) unit;
        int curHP = enemy.getHP() - super.getAD();
        enemy.setHP(curHP);
    }
}
