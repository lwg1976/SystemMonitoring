package sm20141106;

import java.io.IOException;
import java.io.RandomAccessFile;

public class readTest {
    public static void main(String[] args)
    {
        try
        {
            // Create a new random access file.
            RandomAccessFile raf = new RandomAccessFile(
                "D:/workspace/test.txt", "rw");

            // Write out a byte array from position 0 to 6.
            String s = "another byte array";
            byte[] arr2 = s.getBytes();
            raf.write(arr2, 0, 7);

            // Reposition the file pointer to position 0.
            raf.seek(0);

            // Read in the next byte array.
            System.out.println("arr2.length : " + arr2.length);
            byte[] newArr2 = new byte[arr2.length];
            raf.read(newArr2, 9, 9);
            System.out.println("byte[]: "+ new String(newArr2));

            // Close the file.
            raf.close();
        }
        catch (IOException ex)
        {
            System.out.println(ex.toString());
        }
    }
}