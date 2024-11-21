package game.ingame.bottom;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

// 생성자 사용해서 기본 Border 및 TextBar 제공
// 기본 틀만 제공해주기에 abstract class 선언 
public abstract class BottomBox extends JPanel {

	// static 선언 -> 상속받는 클래스들이 하나의 TextLabel 사용
	protected static TextLabel textLabel = new TextLabel();

	// TextLabel 부착 및 Border, Size, Location 제공
	protected BottomBox() {
		setLayout(null);
		BottomBox.this.setBorder(BorderFactory.createLineBorder(Color.gray, 3, true));
		BottomBox.this.add(textLabel);
		BottomBox.this.setBounds(16, 3, 1320, 335);
	}

}