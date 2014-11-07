package sm20141106;

import java.io.RandomAccessFile;

public class SearchTest1 {

	public static void main(String[] args) {
		LogReader1 logReader = new LogReader1(); 
		RandomAccessFile raf = null;
		
		while(true) {
			raf = logReader.readFile();
			
			logReader.errorSearch(raf);
			
			try {
				System.out.println("10초 후에 다시 실행합니다.");
				Thread.sleep(10*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	// 10초 대기
		}
	}
}