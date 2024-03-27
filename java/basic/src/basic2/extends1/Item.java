package basic2.extends1;

public class Item {
    public String name;
    public int price;

    public int getPrice() {
        return price;
    }

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void print(){
        System.out.println("name = " + name + " price = " +
                price);

    }
}
