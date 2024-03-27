package basic2.extends1;

public class Parent {
    private String name;
    private int price;

    public Parent(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void print() {
        System.out.println("name = " +
                name + " price " +
                price);
    }
}
