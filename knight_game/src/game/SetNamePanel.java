package game;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
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
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	};
	JPanel barConPanel = new JPanel();
	JPanel bar = new JPanel();
	JLabel warning = new JLabel("꺄아아악");

	JPanel popUp = Function.popUp();
	JLabel popUpLabel;

	public void paintComponent(Graphics g) {
		ImageIcon image = new ImageIcon("images/setNameImage.png");
		g.drawImage(image.getImage(), 0, 0, this);
	}

	public SetNamePanel() {
		setLayout(null);

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
		barConPanel.setBounds(23, 480, 1320, 400);
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

		textArea.setBounds(20, 30, 500, 500);
		textArea.setFont(new Font(textArea.getText(), Font.BOLD, 30));
		textArea.setForeground(Color.WHITE);
		textArea.setEditable(false);
		textArea.setHighlighter(null);
		textArea.setOpaque(false);
		textArea.addMouseListener(new MyMouseEvent());

		// 텍스트 드래그시 깨지는 것 방지
		textArea.addMouseMotionListener(new MyMouseEvent());

		textField.setBounds(20, 20, 1, 1);

		// 텍스트 필드에 텍스트 입력시 해당 리스너에서 기록
		textField.getDocument().addDocumentListener(new MyDocument());
		textField.addKeyListener(new MyKeyEvent());

		name.setFont(new Font(name.getText(), Font.BOLD, 30));
		name.setForeground(Color.WHITE);
		name.setBounds(20, 70, 350, 70);

		warning.setFont(new Font(name.getText(), Font.BOLD, 20));
		warning.setForeground(new Color(173, 116, 96));
		warning.setBounds(20, 120, 300, 50);
		warning.setVisible(false);

		popUpLabel = (JLabel) popUp.getComponent(0);
		JButton popUpBtn1 = (JButton) ((JPanel) popUp.getComponent(1)).getComponent(0);
		JButton popUpBtn2 = (JButton) ((JPanel) popUp.getComponent(1)).getComponent(1);

		popUpBtn1.addActionListener(new MyActionEvent());
		popUpBtn2.addActionListener(new MyActionEvent());

		bar.add(name);
		bar.add(textArea);
		bar.add(warning);
		bar.addMouseListener(new MyMouseEvent());

		barConPanel.add(namePanel);
		barConPanel.add(bar);

		addKeyListener(new MyKeyEvent());
		add(popUp);
		add(barConPanel);

	}

	class MyMouseEvent extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			if (textArea.getText().equals(storyText[0])) {
				textArea.setText(storyText[1]);
				bar.add(textField);
			}
			textField.setFocusable(true);
			textField.requestFocus();
			repaint();
		}

		public void mouseDragged(MouseEvent e) {
			// 이벤트를 소비하는 명령어
			e.consume();
			repaint();
		}

	}

	class MyKeyEvent extends KeyAdapter {
		public void keyPressed(KeyEvent e) {

			repaint();
			warning.setVisible(false);

			// 어디선가 목소리가 들려온다 텍스트일때 Enter 누르면 실행
			if (textArea.getText().equals(storyText[0]) && e.getKeyCode() == 10) {
				textArea.setText(storyText[1]);
				bar.add(textField);

				// 이름을 입력하세요 텍스트일때 Enter 누르면 실행
			} else if (e.getKeyCode() == 10 && textField.getText().length() >= 2) {
				popUp.setVisible(true);
				popUpLabel.setText('"' + textField.getText() + '"' + "으로 생성하시겠습니까?");

				// 이름을 입력하세요 텍스트이고 텍스트필드의 텍스트 길이가 2이하인 경우 Enter 눌렀을 때 실행
			} else if (e.getKeyCode() == 10 && textField.getText().length() < 2) {
				warning.setText("두 글자 이상 입력하세요");
				warning.setVisible(true);
			}

			textField.setFocusable(true);
			textField.requestFocus();

		}

		// 닉네임 10자 이하로 제한
		public void keyTyped(KeyEvent e) {
			if (textField.getText().length() > 9) {
				warning.setText("10자 이내로 입력하세요");
				warning.setVisible(true);
				e.consume();
				textField.setFocusable(true);
			}
		}

	}

	class MyDocument implements DocumentListener {
		@Override
		public void insertUpdate(DocumentEvent e) {
			name.setText("<html><u>" + textField.getText() + "</u></html>\t");
			repaint();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
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

				Function.FADE_OUT(new LobbyPanel(character), frame, SetNamePanel.this);
				remove(popUp);
				repaint();

			} else if (btn.getText().equals("다시입력")) {
				popUp.setVisible(false);
				textField.setText("");
				textField.setFocusable(true);
				textField.requestFocus();
			}
		}
	}
}