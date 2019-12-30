package entity;

import com.bulletphysics.linearmath.MotionState;
import component.RigidBodyComponent;

import javafx.scene.transform.Transform;

public interface Physical {
    RigidBodyComponent buildRigidBodyComponent();
    RigidBodyComponent getRigidBodyComponent();
    Transform getMotionState();
    static Transform convertMotionState(MotionState motionState){
        //TODO code this method
        return null;
    }
}
