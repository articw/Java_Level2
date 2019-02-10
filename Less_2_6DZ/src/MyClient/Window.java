package MyClient;

import Client.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Window extends JFrame {

    private JButton button;
    private JScrollPane jsp;
    private JTextField insertMessage;
    private JPanel panel;
    private DefaultListModel<String> listModel; //чтобы работать с list
    private JList<String> list; //список строк в главном окне

    private Socket sock;
    private Scanner in;
    private PrintWriter out;
    private MyNetwork network;


    public Window(){


        //Окно программы
        setTitle("Сетевой чат");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 500, 500);

        //задаем менеджер размещения компонентов
        setLayout(new BorderLayout());

        //создаем кнопку
        button = new JButton("Отправить");
        //создаем тектсовое поле для отправки сообщений
        insertMessage = new JTextField();

        //Текстовое поле в центре окна, с функцией пролистывания содержимого
        listModel = new DefaultListModel();
        list = new JList(listModel);
        jsp = new JScrollPane(list);
        add(jsp, BorderLayout.CENTER);

        //Панель, куда устанавливается поле ввода сообщения и кнопка
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(button, BorderLayout.WEST);
        panel.add(insertMessage, BorderLayout.CENTER);
        //добавляем панель во фрейм
        add(panel, BorderLayout.SOUTH);

        //Обработчик событий в окне ввода сообщения с помощью клавиши Enter
        insertMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               listModel.add(listModel.size(), insertMessage.getText());
                 //По нажатию кнопки отправить сообщение в TextField должно передаться на сервер
                // Почему на сервере не видно сообщения?
               network.sendMessage(insertMessage.getText());
            }
        });

        //Обработчик событий в окне ввода сообщения с помощью кнопки button
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.add(listModel.size(), insertMessage.getText());
            }
        });

        try {
            network = new MyNetwork("localhost", 7777);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        setVisible(true);
    }


        public void sendMsg() {
             out.println(insertMessage.getText());
             out.flush();
             insertMessage.setText("");
         }
}
