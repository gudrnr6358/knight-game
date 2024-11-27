package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Chapter extends JPanel {
	private Image backgroundImage;
	private JButton[] buttons = { new JButton("CHAPTER 1"), new JButton("CHAPTER 2"), new JButton("돌아가기") };
	private Character character;

	public Chapter(Character character) {
		this.character = character;
		setBounds(0, 0, 1366, 900);
		setLayout(null);
		backgroundImage = new ImageIcon("images/ChapterBackground.png").getImage();
		// Chapter 1 버튼
		buttons[0].setBounds(200, 200, 100, 100);
		add(buttons[0]);
		buttons[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameFrame.setPanel(new Chapter1Stage(character));
			}
		});
		// Chapter 2 버튼
		buttons[1].setBounds(200, 200, 100, 100);

		add(buttons[1]);
		buttons[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameFrame.setPanel(new Chapter2Stage(character));
			}
		});

		// 돌아가기 버튼
		buttons[2].setBounds(200, 200, 100, 100);
		add(buttons[2]);
		buttons[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameFrame.setPanel(new Lobby());
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	}
}
