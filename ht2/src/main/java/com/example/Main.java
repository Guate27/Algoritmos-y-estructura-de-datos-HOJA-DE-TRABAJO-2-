import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            String line;
            Stack<Integer> stack = new VectorStack<>();
            PostfixCalculator calculator = new PostfixCalculatorImpl(stack);

            while ((line = br.readLine()) != null) {
                try {
                    int result = calculator.evaluate(line);
                    System.out.println("Resultado: " + result);
                } catch (Exception e) {
                    System.out.println("Error evaluando la expresión: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }
    }
}
