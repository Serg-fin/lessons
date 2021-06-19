package lesson6.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static final int PORT = 8189; // значение порта сделали константой *** 2.

    public static void main(String[] args) {
       try (ServerSocket serverSocket = new ServerSocket(PORT)) { // создаем первый экземпляр серверного сокета и указываем порт для подключения(8189)(ServerSocket занимается только приемом данных по сети) *** 1.
           System.out.println("Server has been started, waiting for new connection...(Сервер был запущен, ожидает новое подключение) ");
           Socket clientSocket = serverSocket.accept(); // что-бы дождаться подключения от клиента вызываем метод accept (принимать). (Socket занимается приемом и отправкой данных по сети)
                                                        // Этот метод будет возвращать экземпляр нашего сокета клиента clientSocket *** 3.
           System.out.println("Client is connected"); // сообщение в консоль, что клиент подключился

           DataInputStream input = new DataInputStream(clientSocket.getInputStream()); // используем для чтения данных по сетевому соединению
           DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream()); // используем для отправки данных по сетевому соединению

           processClientConnection(input, output);
       } catch (IOException e) {
           System.err.println("Failed to bind port " + PORT);
           e.printStackTrace();
       }

    }

    private static void processClientConnection(DataInputStream input, DataOutputStream output) {
        while (true) {
            try {
                String message = input.readUTF(); // создали цикл который будет постоянно ожидать новые сообщения
                System.out.println("Received message: " + message);
                if (message.equals("/end")) { // если полученное сообщение эквивалентно команде "/end" (клиент говорит, что заканчивает соединение) , то работа цикла обрывается и наш сервер прекращает свою работу
                    break;
                }

                output.writeUTF("Echo: " + message); // если сервер не получил в сообщении команду "/end", то сервер отправляет обратно клиенту его-же сообщение с пометкой "Echo"
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Connection has been closed");
                break;
            }
        }
    }
}
