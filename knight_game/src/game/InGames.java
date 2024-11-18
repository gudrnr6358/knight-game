package game;

import java.awt.Color;

import javax.swing.JPanel;

import game.monster.Monster;

public class InGames extends JPanel {

	private Character character;
	private Monster[] monsters;
	private Monster monster;
	private Integer count = 0;

	// 첫 생성 시에는 멤버 초기화, setPanel 호출해서 기본 틀 생성
	public InGames(Character character, Monster[] monsters, Monster monster) {
		super();
		this.character = character;
		this.monsters = monsters;
		this.monster = monster;

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

	}

	// 생성자 사용해서 기본 틀 제공 및 "기본 BottomBox" 부착하는 메서드 호출
	private class BottomPanel extends JPanel {
	
		// 생성자 사용해서 기본 Border 및 TextBar 제공
		abstract class BottomBox extends JPanel {

		}
	}
}
