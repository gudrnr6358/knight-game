package game.stage;
import game.monster.slime.BossSlime;
import game.monster.dragon.AncientDragon;
import game.monster.skeleton.SkeletonHorde;
import game.monster.Monster;
public class Stage5{
    private static Monster[] monsters;
    public Stage5() {
        monsters = new Monster[] {
                new BossSlime(),
                new AncientDragon(),
                new SkeletonHorde()
        };
    }
    public Monster[] getMonsters() {
        return monsters;
    }
}
