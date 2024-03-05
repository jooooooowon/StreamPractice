package stream_practice.StreamPractice.parallelStream;

import java.util.Arrays;
import java.util.List;

public class NotParallelStreamTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4);

        long start = System.currentTimeMillis();
        numbers.forEach(number -> {
            try{
                Thread.sleep(3000);
                System.out.println(number + " : " + Thread.currentThread().getName());
            }catch(Exception e){
                e.printStackTrace();
            }
        });

        long duration =- System.currentTimeMillis() - start;
        System.out.println(duration + " seconds");
    }
}
