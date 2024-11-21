package game.ingame.bottom;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import game.GameFrame;
import game.InGames;
import game.Lobby;

public class BottomPanelEvent {
	public static InGames inGame;
	public static InGames.BottomPanel bottomPanel;

	class BottomMouseListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			super.mousePressed(e);

			// 클릭 소스가 JButton 인 경우
			if (e.getSource() instanceof JButton) {
				JButton src = (JButton) e.getSource();

				if (src.getText().equals("싸운다")) {
					bottomPanel.setBottomBoxPanel(new BattlePanel());
					TextLabel.textLabel.setTextLabel("몬스터 ㅎㅇ");
					return;
				}

				if (src.getText().equals("도망친다")) {
					GameFrame.setPanel(new Lobby());
					return;
				}

				if (src.getText().equals("공격")) {
					inGame.characterAttack();
					inGame.repaint();
					bottomPanel.setBottomBoxPanel(new BattleTextPanel(inGame.character, inGame.monster));
					return;
				}

				if (src.getText().equals("캐릭터 스킬")) {
					inGame.characterSkill();
					inGame.repaint();
					bottomPanel.setBottomBoxPanel(new BattleTextPanel(inGame.character, inGame.monster));
					return;
				}

				if (src.getText().equals("CharSkillButton")) {
					inGame.charSkill();
					inGame.repaint();
					bottomPanel.setBottomBoxPanel(new BattleTextPanel(inGame.character, inGame.monster));
					return;
				}

			}

			// 클릭 소스가 JPanel 인 경우
			if (e.getSource() instanceof JPanel) {
				JPanel src = (JPanel) e.getSource();

				// BattleTextPanel 클릭
				if (src.getClass().equals(BattleTextPanel.class)) {

					if (!inGame.character.isAlive()) {
						bottomPanel.setBottomBoxPanel(new BattleEndPanel());
						TextLabel.textLabel.setTextLabel("캐릭터가 사망했습니다");
						return;
					}

					if (!inGame.monster.isAlive()) {
						bottomPanel.setBottomBoxPanel(new BattleEndPanel());
						TextLabel.textLabel.setTextLabel("몬스터 처치! " + inGame.monster.getEXP() + "의 경험치 획득!");
						return;
					}

					if (inGame.allUnitAlive()) {
						bottomPanel.setBottomBoxPanel(new BattlePanel());
						TextLabel.textLabel.setTextLabel("전투 진행중");
						return;
					}

				}

				// BattleEndPanel 클릭
				if (src.getClass().equals(BattleEndPanel.class)) {
					
				}

			}

		}
	}
}
