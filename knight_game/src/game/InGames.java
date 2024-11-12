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

public class InGames extends JPanel {

	/*
	 * main commit & push
	 * 
	 * 할 일
	 * 
	 * BottomBattleBox Button 크기 조정
	 * 
	 * 첫 몬스터 처치 후 다음 몬스터 생성하는 로직 생성 몬스터가 공격하는 로직 생성
	 * 
	 */

	private final Font FONT = new Font("SansSerif", Font.BOLD, 20);
	private Character character;
	private Monster[] monsters;
	private Monster monster;
	private static Boolean inBattle = false;
	private Timer timer;
	private static JLabel textLabel;

	private static int count = 0;

	public InGames(Character character, Monster[] monsters) {
		this.character = character;
		this.monsters = monsters;
		this.monster = monsters[count++];
		BottomPanel.TextLabel.setTextLabel("하이욤 ㅋㅋzzz");
		setBackground(Color.WHITE);
		setLayout(null);
		setPanel();
		InGames.this.repaint();
	}

	private void setPanel() {
		InGames.this.removeAll();
		InGames.this.revalidate();
		// 이것보다는 몬스터 처치 시에 이런 로직을 넣는 게 좋을 듯
		if (monster.nowHp <= 0) {
			this.monster = monsters[count++];
		}
		//
		setTopPanel();
		setBottomPanel();
		InGames.this.repaint();
	}

	private void setTopPanel() {
		add(new TopPanel(monster));
	}

	private void setBottomPanel() {
		add(new BottomPanel());
	}

	private void battle() {
		if (monster.nowHp <= 0 || character.nowHp <= 0) {
			InGames.this.removeAll();
			timer.stop();
		}
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
						setBounds(15, 55, 300, 20);
					}
					if (combatant instanceof Monster) {
						setBounds(15, 55, 300, 20);
					}
				}

				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(0, 0, 230, 20, 10, 10);

					if (combatant instanceof Character) {
						Character c = (Character) combatant;
						g.setColor(Color.green);
						if ((int) ((c.nowHp / (double) c.hp) * 100) <= 15) {
							g.setColor(Color.red);
						}
						g.fillRoundRect(0, 0, (int) ((c.nowHp / (double) c.hp) * 230), 20, 10, 10);
					}

					if (combatant instanceof Monster) {
						Monster m = (Monster) combatant;
						g.setColor(Color.green);
						if ((int) ((m.nowHp / (double) m.HP) * 100) <= 15) {
							g.setColor(Color.red);
						}
						g.fillRoundRect(0, 0, (int) ((m.nowHp / (double) m.HP) * 230), 20, 10, 10);
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
				setFont(new Font("SansSerif", Font.BOLD, 25));
				setBackground(Color.black);
				setForeground(Color.pink);
				setBounds(0, 0, 1000, 50);
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
						setBounds(10, 10, 100, 30);
					}
				}

				private class SkillButton extends MyButton {

					private SkillButton() {
						super("캐릭터 스킬");
						setBounds(120, 10, 100, 30);
					}
				}

				private class CharSkillButton extends MyButton {

					private CharSkillButton() {
						super("CharSkillButton");
						setBounds(230, 10, 100, 30);
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

			@Override
			public void mousePressed(MouseEvent e) {
				JButton src = (JButton) e.getSource();

				if (src.getText().equals("싸운다")) {
					inBattle = true;
					BottomPanel.this.removeAll();
					BottomPanel.this.add(new BottomBox());
					BottomPanel.this.revalidate();
					BottomPanel.this.repaint();
					timer = new Timer(500, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							battle();
							InGames.this.repaint();
						}
					});
					timer.start();
					nextText("전투 시작!!!");
				}
				if (src.getText().equals("도망친다")) {
					GameFrame.setPanel(new Lobby(character));
				}

				if (src.getText().equals("공격")) {
					monster.nowHp -= character.attack();
					// 스크립트 출력, 시간 2초 대기 메서드 실행
					character.nowHp -= monster.attack();
				}

				if (src.getText().equals("캐릭터 스킬")) {
					monster.nowHp -= character.skill();
					// 스크립트 출력, 시간 2초 대기 메서드 실행
					character.nowHp -= monster.attack();
				}

				if (src.getText().equals("CharSkillButton")) {
					monster.nowHp -= character.charSkill();
					// 스크립트 출력, 시간 2초 대기 메서드 실행
					character.nowHp -= monster.attack();
				}
			}
		}
	}
}
