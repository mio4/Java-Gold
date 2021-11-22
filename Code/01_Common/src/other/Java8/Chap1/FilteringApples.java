package other.Java8.Chap1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Arrays.asList;

public class FilteringApples {

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }


    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : inventory){
            if(p.test(apple))
                result.add(apple);
        }
        return result;
    }

    public static void main(String[] args){
        List<Apple> inventory = asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        //1.将函数作为参数传入函数
        List<Apple> greenApples = filterApples(inventory,FilteringApples::isGreenApple);
        System.out.println(greenApples);

        List<Apple> heavyApples = filterApples(inventory,FilteringApples::isHeavyApple);
        System.out.println(heavyApples);

        //2.优化，使用匿名函数
        List<Apple> greenApples2 = filterApples(inventory,(Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);

        //1.使用stream流
//        List<Apple> heavyApples2 = inventory.stream().filter((Apple a) -> a.getWeight() > 100)
//                .collect(toList());
    }







}
