package scene;

import javafx.scene.*;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import util.IdFactory;

public class GameScene extends SubScene {
    public final Group gameRoot;
    public final GameCamera gameCamera;
    public GameScene(double width, double height) {
        super(new Group(), width, height, true, SceneAntialiasing.BALANCED);
        this.gameCamera = buildGameCamera();
        this.setCamera(this.gameCamera);
        this.gameRoot = buildGameRoot(gameCamera);
        this.setRoot(this.gameRoot);
    }

    /**
     * builds the game scene's root and returns it
     * @param camera the GameCamera to put in the scene's root
     * @return the root
     */
    private Group buildGameRoot(GameCamera camera) {
        Group sceneRoot = new Group();
        sceneRoot.getChildren().add(camera);
        sceneRoot.getChildren().add(new Box(50,50,50));
        return sceneRoot;
    }

    /**
     * build the game's perspective camera and returns it
     * @return the camera
     */
    private GameCamera buildGameCamera(){
        GameCamera gameCamera = new GameCamera(true);
        gameCamera.setTranslateZ(-115);
        return gameCamera;
    }

    /**
     * adds a node to the scene's root and returns the ID
     * @param node the node to add to the scene's root
     */
    public void addNode(Node node) {
        this.gameRoot.getChildren().add(node);
    }
}
