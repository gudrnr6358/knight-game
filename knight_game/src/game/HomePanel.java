package game;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class HomePanel extends JPanel {
  List btns = new ArrayList<>();
  JPanel bgPanel = new JPanel();

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
    setButtonBounds((JButton) btns.get(0), 500, 500, 350, 60);
    setButtonBounds((JButton) btns.get(1), 500, 580, 350, 60);
    setButtonBounds((JButton) btns.get(2), 500, 660, 350, 60);

  }

  public List getButtonList() {

    JButton startBtn = new JButton("게임시작");
    startBtn.addActionListener(new MyEvent());
    JButton loadBtn = new JButton("불러오기");
    loadBtn.addActionListener(new MyEvent());
    JButton exitBtn = new JButton("종료");
    exitBtn.addActionListener(new MyEvent());

    startBtn.setBounds(100, 100, 70, 50);
    // btn2.setBounds(140, 100, 50, 50);
    // btn3.setBounds(180, 100, 50, 50);

    btns.add(startBtn);
    btns.add(loadBtn);
    btns.add(exitBtn);

    add(startBtn);
    add(loadBtn);
    add(exitBtn);

    startBtn.setBorderPainted(false);
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
        fadeout(bgPanel, new SetNamePanel(), frame);
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
        fadeout(bgPanel, new LobbyPanel(character), frame);
      } else {
        System.exit(0);
      }
    }
  }

  public static void fadeout(JPanel bgPanel, JPanel panel, JFrame frame) {
    Timer timer;
    bgPanel.setSize(1350, 860);
    bgPanel.setBackground(new Color(0, 0, 0, 0));

    timer = new Timer(20, new ActionListener() {
      int b = 0;

      public void actionPerformed(ActionEvent e) {
        bgPanel.setBackground(new Color(0, 0, 0, b));
        b += 5;
        if (b > 255) {
          frame.getContentPane().removeAll();
          ((Timer) e.getSource()).stop();
          b = 255;
          frame.add(panel);
          frame.revalidate();
          frame.repaint();
        }
        frame.repaint();
      }
    });

    timer.start();
  }

}
