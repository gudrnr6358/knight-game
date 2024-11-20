package game;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
public class Character extends Combatant{
	public static boolean hadCharacter = false;
	private Integer[] EXP = { 20, 30, 35, 40, 45, 70, 80, 90, 110 };
	private Integer[] LEVEL_UP_PLUS_HP = { 10, 10, 15, 15, 15, 20, 20, 25, 30 };
	private Integer[] LEVEL_UP_PLUS_POWER = { 10, 10, 15, 15, 15, 20, 20, 25, 30 };
	public Integer exp;
	public Integer level;
	public Integer level_count;
	public Integer hp;
	public Character() {
		this.level = 1;
		this.level_count=0;
		this.exp = 0;
	}
	public static void levelup() {
		if(level_count == EXP.length) {
			level++;
			level_count++;
			hp += LEVEL_UP_PLUS_HP[level_count];
			power += LEVEL_UP_PLUS_POWER[level_count];
			nowHp = hp;
			new JLabel("현재 레벨:" + level + " (" + exp + "/" + EXP[level_count] + ")");
		}
		else
			new JLabel("현재 최고레벨을 달성하여 레벨업이 불가합니다.");
	}
	public void recoveryHp() {
		nowHp=hp;
		new JLabel("HP를 모두 회복했습니다!");
	}
}
