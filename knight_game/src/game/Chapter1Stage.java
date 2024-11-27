package game;

import java.awt.Image;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import game.stage.Stage1;
import game.stage.Stage2;
import game.stage.Stage3;

public class Chapter1Stage extends JPanel {
	private JButton[] buttons = { new JButton("Stage 1"), new JButton("Stage 2"), new JButton("Stage 3"),
			new JButton("돌아가기") };
	private Image backgroundImage;
	private Character character;

	public Chapter1Stage(Character character) {
		this.character = character;

		setLayout(null);
		setBounds(0, 0, 1366, 900);
		backgroundImage = new ImageIcon("images/Stage1Background.png").getImage();

		// Stage1 버튼
		buttons[0].setBounds(100, 100, 150, 50);
		add(buttons[0]);
		buttons[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameFrame.setPanel(new InGame(character, new Stage1().getMonsters()));
			}
		});

		// Stage2 버튼
		buttons[1].setBounds(100, 200, 150, 50);
		add(buttons[1]);
		buttons[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameFrame.setPanel(new InGame(character, new Stage2().getMonsters()));
			}
		});

		// Stage3 버튼
		buttons[2].setBounds(100, 300, 150, 50);
		add(buttons[2]);
		buttons[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameFrame.setPanel(new InGame(character, new Stage3().getMonsters()));
			}
		});

		// 돌아가기 버튼
		buttons[3].setBounds(100, 400, 150, 50);
		add(buttons[3]);
		buttons[3].addActionListener(new ActionListener() {
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