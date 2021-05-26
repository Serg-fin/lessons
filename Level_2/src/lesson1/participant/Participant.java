package lesson1.participant;

import lesson1.obstacle.Obstacle;

public interface Participant { // интерфейс обозначает нашего участника

    int run(); // абстрактный метод (возвращает дистанцию которую участник пробежал)

    int jump(); // абстрактный метод (возвращает высоту которую участник перепрыгнул)

    default boolean passObstacle(Obstacle obstacle) {
        return doAction(obstacle);
    }

    private boolean doAction(Obstacle obstacle) {
        return obstacle.passObstacleBy(this);
    }

}