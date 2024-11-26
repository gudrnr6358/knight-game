package game;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import game.monster.Monster;
import game.monster.dragon.AncientDragon;
import game.monster.dragon.BabyDragon;
import game.monster.dragon.CowardDragon;
import game.monster.slime.BossSlime;
import game.monster.slime.CombatSlime;
import game.monster.slime.MiniSlime;

public class Stage extends JPanel {
    private JButton[] Buttons = { new JButton("Stage 1"), new JButton("Stage 2"), new JButton("Stage 3"), new JButton("돌아가기") };
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private Monster[] monsters;
    private boolean[] stageClear = {false,false,false};
    private Chapter chapter;
    public Stage(CardLayout cardLayout, JPanel cardPanel, String chapterType,Chapter chapter) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        this.chapter = chapter;
        setLayout(null);
        // monsters 배열을 Chapter에 맞게 초기화
        if (chapterType.equals("Chapter1")) {
            monsters = new Monster[3];
            monsters[0] = new MiniSlime();
            monsters[1] = new CombatSlime();
            monsters[2] = new BossSlime();
        } else if (chapterType.equals("Chapter2")) {
            monsters = new Monster[3];
            monsters[0] = new BabyDragon();
            monsters[1] = new CowardDragon();
            monsters[2] = new AncientDragon();
        }
        Buttons[1].setEnabled(false);
        Buttons[2].setEnabled(false);
        StageListener listener = new StageListener();
        // Buttons
        Buttons[0].setBounds(100, 200, 100, 100);
        add(Buttons[0]);
        Buttons[0].addActionListener(listener);

        Buttons[1].setBounds(250, 200, 100, 100);
        add(Buttons[1]);
        Buttons[1].addActionListener(listener);

        Buttons[2].setBounds(400, 200, 100, 100);
        add(Buttons[2]);
        Buttons[2].addActionListener(listener);

        Buttons[3].setBounds(550, 200, 100, 100);
        add(Buttons[3]);
        Buttons[3].addActionListener(listener);
    }
    public Monster getSelectedMonster(int stageIndex) {
        return monsters[stageIndex];
    }
    class StageListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Monster selectedMonster = null;
            if (Buttons[0] == e.getSource()) {
                // Stage 1 몬스터 반환
                selectedMonster = getSelectedMonster(0);
                //스테이지 클리어 처리
                stageClear[0] = true;
                Buttons[1].setEnabled(true);
                chapter.updateStageClear(0,true);
            }
            if (Buttons[1] == e.getSource()) {
                // Stage 2 몬스터 반환
                selectedMonster = getSelectedMonster(1);
                //스테이지 클리어 처리
                stageClear[1] = true;
                Buttons[2].setEnabled(true);
                chapter.updateStageClear(1,true);
            }
            if (Buttons[2] == e.getSource()) {
                // Stage 3 몬스터 반환
                selectedMonster = getSelectedMonster(2);
                //스테이지 클리어 처리
                stageClear[2] = true;
                chapter.updateStageClear(2,true);
            }
            if (Buttons[3] == e.getSource()) {
                // 돌아가기 버튼 처리
                cardLayout.show(cardPanel, "Chapter");
            }
        }
    }
    public boolean[] getStageClear(){
        return stageClear;
    }
}