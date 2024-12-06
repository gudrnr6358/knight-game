package game.ingame.bottom;

import javax.swing.ImageIcon;

public class BasicPanel extends BottomBox {
	public static final ImageIcon FIGHT_BUTTON_IMAGE = new ImageIcon("images/fight_button_image.png");
	public static final ImageIcon RUN_BUTTON_IMAGE = new ImageIcon("images/run_button_image.png");

	// 크기, 위치 설정 및 버튼 부착
	public BasicPanel() {
		add(new FightButton());
		add(new RunButton());
	}

	private class FightButton extends BasicPanelButton {

		private FightButton() {
			super(FIGHT_BUTTON_IMAGE);
			setLocation(295, 90);
		}

	}

	private class RunButton extends BasicPanelButton {

		private RunButton() {
			super(RUN_BUTTON_IMAGE);
			setLocation(795, 90);
		}

	}

}
