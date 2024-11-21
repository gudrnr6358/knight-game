package game.ingame.bottom;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

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
				bottomPanel.setBottomBoxPanel(new BattleTextPanel(inGame.character, inGame.monster));
				return;
			}

		}

	}

	class BottomKeyListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
		}

	}
}
