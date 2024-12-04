package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import game.SetNamePanel.MyActionEvent;

public class Function {

  // 페이드 아웃
  public static void fadeout(JPanel bgPanel, JPanel panel, JFrame frame) {
    Timer timer;
    bgPanel.setSize(1366, 899);
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

  // 팝업 창 생성
  public static JPanel popUp() {
    JPanel popUp = new JPanel();
    JLabel popUpLabel = new JLabel();
    JButton popUpBtn1 = new JButton("생성");
    JButton popUpBtn2 = new JButton("다시입력");
    JPanel btnPanel = new JPanel();

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

    btnPanel.setLayout(new BorderLayout());
    btnPanel.setOpaque(false);
    btnPanel.add(popUpBtn1, BorderLayout.WEST);
    btnPanel.add(popUpBtn2, BorderLayout.EAST);

    popUp.add(popUpLabel);
    popUp.add(btnPanel, BorderLayout.SOUTH);
    return popUp;
  }
}

// class MyActionEvent implements ActionListener {

// @Override
// public void actionPerformed(ActionEvent e) {
// JButton btn = (JButton) e.getSource();

// if (btn.getText().equals("생성")) {

// Character character = new Character();
// character.name = textField.getText();

// JFrame frame = (JFrame) btn.getTopLevelAncestor();

// Function.fadeout(bgPanel, new LobbyPanel(character), frame);
// remove(popUp);
// repaint();

// } else if (btn.getText().equals("다시입력")) {
// popUp.setVisible(false);
// textField.setText("");
// textField.setFocusable(true);
// textField.requestFocus();
// }
// }
// }