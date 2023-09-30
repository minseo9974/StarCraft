package unit;

public interface Attackable {
    /**
     * parameter로 가져온 유닛의 HP와 공격 시행 유닛의 AD를 뺀다.
     * 
     * HP - AD 가 0 이하라면 유닛 소멸 precondition : null값이 들어오면안됨.
     * 
     * 날 수 있는 유닛은 날 수 있는 유닛과 날 수 없는 유닛 모두를 공격할 수 있습니다.
     * 
     * 날 수 없는 유닛은 날 수 있는 유닛을 공격할 수 없습니다.
     * 
     * 미사일, 레이저 포 또는 침을 가진 유닛은 날 수 있는 유닛을 공격할 수 있습니다.
     * 
     * @param unit 공격대상
     */
    void attack(Attackable unit);
}
