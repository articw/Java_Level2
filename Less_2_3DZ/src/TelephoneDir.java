import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TelephoneDir {

    //ключ - фамилия, значение - коллекция телефонов
   private Map<String, HashSet<String>> mapPhone;

   //конструктор класса
   public TelephoneDir(){
       this.mapPhone = new HashMap<>();
   }

   //Не смог понять, как реализовать этот метод
   public void add(String lastName, String phone){
      for(Map.Entry<String, String> o : mapPhone.entrySet());

   }

   public HashMap<String, HashSet<String>> get(String lastName){
       return this.mapPhone;
   }







}


