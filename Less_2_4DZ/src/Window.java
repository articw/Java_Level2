import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window extends JFrame {

    private JButton button;
    private JScrollPane jsp;
    private JTextField insertMessage;
    private JPanel panel;
    private DefaultListModel<String> listModel; //чтобы работать с list
    private JList<String> list; //список строк в главном окне

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
       listModel = new DefaultListModel<>();
       list = new JList<>(listModel);
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
           }
       });

       //Обработчик событий в окне ввода сообщения с помощью кнопки button
      button.addActionListener(new AbstractAction() {
           @Override
           public void actionPerformed(ActionEvent e) {
               listModel.add(listModel.size(), insertMessage.getText());
           }
       });

       setVisible(true);
   }
}
