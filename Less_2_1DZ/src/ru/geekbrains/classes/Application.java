package ru.geekbrains.classes;

import ru.geekbrains.classes.animals.Cat;
import ru.geekbrains.classes.animals.Dog;
import ru.geekbrains.classes.obstacles.Cross;
import ru.geekbrains.classes.obstacles.Obstacle;
import ru.geekbrains.classes.obstacles.Wall;
import ru.geekbrains.classes.obstacles.Water;
import ru.geekbrains.classes.Team.*;

public class Application {

    public static void main(String[] args) {


        //создаем экземпляры интерфейса Участники
        Participant[] participants = new Participant[] {
                new Cat("Барсик", 10, 12, 0),
                new Dog("Дружок", 20, 5, 15),
                new Cat("Мурзик", 9, 14, 0),
                new Robot("Вертер", 50, 50, 50),
        };
        //создаем экземпляры класса препятсвия
        Obstacle[] obstacles = new Obstacle[] {
                new Cross(5),
                new Wall(3),
                new Water(7)
        };




       Course c = new Course( new Obstacle[]{new Wall(10), new Water(20), new Cross(150)});
       Team team = new Team("Команда", participants);
       c.doIt(team);
       team.getInfo(); //информация о всех  участниках





       /*

        //в двойном цикле обходим массивы участников и препятствий и заставляем участников проходить через препятсвия
        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                obstacle.doIt(participant);
                if (!participant.isOnDistance()) {
                    break;
                }
            }
        }

        //выводим результаты участников
        System.out.println("Итоги:");
        for (Participant participant : participants) {
            System.out.println(participant);
        }

        */
    }
}
