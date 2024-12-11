package game;

import java.awt.Color;
import java.awt.Font;
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

public class ChapterPanel extends JPanel {
	private Image backgroundImage;
	private Character character;
	private static Boolean chapter2Warning = false;
	private ImageIcon chapImage1 = new ImageIcon("images/챕터1.png");
	private ImageIcon chapImage2 = new ImageIcon("images/챕터2좌물쇠.png");
	private ImageIcon chapImage3 = new ImageIcon("images/챕터2.png");
	private JPanel chapPanel = new JPanel();
	private JButton chapbtn1 = new JButton(chapImage1);
	private JButton chapbtn2 = new JButton(chapImage2);
	private JButton returnBtn = new JButton(new ImageIcon("images/돌아가기.png"));
	JPanel overLayPanel1 = new JPanel();
	JPanel overLayPanel2 = new JPanel();
	JLabel overText1 = new JLabel();
	JLabel overText2 = new JLabel();
	JLabel overText3 = new JLabel();

	JPanel bgPanel = new JPanel();

	public ChapterPanel(Character character) {
		add(bgPanel);
		this.character = character;
		setBounds(0, 0, 1366, 900);
		setLayout(null);
		Boolean[] stage = character.getStage();

		backgroundImage = new ImageIcon("images/ChapterBackground.png").getImage();
		// Chapter 1 버튼

		// 챕터 버튼 패널
		chapPanel.setLayout(null);
		chapPanel.setBounds(235, 200, 900, 500);
		chapPanel.setBackground(Color.BLACK);
		chapPanel.setOpaque(false);
		// 챕터 버튼
		chapbtn1.setBounds(50, 0, 350, 500);
		chapbtn2.setBounds(500, 0, 350, 500);

		chapbtn1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 8, true));
		chapbtn2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 8, true));
		chapbtn1.addMouseListener(new MyMouseEvent());
		chapbtn2.addMouseListener(new MyMouseEvent());

		if (stage[0] == true && stage[1] == true && stage[2] == true) {
			chapbtn2.setIcon(chapImage3);
		}

		overLayPanel1.setLayout(null);
		overLayPanel1.setBounds(285, 200, 350, 500);
		overLayPanel1.setBackground(new Color(0, 0, 0, 187));
		overLayPanel1.setOpaque(false);
		overLayPanel1.addMouseListener(new MyMouseEvent());
		overLayPanel1.setName("over1");

		overLayPanel2.setLayout(null);
		overLayPanel2.setBounds(735, 200, 350, 500);
		overLayPanel2.setBackground(new Color(0, 0, 0, 187));
		overLayPanel2.setOpaque(false);
		overLayPanel2.addMouseListener(new MyMouseEvent());
		overLayPanel2.setName("over2");

		overText1.setFont(new Font(overText1.getText(), Font.BOLD, 20));
		overText1.setForeground(Color.WHITE);
		overText1.setBounds(100, 50, 300, 300);

		overText2.setFont(new Font(overText2.getText(), Font.BOLD, 20));
		overText2.setForeground(Color.WHITE);
		overText2.setSize(100, 100);
		overText2.setBounds(100, 50, 300, 300);

		overText3.setFont(new Font(overText2.getText(), Font.BOLD, 20));
		overText3.setForeground(Color.WHITE);
		overText3.setSize(100, 100);
		overText3.setBounds(50, 90, 300, 300);

		overLayPanel1.add(overText1);
		overLayPanel2.add(overText2);
		overLayPanel2.add(overText3);

		chapPanel.add(chapbtn1);
		chapPanel.add(chapbtn2);

		add(overLayPanel1);
		add(overLayPanel2);
		add(chapPanel);

		// 돌아가기 버튼
		returnBtn.setBounds(0, 0, 180, 92);
		add(returnBtn);
		returnBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton a = (JButton) e.getSource();
				JFrame frame = (JFrame) a.getTopLevelAncestor();
				Function.FADE_OUT(new LobbyPanel(character), frame, ChapterPanel.this);
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	};

	class MyMouseEvent extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			JPanel panel = (JPanel) e.getSource();
			JFrame frame = (JFrame) panel.getTopLevelAncestor();
			if (panel.getName() == "over1") {
				Function.FADE_OUT(new Chapter1Panel(character), frame, ChapterPanel.this);
				remove(chapPanel);
				remove(overLayPanel1);
				remove(overLayPanel2);
			} else if (panel.getName() == "over2") {
				Boolean[] stage = character.getStage();
				if (stage[0] == true && stage[1] == true && stage[2] == true) {
					Function.FADE_OUT(new Chapter2Panel(character), frame, ChapterPanel.this);
					remove(chapPanel);
					remove(overLayPanel1);
					remove(overLayPanel2);
					overText3.setText("");
				}
			}
		}

		public void mouseEntered(MouseEvent e) {
			JPanel panel = (JPanel) e.getSource();
			if (panel.getName() == "over1") {
				overLayPanel1.setOpaque(true);
				overText1.setText("모든 레벨 추천");
			} else if (panel.getName() == "over2") {
				overLayPanel2.setOpaque(true);
				overText2.setText("7Lv 이상 추천");
				overText3.setText("(챕터1 모드 클리어시 해제)");
				Boolean[] stage = character.getStage();
				if (stage[0] == true && stage[1] == true && stage[2] == true) {
					overText3.setText("");
				}
			}
			repaint();
		}

		public void mouseExited(MouseEvent e) {
			JPanel panel = (JPanel) e.getSource();
			if (panel.getName() == "over1") {
				overLayPanel1.setOpaque(false);
				overText1.setText("");
			} else if (panel.getName() == "over2") {
				overLayPanel2.setOpaque(false);
				overText2.setText("");
				overText3.setText("");
			}
			repaint();
		}

	}
}
