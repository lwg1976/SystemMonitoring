package sm20141109;

import java.io.RandomAccessFile;

public class searchMain {

	public static void main(String[] args) {
		LogReader logReader = new LogReader(); 
		RandomAccessFile raf = null;
		
		// 로그 파일을 읽어서  raf에 저장
		raf = logReader.readFile();
		
		// 로그 파일을 줄단위로 읽어서 error 문구가 있으면 출력
		logReader.errorSearch(raf);

	}
}