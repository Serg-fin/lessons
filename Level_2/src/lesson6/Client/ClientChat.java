package lesson6.Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.List;

public class ClientChat extends Application {

    public static final List<String> USERS_TEST_DATA = List.of("Иванов", "Петров", "Сидоров");

    private static final String NETWORK_ERROR_TITLE = "Сетевая ошибка";
    private static final String NETWORK_ERROR_CONNECTION_TYPE = "Невозможно установить сетевое соединение";
    private Stage primaryStage; //*****

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage; //*****

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("view.fxml"));

        Parent root = fxmlLoader.load();
        this.primaryStage.setTitle("Мой чат");
        this.primaryStage.setScene(new Scene(root));

        ViewController controller = fxmlLoader.getController();
//        controller.usersList.getItems().addAll("user1", "user2");

        primaryStage.show();

        ViewController viewController = fxmlLoader.getController();
        connectToServer(viewController); // метод описывающий логику подключения

    }

    private void connectToServer(ViewController viewController) {
        Network network = new Network();
        boolean result = network.connect();
        if (!result) {
            String errMsg = "Не удалось установить соединение с сервером!";
            showNetworkErrorDialog(NETWORK_ERROR_CONNECTION_TYPE, errMsg);
            return;
        }

        viewController.setNetwork(network);
        viewController.setApplication(this);

        primaryStage.setOnCloseRequest(windowEvent -> network.close());

//
//
//
//        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT)) { // создали экземпляр сокета
//            DataInputStream input = new DataInputStream(socket.getInputStream()); // используем для чтения данных по сетевому соединению
//            DataOutputStream output = new DataOutputStream(socket.getOutputStream()); // используем для отправки данных по сетевому соединению
//
//            output.writeUTF(" Test massage!"); // отправляем тестовое сообщение
//            System.out.println(input.readUTF());
//        } catch (UnknownHostException e) {
//            String errType = NETWORK_ERROR_CONNECTION_TYPE;
//            String errMsg = "хост неизвестен!";
//            System.err.println(errMsg);
//            showNetworkErrorDialog(NETWORK_ERROR_CONNECTION_TYPE, errMsg);
//            e.printStackTrace();
//        } catch (IOException e) {
//            String errMsg = "Не удалось установить соединение с сервером!";
//            System.err.println(errMsg);
//            showNetworkErrorDialog(NETWORK_ERROR_CONNECTION_TYPE, errMsg);
//            e.printStackTrace();
//        }
    }

    private void showErrorDialog(String title, String type, String details) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(type);
        alert.setContentText(details);
        alert.showAndWait();
    }

    public void showNetworkErrorDialog(String type, String details) {
        showErrorDialog(NETWORK_ERROR_TITLE, type, details);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
