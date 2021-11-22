Compiled from "BadLockOnInteger.java"
public class testBadLockOnInteger.BadLockOnInteger extends java.lang.Thread {
  public static java.lang.Integer i;

  static testBadLockOnInteger.BadLockOnInteger instance;

  public testBadLockOnInteger.BadLockOnInteger();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Thread."<init>":()V
       4: return

  public void run();
    Code:
       0: iconst_0
       1: istore_1
       2: iload_1
       3: ldc           #2                  // int 100000
       5: if_icmpge     55
       8: getstatic     #3                  // Field i:Ljava/lang/Integer;
      11: dup
      12: astore_2
      13: monitorenter
      14: getstatic     #3                  // Field i:Ljava/lang/Integer;
      17: astore_3
      18: getstatic     #3                  // Field i:Ljava/lang/Integer;
      21: invokevirtual #4                  // Method java/lang/Integer.intValue:()I
      24: iconst_1
      25: iadd
      26: invokestatic  #5                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
      29: dup
      30: putstatic     #3                  // Field i:Ljava/lang/Integer;
      33: astore        4
      35: aload_3
      36: pop
      37: aload_2
      38: monitorexit
      39: goto          49
      42: astore        5
      44: aload_2
      45: monitorexit
      46: aload         5
      48: athrow
      49: iinc          1, 1
      52: goto          2
      55: return
    Exception table:
       from    to  target type
          14    39    42   any
          42    46    42   any

  public static void main(java.lang.String[]) throws java.lang.InterruptedException;
    Code:
       0: new           #6                  // class java/lang/Thread
       3: dup
       4: getstatic     #7                  // Field instance:LtestBadLockOnInteger/BadLockOnInteger;
       7: invokespecial #8                  // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;)V
      10: astore_1
      11: new           #6                  // class java/lang/Thread
      14: dup
      15: getstatic     #7                  // Field instance:LtestBadLockOnInteger/BadLockOnInteger;
      18: invokespecial #8                  // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;)V
      21: astore_2
      22: aload_1
      23: invokevirtual #9                  // Method java/lang/Thread.start:()V
      26: aload_2
      27: invokevirtual #9                  // Method java/lang/Thread.start:()V
      30: aload_1
      31: invokevirtual #10                 // Method java/lang/Thread.join:()V
      34: aload_2
      35: invokevirtual #10                 // Method java/lang/Thread.join:()V
      38: getstatic     #11                 // Field java/lang/System.out:Ljava/io/PrintStream;
      41: getstatic     #3                  // Field i:Ljava/lang/Integer;
      44: invokevirtual #12                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      47: return

  static {};
    Code:
       0: iconst_0
       1: invokestatic  #5                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
       4: putstatic     #3                  // Field i:Ljava/lang/Integer;
       7: new           #13                 // class testBadLockOnInteger/BadLockOnInteger
      10: dup
      11: invokespecial #14                 // Method "<init>":()V
      14: putstatic     #7                  // Field instance:LtestBadLockOnInteger/BadLockOnInteger;
      17: return
}
