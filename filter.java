import java.util.List;

class Main {
    public static void main(String[] args) {
        List<String> personas = List.of("Juan", "Samuel", "Mario", "Sofia", "Sara");
        personas.stream()
                .filter(x -> x.startsWith("S"))
                .forEach(nombre -> System.out.println(nombre));
    }
}
