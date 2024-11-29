package game.ingame.top.statuspanel;

import game.AbstractCombatant;

public class CharacterStatusPanel extends StatusPanel {

  public CharacterStatusPanel(AbstractCombatant c) {
    super(c, 0);
    setLocation(986, 400);
  }

}