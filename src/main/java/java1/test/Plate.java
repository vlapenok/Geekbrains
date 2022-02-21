package java1.test;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int appetite) {
        if (food < appetite) {
            return false;
        }
        food -= appetite;
        return true;
    }

    public void info() {
        System.out.println("Еды в тарелке " + food);
    }
}
