package game.ingame.bottom;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import game.GameFrame;
import game.Lobby;

public class BottomPanelEvent extends BottomPanel {

	class BottomMouseListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			super.mousePressed(e);
			JButton src = (JButton) e.getSource();

			if (src.getText().equals("싸운다")) {
				setBottomBoxPanel(new BattlePanel());
			}

			if (src.getText().equals("도망친다")) {
				GameFrame.setPanel(new Lobby());
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
