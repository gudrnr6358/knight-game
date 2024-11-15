package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Lobby extends JPanel {
	public Lobby() {
		Player la = new Player();
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1366, 900);

		Background bg = new Background();
		bg.setBounds(0, 0, 1366, 900);
		layeredPane.add(bg, JLayeredPane.DEFAULT_LAYER);

		la.setBounds((bg.getWidth() / 2 - la.getWidth() / 2), (bg.getHeight() / 2 - la.getHeight() / 2), 100, 100);
		layeredPane.add(la, JLayeredPane.DRAG_LAYER);

		setLayout(null);
		add(layeredPane);

		la.setFocusable(true);
		la.requestFocusInWindow();
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

class Player extends JPanel implements KeyListener {
	private Image img2;
	private int x, y;
	private final int WIDTH = 100;
	private final int HEIGHT = 100;
	private final int FRAME_WIDTH = 1366 - WIDTH;
	private final int FRAME_HEIGHT = 900 - HEIGHT;

	public Player() {
		img2 = new ImageIcon("images/player.jpeg").getImage();
		x = FRAME_WIDTH / 2;
		y = FRAME_HEIGHT / 2;
		addKeyListener(this);
		setFocusable(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img2, 0, 0, WIDTH, HEIGHT, this);
	}

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
		if (x < 100)
			x = 100;
		if (x > FRAME_WIDTH - WIDTH)
			x = FRAME_WIDTH - WIDTH;
		if (y < 100)
			y = 100;
		if (y > FRAME_HEIGHT - HEIGHT)
			y = FRAME_HEIGHT - HEIGHT;

		// 특정 구역 도달 시 메서드 호출
		if (x >= 90 && x <= 110 && y >= 230 && y <= 260) {
			Method1();// 동
		}
		if (x >= 340 && x <= 370 && y >= 390 && y <= 410) {
			Method2();// 북
		}
		if (x >= 580 && x <= 610 && y >= 240 && y <= 270) {
			Method3();// 서
		}

		setLocation(x, y);
		repaint(); // 위치를 변경한 후 다시 그리기
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Do nothing
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// Do nothing
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
