package component;

import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.linearmath.MotionState;
import javafx.scene.transform.Transform;
import util.IdFactory;

public abstract class RigidBodyComponent implements Component{
    private final String id;
    private RigidBody rigidBody;

    public RigidBodyComponent(){
        this.rigidBody = this.buildRigidBody();
        this.id = IdFactory.nextId(IdFactory.ID_PREFIX_RBC);
    }

    public RigidBody getRigidBody(){
        return this.rigidBody;
    }

    protected abstract RigidBody buildRigidBody();
}
