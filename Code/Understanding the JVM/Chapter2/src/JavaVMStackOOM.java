//���׵��²���ϵͳ����
public class JavaVMStackOOM {
	private void donStop(){
		while(true){
			
		}
	}
	
	public void stackLeakByThread(){
		while(true){
			Thread thread = new Thread(new Runnable(){
				@Override
				public void run(){
					donStop();
				}
			});
			thread.start();
		}
	}
	public static void main(String[] args){
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
