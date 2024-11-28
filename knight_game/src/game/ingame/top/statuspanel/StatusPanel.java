package game.ingame.top.statuspanel;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.AbstractCombatant;

public abstract class StatusPanel extends JPanel {
	private Font FONT = new Font("SansSerif", Font.BOLD, 20);
	private AbstractCombatant c;

	protected StatusPanel(AbstractCombatant c) {
		this.c = c;
		setLayout(null);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
		add(new NameLabel());
		add(new PowerLabel());
		add(new HealthPanel());
		setSize(350, 100);
	}

	// BorderRadius 공백 채우기용 paintComponent
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		g2d.drawRect(0, 0, getWidth(), getHeight());
	}

	private class NameLabel extends JLabel {
		private NameLabel() {
			super(c.getName());
			super.setFont(FONT);
			setBounds(15, 10, 500, 30);
		}
	}

	private class PowerLabel extends JLabel {
		private PowerLabel() {
			super("전투력 : " + c.getPower());
			super.setFont(FONT);
			setBounds(195, 10, 200, 30);
		}
	}

	private class HealthPanel extends JPanel {
		private final Integer cornerRadius = 10;

		private HealthPanel() {
			super();
			setBounds(15, 55, 332, 20);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			// 체력의 경계를 나타내줄 기본 틀 그리기
			g.setColor(Color.LIGHT_GRAY);
			g.fillRoundRect(0, 0, 230, 20, cornerRadius, cornerRadius);

			g.setColor(Color.green);
			// 체력이 15% 이하일 경우 빨간색으로 체력 표시
			if ((int) ((c.getNowHp() / (double) c.getHp()) * 100) <= 15) {
				g.setColor(Color.red);
			}
			// 현재 체력만큼 RoundRect 채우기
			g.fillRoundRect(0, 0, (int) ((c.getNowHp() / (double) c.getHp()) * 230), 20, cornerRadius, cornerRadius);
			// 현재 체력 수치(문자열) 표시
			String str = new String(c.getNowHp() + " / " + c.getHp());
			super.setFont(FONT);
			g.setColor(Color.black);
			g.drawString(str, 235, 15);
		}
	}

}
