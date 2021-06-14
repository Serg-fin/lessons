package lesson6.Client;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.function.Consumer;


public class ViewController {
    @FXML
    public ListView<String> usersList; // список клиентов
    @FXML
    private Button sendButton;
    @FXML
    private TextArea chatHistory; // поле со всеми предыдущими сообщениями
    @FXML
    private TextArea messageTextArea; // поле для ввода сообщения

    private Network network;
    private ClientChat application;

    @FXML
    public void initialize() {
        usersList.setItems(FXCollections.observableArrayList(ClientChat.USERS_TEST_DATA));
    }


    @FXML
    private void sendMessage() {
        String message = messageTextArea.getText();

        String sender = null;
        if (!usersList.getSelectionModel().isEmpty()) {
            sender = usersList.getSelectionModel().getSelectedItem();
        }

        try {
            network.sendMessage(message);
        } catch (IOException e) {
            application.showNetworkErrorDialog("Ошибка передачи данных по сети", "Не удалось отправить сообщение!");
        }
        appendMessageToChat(sender, message);

    }

    private void appendMessageToChat(String sender, String message) {
        chatHistory.appendText(DateFormat.getDateTimeInstance().format(new Date()));
        chatHistory.appendText(System.lineSeparator());
        if (sender != null) {
            String selectedUser = usersList.getSelectionModel().getSelectedItem();
            chatHistory.appendText(selectedUser + ":");
            chatHistory.appendText(System.lineSeparator());
        }
        chatHistory.appendText(message);
        chatHistory.appendText(System.lineSeparator());
        messageTextArea.clear();
    }

    @FXML
    public void sendTextAreaMessage(KeyEvent event) { // определили логику работы клавиши ENTER
        if (event.getCode() == KeyCode.ENTER) {
            event.consume(); //
            if (event.isShiftDown()) {
                messageTextArea.appendText(System.lineSeparator());
            } else {
                sendMessage();
            }
        }
    }

    public void setNetwork(Network network) {
        this.network = network;

    }

    public void setApplication(ClientChat application) {
        this.application = application;
        network.waitMessages(new Consumer<String>() {
            @Override
            public void accept(String message) {
                appendMessageToChat();
            }
        });
    }
}


