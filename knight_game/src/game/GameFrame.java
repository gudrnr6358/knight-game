package game;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

  public GameFrame() {
    setSize(1366, 900);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // 프레임 크기조절 false : 불가, true : 허용
    setResizable(false);

    // 프레임 테두리 제거
    setUndecorated(true);

    // 프레임 화면 가운데 정렬
    setLocationRelativeTo(null);

    setVisible(true);
    // 기본 프레임 패널 Home 패널로 설정
    // add(new Home());
    add(new HomePanel());
  }

  public static void main(String[] args) {
    new GameFrame();
  }
}