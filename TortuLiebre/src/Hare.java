
public class Hare implements Runnable {

	private int counterLimit;
	private double randomSleep;
	private static Boolean isVerbose;
	private final String hareName;
	private static int sleepTime = 5000;
	private Boolean slept;
	private int position;

	public Hare(String name, int counter, Boolean verbose) {
		this.hareName = name;
		this.counterLimit = counter;
		this.isVerbose = verbose;
		this.randomSleep = Math.random();
		this.slept = false;
		this.position=0;
	}
	
	public int getPosition() {
		return this.position;
	}

	public void run() {
		double dice;
		for (; position < counterLimit; position++) {
			if (!slept) {
				dice = Math.random();

				if (dice > this.randomSleep) {
					try {
						if (isVerbose) {
							System.out.println(hareName + "[zzZZZZ]");
						}
						Thread.sleep(sleepTime);
						this.slept = true;
					} catch (InterruptedException e) {
						if (isVerbose) {
							System.out.println(hareName + "[zzZZZZ]");
						}
					}
				}
			}
			if (isVerbose) {
				System.out.println(hareName + "[" + position + "]");
			}
		}
	}
}
