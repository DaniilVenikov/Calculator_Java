import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение: ");
        String input = scanner.nextLine();


        System.out.println(calc(input));
    }


    public static String calc(String input) throws Exception {
        Converter converter = new Converter();

        String[] operation = {"+", "-", "/", "*"};
        String[] regexOperation = {"\\+", "-", "/", "\\*"};

        int operationIndex = -1;
        for (int i = 0; i < operation.length; i++) {
            if(input.contains(operation[i])){
                operationIndex = i;
                break;
            }
        }

        if(operationIndex == -1) {
            throw new Exception();
        }

        String[] data = input.split(regexOperation[operationIndex]);

        if(data.length > 2){
            throw new Exception();
        }

        if(converter.isRoman(data[0].trim()) == converter.isRoman(data[1].trim())){
            int value1, value2;
            boolean isRoman = converter.isRoman(data[0]);
            if(isRoman){
                value1 = converter.romanToInt(data[0].trim());
                value2 = converter.romanToInt(data[1].trim());

            } else {
                value1 = Integer.parseInt(data[0].trim());
                value2 = Integer.parseInt(data[1].trim());

            }
            if(value1 < 1 || value1 > 10 || value2 < 1 || value2 > 10){
                throw new Exception();
            }


            int result = 0;
            switch (operation[operationIndex]) {
                case "+" -> result = value1 + value2;
                case "-" -> result = value1 - value2;
                case "/" -> result = value1 / value2;
                case "*" -> result = value1 * value2;
            }
            if(isRoman){
                if(result <= 0){
                    throw new Exception();
                } else return converter.intToRoman(result);
            }
            else{
                return Integer.toString(result);
            }
        } else throw new Exception();
    }
}
