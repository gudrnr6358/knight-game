package game.ingame.bottom;

public class BasicPanel extends BottomBox {

	// 크기, 위치 설정 및 버튼 부착
	public BasicPanel() {
		add(new FightButton());
		add(new RunButton());
	}

	private class FightButton extends BasicPanelButton {

		private FightButton() {
			super("싸운다");
			setLocation(60, 100);
		}

	}

	private class RunButton extends BasicPanelButton {

		private RunButton() {
			super("도망친다");
			setLocation(60, 210);
		}

	}

}
