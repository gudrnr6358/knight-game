package game;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {
	public static JFrame frame = new JFrame("기사 키우기");
	public static Container container = frame.getContentPane();

	public static void main(String[] args) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		// home에서 게임 시작 누른 이후에 캐릭터 객체 생성
		Character c = new Character();
		
		container.setLayout(null);
		container.add(new Chapter(c));
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
