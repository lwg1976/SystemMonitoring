package sm20141029;

import java.io.*;

public class RandomAccessFileTest1 {

	public static void main(String[] args) {
		String fileName = "D:/workspace/catalina.err";
		
		try {
			RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

			System.out.println("파일 포인터의 위치 : " + raf.getFilePointer());
			
			raf.writeInt(100);
			
			System.out.println("파일 포인터의 위치 : " + raf.getFilePointer());
			
			raf.writeLong(100L);
			
			System.out.println("파일 포인터의 위치 : " + raf.getFilePointer());
			
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
