import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TelephoneDir {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addPhoneNumber("Иван", "12345");
        phoneBook.addPhoneNumber("Петр", "546789");
        phoneBook.addPhoneNumber("Иван", "434234");

        System.out.println(phoneBook.get("Иван"));
        System.out.println(phoneBook.get("Петр"));


    }

}










