package ru.geekbrains.classes;

import ru.geekbrains.classes.animals.Cat; //что значит импорт?


public class Team  {

    private String name; //название команды
    private Participant[] participants; //массив участников


    //Конструктор класса, создаем команду на основе массива участников
    public Team(String name, Participant[] participant) {
        this.name = name;
        this.participants = participant;

    }


    //Метод вывода информации об участниках, прошедших дистанцию

    public void getInfoDone() {
        System.out.println("Участники, прошедшие дистанцию:");

        //обходим массив участников и если прошел дистанцию, выводим результат
        //пременная в цикле названа p, чтобы отличать от participants
        for (Participant p : participants)
            if (p.isOnDistance()) {
                System.out.println(p);
            }
    }

    //Метод вывода информации об участниках
    public void getInfo() {
        System.out.println("Участники" + this.name);

    }

    //геттер для массива участников
    public Participant[] getPartisipants() {
        return this.participants;
    }
}




