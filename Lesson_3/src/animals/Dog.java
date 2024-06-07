package animals;

public class Dog extends Animal {
    public static final int MAX_RUN_DISTANCE = 500;
    public static final int MAX_SWIM_DISTANCE = 10;
    private static int dogCount;

    public Dog() {
        dogCount++;
    }

    public Dog(String name) {
        super.setName(name);
        dogCount++;
    }

    public void setName(String name) {
        super.setName(name);
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void ran(int distance) {
        do {
            if (distance > MAX_RUN_DISTANCE) {
                System.out.print("Собака по кличке " + super.getName() + " пробежала " + MAX_RUN_DISTANCE +
                        " метров и легла отдохнуть 10 минут. После чего ещё ");
                distance -= MAX_RUN_DISTANCE;
            } else {
                System.out.println("Собака по кличке " + super.getName() + " пробежала " + distance + " метров.");
                distance = 0;
            }
        } while (distance > 0);
    }

    @Override
    public void swim(int distance) {
        if (distance > MAX_SWIM_DISTANCE) {
            System.out.println("Собачка по кличке " + super.getName() + " утонула. RIP");
        } else {
            System.out.println("Собака по кличке " + super.getName() + " проплыла " + distance + " метров.");
        }
    }
}
