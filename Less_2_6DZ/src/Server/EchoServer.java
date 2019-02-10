package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {


    public static void main(String[] args) {



        try (ServerSocket serverSocket = new ServerSocket(7777)) {
            System.out.println("Server started!");

            while (true) {

                //accept - это точка нового подключения. Значит, для того чтобы поддерживать несколько подключений, нужно создать новый поток
                //и поместить его в цикл?
                //Не работает, потому что поток ввода-вывода не видит сокет

                /*
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Socket socket = serverSocket.accept();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Client connected!");

                    }
                }).start();
                */

                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                Scanner serverMsg = new Scanner(System.in);
                System.out.print("Сообщение сервера: ");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try (DataInputStream inp = new DataInputStream(socket.getInputStream());
                             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
                            {
                                //Для клиента, написанного на уроке, сообщения с сервера приходят в Input клиента, но
                                //cообщения от клиента не приходят в Input сервера и не отображаются в консоли. Почему?


                            while (true){
                                    //Чтобы напечатать что-то в консоли сервера и положить в поток Output

                                   String servMsg = serverMsg.nextLine();
                                   if(servMsg.equals("end")) break;
                                   out.writeUTF(servMsg);
                                   out.flush();
                                   System.out.println(servMsg);

                                   //Получаем на сервер сообщение от клиента и выводим в консоли сервера
                                   //Почему в Input пищется не сообщение от клиента, а сообщение из консоли сервера?
                                  String msg = inp.readUTF();
                                  System.out.println("Message: " + msg);

                                }

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

