package game;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SetNamePanel extends JPanel {
	Character character = new Character();
	StoryText storyTexts = new StoryText();
	String[] storyText = storyTexts.setNameText();
	JLabel charNameLabel = new JLabel(character.name);
	JTextArea textArea = new JTextArea(storyText[0]);
	JLabel name = new JLabel();
	JTextField textField = new JTextField(10) {
		protected void paintComponent(Graphics g) {
			g.setColor(getBackground());
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	};
	JPanel bgPanel = new JPanel();
	JPanel barConPanel = new JPanel();
	JPanel bar = new JPanel();
	JLabel warning = new JLabel("꺄아아악");
	JPanel popUp = new JPanel();
	JLabel popUpLabel = new JLabel();
	JButton popUpBtn1 = new JButton("생성");
	JButton popUpBtn2 = new JButton("다시입력");
	JPanel btnPanel = new JPanel();

	public void paintComponent(Graphics g) {
		ImageIcon image = new ImageIcon("images/setNameImage.jpg");
		g.drawImage(image.getImage(), 0, 0, this);
	}

	public SetNamePanel() {
		setLayout(null);
		add(bgPanel);

		// paintComponent로 namePanel 둥글게 처리
		JPanel namePanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setColor(Color.LIGHT_GRAY);
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
				g2d.setColor(Color.BLACK);
				g2d.setStroke(new BasicStroke(4.0f));
				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
			}
		};

		barConPanel.setLayout(null);
		barConPanel.setBounds(16, 448, 1320, 400);
		barConPanel.setOpaque(false);

		bar.setLayout(null);
		bar.setBorder(BorderFactory.createLineBorder(Color.gray, 3, true));
		bar.setBounds(0, 65, 1320, 335);
		bar.setBackground(new Color(0, 0, 5, 100));

		namePanel.setLayout(new BorderLayout());
		namePanel.setOpaque(false);
		namePanel.setBackground(new Color(0, 0, 3));
		namePanel.setBounds(140, 40, 130, 50);

		charNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		charNameLabel.setVerticalAlignment(SwingConstants.CENTER);
		charNameLabel.setFont(new Font(charNameLabel.getText(), Font.BOLD, 20));

		namePanel.add(charNameLabel, BorderLayout.CENTER);

		textArea.setBounds(20, 20, 500, 500);
		textArea.setFont(new Font(textArea.getText(), Font.BOLD, 30));
		textArea.setForeground(Color.WHITE);
		textArea.setEditable(false);
		textArea.setHighlighter(null);
		textArea.setOpaque(false);

		// 텍스트 드래그시 깨지는 것 방지
		textArea.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				// 이벤트를 소비하는 명령어
				e.consume();
				repaint();
			}
		});

		textField.setBounds(20, 20, 1, 1);
		textField.setForeground(Color.WHITE);
		textField.addKeyListener(new KeyAdapter() {
			// 텍스트 필드 10으로 길이 제한
			public void keyTyped(KeyEvent e) {
				if (textField.getText().length() > 9) {
					warning.setText("10자 이내로 입력하세요");
					warning.setVisible(true);
					e.consume();
					textField.setFocusable(true);
				}
			}
		});
		// 텍스트 필드에 텍스트 입력시 해당 리스너에서 기록
		textField.getDocument().addDocumentListener(new MyDocument());
		textField.addKeyListener(new MyKeyEvent());

		name.setFont(new Font(name.getText(), Font.BOLD, 30));
		name.setForeground(Color.WHITE);
		name.setBounds(20, 70, 350, 70);

		warning.setFont(new Font(name.getText(), Font.BOLD, 20));
		warning.setForeground(new Color(173, 116, 96));
		warning.setBounds(20, 50, 300, 50);
		warning.setVisible(false);

		popUp.setLayout(new BorderLayout());
		popUp.setBounds(325, 300, 700, 250);
		popUp.setBackground(new Color(0, 0, 0, 230));
		popUp.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3, true));
		popUp.setVisible(false);

		popUpLabel.setForeground(Color.WHITE);
		popUpLabel.setFont(new Font(popUpLabel.getText(), Font.BOLD, 30));
		popUpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		popUpLabel.setVerticalAlignment(SwingConstants.CENTER);

		popUpBtn1.setPreferredSize(new Dimension(350, 50));
		popUpBtn2.setPreferredSize(new Dimension(350, 50));
		popUpBtn1.addActionListener(new MyActionEvent());
		popUpBtn2.addActionListener(new MyActionEvent());

		btnPanel.setLayout(new BorderLayout());
		btnPanel.setOpaque(false);
		btnPanel.add(popUpBtn1, BorderLayout.WEST);
		btnPanel.add(popUpBtn2, BorderLayout.EAST);

		popUp.add(popUpLabel);
		popUp.add(btnPanel, BorderLayout.SOUTH);

		bar.add(name);
		bar.add(textArea);
		bar.add(warning);
		bar.addMouseListener(new MyEvent());

		barConPanel.add(namePanel);
		barConPanel.add(bar);

		addKeyListener(new MyKeyEvent());
		add(popUp);
		add(barConPanel);
	}

	class MyEvent extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			System.out.println("패널");
			if (textArea.getText().equals(storyText[0])) {
				textArea.setText(storyText[1]);
				bar.add(textField);
			}
			textField.setFocusable(true);
			textField.requestFocus();
			repaint();

		}
	}

	class MyKeyEvent extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			repaint();
			System.out.println("키이벤트");
			warning.setVisible(false);
			if (textArea.getText().equals(storyText[0]) && e.getKeyCode() == 10) {
				textArea.setText(storyText[1]);
				bar.add(textField);
			} else if (textArea.getText().equals(storyText[1]) && e.getKeyCode() == 10
					&& textField.getText().length() >= 2) {
				popUp.setVisible(true);
				popUpLabel.setText('"' + textField.getText() + '"' + "으로 생성하시겠습니까?");
			} else if (textArea.getText().equals(storyText[1]) && e.getKeyCode() == 10
					&& textField.getText().length() < 2) {
				warning.setText("두 글자 이상 입력하세요");
				warning.setVisible(true);
			}

			textField.setFocusable(true);
			textField.requestFocus();

		}
	}

	class MyDocument implements DocumentListener {

		@Override
		public void insertUpdate(DocumentEvent e) {
			System.out.println("입력 텍스트 " + textField.getText());
			name.setText("<html><u>" + textField.getText() + "</u></html>\t");
			repaint();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			System.out.println("삭제된 텍스트" + textField.getText());
			name.setText("<html><u>" + textField.getText() + "</u></html>\t");
			repaint();
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
		}
	}

	class MyActionEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();

			if (btn.getText().equals("생성")) {

				Character character = new Character();
				character.name = textField.getText();

				JFrame frame = (JFrame) btn.getTopLevelAncestor();

				HomePanel.padeOut(bgPanel, new LobbyPanel(character), frame);
				remove(popUp);
				repaint();
				System.out.println(textField.getText() + " 캐릭터 생성 완료");

			} else if (btn.getText().equals("다시입력")) {
				System.out.println("다시입력");
				popUp.setVisible(false);
				textField.setText("");
				textField.setFocusable(true);
				textField.requestFocus();
			}
		}
	}
}