package component;

import entity.Physical;
import entity.GameEntity;
import javafx.scene.Group;
import javafx.scene.transform.Transform;
import util.IdFactory;

public abstract class VisualComponent implements Component {
    private final String id;
    private final Group visuals;
    private final GameEntity entity;

    public VisualComponent(GameEntity entity) {
        this.id = IdFactory.nextId(IdFactory.ID_PREFIX_VC);
        this.visuals = this.buildVisuals();
        this.entity = entity;
    }

    private Group getVisuals() {
        return this.visuals;
    }

    protected abstract Group buildVisuals();

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public GameEntity getEntity() {
        return this.entity;
    }

    @Override
    public void update(float nanoSeconds) {
        if(getEntity() instanceof Physical){
            Physical entity = (Physical)getEntity();
            this.setMotionState(entity.getMotionState());
        }
        //TODO add stuff to this method
    }
    protected final void setMotionState(Transform t){
        this.getVisuals().getTransforms().add(t);
    }
}
