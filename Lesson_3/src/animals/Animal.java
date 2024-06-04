package animals;

public class Animal {
    public static int count;

    public Animal() {
        count++;
    }

    public void ran(int distance) {
        System.out.println("Животное пробежало " + distance + " метров.");
    }

    public void swim(int distance) {
        System.out.println("Животное проплыло " + distance + " метров.");
    }
}
