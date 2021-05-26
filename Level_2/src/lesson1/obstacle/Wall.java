package lesson1.obstacle;

import lesson1.participant.Participant;

public class Wall implements Obstacle{

    private final int height;

    public Wall(int height) {   // создали класс "стена"
         this.height = height;   // задаем высоту которую нужно перепрыгнуть
    }

    @Override
    public boolean passObstacleBy(Participant participant) {
        if(participant.jump() >= height) {
            System.out.println("Участник " + participant + " успешно перепрыгнул стену ");
            return true;
        }
        else {
            System.out.println("Участник " + participant + " не смог перепрыгнуть стену " + height);
            return false;
        }
    }
}