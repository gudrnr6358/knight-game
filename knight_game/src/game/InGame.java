package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.monster.Monster;

public class InGame extends JPanel {

	private final Font FONT = new Font("SansSerif", Font.BOLD, 20);
	private Character character;
	private Monster[] monsters;
	private Monster monster;
	private Boolean inBattle = false;

	private static int count = 0;

	/*
	 * 할 일
	 * 
	 * 몬스터 죽이고 경험치 얻고 몬스터 죽은 거 나타내기
	 * 
	 */

	public InGame(Character character, Monster[] monsters) {
		this.character = character;
		this.monsters = monsters;
		this.monster = monsters[count++];
		BottomPanel.TextLabel.setTextLabel(monster.NAME + "을 마주쳤다!");
		setBackground(Color.WHITE);
		setLayout(null);
		setPanel();
	}

	private void setPanel() {
		InGame.this.removeAll();
		InGame.this.revalidate();
		if (monster.nowHp <= 0 && count < monsters.length) {
			this.monster = monsters[count++];
			inBattle = false;
			BottomPanel.TextLabel.setTextLabel(monster.NAME + "을 마주쳤다!");
		}
		setTopPanel();
		setBottomPanel();
		InGame.this.repaint();
	}

	private void setTopPanel() {
		add(new TopPanel(monster));
	}

	private void setBottomPanel() {
		add(new BottomPanel());
	}

	private void nextText(String str) {
		BottomPanel.TextLabel.setTextLabel(str);
		setPanel();
	}

	private class TopPanel extends JPanel {

		private TopPanel(Monster monster) {
			setLayout(null);
			setBackground(Color.white);
			add(new StatusPanel(character));
			add(new StatusPanel(monster));
			add(new CombatantImages(character));
			add(new CombatantImages(monster));
			setBounds(0, 0, 1366, 510);
		}

		private class StatusPanel extends JPanel {

			private StatusPanel(Character c) {
				setLayout(null);
				setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
				add(new NameLabel(c.name));
				add(new PowerLabel(c.power.toString()));
				add(new HealthPanel(c));
				setBounds(986, 400, 350, 100);
			}

			private StatusPanel(Monster m) {
				setLayout(null);
				setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
				add(new NameLabel(m.NAME));
				add(new PowerLabel(m.POWER.toString()));
				add(new HealthPanel(m));
				setBounds(25, 25, 350, 100);
			}

			private class NameLabel extends JLabel {
				private NameLabel(String name) {
					super(name);
					super.setFont(FONT);
					super.setBounds(15, 10, 500, 30);
				}
			}

			private class PowerLabel extends JLabel {
				private PowerLabel(String power) {
					super("전투력 : " + power);
					super.setFont(FONT);
					super.setBounds(195, 10, 200, 30);
				}
			}

			private class HealthPanel extends JPanel {
				Combatant combatant;

				private HealthPanel(Combatant combatant) {
					this.combatant = combatant;

					if (combatant instanceof Character) {
						setBounds(15, 55, 332, 20);
					}
					if (combatant instanceof Monster) {
						setBounds(15, 55, 332, 20);
					}
				}

				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(0, 0, 230, 20, 10, 10);
					String str;

					if (combatant instanceof Character) {
						Character c = (Character) combatant;
						g.setColor(Color.green);
						if ((int) ((c.nowHp / (double) c.hp) * 100) <= 15) {
							g.setColor(Color.red);
						}
						g.fillRoundRect(0, 0, (int) ((c.nowHp / (double) c.hp) * 230), 20, 10, 10);
						str = new String(c.nowHp + " / " + c.hp);
						g.setColor(Color.black);
						g.setFont(FONT);
						g.drawString(str, 235, 15);
					}

					if (combatant instanceof Monster) {
						Monster m = (Monster) combatant;
						g.setColor(Color.green);
						if ((int) ((m.nowHp / (double) m.HP) * 100) <= 15) {
							g.setColor(Color.red);
						}
						g.fillRoundRect(0, 0, (int) ((m.nowHp / (double) m.HP) * 230), 20, 10, 10);
						str = new String(m.nowHp + " / " + m.HP);
						g.setColor(Color.black);
						g.setFont(FONT);
						g.drawString(str, 235, 15);
					}
				}
			}

		}

		private class CombatantImages extends JLabel {

