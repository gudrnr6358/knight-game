package game.ingame.bottom;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BottomPanelButton extends JButton {

	// MouseEventListener 추가 및 기본 설정 세팅
	protected BottomPanelButton(String str) {
		super(str);
		addMouseListener(new BottomPanelEvent().new BottomMouseListener());
		setFocusable(false);
		setFont(new Font("SansSerif", Font.BOLD, 20));
	}
	
	protected BottomPanelButton(ImageIcon img) {
		super(img);
		addMouseListener(new BottomPanelEvent().new BottomMouseListener());
		setFocusable(false);
	}

}

class BasicPanelButton extends BottomPanelButton {

	// BasicPanelButton size 세팅 (1200, 90)
	protected BasicPanelButton(String str) {
		super(str);
		setSize(1200, 90);
	}

}

class BattlePanelButton extends BottomPanelButton {
	// BattlePanelButton size 세팅 (250, 120)
	protected BattlePanelButton(ImageIcon img) {
		super(img);
		setSize(250, 141);
	}
	
}

class SkillPanelButton extends BottomPanelButton {
	// SkillPanelButton size 세팅 (230, 120)
	protected SkillPanelButton(String str) {
		super(str);
		setSize(230, 120);
	}
}