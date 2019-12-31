package game.physics;

import com.bulletphysics.collision.broadphase.BroadphaseInterface;
import com.bulletphysics.collision.broadphase.DbvtBroadphase;
import com.bulletphysics.collision.dispatch.CollisionDispatcher;
import com.bulletphysics.collision.dispatch.DefaultCollisionConfiguration;
import com.bulletphysics.dynamics.DiscreteDynamicsWorld;
import com.bulletphysics.dynamics.DynamicsWorld;
import com.bulletphysics.dynamics.constraintsolver.SequentialImpulseConstraintSolver;

import javax.vecmath.Vector3f;

public abstract class PhysicsEngineInstance {

    private BroadphaseInterface broadphase = new DbvtBroadphase();
    private DefaultCollisionConfiguration collisionConfiguration = new DefaultCollisionConfiguration();
    private CollisionDispatcher dispatcher = new CollisionDispatcher(collisionConfiguration);
    private SequentialImpulseConstraintSolver solver = new SequentialImpulseConstraintSolver();
    DiscreteDynamicsWorld dynamicsWorld = new DiscreteDynamicsWorld(dispatcher, broadphase, solver, collisionConfiguration);
    private Vector3f gravityVector;
    public PhysicsEngineInstance(){
        this.gravityVector = this.gravityVector();
        dynamicsWorld.setGravity(this.getGravityVector());
    }
    protected Vector3f getGravityVector(){
        return this.gravityVector;
    }
    protected abstract Vector3f gravityVector();

    public DynamicsWorld getDynamicsWorld() {
        return dynamicsWorld;
    }
}
