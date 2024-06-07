package animals;

import java.util.Random;

public class Cat extends Animal {
    public static final int MAX_RUN_DISTANCE = 200;
    public static final int DISH_CAPACITY = 15;
    private static int catCount;
    private static int foodInDish = 10;
    private boolean hungry = true;
    private final int stomachCapacity;

    public Cat() {
        catCount++;
        Random random = new Random();
        stomachCapacity = random.nextInt(10) + 1;
    }

    public Cat(String name) {
        super.setName(name);
        catCount++;
        Random random = new Random();
        stomachCapacity = random.nextInt(10) + 1;
    }

    public void setName(String name) {
        super.setName(name);
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void ran(int distance) {
        do {
            if (distance > MAX_RUN_DISTANCE) {
                System.out.print("Кошка по кличке " + super.getName() + " пробежала " + MAX_RUN_DISTANCE +
                        " метров и легла отдохнуть 10 минут. После чего ещё ");
                distance -= MAX_RUN_DISTANCE;
            } else {
                System.out.println("Кошка по кличке " + super.getName() + " пробежала " + distance + " метров.");
                distance = 0;
            }
        } while (distance > 0);
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кошки не умеют плавать!");
    }

    public void eatFromDish() {
        if (hungry) {
            if (foodInDish >= stomachCapacity) {
                foodInDish -= stomachCapacity;
                hungry = false;
                System.out.println("Кошка по кличке " + super.getName() + " покушала " + stomachCapacity +
                        " еды из миски и теперь сыта.");
            } else {
                System.out.println("Кошка по кличке " + super.getName() + " не покушала! В миске всего " + foodInDish +
                        " еды, а ей нужно " + stomachCapacity + ", она осталась голодной.");
            }
        } else {
            System.out.println("Кошка по кличке " + super.getName() + " не голодна.");
        }
    }

    public static void addFoodToDish(int addedFoodCount) {
        foodInDish += addedFoodCount;

        if (foodInDish > DISH_CAPACITY) {
            foodInDish = DISH_CAPACITY;
            System.out.println("Мисска еды теперь полная!");
        } else {
            System.out.println("Добавили " + addedFoodCount + " еды в миску, теперь там " + foodInDish + " еды.");
        }
    }
}
