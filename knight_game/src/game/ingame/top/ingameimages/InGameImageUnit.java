package game.ingame.top.ingameimages;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import game.ImageUnit;

public abstract class InGameImageUnit extends JLabel {
	private float alpha = 1f;

	protected InGameImageUnit(ImageUnit i) {
		super(i.getUnitImage());
		setSize(340, 340);
		setLayout(null);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		super.paintComponent(g2);
		g2.dispose();
	}

	private JLabel setEffectImage(Boolean useSkill) {
		// 스킬 사용 시, 스킬 이펙트 이미지 담은 JLabel 생성해서 return
		if (useSkill) {
			return new JLabel(new ImageIcon("images/skill_effect.png"));
		}
		return new JLabel(new ImageIcon("images/attack_effect.png"));
	}

	// 공격 당했을 때 깜빡이는 이펙트 및 타격 이미지 출력
	public void attackedEffect(Boolean useSkill) {

		JLabel effect = setEffectImage(useSkill);
		effect.setBounds(20, -20, 340, 340);
		effect.setVisible(true);
		add(effect); 

		Timer timer = new Timer(15, new ActionListener() {
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
					effect.setVisible(false);
					repaint();
				}
			}
		});
		timer.setInitialDelay(0);
		timer.start();
	}
}
