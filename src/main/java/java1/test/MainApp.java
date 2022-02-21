package java1.test;

public class MainApp {
    public static void main(String[] args) {
//        oop();
        new TicTacToe();
    }

    private static void oop() {
        Animal[] animals = {
                new Cat("Barsik", 8),
                new Dog("Tuzik", 18)
        };
        Plate plate = new Plate(10);

        for (int i = 0; i < animals.length; i++) {
            plate.info();
            animals[i].eat(plate);
            System.out.println();
        }
    }
}
