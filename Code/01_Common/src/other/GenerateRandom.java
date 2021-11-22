package other;

import java.util.Random;

/**
 * 给你一个能生成1到5随机数的函数，用它写一个函数生成1到7的随机数。 (即，使用函数rand5()来实现函数rand7())。
 * 给定一个函数，它完全随机地产生【1,3】范围内的整数（即每个数的产生机率都是1/3）。用给定的函数去求一个完全随机产生【1,89】范围内的整数函数
 *
 * 通过通项公式X = i*(random(i)-1) + random(i)构造相同概率等比例放大的随机数生成器
 */
public class GenerateRandom {


    public static int dealRandom(Random random,int i){
        return i*(random.nextInt(i)-1) + random.nextInt(i);
    }

    public static void main(String[] args){

    }

}
