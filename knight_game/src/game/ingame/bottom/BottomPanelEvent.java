package game.ingame.bottom;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.Function;
import game.InGamePanel;
import game.LobbyPanel;

public class BottomPanelEvent {
	public static InGamePanel inGame;
	public static InGamePanel.BottomPanel bottomPanel;
	private static Integer textPanelCount = 0;
	private final ImageIcon ATTACK_BUTTON_IMAGE = BattlePanel.ATTACK_BUTTON_IMAGE;
	private final ImageIcon SKILL_BUTTON_IMAGE = BattlePanel.SKILL_BUTTON_IMAGE;
	private final ImageIcon FIGHT_BUTTON_IMAGE = BasicPanel.FIGHT_BUTTON_IMAGE;
	private final ImageIcon RUN_BUTTON_IMAGE = BasicPanel.RUN_BUTTON_IMAGE;
	private final ImageIcon CRITICAL_ATTACK_BUTTON_IMAGE = BattleSkillPanel.CRITICAL_ATTACK_BUTTON_IMAGE;
	private final ImageIcon DOUBLE_ATTACK_BUTTON_IMAGE = BattleSkillPanel.DOUBLE_ATTACK_BUTTON_IMAGE;
	private final ImageIcon HEAVENLY_STRIKE_BUTTON_IMAGE = BattleSkillPanel.HEAVENLY_STRIKE_BUTTON_IMAGE;

	private boolean fadeoutCalled = false;

	public BottomPanelEvent() {
		super();
	}

	class BottomMouseListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			super.mousePressed(e);

			// 클릭 소스가 JButton 인 경우
			if (e.getSource() instanceof JButton) {
				JButton src = (JButton) e.getSource();
				JFrame frame = (JFrame) src.getTopLevelAncestor();

				if (src.getIcon() != null && src.getIcon().equals(FIGHT_BUTTON_IMAGE)) {
					bottomPanel.setBottomBoxPanel(new BattlePanel());
					TextLabel.textLabel.setTextLabel("");
					return;
				}

				// 사용 예
				if (src.getIcon() != null && src.getIcon().equals(RUN_BUTTON_IMAGE)) {
					JPanel a = (JPanel) src.getParent().getParent().getParent();
					JPanel bgPanel = (JPanel) a.getComponent(0);
					Function.FADE_OUT(new LobbyPanel(inGame.character), frame, (JPanel) src.getParent().getParent());
					inGame.setEnabled(false);

					return;
				}

				if (src.getIcon() != null && src.getIcon().equals(ATTACK_BUTTON_IMAGE)) {
					inGame.characterAttack();
					inGame.repaint();
					bottomPanel.setBottomBoxPanel(new BattleTextPanel(inGame.character, inGame.monster));
					inGame.monsterAttackedEffect();
					return;
				}

				if (src.getIcon() != null && src.getIcon().equals(SKILL_BUTTON_IMAGE)) {
					bottomPanel.setBottomBoxPanel(new BattleSkillPanel());
					return;
				}

				if (src.getIcon() != null && src.getIcon().equals(CRITICAL_ATTACK_BUTTON_IMAGE)) {
					if (!inGame.character.canUseCriticalAttack()) {
						TextLabel.textLabel.setTextLabel("스킬 사용 가능 횟수를 초과했습니다.");
						return;
					}
					inGame.characterCriticalAttack();
					inGame.repaint();
					bottomPanel.setBottomBoxPanel(new BattleTextPanel(inGame.character, inGame.monster));
					inGame.monsterAttackedEffect();
					return;
				}

				if (src.getIcon() != null && src.getIcon().equals(DOUBLE_ATTACK_BUTTON_IMAGE)) {
					if (!inGame.character.canUseDoubleAttack()) {
						TextLabel.textLabel.setTextLabel("스킬 사용 가능 횟수를 초과했습니다.");
						return;
					}
					inGame.characterDoubleAttack();
					inGame.repaint();
					bottomPanel.setBottomBoxPanel(new BattleTextPanel(inGame.character, inGame.monster));
					inGame.monsterAttackedEffect();
					return;
				}

				if (src.getIcon() != null && src.getIcon().equals(HEAVENLY_STRIKE_BUTTON_IMAGE)) {
					if (!inGame.character.canUseHeavenlyStrike()) {
						TextLabel.textLabel.setTextLabel("스킬 사용 가능 횟수를 초과했습니다.");
						return;
					}
					inGame.characterHeavenlyStrike();
					inGame.repaint();
					bottomPanel.setBottomBoxPanel(new BattleTextPanel(inGame.character, inGame.monster));
					inGame.monsterAttackedEffect();
					return;
				}

			}

