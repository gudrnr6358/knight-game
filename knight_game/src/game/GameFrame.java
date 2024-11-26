package game;

import java.awt.Container;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.monster.Monster;
import game.monster.dragon.AncientDragon;
import game.monster.dragon.BabyDragon;
import game.monster.dragon.CowardDragon;
import game.monster.skeleton.ArcherSkeleton;
import game.monster.skeleton.SkeletonHorde;
import game.monster.skeleton.WarriorSkeleton;
import game.monster.slime.BossSlime;
import game.monster.slime.CombatSlime;
import game.monster.slime.MiniSlime;

public class GameFrame extends JFrame {
	public static JFrame frame = new JFrame("기사 키우기");
	public static Container container = frame.getContentPane();

	public static void main(String[] args) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		// home에서 게임 시작 누른 이후에 캐릭터 객체 생성
		Character c = new Character();
		Monster[] slimes = { new MiniSlime(), new CombatSlime(), new BossSlime() };
		Monster[] skeletons = { new WarriorSkeleton(), new ArcherSkeleton(), new SkeletonHorde() };
		Monster[] dragons = { new BabyDragon(), new CowardDragon(), new AncientDragon() };

		Vector<Monster> v = new Vector<>();
		v.add(new MiniSlime());
		InGame ingamePanel = new InGame(c, skeletons);

		container.setLayout(null);
		container.add(ingamePanel);
		container.setVisible(true);

		frame.setSize(1366, 900);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void setPanel(JPanel panel) {
		container.removeAll();
		container.add(panel);
		container.revalidate();
		container.repaint();
	}

}
