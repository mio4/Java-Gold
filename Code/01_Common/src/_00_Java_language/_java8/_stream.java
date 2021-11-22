package _00_Java_language._java8;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _stream {

    public static void main(String[] args) {
        int[] source = {1,2,3,4,5,6};
        IntStream s = Arrays.stream(source);

        Arrays.stream(source)
                .map(i -> i*i)
                .forEach(System.out::println);
    }


}
