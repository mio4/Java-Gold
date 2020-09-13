今天朋友突然问到一个问题：

> 两个对象使用`x.equals(y)`判断结果为`true`时，两个对象的`hashCode`可以不同吗？

在Java编程中，判断两个对象是否相等常常使用`equals()`或是`==`，但是其中的区别和原理可能很多人并不完全清楚。今天就借着上面这个问题来看看`equals()`和`==`的区别和原理。

## 1. 数据类型与==的含义

Java中的数据类型分为基本数据类型和引用数据类型：

1. 基本类型：编程语言中内置的最小粒度的数据类型。它包括四大类八种类型
   - 4种整数类型：byte、short、int、long
   - 2种浮点数类型：float、double
   - 1种字符类型：char
   - 1种布尔类型：boolean
2. 引用类型：引用也叫句柄，引用类型，是编程语言中定义的在句柄中存放着实际内容所在地址的地址值的一种数据形式
   - 类
   - 接口
   - 数组

- 对于基本类型来说，`==` 比较的是它们的值
- 对于引用类型来说，`==` 比较的是它们在内存中存放的地址（堆内存地址）

例：

```
public void test(){
    int num1 = 100;
    int num2 = 100;

    String str1 = "James";
    String str2 = "James";

    String str3 = new String("James");
    String str4 = new String("James");

    System.out.println("num1 == num2 : " + (num1 == num2));
    System.out.println("str1 address : " + System.identityHashCode(str1) + ";\nstr2 address : " + System.identityHashCode(str1) + ";\nstr1 == str2 : " + (str1 == str2));
    System.out.println("str3 address : " + System.identityHashCode(str3) + ";\nstr4 address : " + System.identityHashCode(str4) + ";\nstr3 == str4 : " + (str3 == str4));
}
```

运行上面的代码，可以得到以下结果：

```
num1 == num2 : true

str1 address : 1174290147;
str2 address : 1174290147;
str1 == str2 : true

str3 address : 1289696681;
str4 address : 1285044316;
str3 == str4 : false
```

可以看到str1和str2的内存地址都是`1174290147`,所以使用`==`判断为`true`,但是str3和str4的地址是不同的，所以判断为`false`。

## 2. equals() 方法解析

在Java语言中，所有类都是继承于`Object`这个超类的，在这个类中也有一个`equals()`方法，那么我们先来看一下这个方法。

```
public boolean equals(Object obj) {
    return (this == obj);
}
```

可以看得出，这个方法很简单，就是比较对象的内存地址的。所以在对象没有重写这个方法时，默认使用此方法，即比较对象的内存地址值。但是类似于String、Integer等类均已重写了`equals()`。下面以`String`为例。

```
public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String anotherString = (String)anObject;
            int n = length();
            if (n == anotherString.length()) {
                int i = 0;
                while (n-- != 0) {
                    if (charAt(i) != anotherString.charAt(i))
                            return false;
                    i++;
                }
                return true;
            }
        }
        return false;
    }
```

很明显，String的equals()方法仅仅是对比它的 **数据值**，而不是对象的 **内存地址** 。

以 `String` 为例测试一下。

```
public void test() {

    String str1 = "James";
    String str2 = "James";

    String str3 = new String("James");
    String str4 = new String("James");

    System.out.println("str1 address : " + System.identityHashCode(str1) + ";\nstr2 address : " + System.identityHashCode(str1) + ";\nstr1.equals(str2) : " + str1.equals(str2));
    System.out.println("str3 address : " + System.identityHashCode(str3) + ";\nstr4 address : " + System.identityHashCode(str4) + ";\nstr3.equals(str4) : " + str3.equals(str4));
}
```

结果为：

```
str1 address : 1174290147;
str2 address : 1174290147;
str1.equals(str2) : true

str3 address : 1289696681;
str4 address : 1285044316;
str3.equals(str4) : true
```

可以发现不管对象的内存地址是否相同并不影响其结果，所以String类型比较的是 **数据值**, 而不是 **内存地址值**。

所以总结一下`equals()` 和 `==` 的区别：

1. `==`
   - 基本类型：对比它们的值是否相等
   - 引用类型：对比它们的内存地址是否相等
2. `equals()`
   - 基本类型：使用`==`进行比较
   - 引用类型：默认情况下，对比它们的地址是否相等；如果`equals()`方法被重写，则根据重写的要求来比较。

## 3. equals() 与 hashCode()

在详细的了解了`==`和`equals()`的作用和区别后，现在来研究一下之前的那个问题：

