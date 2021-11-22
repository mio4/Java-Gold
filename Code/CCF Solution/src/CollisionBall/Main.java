package CollisionBall;

//首先是将球这个模型封装成类，两个public属性便于访问和改变值
//然后是对运动过程的分析，遍历所有的小球，模拟时间运行，每次都是先运动再判断是否相撞
//最后按照格式分类输出结果

//第一次Bug：Integer属性比较相同应该使用equals方法而不是==
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int L = sc.nextInt();
		int t = sc.nextInt();
		int time = 0;
		Ball[] balls = new Ball[n];
		for(int i=0; i < n; i++){
			int pos = sc.nextInt();
			balls[i] = new Ball(pos,1);
		}
		while(time++ < t){
			//要发生碰撞，一定会先有移动
			//碰撞只是因为移动之后位置相同产生的结果，但是都会先有移动
			for(int i=0; i < n; i++){
				//移动
					if(balls[i].direction == 1) {
						balls[i].position++;
						if (balls[i].position == L)
							balls[i].direction *= -1;
					} else {
						balls[i].position--;
						if(balls[i].position == 0)
							balls[i].direction *= -1;
					}
				}
			//判断是否发生碰撞
			for(int i=0; i < n-1;i++)
				for(int j=i+1; j < n;j++){
					if(balls[i].position.equals(balls[j].position)){
						balls[i].direction *= -1;
						balls[j].direction *= -1;
						break;
					}
			}
		}
		//输出结果
		for(int i=0; i < n; i++){
			if(i == n-1)
				System.out.print(balls[i].position);
			else
				System.out.print(balls[i].position + " ");
		}

	}
}

class Ball {
	public Integer position; //小球的位置
	public Integer direction; //小球运动的方向
	public Ball(int position, int direction){
		this.position = position;
		this.direction = direction;
	}
}
