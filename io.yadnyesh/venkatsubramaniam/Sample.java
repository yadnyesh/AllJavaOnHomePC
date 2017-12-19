package venkatsubramaniam;

import java.util.Arrays;
import java.util.List;

public class Sample {

    public static int transform(int number){
        return number;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3);

        int result = 0;
        for(int e : numbers){
            if(e % 2 ==0){
                result += e * 2;
            }
        }
        System.out.println(result);

        //Collection Pipeline pattern - Martin Fowler
            numbers.stream()
                .map(Sample::transform)
                .forEach(System.out::println);
    }

}
