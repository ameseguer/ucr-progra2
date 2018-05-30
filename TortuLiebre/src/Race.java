import java.util.ArrayList;
import org.apache.commons.cli.*;

/*
 * javac -cp ".:commons-cli-1.4.jar" ../src/Race.java 
 * java -cp ".:commons-cli-1.4.jar" Race -t 3 -h 3 -q
 */

public class Race {
	
	static int highPosition;
	
	public static void main(String[] args) {
		int tCount=10;
		int tLimit=10;
		int hCount=3;
		Boolean verbose=true;
		/*
		 * READ arg from CLI
		 */
		
		Options options = new Options();

        Option optionTurtles = new Option("t", "turtles", true, "How many turtles at race");
        optionTurtles.setRequired(false);
        options.addOption(optionTurtles);

        Option optionsHares = new Option("h", "hares", true, "How many hares a trace");
        optionsHares.setRequired(false);
        options.addOption(optionsHares);
        
        Option optionCounter = new Option("l", "laps", true, "How many laps in a race");
        optionCounter.setRequired(false);
        options.addOption(optionCounter);
        
        Option optionVerbose = new Option("q", "quiet", false, "How many laps in a race");
        optionVerbose.setRequired(false);
        options.addOption(optionVerbose);
        
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;
        
        try {
            cmd = parser.parse(options, args);
            if(cmd.hasOption("turtles")) {
            	tCount=new Integer(cmd.getOptionValue("turtles"));
            }
            if(cmd.hasOption("laps")) {
            	tLimit=new Integer(cmd.getOptionValue("laps"));
            }
    		if(cmd.hasOption("hares")) {
    			hCount=new Integer(cmd.getOptionValue("hares"));	
    		}	
    		verbose=!cmd.hasOption("q");
    		
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("Hares vs Turtles...the race", options);

            System.exit(1);
            return;
        }
        
        
        /*
         * END of CLI
         */
		
		ArrayList<Hare>  hares = new ArrayList<Hare>(hCount);

		
		for(int counter=0;counter<hCount;counter++) {
			new Thread(new Hare("H"+new Integer(counter).toString(), tLimit, verbose)).start();
		}
		for(int counter=0;counter<tCount;counter++) {
			new Thread(new Turtle("T"+new Integer(counter).toString(), tLimit, verbose)).start();
		}
		
	}

}
