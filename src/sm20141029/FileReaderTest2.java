package sm20141029;

import java.io.*;

public class FileReaderTest2 {

	public static void main(String[] args) {
		String fileName = "D:/workspace/catalina.err";
				
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			
			String data = null;
			while((data=br.readLine()) != null) {
				System.out.println(data);
			}
			
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일의 경로 또는 이름이 잘못 되었습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
