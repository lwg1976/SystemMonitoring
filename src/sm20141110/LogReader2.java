package sm20141110;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogReader2 {
	Date time = new Date();				// 실행시간을 출력하기 위한 객체
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd, hh:mm:ss a"); // 시간의 출력 형식을 나타내는 객체
	FileSize2 fs = new FileSize2();
	Long prevSize = 0L;
	int readSize = 4096;
		
	RandomAccessFile readFile() {
		String fileRoute = "D:/workspace/";	// 파일 경로
		String fileName = "target.err";		// 파일 이름
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(fileRoute + fileName, "r");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일이 존재하지 않습니다.");
			e.printStackTrace();
		}
		return raf;
	}
	
	Long errorSearch(RandomAccessFile raf) {
		try {
			System.out.println("실행 시간: " + sdf.format(time).toString());	// 실행 시간 출력
			byte[] data = null;
			prevSize = fs.sizeRead();
			
			// 이전 파일의 크기와 새로 읽은 파일의 크기가 다르면
			// 새로운 부분을 출력하고 읽은 파일의 크기를 이전 파일의 크기에 입력 
			if(prevSize < raf.length()) {
				raf.seek(prevSize);
				
				// for 문 돌릴 횟수
				long size = ((raf.length()-prevSize)/readSize) + (raf.length()%readSize == 0 ? 0 : 1);
				
				for(int i=0; i<size; i++) {
					data = new byte[readSize];				// data 배열 초기화
					
					raf.seek(prevSize + i*readSize);		// 출력할 데이터의 첫 지점으로 커서 이동
					raf.read(data,0,readSize);				// data 배열에 출력할 데이터를 저장
					System.out.println(new String(data));	// 데이터 출력
				}
				
				System.out.println();					// 빈 줄 삽입
				System.out.println("현재까지의 파일의 크기 : " + raf.length() + "Byte");
			} else {
				System.out.println("추가된 부분이 없습니다.");
			}
			
			// 파일의 크기를 D:/workspace/filesize.txt에 저장
//			fs.sizeSave(raf.length());
			
			raf.close();		// raf 연결을 닫음
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prevSize;
	}
}
