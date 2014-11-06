package sm20141030;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RotateTest3 {

	public static void main(String[] args) {
		long prevSize = 0;					// 이전 파일 크기
		String data = null;					// 출력할 파일을 읽기 위한 변수
		Date time = new Date();				// 실행시간을 출력하기 위한 객체
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd, hh:mm:ss a"); // 시간의 출력 형식을 나타내는 객체
		
		String fileRoute = "D:/workspace/";	// 파일 경로
		String fileName = "target.err";		// 파일 이름
		
		while(true) {
			try {
				System.out.println("실행 시간: " + sdf.format(time).toString());	// 실행 시간 출력
				
				RandomAccessFile raf = new RandomAccessFile(fileRoute + fileName, "r");
	
				// 이전 파일의 크기와 새로 읽은 파일의 크기가 다르면
				// 새로운 부분을 출력하고 읽은 파일의 크기를 이전 파일의 크기에 입력 
				if(prevSize < raf.length()) {
					raf.seek(prevSize);
					
					while((data=raf.readLine()) != null) {
						data = new String(data.getBytes("ISO-8859-1"),"EUC-KR");
						System.out.println(data);
					}
					
					System.out.println();					// 빈 줄 삽입
					
					prevSize = raf.length();				// preSize에 현재 파일의 크기를 저장
					System.out.println("현재까지의 파일의 크기 : " + prevSize + "Byte");
				} else if (prevSize == raf.length()){
					System.out.println("추가된 부분이 없습니다.");
				} else {
					prevSize = raf.length();
					System.out.println("헉! 파일의 중간에 수정이 있습니다.");
				}
				
				raf.close();		// raf 연결을 닫음
				
				System.out.println("10초 후에 다시 실행합니다.");
				Thread.sleep(10*1000);	// 10초 대기
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}