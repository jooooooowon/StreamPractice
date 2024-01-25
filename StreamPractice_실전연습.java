package stream_practice.StreamPractice;

import stream_practice.StreamPractice.dto.Trader;
import stream_practice.StreamPractice.dto.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamPractice_실전연습 {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
//        1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오.
        List<Transaction> result1 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .toList();
        System.out.println("1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오. : ");
        result1.stream().forEach(System.out::println);
//        2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
        List<String> result2 = transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().toList();
        System.out.println("2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오. : ");
        result2.stream().forEach(System.out::println);
//        3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 나열하시오.
        List<Trader> result3 = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(trader -> trader.getName()))
                .toList();
        System.out.println("3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 나열하시오. : ");
        result3.stream().forEach(System.out::println);
//        4. 모든 거래자의 이름을 알파벳 순으로 정렬해서 반환하시오.
        List<String> result4 = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .toList();
        System.out.println("4. 모든 거래자의 이름을 알파벳 순으로 정렬해서 반환하시오. : ");
        result4.stream().forEach(System.out::println);
//        5. 밀라노에 거래자가 있는가?
        boolean result5 = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println("5. 밀라노에 거래자가 있는가? : ");
        System.out.println(result5 ? "yes" : "no");
//        6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
        List<Integer> result6 = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .toList();
        System.out.println("6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오. : ");
        result6.stream().forEach(System.out::println);
//        7. 전체 트랜잭션 중 최댓값은 얼마인가?
        Optional result7 = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compare);
        System.out.println("7. 전체 트랜잭션 중 최댓값은 얼마인가? : ");
        System.out.println(result7.toString());
//        8. 전체 트랜잭션 중 최솟값은 얼마인가?
        Optional result8 = transactions.stream()
                .map(Transaction::getValue)
                .min(Integer::compare);
        System.out.println("8. 전체 트랜잭션 중 최솟값은 얼마인가? : ");
        System.out.println(result8.toString());

    }
}
