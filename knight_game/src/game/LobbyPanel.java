package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import game.ingame.top.statuspanel.CharacterStatusPanel;

public class LobbyPanel extends JPanel {
	int count = 0;
	Character character;
	JLayeredPane layeredPane = new JLayeredPane();
	Player la = new Player();
	ImageIcon saveBtn = new ImageIcon("images/popup/저장.png");
	ImageIcon cancelBtn = new ImageIcon("images/popup/취소.png");
	ImageIcon checkBtn = new ImageIcon("images/popup/확인.png");
	ImageIcon endBtn = new ImageIcon("images/popup/종료.png");
	JPanel popUp = Function.popUp();
	JLabel popUpLabel;
	CharacterStatusPanel characterStatusPanel;
	JButton popUpBtn1;
	JButton popUpBtn2;

	public LobbyPanel() {
	}

	public LobbyPanel(Character character) {

		if (!character.isAlive()) {
			character.dead();
		}

		characterStatusPanel = new CharacterStatusPanel(character);
		this.character = character;

		characterStatusPanel.setLocation(20, 20);
		add(characterStatusPanel);

		setLayout(null);

		add(popUp);

		layeredPane.setSize(1366, 900);

		Background bg = new Background();
		bg.setBounds(0, 0, 1366, 900);
		layeredPane.add(bg, JLayeredPane.DEFAULT_LAYER);

		la.setBounds(625, 380, 100, 100);
		layeredPane.add(la, JLayeredPane.DRAG_LAYER);

		add(layeredPane);
		setSize(1366, 900);

		setFocusable(true);
		requestFocusInWindow();
		layeredPane.revalidate();
		layeredPane.repaint();

		popUpLabel = (JLabel) popUp.getComponent(0);
		popUpBtn1 = (JButton) ((JPanel) popUp.getComponent(1)).getComponent(0);
		popUpBtn2 = (JButton) ((JPanel) popUp.getComponent(1)).getComponent(1);
		popUpBtn2.setText("취소");
		popUpBtn2.setIcon(cancelBtn);

		popUpBtn1.addActionListener(new MyBtnEvent());
		popUpBtn2.addActionListener(new MyBtnEvent());

	}

	class Background extends JPanel {
		private Image backgroundImage = new ImageIcon("images/홈패널/백.jpeg").getImage();;

		public Background() {
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		}
	}

	class Player extends JLabel {
		private Image img2 = new ImageIcon("images/캐릭터/캐릭터1.png").getImage();
		private Image img3 = new ImageIcon("images/캐릭터/캐릭터2.png").getImage();
		private Image img4 = new ImageIcon("images/캐릭터/캐릭터3.png").getImage();
		private Image img5 = new ImageIcon("images/캐릭터/캐릭터4.png").getImage();
		private Image img6 = new ImageIcon("images/캐릭터/캐릭터5.png").getImage();
		private Image img7 = new ImageIcon("images/캐릭터/캐릭터6.png").getImage();
		private Image img8 = new ImageIcon("images/캐릭터/캐릭터7.png").getImage();
		private Image img9 = new ImageIcon("images/캐릭터/캐릭터8.png").getImage();
		private int x, y;
		private final int CHARACTER_WIDTH = 100;
		private final int CHARACTER_HEIGHT = 100;
		private final int FRAME_WIDTH = 1200;
		private final int FRAME_HEIGHT = 800;
		private String way;
		private int a = 0;

		public Player() {
			x = 625;
			y = 380;
			addKeyListener(new MyKey());
			setFocusable(true);
			requestFocusInWindow();
		}

		@Override
		protected void paintComponent(Graphics g) {
			// System.out.println(way);
			super.paintComponent(g);
			if (a == 0) {
				g.drawImage(img2, 0, 0, getWidth(), getHeight(), this);
				a++;
			}

			if (way == "up") {
				if (count == 0) {
					g.drawImage(img2, 0, 0, getWidth(), getHeight(), this);
				} else if (count == 1) {
					g.drawImage(img3, 0, 0, getWidth(), getHeight(), this);
				}

			} else if (way == "left") {
				if (count == 0) {
					g.drawImage(img4, 0, 0, getWidth(), getHeight(), this);
				} else if (count == 1) {
					g.drawImage(img5, 0, 0, getWidth(), getHeight(), this);
				}

			} else if (way == "right") {
				if (count == 0) {
					g.drawImage(img6, 0, 0, getWidth(), getHeight(), this);
				} else if (count == 1) {
					g.drawImage(img7, 0, 0, getWidth(), getHeight(), this);
				}

			} else if (way == "down") {
				if (count == 0) {
					g.drawImage(img8, 0, 0, getWidth(), getHeight(), this);
				} else if (count == 1) {
					g.drawImage(img9, 0, 0, getWidth(), getHeight(), this);
				}

			}

		}

