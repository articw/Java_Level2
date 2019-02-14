package Client;

import java.time.LocalDate;

public class Message {

    private String userName;

    private String message;

    private String text;

    private LocalDate date;

    public Message(String userName, String message) {
        this.userName = userName;
        this.message = message;
        this.date = LocalDate.now();
    }

    public Message(String userName, String message, String text){
        this.userName = userName;
        this.message = message;
        this.text = text;
    }



    public String getUserName() {
        return userName;
    }

    public String getMessage() {
        return message;
    }

    public LocalDate getDate() {
        return date;
    }


}
