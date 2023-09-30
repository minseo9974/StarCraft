package terran;

import unit.Attackable;
import unit.GroundUnit;
import unit.Unit;

public class Marine extends GroundUnit {

    public Marine() {
        super("Marine", 10, 3);
    }

    @Override
    public void attack(Attackable unit) {
        Unit enemy = (Unit) unit;
        int curHP = enemy.getHP() - super.getAD();
        enemy.setHP(curHP);
    }


}
