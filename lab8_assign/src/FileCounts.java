import java.io.*;
import java.util.Scanner;

/** Provides statistical information about a supplied file.
 * @author Haley, K.
 * */
public class FileCounts {
	/** File to be used in calculations.
	 * */
    private File file;
    
    /** Takes a {@link File} and stores it in the class for later processing
     * when the individual methods are called.
     * @param file The file to be examined.
     * */
    public FileCounts(File file) {
        this.file = file;
    }
 
    /** Returns the number of lines in the file. Uses the {@link Scanner}
     * class to iterate on a per line basis and increment a counter.
     * @return Number of lines in the target file.
     * */
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
    
    /** Returns the number of tokens in the file, which is separated by
     * whitespace character (space, tab or newline). Uses the {@link Scanner}
     * class to iterate on a per token basis and increment a counter.
     * @return Returns the number of tokens (words) separted by whitespace in
     * the target file.
     * */
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
    
    /** Returns the number of characters in the target file. Uses the
     * {@link BufferedReader} to read one character at a time from the file
     * and increment a counter.
     * @return Number of characters in the target file.
     * */
    public int charCount() throws IOException {
    	BufferedReader reader = new BufferedReader(new FileReader(this.file));
    	int characterCount = 0;
    	while(reader.read() != -1){
    		characterCount++;
    	}
    	reader.close();
        return characterCount;
    }
    
    /** Returns the number of bytes in the target file. Uses the
     * {@link BufferedInputStream} to iterate over the file on a byte by byte
     * basis and increment a counter.
     * @return Returns the number of bytes in the target file.
     * */
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
