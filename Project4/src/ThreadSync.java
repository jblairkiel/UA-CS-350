import java.lang.Thread;
import java.util.concurrent.*;

public class ThreadSync 
{
	//Start with 4 symbol permits so that after two digits are run and two letters are run that 4 symbol
	//permits are released to start another loop
	private static Semaphore semSym = new Semaphore(4);
	private static Semaphore semDig = new Semaphore(0);
	private static Semaphore semLet = new Semaphore(0);
    private static boolean runFlag = true;

    public static void main( String[] args ) {
     	Runnable[] tasks = new Runnable[17];
    	Thread[] threads = new Thread[17];
    	// create 10 digit threads
    	for (int d=0; d<10; d++) {
    		tasks[d] = new PrintDigit((char)('0'+d));
    		threads[d] = new Thread( tasks[d] );
    		threads[d].start();
    	}
    	// create 6 letter threads
    	for (int d=0; d<6; d++) {
    		tasks[d+10] = new PrintLetter((char)('A'+d));
    		threads[d+10] = new Thread( tasks[d+10] );
    		threads[d+10].start();
    	}
       	// create a thread to print dash(-)
		tasks[16] = new PrintSymbol('*');
		threads[16] = new Thread( tasks[16] );
		threads[16].start();

		// Let the threads to run for a period of time
        try {
        	Thread.sleep(50);
        }
        catch (InterruptedException ex) {
        	ex.printStackTrace();
        }
        
        runFlag = false;
        // Interrupt the threads
        for (int i=0; i<17; i++) threads[i].interrupt();
    }
    
    public static class PrintDigit implements Runnable 
    {
    	private char c;
    	public PrintDigit(char c) { this.c=c; }
        public void run(){
    	    while (runFlag) {
    	    	try {
					semDig.acquire();
				} catch (InterruptedException e) {
					//e.printStackTrace();
				}
       	        System.out.printf( "%c\n", c);
       	        semLet.release(2);
       	        //semLet.release();
       	        semSym.release();
       	        
    	    }
        }
    }
    public static class PrintLetter implements Runnable 
    {
    	private char c;
    	public PrintLetter(char c) { this.c=c; }
        public void run(){
    	    while (runFlag) {
    	    	try {
    	    		
					semLet.acquire(2);
				} catch (InterruptedException e) {
					//e.printStackTrace();
				}
    	        System.out.printf( "%c\n", c);
    	        semSym.release();
    	        
    	    }
         }
    }
    public static class PrintSymbol implements Runnable 
    {
    	private char c;
    	public PrintSymbol(char c) { this.c=c; }
        public void run(){
    	    while (runFlag) {
    	    	try {
					semSym.acquire(4);
				} catch (InterruptedException e) {
					//e.printStackTrace();
				}
    	        System.out.printf( "%c\n", c);
    	        semDig.release(2);
    	        
    	    }
        }
    }
}
