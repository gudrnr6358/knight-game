package game.ingame.top.statuspanel;

import game.AbstractCombatant;

public class MonsterStatusPanel extends StatusPanel {

  public MonsterStatusPanel(AbstractCombatant c) {
    super(c, 1);
    setLocation(25, 25);
  }

}