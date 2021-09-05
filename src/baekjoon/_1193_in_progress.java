package baekjoon;

//import java.util.Scanner;

class function1 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("i:" + i);
		}

	}
}

class function2 implements Runnable {
	@Override
	public void run() {
		for (int k = 0; k < 10; k++) {
			System.out.println("k:" + k);
		}

	}
}

public class _1193_in_progress {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int a = sc.nextInt();
		int arrj[] = new int[10000];
		int arrk[] = new int[10000];

		Thread f1 = new Thread(new function1());
		f1.start();
		Thread f2 = new Thread(new function2());
		f2.start();
//		for(int i=0 ; i<10; i++) {
//			for(int j=0 ; j < i ; j++) {
//				arrj[j]=j;
//				System.out.println("j: " + arrj[j]);
//			}
//			for(int k=10 ; i<k ; k--) {
//				arrk[k]=k;
//				System.out.println("k: " + arrk[k]);
//			}
//			
//		}

	}
}
