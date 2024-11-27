package game.stage;
import game.monster.skeleton.WarriorSkeleton;
import game.monster.skeleton.ArcherSkeleton;
import game.monster.skeleton.SkeletonHorde;
import game.monster.Monster;
public class Stage3{
    private static Monster[] monsters;
    public Stage3() {
        monsters = new Monster[] {
                new WarriorSkeleton(),
                new ArcherSkeleton(),
                new SkeletonHorde()
        };
    }
    public Monster[] getMonsters() {
        return monsters;
    }
}
