//容易导致操作系统假死
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
