package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.stage.Stage1;
import game.stage.Stage2;
import game.stage.Stage3;

public class Chapter1Panel extends JPanel {
	private JButton[] buttons = { new JButton("Stage 1"), new JButton("Stage 2"), new JButton("Stage 3"),
			new JButton("돌아가기") };
	private Image backgroundImage;
	private Character character;
	JPanel bgPanel = new JPanel();

	public Chapter1Panel(Character character) {
		add(bgPanel);
		this.character = character;

		setLayout(null);
		setBounds(0, 0, 1366, 900);
		backgroundImage = new ImageIcon("images/Stage1Background.png").getImage();

		// Stage1 버튼
		buttons[0].setBounds(730, 700, 180, 80);
		add(buttons[0]);
		buttons[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("클릭");
				JButton a = (JButton) e.getSource();
				JFrame frame = (JFrame) a.getTopLevelAncestor();
				HomePanel.fadeout(bgPanel, new InGamePanel(character, new Stage1().getMonsters(), backgroundImage),
						frame);
			}
		});

		// Stage2 버튼
		buttons[1].setBounds(450, 580, 180, 80);
		add(buttons[1]);
		buttons[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton a = (JButton) e.getSource();
				JFrame frame = (JFrame) a.getTopLevelAncestor();
				HomePanel.fadeout(bgPanel, new InGamePanel(character, new Stage2().getMonsters(), backgroundImage),
						frame);
			}
		});

		// Stage3 버튼
		buttons[2].setBounds(530, 410, 180, 80);
		add(buttons[2]);
		buttons[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton a = (JButton) e.getSource();
				JFrame frame = (JFrame) a.getTopLevelAncestor();
				HomePanel.fadeout(bgPanel, new InGamePanel(character, new Stage3().getMonsters(), backgroundImage),
						frame);
			}
		});

		// 돌아가기 버튼
		buttons[3].setBounds(0, 0, 180, 80);
		add(buttons[3]);
		buttons[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("돌아가기 클릭");
				JButton a = (JButton) e.getSource();
				JFrame frame = (JFrame) a.getTopLevelAncestor();
				frame.getContentPane().removeAll();
				frame.add(new ChapterPanel(character));
				frame.revalidate();
				frame.repaint();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	}
}
