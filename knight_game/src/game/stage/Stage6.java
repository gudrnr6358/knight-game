package game.stage;
import game.monster.boss.Boss;
import game.monster.Monster;
public class Stage6{
    private static Monster[] monsters;
    public Stage6() {
        monsters = new Monster[] {
                new Boss()
        };
    }
    public Monster[] getMonsters() {
        return monsters;
    }
}