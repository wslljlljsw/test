package test;

public class test13 {
	static node last;
	public static void main(String[] args) {
		
	}
	
	public void mid(node root) {
		if(root.left != null) {
			mid(root.left);
			connect(root.left);
		}
		connect(root);
		if(root.right != null) {
			mid(root.right);
			connect(root.right);
		}
	}
	
	public void connect(node next) {
		if(last == null) {
			last = next;
			return;
		}
		last.right = next;
		next.left = last;
		last = next;
	}
}

class node{
	int value;
	node left;
	node right;
}
