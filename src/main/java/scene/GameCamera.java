package scene;

import javafx.scene.PerspectiveCamera;

public class GameCamera extends PerspectiveCamera {

    public GameCamera(boolean fixedEyeAtCameraZero) {
        super(fixedEyeAtCameraZero);
        setFieldOfView(90);
        setNearClip(10);
        setFarClip(1000);
    }
}
