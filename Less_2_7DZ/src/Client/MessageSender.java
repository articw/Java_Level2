package Client;

public interface MessageSender {

    void submitMessage(String user, String message);



    void submitMessage(Message msg);
}
