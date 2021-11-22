package XiaoZhao.JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * Java中堆溢出
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args){
        List<OOMObject> list = new ArrayList<OOMObject>();

        while(true){
            list.add(new OOMObject());
        }
    }
}
