public class FibonacciGenerator {

    public String generate(int number){
        StringBuffer buffer = new StringBuffer();

        int previousNumber = 1;
        int currentNumber = 1;
        buffer.append(previousNumber);
        buffer.append(" ") ;
        buffer.append(currentNumber);
        int temp = 0;
        System.out.println(previousNumber);
        System.out.println(currentNumber);
        for (int i = 1; i <number ; i++) {
            buffer.append(" ") ;
            temp = currentNumber;
            currentNumber = currentNumber + previousNumber;
            previousNumber = temp;
            buffer.append(currentNumber);
            System.out.println(currentNumber);
        }

        return buffer.toString();

    }

    public static void main(String[] args) {
        FibonacciGenerator generator = new FibonacciGenerator();
        String string = generator.generate(10);

        System.out.println(string);
    }


}
