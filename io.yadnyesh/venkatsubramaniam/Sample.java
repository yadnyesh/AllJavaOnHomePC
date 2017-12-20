package venkatsubramaniam;

import java.util.Arrays;
import java.util.List;

public class Sample {

    public static int transform(int number){
        System.out.println("Transform: " + number + " > " + Thread.currentThread());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number;
    }

    private static boolean check(int number){
        System.out.println("Check: " + number + " > " + Thread.currentThread());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    private static void printIt(int number){
        System.out.println(number);
        System.out.println("Thread ..." + Thread.currentThread());
    }

    private static int add(int total, int e){
        int result = total + e;
        System.out.println("Total: " + total + "  Element: " + e + "   Result: " + result);
        return result;

    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        int result = 0;
        for(int e : numbers){
            if(e % 2 ==0){
                result += e * 2;
            }
        }
        //System.out.println(result);

        System.out.println(
            numbers.stream()
                    //.reduce(0,(total, e) -> add(total, e)));
                .reduce(0, Sample::add));


        //Collection Pipeline pattern - Martin Fowler
        //If you are the source of the stream use parallelStream
        //use stream().parallel() if you are not the source/author/creator of the stream
//            numbers.stream()
//                .parallel()
//                .filter(Sample::check)
//                //.map(Sample::transform)
//                .forEachOrdered(Sample::printIt);
    }

}
