class PostfixCalculatorImpl implements PostfixCalculator {
    private Stack<Integer> stack;

    public PostfixCalculatorImpl(Stack<Integer> stack) {
        this.stack = stack;
    }

    @Override
    public int evaluate(String expression) {
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (token.matches("\\d+")) {
                stack.push(Integer.parseInt(token));
            } else if (token.matches("[+\-*/%]") && stack.peek() != null) {
                int b = stack.pop();
                int a = stack.pop();
                int result;
                switch (token) {
                    case "+": result = a + b; break;
                    case "-": result = a - b; break;
                    case "*": result = a * b; break;
                    case "/":
                        if (b == 0) throw new ArithmeticException("División entre cero");
                        result = a / b;
                        break;
                    case "%": result = a % b; break;
                    default: throw new IllegalArgumentException("Operador desconocido: " + token);
                }
                stack.push(result);
            } else {
                throw new IllegalArgumentException("Entrada inválida: " + token);
            }
        }
        return stack.pop();
    }
}
