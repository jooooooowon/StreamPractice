package stream_practice.StreamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice_숫자쌍리스트 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(3,4);
        List<int[]> result = list1.stream()
                .flatMap(i -> list2.stream()
                        .map(j -> new int[]{i,j}))
                .collect(Collectors.toList());
        result.stream().map(Arrays::toString).forEach(System.out::println);
    }
}
