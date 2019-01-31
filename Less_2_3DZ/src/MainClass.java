/*
1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
   Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
   Посчитать, сколько раз встречается каждое слово.

2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 В этот телефонный справочник с помощью метода add() можно добавлять записи.
  С помощью метода get() искать номер телефона по фамилии.
  Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
  тогда при запросе такой фамилии должны выводиться все телефоны.



 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MainClass {
    public static void main(String[] args) {

        //cоздаем массив
        String[] words  = {"красный", "белый", "красный", "черный", "желтый", "зеленый", "фиолетовый", "белый"};

        //
        HashMap<String, Integer> mapWords = new HashMap<>();
        for(String word : words){
            mapWords.put(word, mapWords.getOrDefault(word, 0) +1);
        }


        System.out.println(mapWords + "");


        //На основе HashMap создаем коллекцию только из уникальных элементов
        HashSet<String> uniqList = new HashSet(Arrays.asList(words));
        System.out.println(uniqList);


        TelephoneDir pd = new TelephoneDir();

        pd.add("Петров", "546-56-87");
        pd.add("Петров", "876-45-32");
        pd.add("Сидоров", "321-32-98");


        pd.get("Петров");



    }



}
