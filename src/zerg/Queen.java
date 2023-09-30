package zerg;

import unit.AirUnit;
import unit.Attackable;
import unit.Unit;

public class Queen extends AirUnit {

    public Queen() {
        super("Queen", 25, 15);
    }

    @Override
    public void attack(Attackable unit) {
        Unit enemy = (Unit) unit;
        int curHP = enemy.getHP() - super.getAD();
        enemy.setHP(curHP);
    }

}
