package unit;

public class Unit implements Attackable {
    private int HP;
    private int AD;
    private String name;


    public Unit(String name, int hp, int ad) {
        this.HP = hp;
        this.AD = ad;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public int getAD() {
        return AD;
    }

    public void setHP(int hP) {
        HP = hP;
    }

    public String toString() {
        return name + " [공격력 : " + this.AD + " , 현재 HP : " + this.HP + " ]";
    }

    @Override
    public void attack(Attackable unit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attack'");
    }

}
