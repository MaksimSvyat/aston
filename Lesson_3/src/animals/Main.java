package animals;

public class Main {

    public static void main(String[] args) {
        Dog dog1 = new Dog("Bobik");
        Dog dog2 = new Dog();
        dog2.setName("Tuzik");
        Dog dog3 = new Dog();

        dog1.ran(1235);
        dog1.swim(7);

        dog2.ran(125);
        dog2.swim(10);

        dog3.swim(11);

        Cat cat1 = new Cat("Barsik");
        Cat cat2 = new Cat();
        cat2.setName("Gav");
        Cat cat3 = new Cat("Murzik");

        cat1.ran(217);
        cat2.ran(200);
        cat2.swim(10);

        Cat[] cats = {cat1, cat2, cat3};

        for (Cat cat : cats) {
            cat.eatFromDish();
        }

        Cat.addFoodToDish(15);

        for (Cat cat : cats) {
            cat.eatFromDish();
        }

        System.out.println("Создано животных: " + Animal.count + " шт. Из них собак: " + Dog.dogCount +
                " шт. и кошек: " + Cat.catCount + " шт.");
    }
}