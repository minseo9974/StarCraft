package terran;

import unit.AirUnit;
import unit.Attackable;
import unit.GroundUnit;
import unit.Unit;

public class Valkyrie extends AirUnit {

    public Valkyrie() {
        super("Valkyrie", 12, 4);
    }

    /**
     * 발키리는 지상유닛 공격 못함
     */
    @Override
    public void attack(Attackable unit) {
        if (unit instanceof GroundUnit) {
            throw new IllegalArgumentException("can not attack GroundUnit");
        }
        Unit enemy = (Unit) unit;
        int curHP = enemy.getHP() - super.getAD();
        enemy.setHP(curHP);
    }

}
