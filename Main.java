import java.util.*;
import java.io.IOException;
import java.nio.file.*;
//@FunctionalInterface
interface TraerDatos { List<String> leeDatos(String archivo) throws IOException;}
public class Main {
    public static void main(String[] args) throws IOException {
        TraerDatos lectura = (a) -> {
            String filePath = System.getProperty("user.dir") + "/" + a;
            return Files.readAllLines(Paths.get(filePath));
        };
        List<String> registros = lectura.leeDatos("compras.csv");
        registros.remove(0); // quita encabezados
        int totalReg = registros.size();
        System.out.println("Reporte Semanal de Ventas \n Cantidad de ventas del periodo: " + totalReg);
        Map<String, Integer> agregado = new HashMap<>();
        final Integer[] valort = {0};
        registros.forEach(linea -> {
            String[] campos = linea.split(",");
            String cliente = campos[0];
            Integer valor = Integer.parseInt(campos[2]);
            valort[0] = valort[0] + valor;
            agregado.compute(cliente, (k, v) -> v == null ? valor : v + valor);
            agregado.put("Monto total de ventas", valort[0]);
        });
        List<String> resumen = agregado.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .map(entry -> entry.getKey() + ": $" + entry.getValue()).toList();
        resumen.forEach(s -> System.out.println("      " + s));
    }
}