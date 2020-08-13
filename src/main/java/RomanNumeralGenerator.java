import java.util.*;
import java.util.stream.Collectors;

public class RomanNumeralGenerator {

    private Map<Integer,String> numberMap = new HashMap<>();

    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();


    public RomanNumeralGenerator(){
        numberMap.put(1,"I");
        numberMap.put(5,"V");
        numberMap.put(10,"X");
        numberMap.put(50,"L");
        numberMap.put(100,"C");
        numberMap.put(500,"D");
        numberMap.put(1000,"M");

        numberMap.put(4,"IV");
        numberMap.put(9,"IX");
        numberMap.put(400,"CD");
        numberMap.put(900,"CM");
        numberMap.put(40,"XL");
        numberMap.put(90,"XC");

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    public String translate(int number){
        StringBuilder buffer = new StringBuilder();
        List<Integer> keys = numberMap.keySet().stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        //iterate over the keyset in reverse order and check if number is divisible with the first key keys, if it is then append roman numeral to the buffer;
        // if it is not get the remainder and check if the remainder is divisible with the next key and so.....

        for (Integer key: keys) {
            int remainder = number % key;
            int quotient = number / key;

            if(number % key ==0){
                for (int i = 1; i <= quotient ; i++) {
                    buffer.append(numberMap.get(key));
                }
                break;
            }else if((number % key) < number){
                number =  remainder;
                for (int i = 1; i <= quotient ; i++) {
                    buffer.append(numberMap.get(key));
                }
            }


        }
        return buffer.toString() ;
    }

    public  String toRoman(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
    }

}
