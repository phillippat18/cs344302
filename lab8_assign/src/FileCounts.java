import java.io.*;
import java.util.Scanner;

public class FileCounts {
    private File file;
    
    public FileCounts(File file) {
        this.file = file;
    }
 
    public int lineCount() throws FileNotFoundException {
    	Scanner scan = new Scanner(this.file);
    	int lineCount = 0;
    	while(scan.hasNextLine()){
    		lineCount++;
    		scan.nextLine();
    	}
    	scan.close();
        return lineCount;
    }
    
    public int tokenCount() throws FileNotFoundException {
    	Scanner scan = new Scanner(this.file);
    	int tokenCount = 0;
    	while(scan.hasNext()){
    		tokenCount++;
    		scan.next();
    	}
    	scan.close();
        return tokenCount;
    }
    
    public int charCount() throws IOException {
    	BufferedReader reader = new BufferedReader(new FileReader(this.file));
    	int characterCount = 0;
    	while(reader.read() != -1){
    		characterCount++;
    	}
    	reader.close();
        return characterCount;
    }
    
    public int byteCount() throws IOException {
    	BufferedInputStream input = new BufferedInputStream(new FileInputStream(this.file));
    	int numBytes = 0;	
    	while(input.read() != -1){
    		numBytes++;
    	}
    	input.close();
        return numBytes;
    }
}
