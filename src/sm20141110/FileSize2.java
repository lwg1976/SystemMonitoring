package sm20141110;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileSize2 {
	FileReader fr = null;
	BufferedReader br = null;
	FileWriter fw = null;
	BufferedWriter bw = null;
	
	String fileRoute = "D:/workspace/";	// 파일 경로
	String fileName = "filesize.txt";	// 파일 이름
	
	Long prevSize = 0L;
	
	Long sizeRead() {
		try {
			fr = new FileReader(fileRoute + fileName);
			br = new BufferedReader(fr);
				
			String readSize = br.readLine();
			if(!(readSize.equals(null))) {
				prevSize = Long.parseLong(readSize);
			}
			
			br.close();
			fr.close();
		} catch (NullPointerException e) {
			prevSize = 0L;
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prevSize;
	}
	
	Boolean sizeSave(long prevSize) {
		try {
			fw = new FileWriter(fileRoute + fileName);
			bw = new BufferedWriter(fw);
			
			System.out.println("prevSize : " + prevSize);
			bw.write(Long.toString(prevSize));
			
			bw.close();
			fw.close();
		} catch(IOException e) {
			System.out.println(e.toString());
		}
		return true;
	}
}
