/* COMPSCI 424 Program 1
 * Name:
 * 
 * This is a template. Program1.java *must* contain the main class
 * for this program. Otherwise, feel free to edit these files, even
 * these pre-written comments or my provided code. You can add any
 * classes, methods, and data structures that you need to solve the
 * problem and display your solution in the correct format.
 */
package compsci424.p1.java;

import java.util.Scanner;

/**
 * Main class for this program. The required steps have been copied
 * into the main method as comments. Feel free to add more comments to
 * help you understand your code, or for any other reason. Also feel
 * free to edit this comment to be more helpful for you.
 */
public class Program1 {
    // Declare any class/instance variables that you need here.

    /**
     * @param args command-line arguments, which can be ignored
     */
    public static void main(String[] args) {
    	Scanner typeCommand = new Scanner(System.in);
    	int commandCount = 0;
    	int commandList[] = new int[200]; //First has create (0) or destroy (1). 
    	int commandListValues[] = new int[200]; //Second has the N
    	while(true) {
    		int N = 0;
    		System.out.println("\nWhat is your command? (N = Integer between 0 and 15)" + "\n1. create N" + "\n2. destroy N" + "\n3. end");
    		String command = typeCommand.nextLine();
    		String c[] = command.split(" ");
    		if (c[0].equals("end")) {
    			break;
    		}
    		else if (c[0].equals("create")) {
    			N = Integer.parseInt(c[1]);
    			commandList[commandCount] = 0;
    			commandListValues[commandCount] = N;
    			commandCount++;
    		}
    		else if (c[0].equals("destroy")) {
    			N = Integer.parseInt(c[1]);
    			commandList[commandCount] = 1;
    			commandListValues[commandCount] = N;
    			commandCount++;
    		}
    		else {
    			break;
    		}
    		
    	}
    	typeCommand.close();
    	
    	Version1 version1 = new Version1();
    	for (int i = 0; i < commandCount; i++) {
    		if (commandList[i] == 0) {
    			version1.create(commandListValues[i]);
    			version1.showProcessInfo();
    		}
    		else if (commandList[i] == 1) {
    			version1.destroy(commandListValues[i]);
    			version1.showProcessInfo();
    		}
    		else {
    			break; //value other than 0 or 1 got into commandList
    		}
    	}
    	
    	Version2 version2 = new Version2();
    	for (int i = 0; i < commandCount; i++) {
    		if (commandList[i] == 0) {
    			version2.create(commandListValues[i]);
    			version2.showProcessInfo();
    		}
    		else if (commandList[i] == 1) {
    			version2.destroy(commandListValues[i]);
    			version2.showProcessInfo();
    		}
    		else {
    			break; //value other than 0 or 1 got into commandList
    		}
    	}
    	
    	long startTime1 = System.nanoTime();
    	Version1 version1Time = new Version1();
    	for (int i = 0; i < 200; i++) {
        	for (int j = 0; j < commandCount; j++) {
        		if (commandList[j] == 0) {
        			version1Time.create(commandListValues[j]);
        			//version1Time.showProcessInfo();
        			//You can add back the showProcessInfo() and the program will still work
        			//Since it fills up the console, I just have it commented out
        		}
        		else if (commandList[j] == 1) {
        			version1Time.destroy(commandListValues[j]);
        			//version1Time.showProcessInfo();
        		}
        		else {
        			break;
        		}
        	}
    		
    	}
    	long endTime1 = System.nanoTime();
    	long timeTotal1 = endTime1 - startTime1;
    	System.out.println("Version1 ran for: " + timeTotal1);
    	
    	long startTime2 = System.nanoTime();
    	Version2 version2Time = new Version2();
    	for (int i = 0; i < 200; i++) {
        	for (int j = 0; j < commandCount; j++) {
        		if (commandList[j] == 0) {
        			version2Time.create(commandListValues[j]);
        			//version2Time.showProcessInfo();
        		}
        		else if (commandList[j] == 1) {
        			version2Time.destroy(commandListValues[j]);
        			//version2Time.showProcessInfo();
        		}
        		else {
        			break; //value other than 0 or 1 got into commandList
        		}
        	}	
    	}
    	long endTime2 = System.nanoTime();
    	long timeTotal2 = endTime2 - startTime2;
    	System.out.println("Version2 ran for: " + timeTotal2);
    	
        System.out.println("Builds without errors and runs to completion.");
    }
}
