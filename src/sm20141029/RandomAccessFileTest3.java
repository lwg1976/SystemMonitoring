package sm20141029;

import java.io.*;

public class RandomAccessFileTest3 {

	public static void main(String[] args) {
		int seekSize = 100; // 읽어들일 사이즈
		String fileName = "D:/workspace/catalina.err"; // 파일 경로 및 이름
		
		try {
			RandomAccessFile raf = new RandomAccessFile(fileName, "r");

			byte[] data = null;
			String str = null;
			
			long size = (raf.length()/seekSize) + (raf.length()%seekSize == 0 ? 0 : 1);
			for(int i=0; i<size; i++) {
				data = new byte[seekSize];
				
				raf.seek(i*seekSize);
				raf.read(data);
				str = new String(data);
				str = new String(str.getBytes("ISO-8859-1"),"EUC-KR");
				System.out.println(str);
			}
						
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