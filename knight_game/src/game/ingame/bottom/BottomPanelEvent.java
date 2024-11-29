package game.ingame.bottom;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.HomePanel;
import game.InGamePanel;
import game.LobbyPanel;
import game.monster.boss.Boss;

public class BottomPanelEvent {
	public static InGamePanel inGame;
	public static InGamePanel.BottomPanel bottomPanel;
	private static Integer count = 0;

	class BottomMouseListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			super.mousePressed(e);

			// 클릭 소스가 JButton 인 경우
			if (e.getSource() instanceof JButton) {
				JButton src = (JButton) e.getSource();
				JFrame frame = (JFrame) src.getTopLevelAncestor();

				if (src.getText().equals("싸운다")) {
					bottomPanel.setBottomBoxPanel(new BattlePanel());
					TextLabel.textLabel.setTextLabel("");
					return;
				}

				if (src.getText().equals("도망친다")) {
					JPanel a = (JPanel) src.getParent().getParent().getParent();
					JPanel bgPanel = (JPanel) a.getComponent(0);
					HomePanel.fadeout(bgPanel, new LobbyPanel(inGame.character), frame);
					return;
				}

				if (src.getText().equals("공격")) {
					inGame.characterAttack();
					inGame.repaint();
					bottomPanel.setBottomBoxPanel(new BattleTextPanel(inGame.character, inGame.monster));
					return;
				}

				if (src.getText().equals("캐릭터 스킬")) {
					if (!inGame.character.canUseSkill()) {
						TextLabel.textLabel.setTextLabel("스킬 사용 가능 횟수를 초과했습니다.");
						return;
					}
					inGame.characterSkill();
					inGame.repaint();
					bottomPanel.setBottomBoxPanel(new BattleTextPanel(inGame.character, inGame.monster));
					return;
				}

				if (src.getText().equals("두번 베기")) {
					if (!inGame.character.canUsecharSkill()) {
						TextLabel.textLabel.setTextLabel("스킬 사용 가능 횟수를 초과했습니다.");
						return;
					}
					inGame.charSkill();
					inGame.repaint();
					bottomPanel.setBottomBoxPanel(new BattleTextPanel(inGame.character, inGame.monster));
					return;
				}

			}

			// 클릭 소스가 JPanel 인 경우
			if (e.getSource() instanceof JPanel) {

				JPanel src = (JPanel) e.getSource();
				JFrame frame = (JFrame) src.getTopLevelAncestor();

				// BattleTextPanel 클릭
				if (src.getClass().equals(BattleTextPanel.class)) {

					if (!inGame.character.isAlive()) {
						bottomPanel.setBottomBoxPanel(new BattleEndPanel());
						TextLabel.textLabel.setTextLabel(
								inGame.character.getName() + " 기사가 사망했습니다 경험치 - " + inGame.character.getExp());
						return;
					}

					if (!inGame.monster.isAlive()) {
						String str = "";
						bottomPanel.setBottomBoxPanel(new BattleEndPanel());
						if (inGame.monsters.length == inGame.count) {
							str = " 스테이지 클리어!";
						}
						inGame.character.plusEXP(inGame.monster.getEXP());
						TextLabel.textLabel.setTextLabel(inGame.monster.getName() + " 처치 " + inGame.monster.getEXP()
								+ "의 경험치 획득!    " + "Lv" + inGame.character.getLevel() + " ("
								+ inGame.character.getExp() + "/" + inGame.character.getLevelExp() + ") " + str);
						return;
					}

					// 몬스터가 공격을 할 지, 공격 패널로 돌아갈 지 확인
					if (count == 0) {
						inGame.monsterAttack();
						inGame.repaint();
						bottomPanel.setBottomBoxPanel(new BattleTextPanel(inGame.monster, inGame.character));
						count++;
					} else {
						bottomPanel.setBottomBoxPanel(new BattlePanel());
						TextLabel.textLabel.setTextLabel("");
						count = 0;
						return;
					}
				}

				// BattleEndPanel 클릭
				if (src.getClass().equals(BattleEndPanel.class)) {
					// 캐릭터 사망시
					if (!inGame.character.isAlive()) {
						JPanel a = (JPanel) src.getParent().getParent();
						JPanel bgPanel = (JPanel) a.getComponent(0);
						HomePanel.fadeout(bgPanel, new LobbyPanel(inGame.character), frame);
						inGame.character.dead();
						return;
					}

					// 다음 몬스터가 있을 때
					if (inGame.setMonster()) {
						inGame.setPanel();
						return;
					}
					// 다음 몬스터가 없을 때
					if (!inGame.setMonster()) {
						JPanel a = (JPanel) src.getParent().getParent();
						JPanel bgPanel = (JPanel) a.getComponent(0);
						HomePanel.fadeout(bgPanel, new LobbyPanel(inGame.character), frame);
						return;
					}
				}

			}

		}
	}
}
