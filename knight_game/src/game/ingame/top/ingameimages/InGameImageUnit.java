package game.ingame.top.ingameimages;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

import game.ImageUnit;

public abstract class InGameImageUnit extends JLabel {
	private float alpha = 1f;

	protected InGameImageUnit(ImageUnit i) {
		super(i.getUnitImage());
		setSize(340, 340);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		super.paintComponent(g2);
		g2.dispose();
	}

	// 공격 당했을 때 깜빡이는 이펙트 출력
	public void attackedEffect() {
		Timer timer = new Timer(10, new ActionListener() {
			private int count = 0;
			private boolean isFadingOut = true;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isFadingOut) {
					alpha -= 0.1f;
					if (alpha <= 0) {
						alpha = 0;
						isFadingOut = false;
					}
				} else {
					alpha += 0.1f;
					if (alpha >= 1) {
						alpha = 1;
						count++;
						isFadingOut = true;
					}
				}
				repaint();

				if (count >= 2) { // 2번 깜빡임
					((Timer) e.getSource()).stop();
					alpha = 1f; // 원래 투명도로 복원
					repaint();
				}
			}
		});
		timer.setInitialDelay(0);
		timer.start();
	}
}
