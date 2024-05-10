/* COMPSCI 424 Program 1
 * Name:
 */
package compsci424.p1.java;

/** 
 * Implements the process creation hierarchy for Version 2, which does
 * not use linked lists.
 * 
 * This is a template. Program1.java *must* contain the main class
 * for this program. Otherwise, feel free to edit these files, even
 * these pre-written comments or my provided code. You can add any
 * classes, methods, and data structures that you need to solve the
 * problem and display your solution in the correct format.
 */
public class Version2 {
    // Declare any class/instance variables that you need here.
	Version2PCB[] pcbArray;
	int n = 16; 

    /**
     * Default constructor. Use this to allocate (if needed) and
     * initialize the PCB array, create the PCB for process 0, and do
     * any other initialization that is needed. 
     */
    public Version2() {
    	pcbArray = new Version2PCB[n];
    	pcbArray[0] = new Version2PCB(-1);
    }
    
    /**
     * Creates a new child process of the process with ID parentPid. 
     * @param parentPid the PID of the new process's parent
     * @return 0 if successful, not 0 if unsuccessful
     */
    int create(int parentPid) {
    	int freePCB = -1;
    	if (pcbArray[parentPid] == null) {
    		return -1;
    	}
    	for (int i = 0; i < pcbArray.length; i++) {
            if (pcbArray[i] == null) {
                freePCB = i;
                break;
            }
        }
    	if (freePCB == -1) {
    		return 1; 
    	}
    	pcbArray[freePCB] = new Version2PCB(parentPid);
    	if(pcbArray[parentPid].firstChild == -1) {
    		pcbArray[parentPid].firstChild = freePCB;
    	}
    	else {
    		int child = pcbArray[parentPid].firstChild;
    		while (pcbArray[child].youngerSibling != -1) {
    			child = pcbArray[child].youngerSibling;
    		}
    		pcbArray[child].youngerSibling = freePCB;
    		pcbArray[freePCB].olderSibling = child;
    	}
        return 0; // often means "success" or "terminated normally"
    }

    /**
     * Recursively destroys the process with ID parentPid and all of
     * its descendant processes (child, grandchild, etc.).
     * @param targetPid the PID of the process to be destroyed
     * @return 0 if successful, not 0 if unsuccessful
     */
    int destroy (int targetPid) {
    	if (pcbArray[targetPid] == null) {
    		return -1;
    	}
    	if (pcbArray[targetPid].olderSibling != -1) {
    		pcbArray[pcbArray[targetPid].olderSibling].youngerSibling = -1;
    	}
    	if (pcbArray[targetPid].youngerSibling != -1) {
    		pcbArray[pcbArray[targetPid].youngerSibling].olderSibling = -1;
    	}
    	pcbArray[targetPid] = null;
    	
    	
    	
       return 0; // often means "success" or "terminated normally"
   }

   /**
    * Traverse the process creation hierarchy graph, printing
    * information about each process as you go. See Canvas for the
    * *required* output format. 
    *         
    * You can directly use "System.out.println" statements (or
    * similar) to send the required output to stdout, or you can
    * change the return type of this function to return the text to
    * the main program for printing. It's your choice. 
    */
   void showProcessInfo() {
	   for (int i = 0; i < pcbArray.length; i++) {
   		if (pcbArray[i] != null) {
   			System.out.print("Process " + i + ": parent is " + pcbArray[i].parent);
   			if (pcbArray[i].firstChild != -1) {
   				System.out.print(" and children are ");
   				System.out.print(pcbArray[i].firstChild + " ");
   				int children = pcbArray[pcbArray[i].firstChild].youngerSibling;
   				while (children != -1) {
   					System.out.print(children);
   					children = pcbArray[children].youngerSibling;
   				}
   				System.out.println(" ");
   			}
   			else {
   				System.out.println(" and children are empty");
   			}
   		}
   		
   	}
   	System.out.println(" ");
   }

}

