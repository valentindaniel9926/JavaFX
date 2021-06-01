package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    private TextField NameField;
    @FXML
    private Button HelloButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox ourCheckBox;
    @FXML
    private Label OurLabel;
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
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try{
                    String s= Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                    System.out.println("I'm going to sleep on the: " + s);
                    Thread.sleep(10000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            String s= Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                            System.out.println("I'm updating the label on the UI thread: " + s);
                            OurLabel.setText("We did something");
                        }
                    });

                }catch (InterruptedException event){

                }
            }
        };
        new Thread(task).start();

        if(ourCheckBox.isSelected()){
            NameField.clear();
            HelloButton.setDisable(true);
            byeButton.setDisable(true);
        }
    }
    @FXML
    public void  handleKeyReleased(){
        String text = NameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        HelloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }
    @FXML
    public void handleChange(){
        System.out.println("The checkbox is" + (ourCheckBox.isSelected() ?  "checked"  : "not checked"));
    }
}
