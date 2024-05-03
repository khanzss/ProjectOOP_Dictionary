package App;

import CommandLine.Dictionary;
import CommandLine.DictionaryManagement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DicController implements Initializable {


    @FXML
    private Button addbtn,searchbtn,translatebtn,gamebtn,homebtn;

    @FXML
    private AnchorPane container;

    @FXML
    private ImageView homeimg;

    @FXML
    private void showComponent(String path) {
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource(path));
            container.getChildren().clear();
            container.getChildren().add(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        addbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showComponent("Add.fxml");
            }

        });

        searchbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showComponent("Search.fxml");
            }
        });


        translatebtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showComponent("Translate.fxml");
            }
        });
        gamebtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {showComponent("Game.fxml");}
        });

        homebtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                container.getChildren().add(homeimg);
            }
        });




    }
}
