package XiaoZhao.JVM;

/**
 * Java中栈溢出
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args){
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try{
            javaVMStackSOF.stackLeak();
        }catch (Throwable e){
            System.out.println(javaVMStackSOF.stackLength);
            throw e;
        }
    }
}
