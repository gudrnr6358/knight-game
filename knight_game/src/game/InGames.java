package game;

import java.awt.Color;

import javax.swing.JPanel;

import game.ingame.bottompanel.BasicPanel;
import game.ingame.bottompanel.BottomBox;
import game.ingame.toppanel.ingameimages.CharacterImageUnit;
import game.ingame.toppanel.ingameimages.MonsterImageUnit;
import game.ingame.toppanel.statuspanel.CharacterStatusPanel;
import game.ingame.toppanel.statuspanel.MonsterStatusPanel;
import game.monster.Monster;

public class InGames extends JPanel {

	private Character character;
	private Monster[] monsters;
	private Monster monster;
	private Integer count = 0;

	// 첫 생성 시에는 멤버 초기화, setPanel 호출해서 기본 틀 생성
	public InGames(Character character, Monster[] monsters) {
		super();
		this.character = character;
		this.monsters = monsters;
		this.monster = monsters[count];

		setBackground(Color.WHITE);
		setLayout(null);

		setPanel();
	}

	// 이전 Panel 제거하고 Panel 부착
	private void setPanel() {
		InGames.this.removeAll();
		setTopPanel();
		setBottomPanel();
		InGames.this.repaint();
	}

	private void setTopPanel() {
		add(new TopPanel());
	}

	private void setBottomPanel() {
		add(new BottomPanel());
	}

	// 생성자 사용해서 기본 틀 제공 및 StatusBar, Image 부착하는 메서드 호출
	private class TopPanel extends JPanel {

		private TopPanel() {
			setLayout(null);
			setTopPanel();
			setBounds(0, 0, 1366, 510);
		}

		public void setTopPanel() {
			setBackground(Color.white);
			setStatusBar();
			setInGameImageUnit();
		}

		// 직관적으로 보이기 위해 TopPanel.this.add() 사용
		public void setStatusBar() {
			TopPanel.this.add(new CharacterStatusPanel(character));
			TopPanel.this.add(new MonsterStatusPanel(monster));
		}

		// 직관적으로 보이기 위해 TopPanel.this.add() 사용
		public void setInGameImageUnit() {
			TopPanel.this.add(new CharacterImageUnit(character));
			TopPanel.this.add(new MonsterImageUnit(monster));
		}
	}

	// 생성자 사용해서 기본 틀 제공 및 "기본 BottomBox" 부착하는 메서드 호출
	private class BottomPanel extends JPanel {

		private BottomPanel() {
			BottomPanel.this.setLayout(null);
			setBackground(Color.white);
			setBounds(0, 510, 1366, 390);
			// setBottomBoxPanel 메서드 체이닝 사용
			add(new BottomBox().setBottomBoxPanel(new BasicPanel()));
		}
	}
}
