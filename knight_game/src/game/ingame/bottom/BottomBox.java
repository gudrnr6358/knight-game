package game.ingame.bottom;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import game.ingame.bottom.BottomPanelEvent.BottomMouseListener;

// 생성자 사용해서 기본 Border 및 TextBar 제공
// 기본 틀만 제공해주기에 abstract class 선언 
public abstract class BottomBox extends JPanel {

	// TextLabel 부착 및 Border, Size, Location 제공
	protected BottomBox() {
		setLayout(null);
		BottomBox.this.setBorder(BorderFactory.createLineBorder(Color.gray, 3, true));
		BottomBox.this.add(TextLabel.textLabel);
		BottomBox.this.setBounds(16, 3, 1320, 335);
		addMouseListener(new BottomPanelEvent().new BottomMouseListener());
	}

}