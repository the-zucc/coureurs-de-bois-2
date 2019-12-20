package display;

import javafx.scene.Group;
import javafx.scene.Scene;
import scene.GameScene;

public class GameScreen extends Scene {

    public final GameScene gameScene;
    public GameScreen(double width, double height) {
        super(new Group(), width, height);
        this.gameScene = new GameScene(width, height);
        this.setRoot(buildScreenRoot(this.gameScene, width, height));
    }

    private static Group buildScreenRoot(GameScene scene, double height, double width) {
        Group returnVal = new Group();
        returnVal.getChildren().add(new GameScene(width, height));
        return returnVal;
    }
}
