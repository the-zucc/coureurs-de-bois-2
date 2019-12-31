package entity;

import component.RigidBodyComponent;
import component.VisualComponent;
import game.Controllable;

public abstract class ControllableGameEntity extends PhysicalGameEntity implements Controllable {
    @Override
    protected abstract String generateId();

    @Override
    public abstract RigidBodyComponent buildRigidBodyComponent();

    @Override
    public VisualComponent buildVisualComponent() {
        return null;
    }
}
