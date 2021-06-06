package lesson4.Chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class Controller {
    @FXML
    public ListView userList;
    @FXML
    private TextArea chatTextArea;
    @FXML
    private TextArea messageTextArea;
    @FXML
    private Button sendMessageButton;


    public void sendMessage(ActionEvent actionEvent) {
        chatTextArea.appendText(messageTextArea.getText());
        chatTextArea.appendText(System.lineSeparator());
        messageTextArea.clear();

    }

}

