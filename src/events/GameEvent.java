package events;

import core.Player;
import core.GameLoop;

public interface GameEvent {
    void trigger(Player player, GameLoop loop);
}
