package App;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class TranslateController implements Initializable {
    private String sourceLang = "en", targetLang = "vi";

    public Button translateBtn;

    public TextArea translateTarget, translateExplain;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        translateBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onClicktranslateBtn();
            }
        });

        translateTarget.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (translateTarget.getText().trim().isEmpty()) {
                    translateBtn.setDisable(true);
                } else {
                    translateBtn.setDisable(false);
                }
            }
        });
        translateBtn.setDisable(true);
    }
    @FXML
    public void onClicktranslateBtn() {
        TranslateAPI translateAPI = new TranslateAPI();
        String target = translateTarget.getText();
        String explain = translateAPI.translateText(target, sourceLang,targetLang);
        translateExplain.setText(explain);
    }


}
