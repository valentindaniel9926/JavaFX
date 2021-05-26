package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    private TextField NameField;
    @FXML
    private Button HelloButton;
    @FXML
    private Button byeButton;
    @FXML
    public void initialize(){
        HelloButton.setDisable(true);
        byeButton.setDisable(true);
    }
    @FXML
    public void onButtonClicked(ActionEvent e){
        if(e.getSource().equals(HelloButton)){
            System.out.println("Hello , " + NameField.getText());
        }else if(e.getSource().equals(byeButton)){
            System.out.println("Bye, " + NameField.getText());
        }
    }
    @FXML
    public void  handleKeyReleased(){
        String text = NameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        HelloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }
}
