package animals;

public class Dog extends Animal {
    public static final int MAX_RUN_DISTANCE = 500;
    public static final int MAX_SWIM_DISTANCE = 10;
    private String name;
    public static int dogCount;

    public Dog() {
        dogCount++;
    }

    public Dog(String name) {
        this.name = name;
        dogCount++;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void ran(int distance) {
        do {
            if (distance > MAX_RUN_DISTANCE) {
                System.out.print("Собака по кличке " + name + " пробежала " + MAX_RUN_DISTANCE +
                        " метров и легла отдохнуть 10 минут. После чего ещё ");
                distance -= MAX_RUN_DISTANCE;
            } else {
                System.out.println("Собака по кличке " + name + " пробежала " + distance + " метров.");
                distance = 0;
            }
        } while (distance > 0);
    }

    @Override
    public void swim(int distance) {
        if (distance > MAX_SWIM_DISTANCE) {
            System.out.println("Собачка по кличке " + name + " утонула. RIP");
        } else {
            System.out.println("Собака по кличке " + name + " проплыла " + distance + " метров.");
        }
    }
}
