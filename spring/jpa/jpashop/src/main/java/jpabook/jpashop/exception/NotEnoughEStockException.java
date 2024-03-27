package jpabook.jpashop.exception;

public class NotEnoughEStockException extends RuntimeException {
    public NotEnoughEStockException() {
        super();
    }

    public NotEnoughEStockException(String message) {
        super(message);
    }

    public NotEnoughEStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughEStockException(Throwable cause) {
        super(cause);
    }

    protected NotEnoughEStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
