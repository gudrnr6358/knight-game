package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Lobby extends JPanel {

	public Lobby(Character character) {
		setLayout(null);

		Player la = new Player(character);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setSize(1366, 900);

		Background bg = new Background();
		bg.setBounds(0, 0, 1366, 900);
		layeredPane.add(bg, JLayeredPane.DEFAULT_LAYER);

		la.setBounds(350, 250, 100, 100);
		layeredPane.add(la, JLayeredPane.DRAG_LAYER);
		add(layeredPane);
		setSize(1366, 900);

		setFocusable(true);
		requestFocusInWindow();
		layeredPane.revalidate();
		layeredPane.repaint();
	}
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
	private Character character;
	private final int WIDTH = 100;
	private final int HEIGHT = 100;
	private final int FRAME_WIDTH = 1200;
	private final int FRAME_HEIGHT = 800;

	public Player(Character character) {
		this.character = character;
		img2 = new ImageIcon("images/player.jpeg").getImage();
		x = 350;
		y = 250;
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
			}
			if (x >= 600 && x <= 630 && y >= 120 && y <= 230) {
				Method2();// 북
			}
			if (x >= 1000 && x <= 1080 && y >= 390 && y <= 440) {
				Method3();// 동
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

		// 테스트용으로 동쪽에 setPanel 메서드 추가
		private void Method3() {
			GameFrame.setPanel(new Chapter(character));
			System.out.println("특정 구역에 도달했습니다!3");
		}
	}
}