> 两个对象使用`x.equals(y)`判断结果为`true`时，两个对象的`hashCode`可以不同吗？

首先我们需要知道`hashCode`到底是什么？还是从`Object`这个超类来看一下。

```
public int hashCode() {
    return identityHashCode(this); // 此处返回对象的内存地址值
}
```

代码也很简单，看来默认情况下，`hashCode`就等于对象的 **内存地址值**（注：`System.identityHashCode(Object obj)`方法用于获取对象的内存地址，之前的样例代码中有使用）。和`equals()`方法一样重写之后，`hashCode()`方法方法也是可以被重写的，而且两者一般情况下都是成对出现。

简单测试一下String类型重写`hashCode()`方法之后有什么变化。

```
public void test() {
    String str1 = "James";
    System.out.println("str1 address : " + System.identityHashCode(str1) + "\nstr1 hashCode : " + str1.hashCode());
}
```

结果为：

```
str1 address : 1174290147
str1 hashCode : 71338276
```

很明显，hashCode 已经不是内存地址了。

那么总结一下：

- `equals()`：默认情况下比较的是对象的 **内存地址值**，被重写后按照重写要求进行比较，一般是比较对象的 **数据值**
- `hashCode()`: 默认情况下为对象的 **内存地址值**，被重写后按照重写要求生成新的值。

到此对于刚开始提出的问题应该很好解决了。对于这两个对象，只要我们重写`equals()`方法，就可以比较对象的 **数据值**，而不重写`hashCode()`方法，此时两个对象的 **hashCode** 就默认为内存地址值了，只要将两个对象指向不同的地址即可。

验证环节，先创建一个类：

```
public class CustomBean {
    private String name;
    private int age;

    public CustomBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomBean that = (CustomBean) o;
        return age == that.age &&
                Objects.equals(name, that.name);
    }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(name, age);
    // }
}
```

创建测试方法：

```
@Test
public void test() {
    CustomBean x = new CustomBean("James", 18);
    CustomBean y = new CustomBean("James", 18);

    System.out.println("x.hashCode: " + x.hashCode());
    System.out.println("x address : " + System.identityHashCode(x));
    System.out.println("y.hashCode: " + y.hashCode());
    System.out.println("x address : " + System.identityHashCode(y));

    System.out.println("x and y is equals : " + x.equals(y));
}
```

运行结果为：

```
x.hashCode: 1174290147
x address : 1174290147

y.hashCode: 1289696681
x address : 1289696681

x and y is equals : true
```

很明显，这就是问题中所描述的那种情况：两个对象使用`x.equals(y)`判断结果为`true`时，两个对象的`hashCode`不相同。

## 4. 总结

至此，`==`和`equals()`的区别及作用，`equals()`和`hashCode`的关系及使用已经了解清楚了。下面再总结一下：

对于`equals()` 和 `==` 的区别：

1. `==`
   - 基本类型：对比它们的值是否相等
   - 引用类型：对比它们的内存地址是否相等
2. `equals()`
   - 基本类型：使用`==`进行比较
   - 引用类型：默认情况下，对比它们的地址是否相等；如果`equals()`方法被重写，则根据重写的要求来比较

对于`equals()`和`hashCode()`的关系：

根据`Object`超类中的文档说明，`equals()`和`hashCode()`两个方法应该 **同进同退**。上面的例子只是举例说明存在那种情况，但那并不是一个很好的应用。

- 所以一定要记住`equals()`和`hashCode()`两个方法应该 **同进同退**。
- 所以一定要记住`equals()`和`hashCode()`两个方法应该 **同进同退**。
- 所以一定要记住`equals()`和`hashCode()`两个方法应该 **同进同退**。

重要的事情说三遍。





---

【https://blog.csdn.net/u010887744/article/details/50844525】





1、String常量池

  当使用new String（“hello”）时，JVM会先使用常量池来管理“hello”直接量，再调用String类的构造器来创建一个新的String对象，新创建的对象被保存在堆内存中。即new String（“hello”）一共产生了两个字符串对象。

【常量池constant pool】管理在编译时被确定并保存在已编译的.class文件中的一些数据，包括关于类、方法、接口中的常量，和字符串常量。 

【字符串常量池(String pool, String intern pool, String保留池)】 是Java堆内存中一个特殊的存储区域, 当创建一个String对象时,假如此字符串值已经存在于常量池中,则不会创建一个新的对象,而是引用已经存在的对象。

理解了下面这段代码就把常量池理解的七七八八了吧。

