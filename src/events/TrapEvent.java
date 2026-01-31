package events;

import core.Player;
import core.GameLoop;

public class TrapEvent implements GameEvent {
    @Override
    public void trigger(Player player, GameLoop loop) {
        System.out.println("Вы наступили на гнилую доску! -10 HP");
        player.takeDamage(10);
    }
}
