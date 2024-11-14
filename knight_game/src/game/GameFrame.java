package game;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.monster.Monster;
import game.monster.slime.BossSlime;
import game.monster.slime.CombatSlime;
import game.monster.slime.MiniSlime;

public class GameFrame extends JFrame {
	public static JFrame frame = new JFrame("기사 키우기");

	static Character c;
	
	public static void main(String[] args) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// home에서 게임 시작 누른 이후에 캐릭터 객체 생성
		Character c = new Character();
		Monster[] m = { new MiniSlime(), new CombatSlime(), new BossSlime() };
		InGame ingamePanel = new InGame(c, m);
		
		// 여기에다가 본인이 만든 panel 부착하고 테스트 하면 됨
		setPanel(ingamePanel);
		
		frame.setSize(1366, 900);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public static void setPanel(JPanel panel) {
		Container c = frame.getContentPane();
		c.removeAll();
		c.add(panel);
		c.repaint();
	}
	
}
