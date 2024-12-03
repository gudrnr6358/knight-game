package game.ingame.bottom;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

// 전투 종료 후를 관리하는 메서드
public class BattleEndPanel extends BottomBox {

	public BattleEndPanel() {
		super();
		add(new NextPageInfoLabel().setString());
	}

	private class NextPageInfoLabel extends JLabel {

		// 기본 값 세팅
		private Integer x = 1040;
		private Integer y = 70;
		private Integer width = 300;
		private Integer height = 470;

		private NextPageInfoLabel() {
			setForeground(new Color(128, 128, 128));
			setFont(new Font("SansSerif", Font.BOLD, 22));
			setBounds(x, y, width, height);
			repaint();
		}

		// 우측 하단 출력할 문자열 정하는 메서드
		// this 반환을 통해 객체 생성 후, 한번에 처리
		private NextPageInfoLabel setString() {

			// 캐릭터 사망
			if (!INGAME.character.isAlive()) {
				setText("클릭 시 로비로 돌아갑니다");
				return this;
			}
			// 마지막 몬스터 처치
			if (!INGAME.monsters[INGAME.monsters.length - 1].isAlive()) {
				setText("클릭 시 로비로 돌아갑니다");
				return this;
			}
			setText("진행하려면 클릭하세요");
			// 글자 수가 달라 위치가 달라져서 x 값 수정
			x = 1040 + 35;
			setBounds(x, y, width, height);
			return this;
		}
	}

}