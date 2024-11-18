package game.ingame.bottompanel;

import java.awt.Font;

import javax.swing.JButton;

public class BottomPanelButton extends JButton {

	// MouseEventListener 추가 및 기본 설정 세팅
	protected BottomPanelButton(String str) {
		super(str);
		addMouseListener(new BottomPanelEvent());
		setFocusable(false);
		setFont(new Font("SansSerif", Font.BOLD, 20));
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
	protected BattlePanelButton(String str) {
		super(str);
		setSize(250, 120);
	}
}