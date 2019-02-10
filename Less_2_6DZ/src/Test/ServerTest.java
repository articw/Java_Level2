package Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerTest {

    public static void main(String[] args) {
        ServerSocket serv = null;
        Socket sock = null; //сюда пишется информация о том что клиент подключился

        try {
            serv = new ServerSocket(8189); //объект класса ServerSocket, который прослушивает порт 8189
            System.out.println("Сервер запущен, ожидаем подключение...");
            sock = serv.accept(); //основной поток в режим ожидания
            System.out.println("Клиент подключился");
            Scanner sc = new Scanner(sock.getInputStream()); //обработчик входящего потока
            PrintWriter pw = new PrintWriter(sock.getOutputStream()); //обработчик исходящего потока


            while (true){
                String str = sc.nextLine();
                if(str.equals("end")) break;
                pw.println("Эхо: " + str);
                pw.flush();
                System.out.println(str);
            }

        } catch (IOException e) {
            System.err.println("Ошибка инициализации сервера ");
        } finally {
            try {
                serv.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }




}
