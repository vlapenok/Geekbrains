package java1.test;

public class Animal {
    private String name;
    private int appetite;
    private boolean hungry;

    public Animal(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        hungry = true;
    }

    public void eat(Plate plate) {
        if(!hungry) {
            System.out.println(name + " не голоден");
            return;
        }
        if(plate.decreaseFood(appetite)) {
            System.out.println(name + " поел из тарелки");
            hungry = false;
            appetite = 0;
        } else {
            System.out.println(name + " не хватило еды");
        }
    }

}
