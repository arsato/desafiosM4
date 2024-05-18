package cl.praxis.desafios.automotoraexcepciones;

public class MyException extends Exception {

    public MyException(String message) {
        super(message);
    }

    public MyException() {
        super();
    }
}