*public* *void* *test**()**{*

  *String a* *=**"*张三*"**;*

  *String b* *=**"*张*"**;*

  *String c* *=**"*三*"**;*

  *String d* *=* *b* *+* *c**;*

  *System**.**out**.**println**(**a* *==* *d**);**// false*

  *String e* *=**"*张*"**+**"*三*"**;*

  *System**.**out**.**println**(**a* *==* *e**);**// true*

*}*

  d=b+c：先执行StringBuilder的拼接，相当于new了一下，虽然值相等，但内存地址已变。

  当Java能直接使用字符串直接量（包括在编译时就计算出来的字符串值时，如String e = "张" + "三";），JVM就会使用常量池来管理这些字符串。

------



2、String为什么是不可变的？

***\*注：【以下内容来于网络，并结合自己的理解】\****

答案一：

最流行的Java面试题之一就是：什么是不可变对象(immutable object)，不可变对象有什么好处，在什么情况下应该用，或者更具体一些，Java的String类为什么要设成immutable类型？
不可变对象，顾名思义就是创建后不可以改变的对象，典型的例子就是Java中的String类。


String s = "ABC"; 
s.toLowerCase();


如上s.toLowerCase()并没有改变“ABC“的值，而是创建了一个新的String类“abc”，然后将新的实例的指向变量s。
相对于可变对象，不可变对象有很多优势：
    1).不可变对象可以提高String Pool的效率和安全性。如果你知道一个对象是不可变的，那么需要拷贝这个对象的内容时，就不用复制它的本身而只是复制它的地址，复制地址（通常一个指针的大小）需要很小的内存效率也很高。对于同时引用这个“ABC”的其他变量也不会造成影响。
    2).不可变对象对于多线程是安全的，因为在多线程同时进行的情况下，一个可变对象的值很可能被其他进程改变，这样会造成不可预期的结果，而使用不可变对象就可以避免这种情况。
当然也有其他方面原因，但是Java把String设成immutable最大的原因应该是效率和安全。


答案二：

​    这是一个老生常谈的话题(This is an old yet still popular question). 在Java中将String设计成不可变的是综合考虑到各种因素的结果,想要理解这个问题,需要综合内存,同步,数据结构以及安全等方面的考虑. 在下文中,我将为各种原因做一个小结。

\1. 字符串常量池的需要

​    字符串常量池(String pool, String intern pool, String保留池) 是Java堆内存中一个特殊的存储区域, 当创建一个String对象时,假如此字符串值已经存在于常量池中,则不会创建一个新的对象,而是引用已经存在的对象。
如下面的代码所示,将会在堆内存中只创建一个实际String对象.


String s1 = "abcd"; 
String s2 = "abcd"; 

示意图如下所示:

