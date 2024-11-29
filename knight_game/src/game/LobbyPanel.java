package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import game.ingame.top.statuspanel.CharacterStatusPanel;

public class LobbyPanel extends JPanel {
	Character character;
	JPanel bgPanel = new JPanel();
	JLayeredPane layeredPane = new JLayeredPane();
	Player la = new Player();
	JPanel popUpPanel = new JPanel();
	JLabel popUpLabel = new JLabel("저장하시겠습니까?");
	JButton popUpBtn1 = new JButton("저장");
	JButton popUpBtn2 = new JButton("취소");
	JPanel btnPanel = new JPanel();
	CharacterStatusPanel characterStatusPanel;

	public LobbyPanel() {
	}

	public LobbyPanel(Character character) {
		characterStatusPanel = new CharacterStatusPanel(character);
		this.character = character;

		if (character.nowHp <= 0)
			character.nowHp = 10;

		add(bgPanel);
		characterStatusPanel.setLocation(20, 20);
		add(characterStatusPanel);

		setLayout(null);
		add(popUpPanel);

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

		popUpPanel.setLayout(new BorderLayout());
		popUpPanel.setBounds(325, 300, 700, 250);
		popUpPanel.setBackground(new Color(0, 0, 0, 230));
		popUpPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3, true));
		popUpPanel.setVisible(false);

		popUpLabel.setForeground(Color.WHITE);
		popUpLabel.setFont(new Font(popUpLabel.getText(), Font.BOLD, 30));
		popUpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		popUpLabel.setVerticalAlignment(SwingConstants.CENTER);

		popUpBtn1.setPreferredSize(new Dimension(350, 50));
		popUpBtn2.setPreferredSize(new Dimension(350, 50));
		popUpBtn1.addActionListener(new MyBtnEvent());
		popUpBtn2.addActionListener(new MyBtnEvent());

		btnPanel.setLayout(new BorderLayout());
		btnPanel.setOpaque(false);
		btnPanel.add(popUpBtn1, BorderLayout.WEST);
		btnPanel.add(popUpBtn2, BorderLayout.EAST);

		popUpPanel.add(popUpLabel);
		popUpPanel.add(btnPanel, BorderLayout.SOUTH);
	}

	class Background extends JPanel {
		private Image backgroundImage;

		public Background() {
			backgroundImage = new ImageIcon("images/background.jpg").getImage();
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		}
	}

	class Player extends JPanel {
		private Image img2;
		private int x, y;
		private final int WIDTH = 100;
		private final int HEIGHT = 100;
		private final int FRAME_WIDTH = 1200;
		private final int FRAME_HEIGHT = 800;

		public Player() {
			img2 = new ImageIcon("images/player.jpeg").getImage();
			x = 625;
			y = 380;
			addKeyListener(new MyKey());
			setFocusable(true);
			requestFocusInWindow();
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img2, 0, 0, getWidth(), getHeight(), this);
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
				JPanel a = (JPanel) e.getSource();
				JFrame frame = (JFrame) a.getTopLevelAncestor();
				if (key == KeyEvent.VK_LEFT) {
					x -= 15;
				} else if (key == KeyEvent.VK_RIGHT) {
					x += 15;
				} else if (key == KeyEvent.VK_UP) {
					y -= 15;
				} else if (key == KeyEvent.VK_DOWN) {
					y += 15;
				}

				// 이동 범위 제한
				if (x < 170)
					x = 170;
				if (x > FRAME_WIDTH - WIDTH)
					x = FRAME_WIDTH - WIDTH;
				if (y < 100)
					y = 100;
				if (y > FRAME_HEIGHT - HEIGHT)
					y = FRAME_HEIGHT - HEIGHT;

				// 특정 구역 도달 시 메서드 호출
				if (x >= 160 && x <= 260 && y >= 390 && y <= 440) {
					Method1();// 서
					if (character.nowHp < character.hp) {
						character.nowHp += 10;
						if (character.nowHp >= character.hp) {
							character.nowHp = character.hp;
						}
					}
					// characterStatusPanel.repaint();
					layeredPane.remove(la);
					layeredPane.repaint();
					HomePanel.fadeout(bgPanel, new LobbyPanel(character), frame);
				}
				if (x >= 600 && x <= 630 && y >= 120 && y <= 230) {
					Method2();// 북
					popUpLabel.setText("저장하시겠습니까?");
					popUpBtn1.setText("저장");
					popUpPanel.setVisible(true);
				} else {
					popUpPanel.setVisible(false);
				}
				if (x >= 1000 && x <= 1080 && y >= 390 && y <= 440) {
					HomePanel.fadeout(bgPanel, new ChapterPanel(character), frame);
					layeredPane.remove(la);
					layeredPane.repaint();
					Method3();// 동
				}
				if (x >= 600 && x <= 630 && y >= 600 && y <= 650) {
					System.out.println("남남");
					popUpPanel.setVisible(true);
					popUpLabel.setText("종료시 데이터가 유실될 수 있습니다");
					popUpBtn1.setText("종료");
				}
				setLocation(x, y);
				repaint(); // 위치를 변경한 후 다시 그리기
			}

			// 특정 구역에 도달했을 때 실행할 메서드
			private void Method1() {
				System.out.println("특정 구역에 도달했습니다!1");
			}

			private void Method2() {
				System.out.println("특정 구역에 도달했습니다!2");
			}

			private void Method3() {
				System.out.println("특정 구역에 도달했습니다!3");
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
				popUpBtn1.setPreferredSize(new Dimension(700, 50));
				popUpBtn2.setVisible(false);
				repaint();

			} else if (btn.getText().equals("취소")) {

				popUpPanel.setVisible(false);
				la.setFocusable(true);
				la.requestFocus();

			} else if (btn.getText().equals("확인")) {

				popUpPanel.setVisible(false);
				popUpLabel.setText("저장하시겠습니까?");
				popUpBtn2.setVisible(true);
				popUpBtn1.setText("저장");
				popUpBtn1.setPreferredSize(new Dimension(350, 50));
				la.setFocusable(true);
				la.requestFocus();

			} else if (btn.getText().equals("종료")) {

				HomePanel.fadeout(bgPanel, new HomePanel(), frame);
				layeredPane.remove(la);
				layeredPane.repaint();
				remove(popUpPanel);
			}
		}
	}
}

