/* COMPSCI 424 Program 1
 * Name:
 */
package compsci424.p1.java;


public class Version2PCB {
	int parent;
	int firstChild;
	int youngerSibling;
	int olderSibling;
	
	public Version2PCB(int parent) {
		this.parent = parent;
		this.firstChild = -1;
		this.youngerSibling = -1;
		this.olderSibling = -1;
	}
	
	public int getParent(){
		return parent;
	}
	public void setParent(int parent) {
        this.parent = parent;
    }
	public int getFirstChild(){
		return firstChild;
	}
	
	public int getYoungerSibling(){
		return youngerSibling;
	}
	
	public int getOlderSibling(){
		return olderSibling;
	}
	  
}
