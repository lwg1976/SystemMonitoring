package sm20141029;

import java.io.*;

public class FileInputStreamTest2 {

	public static void main(String[] args) {
		String fileName = "D:/workspace/catalina.err";
		try {
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			int data = 0;
			while((data = bis.read()) != -1) {
				System.out.print((char)data);
			}
			
			bis.close();
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일의 경로 또는 이름이 잘못 되었습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
