package other;

import java.util.BitSet;

public class bitSet {

    public static void main(String[] args){
        BitSet bitSet = new BitSet();
        int[] arr = {1,2,3,4,5,6,7,8,9,10,1};
        for(int i=0;i < arr.length; i++){
            if(bitSet.get(arr[i])){
                System.out.println(arr[i]);
                break;
            }
            else
                bitSet.set(arr[i]);
        }
    }
}
