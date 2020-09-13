# Java面试炼金系列 (1)  | 关于String类的常见面试题剖析

# 0x0 基础知识

## 1. '==' 运算符

Java中的数据类型分为基本数据类型和引用数据类型：

1. 基本类型：编程语言中内置的最小粒度的数据类型。它包括四大类八种类型
   - 4种整数类型：`byte`、`short`、`int`、`long`
   - 2种浮点数类型：`float`、`double`
   - 1种字符类型：`char`
   - 1种布尔类型：`boolean`
2. 引用类型：引用也叫句柄，引用类型，是编程语言中定义的在句柄中存放着实际内容所在地址的地址值的一种数据形式，例如：
   - 类
   - 接口
   - 数组

- 对于基本类型来说，`==` 比较的是它们的值
- 对于引用类型来说，`==` 比较的是它们在内存中存放的地址（堆内存地址）

举例说明：

```java
    public static void main(String[] args) {
        //基本数据类型
        int num1 = 100;
        int num2 = 100;
        System.out.println("num1 == num2 : " + (num1 == num2) + "\n");

        //引用类型，其中'System.identityHashCode'可以理解为打印对象地址
        String str1 = "mio4";
        String str2 = "mio4";
        System.out.println("str1 address : " + System.identityHashCode(str1));
        System.out.println("str2 address : " + System.identityHashCode(str1));
        System.out.println("str1 == str2 : " + (str1 == str2) + "\n");

        String str3 = new String("mio4");
        String str4 = new String("mio4");
        System.out.println("str3 address : " + System.identityHashCode(str3));
        System.out.println("str4 address : " + System.identityHashCode(str4));
        System.out.println("str3 == str4 : " + (str3 == str4));
    }
```

运行上面的代码，可以得到以下结果：

```shell
num1 == num2 : true

str1 address : 1639705018
str2 address : 1639705018
str1 == str2 : true

str3 address : 1627674070
str4 address : 1360875712
str3 == str4 : false
```

可以看到str1和str2的内存地址都是`1639705018`,所以使用`==`判断为`true`,

但是str3和str4的地址是不同的，所以判断为`false`。



## 2. equals()方法

### 2.1 Object类equals()

在Java语言中，所有类都是继承于`Object`这个超类的，在这个类中也有一个`equals()`方法，那么我们先来看一下这个方法。

![image-20200909213450555](D:\python-spider\000-01\001\image-20200909213450555.png)

![image-20200909213432756](D:\python-spider\000-01\001\image-20200909213432756.png)

​	

可以看得出，这个方法很简单，就是比较对象的内存地址的。所以在对象没有重写这个方法时，默认使用此方法，即比较对象的内存地址值。但是类似于String、Integer等类均已重写了`equals()`。下面以`String`为例。

### 2.2 String类equals()

![image-20200909213550726](D:\python-spider\000-01\001\image-20200909213550726.png)!

很明显，String的equals()方法仅仅是对比它的 **数据值**，而不是对象的 **内存地址** 。

以 `String` 为例测试一下：

```java
public static void main(String[] args) {
        String str1 = "mio4";
        String str2 = "mio4";

        String str3 = new String("mio4");
        String str4 = new String("mio4");

        System.out.println("str1 address : " + System.identityHashCode(str1));
        System.out.println("str2 address : " + System.identityHashCode(str1));
        System.out.println("str1.equals(str2) : " + str1.equals(str2) + "\n");

        System.out.println("str3 address : " + System.identityHashCode(str3));
        System.out.println("str4 address : " + System.identityHashCode(str4));
        System.out.println("str3.equals(str4) : " + str3.equals(str4) + "\n");
    }
```

测试输出为如下，可以看出`str3`和`str4`地址不同，但是因为String字符串内容相同，所以equals判断为true

```shell
str1 address : 1639705018
str2 address : 1639705018
str1.equals(str2) : true

str3 address : 1627674070
str4 address : 1360875712
str3.equals(str4) : true
```



## 3. hashCode()方法

### 3.1 为啥有这个方法？使用场景

Java中的集合（Collection）有三类，一类是List，一类是Queue，集合内的元素是有序的，元素可以重复；再有一类就是Set，一个集合内的元素无序，但元素不可重复。

- 那么, 这里就有一个比较严重的问题：要想保证元素不重复，可两个元素是否重复应该依据什么来判断呢？ 这就是 **Object.equals** 方法了。但是，如果每增加一个元素就检查一次，那么当元素很多时，后添加到集合中的元素比较的次数就非常多了。 也就是说，如果集合中现在已经有1000个元素，那么第1001个元素加入集合时，它就要调用1000次equals方法。这显然会大大降低效率。于是，Java采用了**哈希表的原理**。 这样，我们对每个要存入集合的元素使用哈希算法算出一个值，然后根据该值计算出元素应该在数组的位置。所以，当集合要添加新的元素时，可分为两个步骤：　　　
  - **先调用这个元素的 hashCode 方法，然后根据所得到的值计算出元素应该在数组的位置。如果这个位置上没有元素，那么直接将它存储在这个位置上；**
  - **如果这个位置上已经有元素了，那么调用它的equals方法与新元素进行比较：相同的话就不存了，否则，将其存在这个位置对应的链表中（Java 中 HashSet, HashMap 和 Hashtable的实现总将元素放到链表的表头）。**

### 3.2 hashCode()和equals()关联

　**前提：** 谈到hashCode就不得不说equals方法，二者均是Object类里的方法。由于Object类是所有类的基类，所以一切类里都可以重写这两个方法。

- **原则 1 ：** 如果 x.equals(y) 返回 “true”，那么 x 和 y 的 hashCode() 必须相等 ；
- **原则 2 ：** 如果 x.equals(y) 返回 “false”，那么 x 和 y 的 hashCode() 有可能相等，也有可能不等 ；
- **原则 3 ：** 如果 x 和 y 的 hashCode() 不相等，那么 x.equals(y) 一定返回 “false” ；
- **原则 4 ：** **一般来讲，equals 这个方法是给用户调用的，而 hashcode 方法一般用户不会去调用 ；**
- **原则 5 ：** **当一个对象类型作为集合对象的元素时，那么这个对象应该拥有自己的equals()和hashCode()设计，而且要遵守前面所说的几个原则。**

总结来说，需要注意的是：

- equals相等的两个对象，hashCode一定相等
- equals方法不相等的两个对象，hashCode有可能相等





# 0x1 高频面试题

## 1. 看过String源码吗？为啥用final修饰？



```java
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence {}
```





## 2. 



## 3. 







> 文章中所有源代码已被收录到：https://github.com/mio4/Java-Gold

















### 参考|引用

https://blog.csdn.net/justloveyou_/article/details/52464440