			private CombatantImages(ImageUnit unit) {
				super(unit.getImage());
				if (unit instanceof Character) {
					setBounds(150, 200, 300, 300);
				}
				if (unit instanceof Monster) {
					setBounds(950, 0, 300, 300);
				}
			}

		}
	}

	private class BottomPanel extends JPanel {

		private BottomBox bottomBox;
		private static JLabel textLabel;

		private BottomPanel() {
			setLayout(null);
			setBackground(Color.white);
			setBounds(0, 510, 1366, 390);
			bottomBox = new BottomBox();
			add(bottomBox);
		}

		private static class TextLabel extends JLabel {

			private TextLabel(String str) {
				super(str);
				textLabel = this;
				setFont(new Font("SansSerif", Font.PLAIN, 25));
				setForeground(Color.black);
				setBounds(30, 10, 1300, 60);
			}

			private static void setTextLabel(String str) {
				new TextLabel(str);
			}
		}

		private class BottomBox extends JPanel {

			private BottomBox() {
				setLayout(null);
				setBorder(BorderFactory.createLineBorder(Color.gray, 3, true));
				setBounds(16, 3, 1320, 335);
				if (inBattle) {
					add(new BottomBattlePanel());
				}
				if (!inBattle) {
					add(new BottomBasicPanel());
				}
			}

			private class BottomBasicPanel extends JPanel {

				private BottomBasicPanel() {
					setLayout(null);
					setBounds(3, 3, 1314, 329);
					add(new FightButton());
					add(new RunButton());
					add(textLabel);
				}

				private class FightButton extends MyButton {
					private FightButton() {
						super("싸운다");
						setBounds(55, 100, 1200, 90);
					}
				}

				private class RunButton extends MyButton {

					private RunButton() {
						super("도망친다");
						setBounds(55, 210, 1200, 90);
					}
				}

			}

			private class BottomBattlePanel extends JPanel {

				private BottomBattlePanel() {
					setLayout(null);
					add(new AttackButton());
					add(new SkillButton());
					add(new CharSkillButton());
					setBounds(3, 3, 1314, 329);
					add(textLabel);
				}

				private class AttackButton extends MyButton {

					private AttackButton() {
						super("공격");
						setBounds(100, 100, 250, 120);
					}
				}

				private class SkillButton extends MyButton {

					private SkillButton() {
						super("캐릭터 스킬");
						setBounds(500, 100, 250, 120);
					}
				}

				private class CharSkillButton extends MyButton {

					private CharSkillButton() {
						super("CharSkillButton");
						setBounds(900, 100, 250, 120);
					}
				}

			}

			private class MyButton extends JButton {
				private MyButton(String str) {
					super(str);
					addMouseListener(new ButtonEvent());
					setFocusable(false);
					setFont(FONT);
				}
			}

		}

		private class ButtonEvent extends MouseAdapter {
			private Timer timer;

			@Override
			public void mousePressed(MouseEvent e) {
				JButton src = (JButton) e.getSource();

				if (src.getText().equals("싸운다")) {
					inBattle = true;
					BottomPanel.this.repaint();
					nextText("전투 시작!");
					timer = new Timer(1000, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if (!monsters[(monsters.length - 1)].isAlive()) {
								nextText("스테이지 클리어!");
								timer.stop();
							}
						}
					});
					timer.start();
				}
				if (src.getText().equals("도망친다")) {
					GameFrame.setPanel(new Lobby());
				}

				if (src.getText().equals("공격")) {
					monster.nowHp -= character.attack();
					if (!monster.isAlive()) {
						setPanel();
						return;
					} else {
						character.nowHp -= monster.attack();
					}
					if (!character.isAlive()) {
						nextText("캐릭터가 사망했습니다");
						return;
					}
					battleText();
				}

				if (src.getText().equals("캐릭터 스킬")) {
					monster.nowHp -= character.skill();
					if (!monster.isAlive()) {
						setPanel();
						return;
					} else {
						character.nowHp -= monster.attack();
					}
					if (!character.isAlive()) {
						nextText("캐릭터가 사망했습니다");
						return;
					}
					battleText();
				}

				if (src.getText().equals("CharSkillButton")) {
					monster.nowHp -= character.charSkill();
					if (!monster.isAlive()) {
						setPanel();
						return;
					} else {
						character.nowHp -= monster.attack();
					}
					if (!character.isAlive()) {
						nextText("캐릭터가 사망했습니다");
						return;
					}
					battleText();
				}
			}

			private void battleText() {
				String monsterString, characterString;

				if (character.useSkill) {
					characterString = new String(
							character.name + "의 스킬!!  " + monster.NAME + " -" + character.attackValue);
				} else {
					characterString = new String(
							character.name + "의 공격!  " + monster.NAME + " -" + character.attackValue);
				}

				if (monster.useSkill) {
					monsterString = new String(monster.NAME + "의 " + monster.getSkillName() + "!!  " + character.name
							+ " -" + monster.attackValue);
				} else {
					monsterString = new String(monster.NAME + "의 공격!  " + character.name + " -" + monster.attackValue);
				}
				nextText(characterString + "                         " + monsterString);
			}

			private boolean checkMonsterDead() {
				if (monster.nowHp > 0) {
					return false;
				}
				return true;
			}
		}
	}
}
