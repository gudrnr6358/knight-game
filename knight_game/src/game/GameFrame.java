package game;

import java.awt.Container;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.monster.Monster;
import game.monster.slime.BossSlime;
import game.monster.slime.CombatSlime;
import game.monster.slime.MiniSlime;

public class GameFrame extends JFrame {
	public static JFrame frame = new JFrame("기사 키우기");
	public static Container container = frame.getContentPane();

	public static void main(String[] args) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// home에서 게임 시작 누른 이후에 캐릭터 객체 생성
		Character c = new Character();
		Monster[] m = { new MiniSlime(), new CombatSlime(), new BossSlime() };
		Vector<Monster> v = new Vector<>();
		v.add(new MiniSlime());
		InGames ingamePanel = new InGames(c, m);

		frame.setContentPane(ingamePanel);

		frame.setSize(1366, 900);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public static void setPanel(JPanel panel) {
		frame.removeAll();
		frame.setContentPane(panel);
		frame.repaint();
	}

}
