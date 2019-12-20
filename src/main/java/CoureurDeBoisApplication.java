import display.GameScreen;
import javafx.application.Application;
import javafx.stage.Stage;
import scene.GameScene;

public class CoureurDeBoisApplication extends Application {
    public static double windowWidth = 800;
    public static double windowHeight = 600;

    public static GameScreen gameScreen;
    public static GameScreen buildGameScreen(Stage stage){
        return new GameScreen(
                stage.getWidth(),
                stage.getHeight());
    }

    public static GameScene getGameScene(){
        return gameScreen.gameScene;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setWidth(windowWidth);
        stage.setHeight(windowHeight);
        this.gameScreen = buildGameScreen(stage);
        stage.setScene(gameScreen);
        stage.show();
    }

    public static void main(String[] args) {
        CoureurDeBoisApplication.launch(args);
    }
}
