package ru.geekbrains.classes;

import ru.geekbrains.classes.animals.Cat;
import ru.geekbrains.classes.obstacles.Cross;
import ru.geekbrains.classes.obstacles.Obstacle;
import ru.geekbrains.classes.obstacles.Water;
import ru.geekbrains.classes.obstacles.Wall;
import ru.geekbrains.classes.Team;
import ru.geekbrains.classes.Application;

public class Course {


    public Obstacle[] obstacles;// создаем массив препятсвий - барьер, бассейн, бег

    //в конструкторе заполняем массив
    public Course(Obstacle[] obstacles){
        this.obstacles = obstacles;
    }

    //Метод прохождения препятствий
    //Непонятно, почему не дает сделать Team t, а только Participant
    public void doIt(Team team){
        for (Participant t : team.getPartisipants()) {
            for (Obstacle o : obstacles) {
                o.doIt(t);
                if (!t.isOnDistance()) {
                    break;
                }
            }
        }
    }



}
