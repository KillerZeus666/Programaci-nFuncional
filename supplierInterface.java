// Tal como indica el nombre, provee un valor; función sin argumentos que retorna un resultado.
// Ofrece el método funcional get para implementar como único método.

import java.util.function.Supplier;
import java.time.LocalDateTime;

class Main {
    public static void main(String[] args) {
        // Definimos un Supplier que retorna la fecha y hora actual
        Supplier<LocalDateTime> proveedor = () -> {
            return LocalDateTime.now();
        };
        
        // Imprimimos el resultado de invocar el método get del Supplier
        System.out.println(proveedor.get());
    }
}
