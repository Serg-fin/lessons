package lesson6.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.function.Consumer;

public class Network { // в этом классе описана логика сетевого взаимодействия

    private static final int SERVER_PORT = 8189;
    private static final String SERVER_HOST = "localhost";

    private final String host;
    private final int port;
    private Socket socket;
    private DataInputStream socketInput;
    private DataOutputStream socketOutput;

    public Network(String host, int port) {
       this.host = host; // используем localhost , т.е. всё крутится на одном компьютере
//     this.host = "192.168.1.105"; //  пример явного указания ip адреса
       this.port = port;
    }

    public Network() {
        this(SERVER_HOST, SERVER_PORT);
    }

    public boolean connect() { // данный метод занимается установкой сетевого соединения
        try {
            socket = new Socket(host, port);
            socketInput = new DataInputStream(socket.getInputStream());    // используем для чтения   данных по сетевому соединению
            socketOutput = new DataOutputStream(socket.getOutputStream()); // используем для отправки данных по сетевому соединению
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to establish connection");
            return false;
        }
    }

    public void sendMessage(String message) throws IOException {
        try {
            socketOutput.writeUTF(message);
        } catch (IOException e) {
            System.out.println("Failed to send message to server");
            throw  e;
        }
    }

    public void waitMessages(Consumer<String> messageHandler) {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    String message = socketInput.readUTF();
                    messageHandler.accept(message);
                } catch (IOException e) {
                    System.err.println("Failed to read message from server");
                    break;
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
