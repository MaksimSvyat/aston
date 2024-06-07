package animals;

public class Animal {
    private static int count;
    private String name;

    public Animal() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void ran(int distance) {
        System.out.println("Животное пробежало " + distance + " метров.");
    }

    public void swim(int distance) {
        System.out.println("Животное проплыло " + distance + " метров.");
    }
}
