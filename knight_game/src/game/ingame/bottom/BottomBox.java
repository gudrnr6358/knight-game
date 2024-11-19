package game.ingame.bottom;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

// 생성자 사용해서 기본 Border 및 TextBar 제공
public class BottomBox extends JPanel {

	// static 선언 -> 상속받는 클래스들이 하나의 TextLabel 사용
	protected static TextLabel textLabel = new TextLabel();

	// TextLabel 부착 및 Border, Size, Location 제공
	public BottomBox() {
		setLayout(null);
		BottomBox.this.setBorder(BorderFactory.createLineBorder(Color.gray, 3, true));
		BottomBox.this.add(textLabel);
		BottomBox.this.setBounds(16, 3, 1320, 335);
	}

	// BottomPanel 생성자에서 메서드 체이닝 이용하기 위해 return 설정
	public BottomBox setBottomBoxPanel(BottomBox bottomBox) {
		BottomBox.this.removeAll();
		BottomBox.this.add(bottomBox);
		BottomBox.this.repaint();
		return bottomBox;
	}
}