package com.mio4.demo._exception;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author mio4
 * @date 2020-08-24 14:59
 */
public class UncheckedExceptionHandler {
    /**
     * 处理Unchecked Exception
     * 代码臃肿，不够优雅，违背了lambda表达式设计初衷
     */
    public static void handleUnckeckedExceptionRoughly(){
        List<Integer> integers = Arrays.asList(5,4,3,2,1,0);
        integers.forEach(i -> {
            try{
                System.out.println(1 / i);
            } catch (ArithmeticException e){
                //打日志...处理异常
            }
        });
    }

    /**
     * 处理Unchecked Exception
     *
     * 1. 传入参数Consumer<Integer> consumer，表示接收一个Integer类型的参数
     * 2. 传入 `System.out.println(1/i)` 定义consumer的消费行为
     * 3. 执行 `consumer.accept` 对消费行为进行消费
     *
     * @param consumer
     * @return
     */
    public static Consumer<Integer> calculateWrapper(Consumer<Integer> consumer) {
        return divideByOne -> {
            try {
                consumer.accept(divideByOne);
            } catch (ArithmeticException e) {
                //打日志...处理异常
            }
        };
    }
    public static void handleUncheckedException() {
        List<Integer> integers = Arrays.asList(5,4,3,2,1,0);
        //calculateWrapper内可替换为具体的业务逻辑，例如calculateWrapper(i -> {...})
        integers.forEach(calculateWrapper(i -> System.out.println(1/i)));
    }
}
