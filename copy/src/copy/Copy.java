package copy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Copy {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        RandomAccessFile f1 = new RandomAccessFile(args[0], "rw");
        RandomAccessFile f2 = new RandomAccessFile(args[1], "rw");
        
        f2.seek(0);
        
        for (int i = 0; i < f1.length(); i++) {
            f2.write(f1.read());
            
        }
        
    }
    
}
