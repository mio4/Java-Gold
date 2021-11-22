package _00_Java_language._java8;

import java.util.function.Consumer;

@FunctionalInterface
interface  GreetingService{
    void sayMessage(String message);
}

public class _funcitonalInterface {

    public static void main(String[] args) {
//        testFunctionInterface();
        testConsumer();
    }

    public static void testFunctionInterface(){
        GreetingService greetingService = message -> {
            System.out.println("get msg :" + message);
        };

        greetingService.sayMessage("gee");
    }


    public static void testConsumer(){
        Consumer f = System.out::println;
        Consumer f2 = n -> System.out.println(n + "-F2");
        f.andThen(f2).accept("test");
    }
}
