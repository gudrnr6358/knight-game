package game.monster.slime;

import game.monster.Monster;

// Slime 상속받는 클래스에서 skill() 구현하기 위해 abstract 선언 
public abstract class Slime extends Monster {

	protected Slime(String nAME, int hP, int pOWER) {
		super(nAME, hP, pOWER);
	}

}