		@Override
		public void addNotify() {
			super.addNotify();
			requestFocusInWindow();
		}

		class MyKey extends KeyAdapter {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				JLabel a = (JLabel) e.getSource();
				JFrame frame = (JFrame) a.getTopLevelAncestor();

				if (key == KeyEvent.VK_LEFT) {
					x -= 15;
					way = "left";
				} else if (key == KeyEvent.VK_RIGHT) {
					x += 15;
					way = "right";
				} else if (key == KeyEvent.VK_UP) {
					y -= 15;
					way = "up";
				} else if (key == KeyEvent.VK_DOWN) {
					y += 15;
					way = "down";
				}
				if (count++ == 1) {
					count = 0;
				}

				// 이동 범위 제한
				if (x < 0)
					x = 0;
				if (x > FRAME_WIDTH + CHARACTER_WIDTH)
					x = FRAME_WIDTH + CHARACTER_WIDTH;
				if (y < 0)
					y = 0;
				if (y > FRAME_HEIGHT)
					y = FRAME_HEIGHT;

				if (x >= 0 && x <= 1 && y >= 380 && y <= 440) {
					character.power = 1000;
				}
				// 특정 구역 도달 시 메서드 호출
				if (x >= 10 && x <= 150 && y >= 320 && y <= 470) {
					if (character.nowHp < character.hp) {
						character.nowHp += 10;
						if (character.nowHp >= character.hp) {
							character.nowHp = character.hp;
						}
					}
					layeredPane.remove(la);
					layeredPane.repaint();
					Function.FADE_OUT(new LobbyPanel(character), frame, LobbyPanel.this);
				}
				if (x >= 560 && x <= 700 && y >= 0 && y <= 50) {
					popUpLabel.setText("저장하시겠습니까?");
					popUpBtn1.setIcon(saveBtn);
					popUpBtn1.setText(("저장"));
					popUp.setVisible(true);
				} else {
					popUp.setVisible(false);
				}
				if (x >= FRAME_WIDTH - 40 && x <= FRAME_WIDTH + 100 && y >= 320 && y <= 470) {
					Function.FADE_OUT(new ChapterPanel(character), frame, LobbyPanel.this);
					layeredPane.remove(la);
					layeredPane.repaint();
				}
				if (x >= 560 && x <= 700 && y >= FRAME_HEIGHT - 50 && y <= FRAME_HEIGHT) {
					popUp.setVisible(true);
					popUpLabel.setText("종료시 데이터가 유실될 수 있습니다");
					popUpBtn1.setIcon(endBtn);
					popUpBtn1.setText("종료");
				}
				setLocation(x, y);
				repaint(); // 위치를 변경한 후 다시 그리기
			}
		}

	}

	class MyBtnEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JButton btn = (JButton) e.getSource();
			JFrame frame = (JFrame) btn.getTopLevelAncestor();

			if (btn.getText().equals("저장")) {

				GameSave.saveCharacter(character, "saveData.dat");
				popUpLabel.setText("저장되었습니다");
				popUpBtn1.setText("확인");
				popUpBtn1.setIcon(checkBtn);
				popUpBtn1.setPreferredSize(new Dimension(700, 50));
				popUpBtn2.setVisible(false);
				repaint();

			} else if (btn.getText().equals("취소")) {

				popUp.setVisible(false);
				la.setFocusable(true);
				la.requestFocus();

			} else if (btn.getText().equals("확인")) {

				popUp.setVisible(false);
				popUpLabel.setText("저장하시겠습니까?");
				popUpBtn2.setVisible(true);
				popUpBtn1.setText("저장");
				popUpBtn1.setPreferredSize(new Dimension(350, 50));
				la.setFocusable(true);
				la.requestFocus();

			} else if (btn.getText().equals("종료")) {

				Function.FADE_OUT(new HomePanel(), frame, LobbyPanel.this);
				layeredPane.remove(la);
				layeredPane.repaint();
				remove(popUp);
			}
		}
	}
}