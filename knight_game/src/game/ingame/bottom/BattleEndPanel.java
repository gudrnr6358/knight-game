package game.ingame.bottom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;

import game.InGamePanel;

// 전투 종료 후를 관리하는 메서드
public class BattleEndPanel extends BottomBox {

	public BattleEndPanel() {
		super();
		add(new NextPageInfoLabel().setString());
	}

	private class NextPageInfoLabel extends JLabel {

		private static String str;

		private NextPageInfoLabel() {
			super(str);
			setForeground(new Color(128, 128, 128));
			setFont(new Font("SansSerif", Font.BOLD, 22));
			setBounds(1040, 70, 300, 470);
		}

		// 우측 하단 출력할 문자열 정하는 메서드
		// this 반환을 통해 객체 생성 후, 한번에 처리
		private NextPageInfoLabel setString() {

			// 캐릭터 사망
			if (!INGAME.character.isAlive()) {
				str = "클릭 시 로비로 돌아갑니다";
				return this;
			}
			// 마지막 몬스터 처치
			if (!INGAME.monsters[INGAME.monsters.length - 1].isAlive()) {
				str = "클릭 시 로비로 돌아갑니다";
				return this;
			}
			str = "진행하려면 클릭하세요";
			return this;
		}
	}

}