package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.monster.Monster;

public class InGame extends JPanel {

	/*
	 * 할 일
	 * 
	 * 하단 bar 위치 조정해서 규격 보내주기 전체적인 버튼 위치 조정 몬스터 스킬 로직 구현 (랜덤 사용)
	 *
	 * *** monster 정보 순서대로 얻는 방법 구현하기 ***
	 * 
	 * 다음 몬스터 만났을 때, 상태창과 이미지 재세팅하는 메서드 고안.. setStatusBar setImage 메서드 만들어서 if 안에서
	 * 호출하면 될 듯?
	 * 
	 * 스크립트 라인 추가하기 스크립트 표시하는 방법 고안
	 * 
	 */
	Character character;
	Monster[] monsters;
	Monster monster;

	ImageIcon characterImage;
	ImageIcon monsterImage;
	JLabel charImage;
	JLabel monImage;

	JPanel bar;

	JPanel characterStatusBar;
	JLabel charName;
	JLabel charPower;
	CharacterHealthBar charHealthBar;

	JPanel monsterStatusBar;
	JLabel monName;
	JLabel monPower;
	MonsterHealthBar monHealthBar;

	JPanel battleBar;

	Timer timer;
	Boolean inBattle = false;
	static int count;
	Font font = new Font("SansSerif", Font.BOLD, 20);

	// Monster 배열 넘겨 받는 걸로 수정해야함
	public InGame(Character character, Monster[] monsters) {
		setBackground(Color.WHITE);
		
		this.character = character;
		this.monster = monsters[count++];
		setLayout(null);

		this.setStatusBar();
		this.setBar();
	}

	public void battle() {
		if (monster.nowHp <= 0 || character.nowHp <= 0) {
			removeAll();
			timer.stop();
			return;
		}

	}

	public void setStatusBar() {
		// 캐릭터 상태바 생성
		characterStatusBar = new JPanel();
		characterStatusBar.setLayout(null);
		characterStatusBar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
		characterStatusBar.setBounds(986, 400, 350, 100);
		add(characterStatusBar);

		charName = new JLabel(character.name);
		charName.setFont(font);
		charName.setBounds(15, 10, 500, 30);
		characterStatusBar.add(charName);

		charPower = new JLabel("전투력 : " + character.power.toString());
		charPower.setFont(font);
		charPower.setBounds(195, 10, 200, 30);
		characterStatusBar.add(charPower);

		charHealthBar = new CharacterHealthBar(character);
		characterStatusBar.add(charHealthBar);
		charHealthBar.setBounds(15, 55, 300, 20);

		// 몬스터 상태바 생성
		monsterStatusBar = new JPanel();
		monsterStatusBar.setLayout(null);
		monsterStatusBar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
		monsterStatusBar.setBounds(25, 25, 350, 100);
		add(monsterStatusBar);

		monName = new JLabel(monster.NAME);
		monName.setFont(font);
		monName.setBounds(15, 10, 500, 30);
		monsterStatusBar.add(monName);

		monPower = new JLabel("전투력 : " + monster.POWER.toString());
		monPower.setFont(font);
		monPower.setBounds(195, 10, 200, 30);
		monsterStatusBar.add(monPower);

		monHealthBar = new MonsterHealthBar(monster);
		monsterStatusBar.add(monHealthBar);
		monHealthBar.setBounds(15, 55, 300, 20);
	}

	public void setImage() {
		// Character, Monster Image, Status 나타내기 출력
		characterImage = character.getImage();
		monsterImage = monsters[count].getImage();
		charImage = new JLabel(characterImage);
		monImage = new JLabel(monsterImage);

		charImage.setBackground(Color.black);
		monImage.setBackground(Color.black);

		charImage.setBounds(50, 500, 100, 100);
		monImage.setBounds(50, 1000, 100, 100);

		add(charImage);
		add(monImage);
	}

	public void setBar() {
		bar = new JPanel();
		bar.setLayout(null);
		bar.setBorder(BorderFactory.createLineBorder(Color.gray, 3, true));
		bar.setBounds(16, 513, 1320, 335);
		add(bar);

		JButton btn1 = new JButton("싸운다");
		btn1.setFont(font);
		btn1.setBounds(20, 57, 1280, 60);
		btn1.setForeground(Color.BLACK);
		btn1.setBackground(Color.white);
		btn1.setFocusable(false); // 실행 후 첫 화면, check 방지용
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bar.removeAll();
				setBattleBar();
				timer = new Timer(500, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						battle();
						repaint();
						revalidate();
					}
				});
				timer.start();
				inBattle = true;
				System.out.println(inBattle);
			}
		});

		JButton btn2 = new JButton("도망친다");
		btn2.setFont(font);
		btn2.setBounds(20, 125, 1280, 60);
		btn2.setForeground(Color.BLACK);
		btn2.setBackground(Color.white);
		btn2.setFocusable(false);
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 로비로 돌아가기 어차피 뭘 하든 로비로 돌아가니까
				// new InGame() 끝난 뒤에는 new Lobby 하면 될 듯
			}
		});
		bar.add(btn1);
		bar.add(btn2);
		
	}

	public void setBattleBar() {
			bar.removeAll();
			
			JButton attackBtn = new JButton("공격");
			attackBtn.setFont(font);
			attackBtn.setBounds(200, 70, 250, 90);
			attackBtn.setForeground(Color.BLACK);
			attackBtn.setBackground(Color.white);
			attackBtn.setFocusable(false); // 실행 후 첫 화면, check 방지용
			attackBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					monster.nowHp -= character.attack();
				}
			});

			JButton skillBtn = new JButton("스킬1");
			skillBtn.setFont(font);
			skillBtn.setBounds(500, 70, 250, 90);
			skillBtn.setForeground(Color.BLACK);
			skillBtn.setBackground(Color.white);
			skillBtn.setFocusable(false); // 실행 후 첫 화면, check 방지용
			skillBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					monster.nowHp -= character.skill();
				}
			});
			JButton charSkillBtn = new JButton("스킬2");
			charSkillBtn.setFont(font);
			charSkillBtn.setBounds(800, 70, 250, 90);
			charSkillBtn.setForeground(Color.BLACK);
			charSkillBtn.setBackground(Color.white);
			charSkillBtn.setFocusable(false); // 실행 후 첫 화면, check 방지용
			charSkillBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					monster.nowHp -= character.charSkill();
				}
			});

			bar.add(attackBtn);
			bar.add(skillBtn);
			bar.add(charSkillBtn);
	}
	
	class CharacterHealthBar extends JPanel {
		Character character;

		public CharacterHealthBar(Character character) {
			this.character = character;
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.LIGHT_GRAY);
			g.fillRoundRect(0, 0, 230, 20, 10, 10);

			g.setColor(Color.green);
			if ((int) ((character.nowHp / (double) character.hp) * 100) <= 15) {
				g.setColor(Color.red);
			}
			g.fillRoundRect(0, 0, (int) ((character.nowHp / (double) character.hp) * 230), 20, 10, 10);
		}
	}

	class MonsterHealthBar extends JPanel {
		Monster monster;

		public MonsterHealthBar(Monster monster) {
			this.monster = monster;
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.LIGHT_GRAY);
			g.fillRoundRect(0, 0, 230, 20, 10, 10);

			g.setColor(Color.green);
			g.fillRoundRect(0, 0, (int) ((monster.nowHp / (double) monster.HP) * 230), 20, 10, 10);

		}
	}
}
