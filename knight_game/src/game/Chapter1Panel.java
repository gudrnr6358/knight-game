package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.stage.Stage1;
import game.stage.Stage2;
import game.stage.Stage3;

public class Chapter1Panel extends JPanel {
	private Image backgroundImage = new ImageIcon("images/스테이지/Stage1Background.png").getImage();
	private Character character;
	JPanel bgPanel = new JPanel();
	private JLabel stage1Btn = new JLabel(new ImageIcon("images/스테이지/스테이지1.png"));
	private JLabel stage2Btn = new JLabel(new ImageIcon("images/스테이지/스테이지2.png"));
	private JLabel stage3Btn = new JLabel(new ImageIcon("images/스테이지/스테이지3.png"));
	private JButton returnBtn = new JButton(new ImageIcon("images/돌아가기.png"));

	public Chapter1Panel(Character character) {
		add(bgPanel);
		this.character = character;

		setLayout(null);
		setBounds(0, 0, 1366, 900);

		stage1Btn.setBounds(730, 700, 80, 80);
		stage2Btn.setBounds(450, 580, 80, 80);
		stage3Btn.setBounds(530, 410, 80, 80);
		returnBtn.setBounds(0, 0, 180, 92);
		stage1Btn.addMouseListener(new MyMouseEvent());
		stage2Btn.addMouseListener(new MyMouseEvent());
		stage3Btn.addMouseListener(new MyMouseEvent());
		returnBtn.addMouseListener(new MyMouseEvent());
		stage1Btn.setName("stage1");
		stage2Btn.setName("stage2");
		stage3Btn.setName("stage3");

		add(stage1Btn);
		add(stage2Btn);
		add(stage3Btn);
		add(returnBtn);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	}

	class MyMouseEvent extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			JLabel label = (JLabel) e.getSource();
			JFrame frame = (JFrame) label.getTopLevelAncestor();
			if (label.getName() == "stage1") {
				Function.fadeout(bgPanel,
						new InGamePanel(character, new Stage1().getMonsters(), backgroundImage, "stage1"), frame,
						Chapter1Panel.this);
			} else if (label.getName() == "stage2") {
				Function.fadeout(bgPanel,
						new InGamePanel(character, new Stage2().getMonsters(), backgroundImage, "stage2"), frame,
						Chapter1Panel.this);
			} else if (label.getName() == "stage3") {
				Function.fadeout(bgPanel,
						new InGamePanel(character, new Stage3().getMonsters(), backgroundImage, "stage3"), frame,
						Chapter1Panel.this);

			}
		}

		public void mouseEntered(MouseEvent e) {
			if (e.getSource() instanceof JLabel) {
				JLabel label = (JLabel) e.getSource();
				label.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 224), 3, true));
			}
		}

		public void mouseExited(MouseEvent e) {
			if (e.getSource() instanceof JLabel) {
				JLabel label = (JLabel) e.getSource();
				label.setBorder(null);
			}
		}

	}
}