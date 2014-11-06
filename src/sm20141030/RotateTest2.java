package sm20141030;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RotateTest2 {

	public static void main(String[] args) {
		int readSize = 1024;				// 버퍼에서 한 번에 읽어들일 사이즈
		long prevSize = 0;					// 이전 파일 크기
		String str = "";					// data 배열의 내용을 String로 변경하기 위한 변수
		byte[] data;
		try {
			data = str.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}					// 출력할 부분을 읽어들일 byte 배열
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
				if(prevSize != raf.length()) {
					raf.seek(prevSize);
					
					// for 문 돌릴 횟수
					long size = ((raf.length()-prevSize)/readSize) + (raf.length()%readSize == 0 ? 0 : 1);
					
					for(int i=0; i<size; i++) {
						data = new byte[readSize];			// data 배열 초기화
						
						raf.seek(prevSize + i*readSize);	// 출력할 데이터의 첫 지점으로 커서 이동
						raf.read(data);						// data 배열에 출력할 데이터를 저장
						System.out.println(new String(data));			// 데이터 출력
//						str = new String(data);				// 데이터의 문자셋을 변경하기 위하여 data 배열의 데이터를 String 형으로 만듦
//						str = new String(str.getBytes("ISO-8859-1"),"EUC-KR");	// 데이터의 문자셋을 EUC-KR로 변경
//						System.out.println(str);			// 데이터 출력
					}
					
					prevSize = raf.length();				// preSize에 현재 파일의 크기를 저장
					System.out.println("현재까지의 파일의 크기 : " + prevSize + "Byte");
				} else {
					System.out.println("추가된 부분이 없습니다.");
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