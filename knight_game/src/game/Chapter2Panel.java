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

import game.stage.Stage4;
import game.stage.Stage5;
import game.stage.Stage6;

public class Chapter2Panel extends JPanel {
	JPanel bgPanel = new JPanel();
	Character character;
	private Image backgroundImage;
	JLabel stage1Btn;
	JLabel stage2Btn;
	JLabel stage3Btn;
	private JButton returnBtn = new JButton(new ImageIcon("images/돌아가기.png"));

	public Chapter2Panel(Character character) {
		add(bgPanel);
		this.character = character;

		backgroundImage = new ImageIcon("images/Stage2Background.png").getImage();

		setLayout(null);
		setBounds(0, 0, 1366, 900);
		stage1Btn = new JLabel(new ImageIcon("images/스테이지1.png"));
		stage2Btn = new JLabel(new ImageIcon("images/스테이지2.png"));
		stage3Btn = new JLabel(new ImageIcon("images/스테이지3.png"));
		stage1Btn.setBounds(580, 730, 80, 80);
		stage2Btn.setBounds(730, 500, 80, 80);
		stage3Btn.setBounds(700, 250, 80, 80);
		stage1Btn.addMouseListener(new MyMouseEvent());
		stage2Btn.addMouseListener(new MyMouseEvent());
		stage3Btn.addMouseListener(new MyMouseEvent());
		stage1Btn.setName("stage1");
		stage2Btn.setName("stage2");
		stage3Btn.setName("stage3");

		add(stage1Btn);
		add(stage2Btn);
		add(stage3Btn);

		// 돌아가기 버튼
		returnBtn.setBounds(0, 0, 180, 80);
		add(returnBtn);
		returnBtn.addActionListener(new ActionListener() {
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

	class MyMouseEvent extends MouseAdapter {

		public void mouseClicked(MouseEvent e) {
			JLabel label = (JLabel) e.getSource();
			JFrame frame = (JFrame) label.getTopLevelAncestor();
			if (label.getName() == "stage1") {
				Function.fadeout(bgPanel,
						new InGamePanel(character, new Stage4().getMonsters(), backgroundImage, "stage4"), frame,
						Chapter2Panel.this);
			} else if (label.getName() == "stage2") {
				Function.fadeout(bgPanel,
						new InGamePanel(character, new Stage5().getMonsters(), backgroundImage, "stage5"), frame,
						Chapter2Panel.this);
			} else if (label.getName() == "stage3") {
				Function.fadeout(bgPanel,
						new InGamePanel(character, new Stage6().getMonsters(), backgroundImage, "stage6"), frame,
						Chapter2Panel.this);

			}
		}

		public void mouseEntered(MouseEvent e) {
			JLabel label = (JLabel) e.getSource();
			label.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 224), 3, true));

		}

		public void mouseExited(MouseEvent e) {
			JLabel label = (JLabel) e.getSource();
			label.setBorder(null);
		}

	}

}