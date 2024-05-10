/* COMPSCI 424 Program 1
 * Name:
 */
package compsci424.p1.java;

import java.util.LinkedList;


public class Version1 {
    // Declare any class/instance variables that you need here.
	Version1PCB[] pcbArray;
	int n = 16; 


    public Version1() {
    	pcbArray = new Version1PCB[n];
    	pcbArray[0] = new Version1PCB(-1);
    }
    
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
    		return 1; //Not successful. pcbArray is full
    	}
    	pcbArray[freePCB] = new Version1PCB(parentPid);
    	pcbArray[freePCB].children = new LinkedList<>();
    	pcbArray[parentPid].children.add(freePCB);

        return 0; // often means "success" or "terminated normally"
    }

    int destroy (int targetPid) {
    	if (pcbArray[targetPid] == null) {
    		return -1;
    	}
    	for (int child : pcbArray[targetPid].children) {
    		destroy(child);
    	}
    	int parent = pcbArray[targetPid].parent;
    	pcbArray[parent].children.remove((Integer)targetPid);
    	pcbArray[targetPid] = null;
    	
        return 0; // often means "success" or "terminated normally"
    }
    
    void showProcessInfo() {
    	for (int i = 0; i < pcbArray.length; i++) {
    		if (pcbArray[i] != null) {
    			System.out.print("Process " + i + ": parent is " + pcbArray[i].parent);
    			if (pcbArray[i].children != null && !pcbArray[i].children.isEmpty()) {
    				System.out.print(" and children are ");
    				for (int child : pcbArray[i].children) {
    					System.out.print(child + " ");
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
