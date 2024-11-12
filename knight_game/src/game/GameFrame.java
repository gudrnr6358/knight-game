package game;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.monster.Monster;
import game.monster.skeleton.WarriorSkeleton;
import game.monster.slime.MiniSlime;

public class GameFrame extends JFrame {
	public static CardLayout cardLayout = new CardLayout();
	public static JPanel cardPanel = new JPanel(cardLayout);
	public static JFrame frame = new JFrame("기사 키우기");  
	
	public static void main(String[] args) {
		// home에서 게임 시작 누른 이후에 캐릭터 객체 생성
		Character c = new Character();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Monster[] m = { new WarriorSkeleton(), new MiniSlime(), new MiniSlime() };
		InGames ingamesPanel = new InGames(c, m);
		InGame ingamePanel = new InGame(c, m);

		cardPanel.add(ingamePanel, "InGame");
		cardPanel.add(ingamesPanel, "InGames");
		frame.add(cardPanel);

		cardLayout.show(cardPanel, "InGames");
		
		frame.setSize(1366, 900);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public static void setPanel(JPanel panel) {
		frame.removeAll();
		frame.add(panel);
	}
}
