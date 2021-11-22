package URLMap;
//做不出来，暂时放在这里...
//https://blog.csdn.net/zjj582984208/article/details/55223871
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int p_num = sc.nextInt();
		int site_num = sc.nextInt();
		Pattern[] patterns = new Pattern[p_num];
		String[] sites = new String[site_num];
		for(int i=0; i < p_num; i++){
			String t1 = sc.next();
			String t2 = sc.next();
			patterns[i] = new Pattern(t1,t2);
		}
		for(int i=0; i < site_num; i++){
			sites[i] = sc.nextLine();
		}
		//字符串处理
		for(int i=0;i < site_num;i++){
			String[] site_strs = sites[i].split("/");
			//对每一个匹配进行对比
			for(int j=0; j < p_num; j++){
				for(int k=1; k < site_strs.length; k++){
					if(patterns[j].flags[k] == 3 && patterns[j].strs[k].equals(site_strs[k]))
						;
					else if(patterns[j].flags[k] == 3 && !patterns[j].strs[k].equals(site_strs[k]))
						break;
					else if(patterns[j].flags[k] == 1 && isNumber(site_strs[k]))
						;
					else if(patterns[j].flags[k] == 1 && !isNumber(site_strs[k]))
						break;
					else if(patterns[j].flags[k] == 2)
						;

				}
			}
		}
	}

	public static boolean isNumber(String str){
		for(int i=0; i < str.length(); i++){
			if(!Character.isDigit(str.charAt(i)))
				return false;
		}
		return true;
	}

}
class Pattern{
	public String[] strs;
	public int[] flags;
	public String rule;

	public Pattern(String t1, String t2){
		this.strs = t1.split("/");
		this.rule = t2;

		for(int i=1;i < strs.length; i++){
			if(strs[i].equals("<int>"))
				flags[i] = 1; //int
			else if (strs[i].equals("<path>"))
				flags[i] = 2; //path
			else
				flags[i] = 3; //str
		}
	}
}
