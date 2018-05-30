
public class Turtle implements  Runnable {
	
	private int counterLimit;
	private long randomSleep;
	final private int slowness=1000;
	private static Boolean isVerbose;
	private final String turtleName;
	
	public Turtle(String name,int counter, Boolean verbose) {
		this.turtleName=name;
		this.counterLimit=counter;
		this.randomSleep= (long) (Math.random()*slowness);
		Turtle.isVerbose=verbose;
	}
	
	
	public void run() {
		for(int counter=0;counter<counterLimit;counter++) {
			try {
				Thread.sleep(randomSleep);
			} catch (InterruptedException e) {
				if(isVerbose) {
					System.out.println(turtleName+"[could not sleep]");
				}
			}
			if(isVerbose) {
				System.out.println(turtleName+"["+counter+"]");
			}
		}
		
	}
}