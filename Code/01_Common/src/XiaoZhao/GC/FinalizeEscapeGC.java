package XiaoZhao.GC;

/**
 * 演示一次垃圾回收的整个过程
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yse, i am still alive");
    }

    @Override
    protected void finalize() throws Throwable{ //finalize函数是在垃圾回收之前被隐式调用
        super.finalize();
        System.out.println("finalized method executed");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次拯救自己
        SAVE_HOOK = null;
        System.gc(); //调用垃圾回收函数

        //finalize优先级比较低，等待一段时间
        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }
        else{
            System.out.println("no i am dead");
        }

        //完全相同的代码
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }
        else{
            System.out.println("no i am dead");
        }
    }
}
