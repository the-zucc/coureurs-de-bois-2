package entity;

import component.RigidBodyComponent;
import component.VisualComponent;
import entity.Physical;
import entity.Visual;
import javafx.scene.transform.Transform;
import util.IdFactory;

public abstract class PhysicalGameEntity implements Physical, Visual {

    private final String id;
    private RigidBodyComponent rigidBodyComponent;
    private VisualComponent visualComponent;

    public PhysicalGameEntity(){
        this.id = this.generateId();
        this.rigidBodyComponent = buildRigidBodyComponent();
        this.visualComponent = buildVisualComponent();
    }

    protected abstract String generateId();

    @Override
    public abstract RigidBodyComponent buildRigidBodyComponent();

    @Override
    public RigidBodyComponent getRigidBodyComponent() {
        return this.rigidBodyComponent;
    }

    @Override
    public Transform getMotionState() {
        RigidBodyComponent rigidBody = getRigidBodyComponent();
        return Physical.convertMotionState(rigidBody.getRigidBody().getMotionState());
    }

    @Override
    public abstract VisualComponent buildVisualComponent();

    @Override
    public VisualComponent getVisualComponent() {
        return this.visualComponent;
    }
}
