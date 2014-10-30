package sm20141029;

import java.io.*;

public class RandomAccessFileTest2 {

	public static void main(String[] args) {
		String fileName = "D:/workspace/catalina.err";
		
		try {
			RandomAccessFile raf = new RandomAccessFile(fileName, "r");

			
			String data = null;
			while((data=raf.readLine()) != null) {
				data = new String(data.getBytes("ISO-8859-1"),"EUC-KR");
				System.out.println(data);
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