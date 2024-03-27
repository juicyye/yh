package hello.spinrgtx.order;

public class NotEnoughMoenyException extends Exception {

    public NotEnoughMoenyException(String message) {
        super(message);
    }
}
