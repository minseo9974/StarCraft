package terran;

import unit.Attackable;
import unit.GroundUnit;
import unit.Unit;

public class Goliath extends GroundUnit {

    public Goliath() {
        super("Goliath", 15, 5);
    }

    @Override
    public void attack(Attackable unit) {
        Unit enemy = (Unit) unit;
        int curHP = enemy.getHP() - super.getAD();
        enemy.setHP(curHP);
    }
}