			// 클릭 소스가 JPanel 인 경우
			if (e.getSource() instanceof JPanel) {

				JPanel src = (JPanel) e.getSource();
				JFrame frame = (JFrame) src.getTopLevelAncestor();

				if (src.getClass().equals(BattleSkillPanel.class)) {
					bottomPanel.setBottomBoxPanel(new BattlePanel());
					TextLabel.textLabel.setTextLabel("");
				}

				// BattleTextPanel 클릭
				if (src.getClass().equals(BattleTextPanel.class)) {

					if (!inGame.character.isAlive()) {
						bottomPanel.setBottomBoxPanel(new BattleEndPanel());
						TextLabel.textLabel.setTextLabel(
								inGame.character.getName() + " 기사가 사망했습니다 경험치 - " + inGame.character.getExp());
						textPanelCount = 0;
						return;
					}

					if (!inGame.monster.isAlive()) {
						String str = "";
						bottomPanel.setBottomBoxPanel(new BattleEndPanel());
						if (inGame.monsters.length == inGame.count) {
							str = " 스테이지 클리어!";
							if (inGame.stage == "stage1") {
								inGame.character.setStage(0, true);
							} else if (inGame.stage == "stage2") {
								inGame.character.setStage(1, true);
							} else if (inGame.stage == "stage3") {
								inGame.character.setStage(2, true);
							} else if (inGame.stage == "stage4") {
								inGame.character.setStage(3, true);
							} else if (inGame.stage == "stage5") {
								inGame.character.setStage(4, true);
							} else if (inGame.stage == "stage6") {
								inGame.character.setStage(5, true);
							}
						}
						// 최대 레벨에서 몬스터 처치시의 텍스트
						if (inGame.character.getLevel() == inGame.character.getEXPArrayLength()) {
							TextLabel.textLabel.setTextLabel(inGame.monster.getName() + " 처치! 최대 레벨입니다!");
							return;
						}
						inGame.character.plusEXP(inGame.monster.getEXP());
						TextLabel.textLabel.setTextLabel(
								inGame.monster.getName() + " 처치! " + inGame.monster.getEXP() + "의 경험치 획득!");
						return;
					}

					// 몬스터가 공격을 할 지, 공격 패널로 돌아갈 지 확인
					if (textPanelCount == 0) {
						inGame.monsterAttack();
						inGame.repaint();
						bottomPanel.setBottomBoxPanel(new BattleTextPanel(inGame.monster, inGame.character));
						inGame.characterAttackedEffect();
						textPanelCount++;
					} else {
						bottomPanel.setBottomBoxPanel(new BattlePanel());
						TextLabel.textLabel.setTextLabel("");
						textPanelCount = 0;
						return;
					}
				}

				// BattleEndPanel 클릭
				if (src.getClass().equals(BattleEndPanel.class)) {
					// 캐릭터 사망시
					if (!inGame.character.isAlive() && !fadeoutCalled) {
						fadeoutCalled = true; // 플래그 설정
						JPanel a = (JPanel) src.getParent().getParent();
						JPanel bgPanel = (JPanel) a.getComponent(0);
						Function.FADE_OUT(new LobbyPanel(inGame.character), frame, (JPanel) src.getParent().getParent());
						return;
					}

					// 다음 몬스터가 있을 때
					if (inGame.setMonster()) {
						inGame.setPanel();
						return;
					}

					// 다음 몬스터가 없을 때
					if (!inGame.setMonster() && !fadeoutCalled) {
						fadeoutCalled = true; // 플래그 설정
						JPanel a = (JPanel) src.getParent().getParent();
						JPanel bgPanel = (JPanel) a.getComponent(0);
						Function.FADE_OUT(new LobbyPanel(inGame.character), frame, (JPanel) src.getParent().getParent());
						return;
					}
				}

			}

		}
	}
}
