package basic2.extends1;

public class Album extends Item {
    public String artist;

    public Album(String name, int price, String artist) {
        super(name, price);
        this.artist = artist;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("artist = " + artist);
    }
}
