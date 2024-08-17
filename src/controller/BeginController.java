package controller;

import box.MessageBox;
import box.RedeemBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class BeginController {
    private Stage stage;
    private Scene beginScene;
    private Scene gameScene;
    private GameController gameController;


    @FXML
    public void initialize() throws IOException {
        String fxmlPath = "/gui/game.fxml";
        URL location = getClass().getResource(fxmlPath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);

        gameScene = new Scene(fxmlLoader.load());
        gameController = fxmlLoader.getController();
    }

    public void setStageAndScene(Stage stage, Scene beginScene) {
        this.stage = stage;
        this.beginScene = beginScene;
    }

    public void beginBtnClicked() {
        stage.setScene(gameScene);
        gameController.setStageAndScene(stage, beginScene, gameScene);
    }

    @FXML
    public void redeemBtnClicked() {
        boolean correctCode = RedeemBox.show();
        if (correctCode) {
            gameController.rubyProperty.setValue(gameController.ruby += 50);
            RedeemBox.correctCode = false;
            MessageBox.show("Bạn nhận được 50 Ruby", "Thông báo", stage);
        }
    }
}
