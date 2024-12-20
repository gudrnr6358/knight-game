package game.ingame.bottom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;

public class TextLabel extends JLabel {

	// static 선언해서 하나의 TextLabel 을 다른 패널들이 함꼐 사용
	public static final TextLabel textLabel = new TextLabel();
	private String text = "";

	// Label 크기 및 글자 관련 설정 세팅
	public TextLabel() {
		setFont(new Font("NanumGothic", Font.BOLD, 25));
		setForeground(Color.black);
		setSize(1300, 60);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(text, 35, 50);
	}

	public void setTextLabel(String text) {
		this.text = text;
		repaint();
	}
}
