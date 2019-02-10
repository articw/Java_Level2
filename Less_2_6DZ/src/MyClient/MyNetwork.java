package MyClient;

import javax.swing.*;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MyNetwork implements Closeable {

    private final Socket socket;
    private final DataOutputStream out;
    private final DataInputStream in;

    private final Thread receiver;

    private Window send;



    public MyNetwork(String hostName, int port) throws IOException {
        this.socket = new Socket(hostName, port);
        this.out = new DataOutputStream(socket.getOutputStream());
        this.in = new DataInputStream(socket.getInputStream());

        //this.send = new Window();


        //Здесь мы должны получать сообщение от сервера и выводить в главное окно
        this.receiver = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        String msg = in.readUTF();
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("New message " + msg);
                                //send.sendMsg();
                                //А как тут отправить сообщение, если нет интерфейса?
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        receiver.start();
    }

    public void sendMessage(String msg) {
        try {
            out.writeUTF(msg);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {
        receiver.interrupt();
        socket.close();
    }
}