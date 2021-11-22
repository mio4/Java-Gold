package com.mio4.demo._exception;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author mio4
 * @date 2020-08-24 15:03
 */

public class CheckedExceptionHandler {

    /**
     * 相对于java.util.function.Consumer类，方法添加了抛出异常说明
     * ref: https://www.baeldung.com/java-lambda-exceptions
     * @param <T>
     * @param <E>
     */
    @FunctionalInterface
    interface HandleExceptionConsumer<T, E extends Exception> {
        void accept(T t) throws E;
    }

    public static <T> Consumer<T> throwingConsumerWrapper(HandleExceptionConsumer<T, Exception> throwingConsumer) {
        return i -> {
            try {
                throwingConsumer.accept(i);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }
    public static void handleCheckedException(){
        List<Integer> integers = Arrays.asList(5,4,3,2,1,0);
        integers.forEach(throwingConsumerWrapper(i -> System.out.println(1/i)));
    }
}
