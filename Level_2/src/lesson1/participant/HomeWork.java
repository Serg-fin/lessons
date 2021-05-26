package lesson1.participant;

import lesson1.Competition;
import lesson1.obstacle.Track;
import lesson1.obstacle.Wall;

import java.util.Random;

public class HomeWork {

    public static void main(String[] args) {
        System.out.println("Подготовительный этап...");
        Competition competition = createAndPrepareCompetition();

        System.out.println("Начинаем соревнование!");
        competition.startCompetition();

        System.out.println("Соревнование окончено! Победители:");
        for (Participant winner : competition.getLastWinners()) {
            System.out.println(winner);
        }
    }

    private static Competition createAndPrepareCompetition() {
        Participant human = new Human("Сергей", 200, 200);
        Participant cat = new Cat("Мурзик", 100, 1100);
        Participant robot = new Robot("Вертер", 300, 2000);

        Random random = new Random();

        Wall wall = new Wall(random.nextInt(301));
        Track track = new Track(random.nextInt(2001));

        Competition competition = new Competition("''Олимпийские Игры''");
        competition.setParticipants(human, cat, robot);
        competition.setObstacles(wall, track);
        return competition;
    }
}