package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.stage.Stage4;
import game.stage.Stage5;
import game.stage.Stage6;

public class Chapter2Panel extends JPanel {
	JPanel bgPanel = new JPanel();
	Character character;
	private Image backgroundImage;
	private JButton[] buttons = { new JButton("Stage 4"), new JButton("Stage 5"), new JButton("Stage 6"),
			new JButton("돌아가기") };

	public Chapter2Panel(Character character) {
		add(bgPanel);
		this.character = character;

		backgroundImage = new ImageIcon("images/Stage2Background.png").getImage();

		setLayout(null);
		setBounds(0, 0, 1366, 900);

		// Stage4 버튼
		buttons[0].setBounds(200, 550, 180, 80);
		add(buttons[0]);
		buttons[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton a = (JButton) e.getSource();
				JFrame frame = (JFrame) a.getTopLevelAncestor();
				Function.fadeout(bgPanel, new InGamePanel(character, new Stage4().getMonsters(), backgroundImage),
						frame);
			}
		});

		// Stage5 버튼
		buttons[1].setBounds(450, 720, 180, 80);
		add(buttons[1]);
		buttons[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton a = (JButton) e.getSource();
				JFrame frame = (JFrame) a.getTopLevelAncestor();
				Function.fadeout(bgPanel, new InGamePanel(character, new Stage5().getMonsters(), backgroundImage),
						frame);
			}
		});

		// Stage6 버튼
		buttons[2].setBounds(650, 550, 180, 80);
		add(buttons[2]);
		buttons[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton a = (JButton) e.getSource();
				JFrame frame = (JFrame) a.getTopLevelAncestor();
				Function.fadeout(bgPanel, new InGamePanel(character, new Stage6().getMonsters(), backgroundImage),
						frame);
			}
		});

		// 돌아가기 버튼
		buttons[3].setBounds(0, 0, 180, 80);
		add(buttons[3]);
		buttons[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton a = (JButton) e.getSource();
				JFrame frame = (JFrame) a.getTopLevelAncestor();
				System.out.println(frame);
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