import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PhoneBook {
    private Map<String, HashSet<String>> phonebook;

    public PhoneBook() {
        this.phonebook = new HashMap<>();
    }

    public void addPhoneNumber(String name, String phoneNumber){
        HashSet<String> phones;
       if(phonebook.containsKey(name)){ //если в Map уже есть такое имя
            phones = phonebook.get(name);
       }else {
           phones = new HashSet<>();
           phonebook.put(name, phones);
       }
       phones.add(phoneNumber);
    }

    public HashSet<String> get(String name){
        return phonebook.get(name);
    }
}
