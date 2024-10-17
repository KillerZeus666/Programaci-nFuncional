import java.util.function.Consumer;
import java.util.Date;

class Main {
    public static void main(String[] args) {
        Consumer<Date> iniciar = f -> f.setTime(0);
        Consumer<Date> consumidor = (t) -> {
            System.out.println(t);
        };
        
        var fecha = new Date();
        iniciar.andThen(consumidor).accept(fecha);
    }
}