![img](https://img-blog.csdn.net/20160310104556492?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)
    假若字符串对象允许改变,那么将会导致各种逻辑错误,比如改变一个对象会影响到另一个独立对象. 严格来说，这种常量池的思想,是一种优化手段.

请思考: 假若代码如下所示，s1和s2还会指向同一个实际的String对象吗?

代码如下:

| *public* *class* *Test {*  *public* *static* *void* *main(String[]* *args**) {*    *String* *s1* *=* *"ab"* *+* *"cd"**;*    *String* *s2* *=* *"abc"* *+* *"d"**;*    *System.**out**.println(**"s1==s2:"* *+* *s1* *==* *s2**);*  *}**}* |
| ------------------------------------------------------------ |
| *// output：**false （注意和下面代码对比）*                  |

​    也许这个问题违反新手的直觉, 但是考虑到现代编译器会进行常规的优化, 所以他们都会指向常量池中的同一个对象. 或者,你可以用 jd-gui 之类的工具查看一下编译后的class文件.（自带javap -c 命令）

编译后文件如下：

| *public* *class* *Test* *{* *public* *Test**();* *Code**:*  *0**:* *aload_0*  *1**:* *invokespecial #**8* *//Method java/lang/Object."<init>":()V*  *4**:* *return** * *public* *static* *void* *main**(**java**.**lang**.**String**[]);* *Code**:*  *0**:* *ldc #**16* *//String abcd*  *2**:* *astore_1*  *3**:* *ldc #**16* *//String abcd*  *5**:* *astore_2*  *6**:* *getstatic #**18* *//Field java/lang/System.out:Ljava/io/PrintStream;*  *9**:* *new* *#**24* *//class java/lang/StringBuilder*  *12**:* *dup*  *13**:* *ldc #**26* *//String s1==s2:*  *15**:* *invokespecial #**28* *//Method java/lang/**StringBuilder**."<init>":(Ljava/lang/String;)V*  *18**:* *aload_1*  *19**:* *invokevirtual #**31* *//Method java/lang/StringBuilder.**append**:(Ljava/lang/String;)Ljava/lang/StringBuilder;*  *22**:* *invokevirtual #**35* *//Method java/lang/StringBuilder.**toString**:()Ljava/lang/String;*  *25**:* *aload_2*  *26**:* *if_acmpne*  *33*  *29**:* *iconst_1*  *30**:* *goto* *34*  *33**:* *iconst_0*  *34**:* *invokevirtual #**39* *//Method java/io/PrintStream.println:(Z)V*  *37**:* *return**}* | *public* *class* *Test* *{* *public* *Test**();*  *Code**:*    *0**:* *aload_0*    *1**:* *invokespecial #**8* *//Method java/lang/*          *// Object."<init>":()V*    *4**:* *return*  *public* *static* *void* *main**(**java**.**lang**.**String**[]);*  *Code**:*    *0**:* *ldc      #**16*  *// String abcd*    *2**:* *astore_1*    *3**:* *ldc      #**16*  *// String abcd*    *5**:* *astore_2*    *6**:* *getstatic   #**18*  *// Field java/lang/*       *// System.out:Ljava/io/PrintStream;*    *9**:* *aload_1*   *10**:* *aload_2*   *11**:* *if_acmpne*   *18*   *14**:* *iconst_1*   *15**:* *goto*     *19*   *18**:* *iconst_0*   *19**:* *invokevirtual #**24*  *//Method java/io/*             *// PrintStream.println:(Z)V*   *22**:* *return**}* // 字节码指令2 |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
|                                                              |                                                              |

  两个“abcd”都是#16，多定义了一个S0=“123”后发现两个“abcd”都是#30【这就是代表指向同一个对象？】

接下来高潮来了，上面的代码稍稍改一下：

| *public* *class* *Test {*  *public* *static* *void* *main(String[]* *args**) {*    *String* *s1* *=* *"ab"* *+* *"cd"**;*    *String* *s2* *=* *"abc"* *+* *"d"**;*    *System.**out**.println(**s1* *==* *s2**);*  *}**}* |
| ------------------------------------------------------------ |
| *// output：**true* *// 代码仅仅少了一个字符串而已*          |

  编译一下：见【字节码指令2】左边有底色的是前者比后者的多的字节码指令部分。

两者有什么区别呢？

​    最初还以为是在底层实现有区别，后经导师指点，仅仅是运算符优先级【+优先级高于==，详见笔记《运算符优先级表》】的区别，前者是先计算+号，执行拼接，再和后面的s2比较，肯定是false啊。当然可以把后面加个括号，输出就变为true了，而且是 "s1==s2:"true 。

理解了这个，再稍微改动一下;

| *String* *s1* *=* *"ab"**;**String* *s2* *=* *"abc"* *+* *"d"**;**System.**out**.println(**s1* *+* *"cd"* *==* *s2**);* |
| ------------------------------------------------------------ |
| 输出为：false 【只有false，没有前面"s1==s2:"这一串】// 先执行StringBuilder的拼接，相当于new了一下，虽然值相等，但内存地址已变。 |

但如果这样写：

| *String* *s1* *=* *"1234"**;**String* *s01* *=* *"123"**;**String* *s02* *=* *"4"**;**String* *s2* *=* *s01* *+* *s02**;**System.**out**.println(**s1* *==* *s2**);* |
| ------------------------------------------------------------ |
| false// s2取了*s01**、**s02的引用地址。肯定和s1不同了额。*   |

引：

​    hashCode()返回的是JVM中地址的哈希码，而不是JVM中的地址，要想得到str在物理内存中的真实地存，那只有用JNI技术调用c/c++去实现，否则无能为力，因为java超不出JVM，而JVM对物理内存地址是“不可见”的，否则java中不就有了指针，而去直接操作内存了，当然这是与java语言相违背的。这些只是我个人见解，说不定还真有高手直接用java语言得到了物理内存中的地址了呢。s1.getBytes()也不行。


\2. 允许String对象缓存HashCode

​    Java中String对象的哈希码被频繁地使用, 比如在hashMap 等容器中。

字符串不变性保证了hash码的唯一性,因此可以放心地进行缓存.这也是一种性能优化手段,意味着不必每次都去计算新的哈希码. 在String类的定义中有如下代码:


private int hash;//用来缓存HashCode 



---

### 1. String实例的初始化

`String`类型的初始化在Java中分为两类：

- 一类是通过双引号包裹一个字符来初始化；
- 另一类是通过关键字`new`像一个普通的对象那样初始化一个`String`实例。

前者在constant pool中开辟一个常量，并返回相应的引用，而后者是在heap中开辟一个常量，再返回相应的对象。所以，两者的reference肯定是不同的：



```java
public static void main(String... args) {
    String s1 = "abcd";
    String s2 = new String("abcd");
    System.out.println(s1 == s2);   // false
}
```

而constant pool中的常量是可以被共享用于节省内存开销和创建时间的开销（这也是引入constant pool的原因）。例如：



```java
public static void main(String... args) {
    String s1 = "abcd";
    String s2 = "abcd";
    System.out.println(s1 == s2);   // true
}
```

结合这两者，其实还可以回答另外一个常见的面试题目：



```java
public static void main(String... args) {
    String s = new String("abcd");
}
```

这句话创建了几个对象？

首先毫无疑问，`"abcd"`本身是一个对象，被放于常量池。而由于这里使用了`new`关键字，所以`s`得到的对象必然是被创建在heap里的。所以，这里其实一共创建了2个对象。

但tricky的部分是，如果在这个函数被调用前的别的地方，已经有了`"abcd"`这个字符串，那么它就事先在constant pool中被创建了出来。此时，这里就只会创建一个对象，即创建在heap的`new String("abcd")`对象。

但String的内存分配，远远没有这么简单。对于String的拼接，需要做更深入的理解和思考。

### 2. String的拼接

下面看一个问题：



```java
public static void main(String... args) {
    String s1 = "hell" + "o";
    String s2 = "h" + "ello";
    System.out.println(s1 == s2);   // true
    System.out.println(s1 == "hello");  // true
    System.out.println(s2 == "hello");  // true
    System.out.println("hello" == "hello"); // true
    
    // ------------------------
    
    String c1 = "ab";
    String c2 = c1 + "c";
    System.out.println(c2 == "abc");  // false
    
}
```

前面四个输出其实很容易理解，最终的结果，都指向了constant pool里的一个常量`"hello"`。但奇怪的是，最后一个输出也是`"abc"`，并且还都是用指向constant pool中常量的变量来做的拼接，但却得到了一个`false`的结果。

原因是，Java的`String`拼接有两个规则：

- 对于拼接的值，如果都是双引号包裹字符串的形式，则将结果放于constant pool，如果constant pool已经有这个值了，则直接返回这个已有值。
- **而如果拼接的值中，有一个是非双引号包裹字符串的形式，则从heap中开辟一个新的区域保存常量。也即是使用了String变量来做拼接的情况**。

在这样的大原则下，对声明为`final`的String变量需要做更多的考虑：

- 如果String变量被声明为`final`时就已经被赋值，则它被编译器自动处理为常量，因而它就会被当作常量池的变量来处理。



```java
public class ConstantPool {
    public static final String s1 = "ab";
    public static final String s2 = "cd";
    
    public static void main(String... args) {
        String s = s1 + s2;
        String ss = "abcd";
        
        System.out.println(s == ss);  // true
    }
}
```

- 而如果声明为`final`的字符串没有在声明时被赋值，则编译器无法事先决定它的准确值，所以依旧会把它当作一个变量来处理。



```java
public class ConstantPool {
    public static final String s1;
    public static final String s2;
    
    static {
        s1 = "ab";
        s2 = "cd";
    }
    
    public static void main(String... args) {
        String s = s1 + s2;
        String ss = "abcd";
        
        System.out.println(s == ss);  // false
    }
}
```

### 3. intern()方法

`String.intern()`方法，可以在runtime期间将常量加入到常量池（constant pool）。它的运作方式是：

1. 如果constant pool中存在一个常量恰好等于这个字符串的值，则`intern()`方法返回这个存在于constant pool中的常量的引用。
2. 如果constant pool不存在常量恰好等于这个字符串的值，则在constant pool中创建一个新的常量，并将这个字符串的值赋予这个新创建的在constant pool中的常量。`intern()`方法返回这个新创建的常量的引用。

示例：



```java
public static void main(String... args) {
    String s1 = "abcd";
    String s2 = new String("abcd");

    /**
     * s2.intern() will first search String constant pool,
     * of which the value is the same as s2.
     */
    String s3 = s2.intern();
    // As s1 comes from constant pool, and s3 is also comes from constant pool, they're same.
    System.out.println(s1 == s3);
    // As s2 comes from heap but s3 comes from constant pool, they're different.
    System.out.println(s2 == s3); 
}

/**
 * Output:
 *  true
 *  false
 */
```

回顾到最开始的第一部分，为什么要引入`intern()`这个函数呢？就是因为，虽然`"abcd"`是被分配在constant pool里的，但是，一旦使用`new String("abcd")`就会在heap中新创建一个值为`abcd`的对象出来。试想，如果有100个这样的语句，岂不是就要在heap里创建100个同样值的对象？！这就造成了运行的低效和空间的浪费。

于是，如果引入了`intern()`它就会直接去constant pool找寻是否有值相同的String对象，这就极大地节省了空间也提高了运行效率。



作者：kid551
链接：https://www.jianshu.com/p/875a3d2b5690
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



---

String是最常使用的Java类之一，整理的了一些重要的String知识分享给大家。

作为一个Java新手程序员，对String进行更深入的了解很有必要。如果你是有几年Java开发经验，可以根据目录选择性的阅读以下内容。

#### 1、什么是String，它是什么数据类型？

String是定义在 java.lang 包下的一个类。它不是基本数据类型。

String是不可变的，JVM使用字符串池来存储所有的字符串对象。

#### 2、创建String对象的不同方式有哪些？

- #### 和使用其他类一样通过new关键字来创建。

  使用这种方式时，JVM创建字符串对象但不存储于字符串池。我们可以调用intern()方法将该字符串对象存储在字符串池，如果字符串池已经有了同样值的字符串，则返回引用。

- #### 使用双引号直接创建。

```
使用这种方式时，JVM去字符串池找有没有值相等字符串，如果有，则返回找到的字符串引用。否则创建一个新的字符串对象并存储在字符串池。
String str = new String("abc");
String str1 = "abc";
```

#### 3、写一个方法来判断一个String是否是回文（顺读和倒读都一样的词）？

回文就是正反都一样的词，如果需要判断是否是回文，只需要比较正反是否相等即可。String类并没有提供反转方法供我们使用，但StringBuffer和StringBuilder有reverse方法。

```
private static boolean isPalindrome(String str) {
        if (str == null)
            return false;
        StringBuilder strBuilder = new StringBuilder(str);
        strBuilder.reverse();
        return strBuilder.toString().equals(str);
    }
```

假设面试官让你不使用任何其他类来实现的话，我们只需要首尾一一对比就知道是不是回文了。

```
private static boolean isPalindromeString(String str) {
        if (str == null)
            return false;
        int length = str.length();
        System.out.println(length / 2);
        for (int i = 0; i < length / 2; i++) {

            if (str.charAt(i) != str.charAt(length - i - 1))
                return false;
        }
        return true;
    }
```

#### 4、如何让一个字符串变成小写或大写形式？

使用toUpperCase 和 toLowerCase 方法让一个字符串变为 大写或小写。

#### 5、如何比较两个字符串？

String内部实现了Comparable接口，有两个比较方法：compareTo(String anotherString) 和compareToIgnoreCase(String str)。

- #### compareTo(String anotherString)

  与传入的anotherString字符串进行比较，如果小于传入的字符串返回负数，如果大于则返回证书。当两个字符串值相等时，返回0.此时eqauls方法会返回true。

- #### equalsIgnoreCase(String str)

  该方法与compareTo方法类似，区别只是内部利用了Character.toUpperCase等方法进行了大小写转换后进行比较。

#### 6、如何将String转换为char,反过来呢？

这是一个误导题，String是一系列字符，所有我们没法转换成一个单一的char，但可以调用toCharArray() 方法将字符串转成字符数组。

```
String str = "Java interview";
        
    //string to char array
    char[] chars = str.toCharArray();
    System.out.println(chars.length);
```

#### 7、如何将String转换为byte array,反过来呢？

使用String的getBytes()方法将String转成byte数组，使用String的构造方法 new String(byte[] arr) 将byte数据转为String。

```
public class StringToByteArray {

    public static void main(String[] args) {
        String str = "PANKAJ";
        byte[] byteArr = str.getBytes();
        // print the byte[] elements
        System.out.println("String to byte array: " + Arrays.toString(byteArr));
    }
}
public class ByteArrayToString {

    public static void main(String[] args) {
        byte[] byteArray = { 'P', 'A', 'N', 'K', 'A', 'J' };
        byte[] byteArray1 = { 80, 65, 78, 75, 65, 74 };

        String str = new String(byteArray);
        String str1 = new String(byteArray1);

        System.out.println(str);
        System.out.println(str1);
    }
}
```

<div id="question8"></div>

#### 8、浅谈一下String, StringBuffer，StringBuilder的区别？

String是不可变类，每当我们对String进行操作的时候，总是会创建新的字符串。操作String很耗资源,所以Java提供了两个工具类来操作String - StringBuffer和StringBuilder。

StringBuffer和StringBuilder是可变类，StringBuffer是线程安全的，StringBuilder则不是线程安全的。所以在多线程对同一个字符串操作的时候，我们应该选择用StringBuffer。由于不需要处理多线程的情况，StringBuilder的效率比StringBuffer高。

#### 9、String是不可变的有什么好处？

String是不可变类有以下几个优点

- 由于String是不可变类，所以在多线程中使用是安全的，我们不需要做任何其他同步操作。
- String是不可变的，它的值也不能被改变，所以用来存储数据密码很安全。
- 因为java字符串是不可变的，可以在java运行时节省大量java堆空间。因为不同的字符串变量可以引用池中的相同的字符串。如果字符串是可变得话，任何一个变量的值改变，就会反射到其他变量，那字符串池也就没有任何意义了。

#### 10、如何分割一个String？

- #### public String[] split(String regex):

  根据传入的正则字符串进行分割，注意，如果最后一位刚好有传入的字符，返回数组最后一位不会有空字符串。

```
String s = "abcaada";
System.out.println(Arrays.toString(s.split("a")));

//以上代码输出为  [, bc, , d].
```

- #### public String[] split(String regex, int limit):

  限制分割结果数组中有几个字符串。传入2,则结果分割后数组长度为2。

```
String s = "Y,Kunming,Yunnan";
String[] data = s.split(",", 2);
System.out.println("Name = "+data[0]); //Y
System.out.println("Address = "+data[1]); //Kunming,Yunnan
```

实际上第一个方法调用了第二个方法，只不过不限制返回的数组长度了。

```
public String[] split(String regex) {
    return split(regex, 0);
}
```

#### 11、如何判断两个String是否相等？

有两种方式判断字符串是否相等，使用"=="或者使用equals方法。当使用"=="操作符时，不仅比较字符串的值，还会比较引用的内存地址。大多数情况下，我们只需要判断值是否相等，此时用equals方法比较即可。

还有一个equalsIgnoreCase可以用来忽略大小写进行比较。

```
String s1 = "abc";
        String s2 = "abc";
        String s3= new String("abc");
        System.out.println("s1 == s2 ? "+(s1==s2)); //true
        System.out.println("s1 == s3 ? "+(s1==s3)); //false
        System.out.println("s1 equals s3 ? "+(s1.equals(s3))); //true
```

#### 12、什么是字符串池？

顾名思义，字符串常量池就是用来存储字符串的。它存在于Java 堆内存。

下图解释了字符串池在java堆空间如何存在以及当我们使用不同方式创建字符串时的情况。

![img](https://img1.tuicool.com/YRzeMvv.png!web)

以下是上图的一个编程例子

```
public class StringPool {

   
    public static void main(String[] args) {
        String s1 = "Cat";
        String s2 = "Cat";
        String s3 = new String("Cat");
        
        System.out.println("s1 == s2 :"+(s1==s2));
        System.out.println("s1 == s3 :"+(s1==s3));
    }

}
```

运行以上代码，输出如下：

```
s1 == s2 :true
s1 == s3 :false
```

一些java题中，可能会问一段代码中有几个字符串被创建，例如：

```
String str = new String("Cat");
```

上面一行代码将会创建1或2个字符串。如果在字符串常量池中已经有一个字符串“Cat”，那么就智慧创建一个“Cat”字符串。如果字符串常量池中没有“Cat”，那么首先会在字符串池中创建，然后才在堆内存中创建，这种情况就会创建2个对象了。

#### 13、String的intern()方法

当intern()方法被调用，如果字符串池中含有一个字符串和当前调用方法的字符串eqauls相等，那么就会返回池中的字符串。如果池中没有的话，则首先将当前字符串加入到池中，然后返回引用。

#### 14、String是线程安全的吗？

String是不可变类，一旦创建了String对象，我们就无法改变它的值。因此，它是线程安全的，可以安全地用于多线程环境中。

#### 15、为什么我们在使用HashMap的时候总是用String做key？

因为字符串是不可变的，当创建字符串时，它的它的hashcode被缓存下来，不需要再次计算。因为HashMap内部实现是通过key的hashcode来确定value的存储位置，所以相比于其他对象更快。这也是为什么我们平时都使用String作为HashMap对象。

#### 16、String编程题

#### 1、下面的代码输入什么

```
String s1 = new String("abc");
String s2 = new String("abc");
System.out.println(s1 == s2);
```

输入false

#### 2、下面的代码输入什么

```
String s1 = "abc";
StringBuffer s2 = new StringBuffer(s1);
System.out.println(s1.equals(s2));
```

输入false，因为s2不是String类型，String的equals方法进行了类型判断。

#### 3、下面的代码输入什么

```
String s1 = "abc";
String s2 = new String("abc");
s2.intern();
System.out.println(s1 ==s2);
```

输出false，intern()方法将返回从字符串池中的字符串对象的引用，但因为我们没有分配到S2，S2没有变化，如果该第三行代码为s2 =

s2.intern()，则输入true。

#### 4、下面的代码将创建几个字符串对象。

```
String s1 = new String("Hello");  
String s2 = new String("Hello");
```

答案是3个对象.

第一，行1 字符串池中的“hello”对象。

第二，行1，在堆内存中带有值“hello”的新字符串。

第三，行2，在堆内存中带有“hello”的新字符串。这里“hello”字符串池中的字符串被重用。





---

【https://blog.csdn.net/chaobin6/article/details/81214980】

***\*基础知识：\****

***\*1、==：既可以比较基本数据类型，又可以比较引用数据类型。基本数据类型比较的是值，引用数据类型比较的是地址。\****

***\*equals只能比较引用数据类型\*\*，\*\**\***如果没有重写Object类中的equals方法,equals方法和==号比较引用数据类型无区别  ,重写后的equals方法比较的是对象中的属性。

2.字符串常量存储在常量池，而new String 创建对象，在编译期间不能确定具体的值，所以会在 在在内存中创建的一个地址。 所以下面的第三题用等号比较的两个地址不同，但是属性是相同的，所以用equals比较的是属性值，所以相同。

 

 

 

***\*1.\*******\*判断定义为\*******\*String\*******\*类型的\*******\*s1\*******\*和\*******\*s2\*******\*是否相等\****

\* String s1 = "abc";

\* String s2 = "abc";

\* System.out.println(s1 == s2);         //true ，比较地址值，都在常量池，相等

\* System.out.println(s1.equals(s2));       //true，equals中，先判断两个对象的地址值，地址值相同，默认就是同一个对象，不会继续equalse中的具体值是否相等的判断了，直接会返回true。

 ***\*2.\*******\*下面这句话在内存中创建了几个对象\*******\*?\****

\* String s1 = new String("abc");            //两个对象 ：abc在常量池，有自己的地址。 new String 创建                      对象，在编译期间不能确定具体的值，所以会在 在在内存中创建的一个地址。

 

3.判断定义为String类型的s1和s2是否相等

\* String s1 = new String("abc");

\* String s2 = "abc";

\* System.out.println(s1 == s2); //false

\* System.out.println(s1.equals(s2));   //true

 

***\*4.\*******\*判断定义为\*******\*String\*******\*类型的\*******\*s1\*******\*和\*******\*s2\*******\*是否相等\****

\* String s1 = "a" + "b" + "c";

\* String s2 = "abc";

\* System.out.println(s1 == s2);      //true     地址值相同，都是常量，在常量池里面     

\* System.out.println(s1.equals(s2));         //true     地址值相同，默认同一个对象，值当然也是相等的。

 

***\*5.\*******\*判断定义为\*******\*String\*******\*类型的\*******\*s1\*******\*和\*******\*s2\*******\*是否相等\****

\* String s1 = "ab";

\* String s2 = "abc";

\* String s3 = s1 + "c";

\* System.out.println(s3 == s2);        //false  不相等，s1是变量，编译的时候确定不了值，在内存中会创建值，s3在堆内存中，。s2在常量池，所以不相等。

\* System.out.println(s3.equals(s2));    //true  比较两个对象的值相等。

 

解释：这就关系到底层的运行图了

\* String s1 = "abc";

String s2 = "abc";

s1会在常量池中创建，s2先查看常量池中有没有，如果有的话就指向它，如果没有就在常量池中创建一个然后指向它。所以s1和s2的两种比较是相同的。

\* String s2 = "abc";![img](https://img-blog.csdn.net/20180726101602686?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NoYW9iaW42/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![img](https://img-blog.csdn.net/20180726101455781?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NoYW9iaW42/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

 













