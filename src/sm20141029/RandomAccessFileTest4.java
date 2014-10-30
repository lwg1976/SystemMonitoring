package sm20141029;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest4 {

	public static void main(String[] args) {
		int readSize = 100; // 읽어들일 사이즈
		String fileName = "D:/workspace/catalina.err"; // 파일 경로 및 이름
		
		try {
			RandomAccessFile raf = new RandomAccessFile(fileName, "r");

			raf.seek(100);
			
			byte[] data = new byte[readSize];
			raf.read(data, 0, readSize);
					
			String str = new String(data);
			str = new String(str.getBytes("ISO-8859-1"),"EUC-KR");
			System.out.println(str);
									
			raf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}