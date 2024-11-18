package game.ingame.bottompanel;

public class BasicPanel extends BottomBox {

	// 크기, 위치 설정 및 버튼 부착
	public BasicPanel() {
		setLayout(null);
		setBounds(3, 3, 1314, 329);
		add(new FightButton());
		add(new RunButton());
	}

	private class FightButton extends BasicPanelButton {

		private FightButton() {
			super("싸운다");
			setLocation(55, 100);
		}

	}

	private class RunButton extends BasicPanelButton {

		private RunButton() {
			super("도망친다");
			setLocation(55, 210);
		}

	}

}
