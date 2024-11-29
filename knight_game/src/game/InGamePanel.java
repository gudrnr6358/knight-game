package game;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

import game.ingame.bottom.BasicPanel;
import game.ingame.bottom.BattlePanel;
import game.ingame.bottom.BottomBox;
import game.ingame.bottom.BottomPanelEvent;
import game.ingame.bottom.TextLabel;
import game.ingame.top.ingameimages.CharacterImageUnit;
import game.ingame.top.ingameimages.MonsterImageUnit;
import game.ingame.top.statuspanel.CharacterStatusPanel;
import game.ingame.top.statuspanel.MonsterStatusPanel;
import game.monster.Monster;

public class InGamePanel extends JPanel {

	public Character character;
	public Monster[] monsters;
	public Monster monster;
	public Integer count = 0;
	private Image backgroundImage;
	JPanel bgPanel = new JPanel();

	// 첫 생성 시에는 멤버 초기화, setPanel 호출해서 기본 틀 생성
	public InGamePanel(Character character, Monster[] monsters, Image backgroundImage) {
		super();
		this.character = character;
		this.monsters = monsters;
		this.monster = monsters[count++];
		this.backgroundImage = backgroundImage;

		setLayout(null);
		setPanel();
		setBounds(0, 0, 1366, 900);
		character.setSkillCount();
		// BottomPanelEvent, BottomBox character, monster 정보 공유
		BottomPanelEvent.inGame = InGamePanel.this;
		BottomBox.INGAME = this;
	}

	// 이전 Panel 제거하고 Panel 부착
	// 몬스터 처치 후에 호출
	public void setPanel() {
		InGamePanel.this.removeAll();
		add(bgPanel);
		setTopPanel();
		setBottomPanel();
		InGamePanel.this.repaint();
	}

	private void setTopPanel() {
		add(new TopPanel());
	}

	private void setBottomPanel() {
		add(new BottomPanel());
	}

	public void characterAttack() {
		monster.nowHp -= character.attack();
	}

	public void characterSkill() {
		monster.nowHp -= character.skill();
	}

	public void charSkill() {
		monster.nowHp -= character.charSkill();
	}

	public void monsterAttack() {
		character.nowHp -= monster.attack();
	}

	public Boolean setMonster() {
		// monsters 배열의 크기를 넘어가지 않으면 true 반환
		if (count < monsters.length) {
			monster = monsters[count++];
			return true;
		}
		return false;
	}

	// 생성자 사용해서 기본 틀 제공 및 StatusBar, Image 부착하는 메서드 호출
	private class TopPanel extends JPanel {

		private TopPanel() {
			setLayout(null);
			TopPanel.this.setTopPanel();
			setBounds(0, 0, 1366, 510);
			setOpaque(false);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
			g2d.drawImage(backgroundImage, 0, 0, 1366, 510, 0, 0, 1366, 510, null);
		}

		// TopPanel 생성은 한 번, 이후에는 이 메서드를 통해서 변화
		private void setTopPanel() {
			setStatusBar();
			setInGameImageUnit();
		}

		// 직관적으로 보이기 위해 TopPanel.this.add() 사용
		private void setStatusBar() {
			TopPanel.this.add(new CharacterStatusPanel(character));
			TopPanel.this.add(new MonsterStatusPanel(monster));
		}

		// 직관적으로 보이기 위해 TopPanel.this.add() 사용
		private void setInGameImageUnit() {
			TopPanel.this.add(new CharacterImageUnit(character));
			TopPanel.this.add(new MonsterImageUnit(monster));
		}
	}

	// 생성자 사용해서 기본 틀 제공 및 "기본 BottomBox" 부착하는 메서드 호출
	public class BottomPanel extends JPanel {

		private BottomPanel() {
			BottomPanel.this.setLayout(null);
			setBounds(0, 510, 1366, 390);
			add(new BasicPanel());
			TextLabel.textLabel.setTextLabel(monster.getName() + "을 마주쳤다");
			// BottomPanelEvent 클래스에 BottomBox 전환을 위한 BottomPanel 정보 넘겨주기
			BottomPanelEvent.bottomPanel = this;
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
			g2d.drawImage(backgroundImage, 0, 0, 1366, 390, 0, 510, 1366, 900, null);
		}

		public void setBottomBoxPanel(BottomBox bottomBox) {
			BottomPanel.this.removeAll();
			BottomPanel.this.add(bottomBox);
			BottomPanel.this.repaint();
		}

	}

}