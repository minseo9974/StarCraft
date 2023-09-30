import game.GameConsol;

public class StarCraft {
    public static void main(String[] args) {
        GameConsol starCraft = new GameConsol();
        try {
            starCraft.gameService();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