/*
 * 이거 복사해서 사용 package game;
 * 
 * import java.awt.Graphics; import java.awt.Image; import
 * java.awt.event.KeyAdapter; import java.awt.event.KeyEvent;
 * 
 * import javax.swing.ImageIcon; import javax.swing.JLayeredPane; import
 * javax.swing.JPanel;
 * 
 * public class Lobby extends JPanel {
 * 
 * public Lobby() { setLayout(null);
 * 
 * Player la = new Player(); JLayeredPane layeredPane = new JLayeredPane();
 * layeredPane.setSize(1366, 900);
 * 
 * Background bg = new Background(); bg.setBounds(0, 0, 1366, 900);
 * layeredPane.add(bg, JLayeredPane.DEFAULT_LAYER);
 * 
 * la.setBounds(350, 250, 100, 100); layeredPane.add(la,
 * JLayeredPane.DRAG_LAYER); add(layeredPane); setSize(1366, 900);
 * 
 * // 포커스 설정 및 레이아웃 갱신 setFocusable(true); requestFocusInWindow();
 * la.requestFocusInWindow(); layeredPane.revalidate(); layeredPane.repaint(); }
 * }
 * 
 * class Background extends JPanel { private Image backgroundImage;
 * 
 * public Background() { backgroundImage = new
 * ImageIcon("images/background.jpg").getImage(); }
 * 
 * @Override protected void paintComponent(Graphics g) {
 * super.paintComponent(g); g.drawImage(backgroundImage, 0, 0, getWidth(),
 * getHeight(), this); } }
 * 
 * class Player extends JPanel { private Image img2; private int x, y; private
 * final int WIDTH = 100; private final int HEIGHT = 100; private final int
 * FRAME_WIDTH = 1200; private final int FRAME_HEIGHT = 800;
 * 
 * public Player() { img2 = new ImageIcon("images/player.jpeg").getImage(); x =
 * 350; y = 250; addKeyListener(new MyKey()); setFocusable(true); }
 * 
 * @Override protected void paintComponent(Graphics g) {
 * super.paintComponent(g); g.drawImage(img2, 0, 0, getWidth(), getHeight(),
 * this); }
 * 
 * @Override public void addNotify() { super.addNotify();
 * requestFocusInWindow(); // 패널이 추가될 때 포커스 설정 }
 * 
 * class MyKey extends KeyAdapter {
 * 
 * @Override public void keyPressed(KeyEvent e) { int key = e.getKeyCode();
 * 
 * if (key == KeyEvent.VK_LEFT) { x -= 15; } else if (key == KeyEvent.VK_RIGHT)
 * { x += 15; } else if (key == KeyEvent.VK_UP) { y -= 15; } else if (key ==
 * KeyEvent.VK_DOWN) { y += 15; }
 * 
 * // 이동 범위 제한 if (x < 170) x = 170; if (x > FRAME_WIDTH - WIDTH) x =
 * FRAME_WIDTH - WIDTH; if (y < 100) y = 100; if (y > FRAME_HEIGHT - HEIGHT) y =
 * FRAME_HEIGHT - HEIGHT;
 * 
 * // 특정 구역 도달 시 메서드 호출 if (x >= 160 && x <= 260 && y >= 390 && y <= 440) {
 * Method1();// 서 } if (x >= 600 && x <= 630 && y >= 120 && y <= 230) {
 * Method2();// 북 } if (x >= 1000 && x <= 1080 && y >= 390 && y <= 440) {
 * Method3();// 동 } setLocation(x, y); repaint(); // 위치를 변경한 후 다시 그리기 }
 * 
 * // 특정 구역에 도달했을 때 실행할 메서드 private void Method1() {
 * System.out.println("특정 구역에 도달했습니다!1"); }
 * 
 * private void Method2() { System.out.println("특정 구역에 도달했습니다!2"); }
 * 
 * private void Method3() { System.out.println("특정 구역에 도달했습니다!3"); } } }
 * 
 */
