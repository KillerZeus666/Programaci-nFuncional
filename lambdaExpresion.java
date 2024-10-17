import java.util.function.Function;

class Main {
    public static void main(String[] args) {
        int arg = 6;
        Function<Integer, Integer> lambda = x -> x * x;
        System.out.println("El cuadrado de " + arg + " es: " + lambda.apply(arg));
    }
}
