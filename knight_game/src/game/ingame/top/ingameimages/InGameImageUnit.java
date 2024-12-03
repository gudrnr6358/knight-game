package game.ingame.top.ingameimages;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

import game.ImageUnit;

public abstract class InGameImageUnit extends JLabel {

	protected InGameImageUnit(ImageUnit i) {
		super(i.getUnitImage());
		setSize(340, 340);
	}

	public void attackedEffect() {
		Timer timer = new Timer(100, new ActionListener() {
			private int count = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (count % 2 == 0) {
					setBackground(Color.RED); // 깜빡임 효과
				} else {
					setBackground(null); // 원래 색으로
				}
				count++;
				if (count >= 10) { // 깜빡임 횟수 (5번 깜빡임)
					((Timer) e.getSource()).stop();
					setBackground(null); // 원래 색으로 복원
				}
			}
		});
		timer.setInitialDelay(0);
		timer.start();
	}

}