package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class CbFenetre {

	@FXML
	private Button BoutonTop;

    public void initialize(){
    }

    @FXML
    public void Clickme(ActionEvent actionEvent) {
		BoutonTop.setText("Yo");
	}
}
