import java.util.HashMap;
import java.util.TreeMap;

class Converter {
    HashMap<Character, Integer> romanNumeralMap = new HashMap<>();
    TreeMap<Integer, String> arabianNumeralMap = new TreeMap<>();


    public Converter() {
        romanNumeralMap.put('I',1);
        romanNumeralMap.put('V',5);
        romanNumeralMap.put('X',10);
        romanNumeralMap.put('L',50);
        romanNumeralMap.put('C',100);
        romanNumeralMap.put('D',500);
        romanNumeralMap.put('M',1000);


        arabianNumeralMap.put(1000, "M");
        arabianNumeralMap.put(900, "CM");
        arabianNumeralMap.put(500, "D");
        arabianNumeralMap.put(400, "CD");
        arabianNumeralMap.put(100, "C");
        arabianNumeralMap.put(90, "XC");
        arabianNumeralMap.put(50, "L");
        arabianNumeralMap.put(40, "XL");
        arabianNumeralMap.put(10, "X");
        arabianNumeralMap.put(9, "IX");
        arabianNumeralMap.put(5, "V");
        arabianNumeralMap.put(4, "IV");
        arabianNumeralMap.put(1, "I");
    }

    public boolean isRoman(String number){
        return romanNumeralMap.containsKey(number.charAt(0));
    }

    public String intToRoman(int number) {
        StringBuilder roman = new StringBuilder();
        int arabianKey;
        do {
            arabianKey = arabianNumeralMap.floorKey(number);
            roman.append(arabianNumeralMap.get(arabianKey));
            number -= arabianKey;
        } while (number != 0);
        return roman.toString();
    }


    public int romanToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = romanNumeralMap.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabian = romanNumeralMap.get(arr[i]);

            if (arabian < romanNumeralMap.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return result;
    }
}
