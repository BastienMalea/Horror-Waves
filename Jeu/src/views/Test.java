package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class Test {

    private int i = 0;

    @FXML
    private Button bouton1;
    @FXML
    private TextField textField1;
    @FXML
    private Label label1;

    @FXML
    public void clicBouton1(ActionEvent actionEvent) {
        i = i+1;
        bouton1.setText(String.valueOf(i));
    }

    @FXML
    public void updateTextField(KeyEvent keyEvent) {
        label1.setText(textField1.getText());
    }

    public void initialize(){
        bouton1.setText(String.valueOf(i));
        label1.setText("");
    }
}
