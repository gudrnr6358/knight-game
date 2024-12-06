package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomePanel extends JPanel {
  List btns = new ArrayList<>();
  JPanel bgPanel = new JPanel();
  ImageIcon image1 = new ImageIcon("images/시작하기.png");
  ImageIcon image2 = new ImageIcon("images/불러오기.png");
  ImageIcon image3 = new ImageIcon("images/종료.png");

  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    // g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.05f));
    ImageIcon image = new ImageIcon("images/main1.jpg");
    g.drawImage(image.getImage(), 0, 0, this);

  }

  public HomePanel() {

    add(bgPanel);
    // image = new ImageIcon("img/main1.jpg");
    setLayout(null);

    // 버튼 리스트 생성 메소드
    btns = getButtonList();

    // 리스트를 이용한 버튼 좌표, 크기 설정 메소드
    // 0 : 게임시작
    // 1 : 불러오기
    // 2 : 게임방법
    // 3 : 종료
    // 버튼의 종류와 좌표,크기 지정 하여 사용
    setButtonBounds((JButton) btns.get(0), 515, 540, 350, 60);
    setButtonBounds((JButton) btns.get(1), 515, 620, 350, 60);
    setButtonBounds((JButton) btns.get(2), 515, 700, 350, 60);

  }

  public List getButtonList() {

    JButton startBtn = new JButton("게임시작", image1);
    startBtn.addActionListener(new MyEvent());
    startBtn.addMouseListener(new MyMouseEvent());

    JButton loadBtn = new JButton("불러오기", image2);
    loadBtn.addActionListener(new MyEvent());
    loadBtn.addMouseListener(new MyMouseEvent());

    JButton exitBtn = new JButton("종료", image3);
    exitBtn.addActionListener(new MyEvent());
    exitBtn.addMouseListener(new MyMouseEvent());

    JButton a = new JButton();

    btns.add(startBtn);
    btns.add(loadBtn);
    btns.add(exitBtn);

    add(startBtn);
    add(loadBtn);
    add(exitBtn);

    startBtn.setBorderPainted(false);
    loadBtn.setBorderPainted(false);
    exitBtn.setBorderPainted(false);
    return btns;
  }

  public void setButtonBounds(JButton btn, int x, int y, int width, int height) {
    // JButton btn = (JButton) btns.get(2);
    btn.setBounds(x, y, width, height);
  }

  class MyEvent implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JButton btn = (JButton) e.getSource();
      String btnText = btn.getText();
      JFrame frame = (JFrame) btn.getTopLevelAncestor();

      if (btnText.equals("게임시작")) {
        Function.fadeout(bgPanel, new SetNamePanel(), frame, HomePanel.this);
        remove((JButton) btns.get(0));
        remove((JButton) btns.get(1));
        remove((JButton) btns.get(2));
        repaint();
      } else if (btnText.equals("불러오기")) {
        remove((JButton) btns.get(0));
        remove((JButton) btns.get(1));
        remove((JButton) btns.get(2));
        repaint();
        Character character = GameLoad.loadCharacter("saveData.dat");
        Function.fadeout(bgPanel, new LobbyPanel(character), frame, HomePanel.this);
      } else {
        System.exit(0);
      }
    }
  }

  class MyMouseEvent extends MouseAdapter {

    public void mouseEntered(MouseEvent e) {
      JButton btn = (JButton) e.getSource();
      btn.setBorderPainted(true);
      btn.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 224), 3, true));

    }

    public void mouseExited(MouseEvent e) {
      JButton btn = (JButton) e.getSource();
      btn.setBorderPainted(false);
    }

  }
}
