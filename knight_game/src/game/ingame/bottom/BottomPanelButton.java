package game.ingame.bottom;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BottomPanelButton extends JButton {

	protected BottomPanelButton(ImageIcon img) {
		super(img);
		addMouseListener(new BottomPanelEvent().new BottomMouseListener());
		setFocusable(false);
	}

}

class BasicPanelButton extends BottomPanelButton {
	private final Integer cornerRadius = 3;

	// BasicPanelButton size 세팅 (260, 148)
	protected BasicPanelButton(ImageIcon img) {
		super(img);
		setSize(260, 151);
	}
}

class BattlePanelButton extends BottomPanelButton {
	// BattlePanelButton size 세팅 (250, 141)
	protected BattlePanelButton(ImageIcon img) {
		super(img);
		setSize(250, 141);
	}

}

class SkillPanelButton extends BottomPanelButton {
	// SkillPanelButton size 세팅 (230, 120)
	protected SkillPanelButton(ImageIcon img) {
		super(img);
		setSize(230, 136);
	}
}