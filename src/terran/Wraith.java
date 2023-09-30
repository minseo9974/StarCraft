package terran;

import unit.AirUnit;
import unit.Attackable;
import unit.Unit;

public class Wraith extends AirUnit {

    public Wraith() {
        super("Wraith", 10, 3);
    }

    @Override
    public void attack(Attackable unit) {
        Unit enemy = (Unit) unit;
        int curHP = enemy.getHP() - super.getAD();
        enemy.setHP(curHP);
    }
}
