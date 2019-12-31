package component;

import entity.GameEntity;

public interface Component {
    String getId();
    GameEntity getEntity();
    void update(float nanoSeconds);
}
