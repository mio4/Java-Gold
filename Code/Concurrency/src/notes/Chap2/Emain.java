package notes.Chap2;

/**
 * StringBuffer不是immutable类
 */
public class Emain {

    public static void main(String[] args){
        UserInfo userInfo = new UserInfo("Alice","Alaska");
        System.out.println("userInfo " + userInfo);
        //change the value
        StringBuffer sb = userInfo.getInfo();
        sb.replace(11,19,"Jack");
        System.out.println("userInfo " + userInfo);
    }
}

final class UserInfo{
    private final StringBuffer info;

    public UserInfo(String name, String address){
        this.info = new StringBuffer("<info name = \"" + name + "\"," + "\"" + address + "\""  + " >");
    }

    public StringBuffer getInfo(){
        return this.info;
    }

    public String toString(){
        return "[ UserInfo:" + info + " ]";
    }
}
