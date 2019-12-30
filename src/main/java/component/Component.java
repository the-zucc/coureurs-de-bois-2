package component;

import game.GameEntity;

public interface Component {
    String getId();
    GameEntity getEntity();
    void update(float nanoSeconds);
}
