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

	// BasicPanelButton size 세팅
	protected BasicPanelButton(String str) {
		super(str);
		setSize(1200, 90);
	}

}
