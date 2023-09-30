package zerg;

import unit.AirUnit;
import unit.Attackable;
import unit.Unit;

public class Guardian extends AirUnit {

    public Guardian() {
        super("Guardian", 6, 3);
    }

    @Override
    public void attack(Attackable unit) {
        Unit enemy = (Unit) unit;
        int curHP = enemy.getHP() - super.getAD();
        enemy.setHP(curHP);
    }
}
