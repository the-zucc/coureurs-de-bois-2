package game.map;

import com.bulletphysics.dynamics.DynamicsWorld;
import com.bulletphysics.dynamics.SimpleDynamicsWorld;
import com.bulletphysics.linearmath.Transform;
import entity.Physical;
import entity.Visual;
import game.physics.PhysicsEngineInstance;
import scene.GameScene;

import javax.vecmath.Vector3f;

public abstract class GameMap {
    private final MapBounds bounds;
    private final PhysicsEngineInstance physicsEngineInstance;
    private GameScene scene;

    public GameMap(){
        this.bounds = mapBounds();
        this.physicsEngineInstance = new PhysicsEngineInstance() {
            @Override
            protected Vector3f gravityVector() {
                return new Vector3f(0, -10,0);
            }
        };

    }

    public abstract MapBounds mapBounds();
    public MapBounds getBounds(){
        return this.bounds;
    }

    public boolean isWithinBounds(float x, float y){
        return getBounds().isWithinBounds(x,y);
    }
    public void update(float nanoSeconds){
        //update physics
        physicsEngineInstance.getDynamicsWorld().stepSimulation(nanoSeconds/1e9f,10);
    }
    public void addEntity(Visual visual){

    }
    public void addEntity(Physical physical){

    }
}
