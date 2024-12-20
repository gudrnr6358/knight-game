package game.ingame.bottom;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import game.InGamePanel;

// 생성자 사용해서 기본 Border 및 TextBar 제공
// 기본 틀만 제공해주기에 abstract class 선언 
public abstract class BottomBox extends JPanel {

	private static final Integer cornerRadius = 3;
	public static InGamePanel inGame;

	// TextLabel 부착 및 Border, Size, Location 제공
	protected BottomBox() {
		setLayout(null);
		BottomBox.this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, cornerRadius, true));
		BottomBox.this.add(TextLabel.textLabel);
		BottomBox.this.setBounds(22, 10, 1320, 335);
		addMouseListener(new BottomPanelEvent().new BottomMouseListener());
		setOpaque(false);
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();

		// BorderRadius 공백 채우기용
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		g2d.drawRect(0, 0, getWidth(), getHeight());

		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.85f));
		g2d.setColor(Color.WHITE);
		g2d.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
	}
}