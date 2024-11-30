package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChapterPanel extends JPanel {
	private Image backgroundImage;
	private JButton[] buttons = { new JButton("CHAPTER 1"), new JButton("CHAPTER 2"), new JButton("돌아가기") };
	private Character character;
	JPanel bgPanel = new JPanel();

	public ChapterPanel(Character character) {
		add(bgPanel);
		this.character = character;
		setBounds(0, 0, 1366, 900);
		setLayout(null);
		backgroundImage = new ImageIcon("images/ChapterBackground.png").getImage();
		// Chapter 1 버튼
		buttons[0].setBounds(820, 660, 180, 80);
		add(buttons[0]);

		buttons[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("챕터 1클릭");
				JButton a = (JButton) e.getSource();
				JFrame frame = (JFrame) a.getTopLevelAncestor();
				frame.getContentPane().removeAll();
				frame.add(new Chapter1Panel(character));
				frame.revalidate();
				frame.repaint();
			}
		});
		// Chapter 2 버튼
		buttons[1].setBounds(460, 400, 180, 80);
		add(buttons[1]);
		buttons[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("챕터 2클릭");
				if(!chapter2Warning) {
					JOptionPane.showMessageDialog(null, "Lv7 이상 플레이하는 것을 추천드립니다!","chapter 2",JOptionPane.INFORMATION_MESSAGE);

					chapter2Warning = true;
					JOptionPane.showMessageDialog(null, "이제 Chapter 2로 이동하려면 다시 버튼을 클릭하세요");
				} else {
					JButton a = (JButton) e.getSource();
					JFrame frame = (JFrame) a.getTopLevelAncestor();
					frame.getContentPane().removeAll();
					frame.add(new Chapter2Panel(character));
					frame.revalidate();
					frame.repaint();
				}
			}
		});

		// 돌아가기 버튼
		buttons[2].setBounds(0, 0, 180, 80);
		add(buttons[2]);
		buttons[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("돌아가기 클릭");
				JButton a = (JButton) e.getSource();
				JFrame frame = (JFrame) a.getTopLevelAncestor();
				HomePanel.fadeout(bgPanel, new LobbyPanel(character), frame);
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	}
}
