package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChapterPanel extends JPanel {
  private Image backgroundImage;
  private JButton[] buttons = { new JButton("CHAPTER 1"), new JButton("CHAPTER 2"), new JButton("돌아가기") };
  private Character character;
  JPanel bgPanel = new JPanel();

  public ChapterPanel(Character character) {
    add(bgPanel);
    this.character = character;
    setBounds(0, 0, 1366, 900);
    setLayout(null);
    backgroundImage = new ImageIcon("images/ChapterBackground.png").getImage();
    // Chapter 1 버튼
    buttons[0].setBounds(200, 200, 100, 100);
    add(buttons[0]);

    buttons[0].addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("챕터 1클릭");
        JButton a = (JButton) e.getSource();
        JFrame frame = (JFrame) a.getTopLevelAncestor();
        frame.getContentPane().removeAll();
        frame.add(new Chapter1Panel(character));
        frame.revalidate();
        frame.repaint();
      }
    });
    // Chapter 2 버튼
    buttons[1].setBounds(400, 400, 100, 100);

    add(buttons[1]);
    buttons[1].addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("챕터 2클릭");
        JButton a = (JButton) e.getSource();
        JFrame frame = (JFrame) a.getTopLevelAncestor();
        frame.getContentPane().removeAll();
        frame.add(new Chapter2Panel(character));
        frame.revalidate();
        frame.repaint();
      }
    });

    // 돌아가기 버튼
    buttons[2].setBounds(500, 500, 100, 100);
    add(buttons[2]);
    buttons[2].addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("돌아가기 클릭");
        JButton a = (JButton) e.getSource();
        JFrame frame = (JFrame) a.getTopLevelAncestor();
        HomePanel.fadeout(bgPanel, new LobbyPanel(character), frame);
      }
    });
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
  }
}
