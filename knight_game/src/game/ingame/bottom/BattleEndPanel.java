package game.ingame.bottom;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

// 전투 종료 후를 관리하는 메서드
public class BattleEndPanel extends BottomBox {

	public BattleEndPanel() {
		super();
		JLabel nextpage = new JLabel("클릭시 로비로 돌아갑니다");
		nextpage.setForeground(new Color(128, 128, 128));
		nextpage.setFont(new Font("SansSerif", Font.BOLD, 22));
		nextpage.setBounds(1040, 70, 300, 470);
		add(nextpage);
	}

}