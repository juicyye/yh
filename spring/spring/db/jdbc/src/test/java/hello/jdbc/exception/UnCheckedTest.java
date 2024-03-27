package hello.jdbc.exception;

public class UnCheckedTest {
    static class MyUnCheckedException extends RuntimeException {
        public MyUnCheckedException(String message) {
            super(message);
        }
    }

    static class Service{
        Repository repository = new Repository();
        public void callCatch(){

            try{
                repository.call();
            } catch (RuntimeException e){

            }
        }


    }

    static class Repository{
        public void call(){
            throw new MyUnCheckedException("ex");
        }
    }
}
