package game;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Chapter extends JPanel {
	private JButton[] buttons = { new JButton("CHAPTER 1"), new JButton("CHAPTER 2"), new JButton("돌아가기") };
	private CardLayout cardLayout;
	private JPanel cardPanel;
	private MyListener listener;
	private boolean[] stageClear = new boolean[3];

	public Chapter(CardLayout cardLayout, JPanel cardPanel) {
		this.cardLayout = cardLayout;
		this.cardPanel = cardPanel;
		setLayout(null);
		listener = new MyListener();
		stageClear = new boolean[3];

		// Chapter 1 버튼
		buttons[0].setBounds(200, 200, 100, 100);
		add(buttons[0]);
		buttons[0].addActionListener(listener);

		// Chapter 2 버튼
		buttons[1].setBounds(400, 200, 100, 100);
		add(buttons[1]);
		buttons[1].addActionListener(listener);
		buttons[1].setEnabled(false);

		// 돌아가기 버튼
		buttons[2].setBounds(600, 200, 100, 100);
		add(buttons[2]);
		buttons[2].addActionListener(listener);
	}

	public void updateStageClear(int stageIndex, boolean isClear) {
		stageClear[stageIndex] = isClear;
		updateChapter();
	}

	// chapter2 버튼 활성화
	public void updateChapter() {
		if (stageClear[0] && stageClear[1] && stageClear[2]) {
			buttons[1].setEnabled(true);
		}
	}

	class MyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (buttons[0] == (JButton) e.getSource()) {
				cardLayout.show(cardPanel, "Chapter1Stage");
			}
			if (buttons[1] == (JButton) e.getSource()) {
				cardLayout.show(cardPanel, "Chapter2Stage");
			}
			if (buttons[2] == (JButton) e.getSource()) {
				cardLayout.show(cardPanel, "Lobby");
			}
		}
	}
}