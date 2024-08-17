package box;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import soundmaker.SoundMaker;

public class RedeemBox {
    private static Stage stage;
    private static TextField tf;
    public static boolean correctCode;

    public static boolean show() {
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Nhập code nhận ruby");

        tf = new TextField();
        tf.setFont(new Font(15));

        Button btn = new Button();
        btn.setText("Nhập");
        btn.setFont(new Font(15));
        btn.setOnAction(e -> btn_Clicked());

        HBox pane = new HBox(20);
        pane.setAlignment(Pos.CENTER);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10));
        pane.getChildren().addAll(tf, btn);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.showAndWait();

        return correctCode;
    }

    private static void btn_Clicked() {
        if (tf.getText().equals("batchu")) {
            correctCode = true;
            stage.close();
        } else {
            SoundMaker.wrong();
            MessageBox.show("Code không hợp lệ", "Thông báo", stage);
        }
    }
}