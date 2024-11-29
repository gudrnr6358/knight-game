package game.ingame.bottom;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import game.InGamePanel;

// 전투 종료 후를 관리하는 메서드
public class BattleEndPanel extends BottomBox {
  public InGamePanel inGame;

  public BattleEndPanel(InGamePanel inGame) {
    super();
    this.inGame = inGame;
    String str = "";

    if (!inGame.character.isAlive()) {
      str = "클릭 시 로비로 돌아갑니다";
    }
    if (inGame.monsters.length == inGame.count) {
      str = "클릭 시 로비로 돌아갑니다";
    }
    if (inGame.monsters.length != inGame.count) {
      str = "진행하려면 클릭하세요";
    }

    JLabel nextpage = new JLabel(str);
    nextpage.setForeground(new Color(128, 128, 128));
    nextpage.setFont(new Font("SansSerif", Font.BOLD, 22));
    nextpage.setBounds(1040, 70, 300, 470);

    add(nextpage);
  }

}