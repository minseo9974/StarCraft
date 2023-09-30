package protos;

import unit.AirUnit;
import unit.Attackable;
import unit.GroundUnit;
import unit.Unit;

public class Corsair extends AirUnit {

    public Corsair() {
        super("Corsair", 12, 4);
    }

    /**
     * 커세어는 지상 유닛 공격 못함
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
