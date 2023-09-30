package game;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import unit.Unit;

public class GameConsol {
    static Scanner sc = new Scanner(System.in);
    final static Random r = new Random();
    final static int ZERO = 0;
    static boolean TURN = true;

    public static void gameService() throws Exception, IllegalArgumentException {
        int userSelect = chooseTribe();
        int cpuSelect = r.nextInt(3);
        List<Unit> userArmy = makeTribeArmy(userSelect);
        List<Unit> cpuArmy = makeTribeArmy(cpuSelect);
        while (true) {
            if (TURN) {
                printTurn(userArmy, userSelect, cpuArmy, cpuSelect);
                System.out.print("공격을 수행할 아군 유닛과 공격할 적군 유닛을 선택하세요: ");
                int attacker = sc.nextInt();
                int targetUnit = sc.nextInt();
                try {
                    System.out.println("-----------------------전투 상황-----------------------");
                    battle(userArmy, attacker, cpuArmy, targetUnit);
                } catch (IllegalArgumentException e) {
                    System.out.println("\n" + e.getMessage());
                }
                isBreak(cpuArmy, targetUnit);
                if (cpuArmy.size() == 0) {
                    break;
                }
                TURN = false;
            } else {
                System.out.println("\n적군이 공격합니다.");
                int attacker = r.nextInt(cpuArmy.size());
                int targetUnit = r.nextInt(userArmy.size());
                try {
                    battle(cpuArmy, attacker, userArmy, targetUnit);
                } catch (IllegalArgumentException e) {
                    System.out.println("\n" + e.getMessage());
                }
                isBreak(userArmy, targetUnit);
                if (userArmy.size() == 0) {
                    printTurn(userArmy, userSelect, cpuArmy, cpuSelect);
                    break;
                }
                System.out.println("-----------------------전투 상황-----------------------");
                TURN = true;
            }
        }
        String result = userArmy.size() == ZERO ? "\nYOU LOSE" : "\nYOU WIN";
        System.out.println(result);


    }

    /**
     * 유닛의 인덱스를 가져와 해당 유닛의 체력이 0이하로 떨어지면 소멸시킴과 파괴 메시지 생성.
     * 
     * @param unit 유저의 종족인지 cpu종족인지 구분
     * @param unitNum 체력을 확인할 유닛 index
     */
    public static void isBreak(List<Unit> unit, int unitNum) {
        if (unit.get(unitNum).getHP() < 1) {
            System.out.println(unit.get(unitNum).getName() + "유닛이 파괴됩니다.");
            unit.remove(unitNum);
        }
    }

    /**
     * 공격하는 유닛과 공격 받는 유닛을 가져와 몇의 데미지에 의해 몇의 체력이 남았는지 메시지 생성.
     */
    public static void battle(List<Unit> attackerUnit, int attackerNum, List<Unit> damagedUnit,
            int targetNum) {
        attackerUnit.get(attackerNum).attack(damagedUnit.get(targetNum));
        System.out.println("\n" + attackerUnit.get(attackerNum).getName() + "의 공격력 ["
                + attackerUnit.get(attackerNum).getAD() + "] 에 의해"
                + damagedUnit.get(targetNum).getName() + "의 남은 체력 ["
                + damagedUnit.get(targetNum).getHP() + "]");
    }

    /**
     * 현제 전투 상황 print하는 메서드.
     * 
     * @param userArmy 아군 종족 리스트
     * @param userSelect 아군 종족 개체값
     * @param cpuArmy 적군 종족 리스트
     * @param cpuSelect 적군 종족 개체값
     */
    public static void printTurn(List<Unit> userArmy, int userSelect, List<Unit> cpuArmy,
            int cpuSelect) {
        String[] tribe = {"Terran", "Protos", "Zerg"};
        System.out.println("\n아군 " + tribe[userSelect]);
        for (int i = 0; i < userArmy.size(); i++) {
            System.out.println("[" + i + "] " + userArmy.get(i));
        }
        System.out.println();
        System.out.println("적군 " + tribe[cpuSelect]);
        for (int i = 0; i < cpuArmy.size(); i++) {
            System.out.println("[" + i + "] " + cpuArmy.get(i));
        }

    }

    /**
     * 아군이 무슨 종족을 고를지 선택.
     * 
     * @return 고른 종족의 개체값 리턴
     */
    public static int chooseTribe() {
        System.out.println("Terran(0), Protos(1), Zerg(2) 중 종족 하나를 선택하시오.");
        int userSelect = sc.nextInt();
        if (userSelect < 0 || userSelect > 2) {
            throw new IllegalArgumentException("tribe range is 0 ~ 2");
        }
        return userSelect;
    }

    /**
     * 테란, 프로토스, 저그 중 한가지 유닛을 선택합니다.
     * 
     * @param num 고른 종족 숫자.
     * @return
     */
    public static List<Unit> makeTribeArmy(int num) throws Exception {
        List<Unit> army = new ArrayList<>();
        if (num == 0) {
            addClassObjects(army, "terran", 5);
        } else if (num == 1) {
            addClassObjects(army, "protos", 4);
        } else {
            addClassObjects(army, "zerg", 8);
        }
        return army;

    }

    /**
     * 패키지안의 유닛 클래스들의 이름을 가져와서 동적으로 객체를 만들어 list 컬렉션에 추가.
     * 
     * @param unit 각 종족 유닛을 담을 list컬렉션
     * @param tribe 패키지의 이름이자 종족의 이름
     * @throws Exception
     */
    public static void addClassObjects(List<Unit> unit, String tribe, int num) throws Exception {
        List<String> classNames = getClassNameList(tribe);

        for (int i = 0; i < num; i++) {
            Class clazz = Class.forName(classNames.get(r.nextInt(classNames.size())));
            Unit obj = (Unit) clazz.newInstance();
            unit.add(obj);
        }
    }

    /**
     * 각 종족 패키지 안의 유닛들 클래스 이름을 list 컬렉션에 담아서 반환.
     * 
     * @param packageName 객체를 생성할 패키지 이름
     * @return 각 종족의 유닛들을 list에 담아서 반환
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static List<String> getClassNameList(String packageName)
            throws IOException, ClassNotFoundException {
        List<String> classNames = new ArrayList<>();
        String path = packageName.replace('.', '/');
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File dir = new File(classLoader.getResource(path).getFile());
        if (!dir.exists()) {
            throw new ClassNotFoundException();
        }
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().endsWith(".class")) {
                    String className = packageName + "."
                            + file.getName().substring(0, file.getName().length() - 6);
                    classNames.add(className);
                }
            }
        }
        return classNames;
    }


}
