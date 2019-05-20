/*
 * Name: Christine Johnson
 * Date: 5/19/19
 * Program Overview: This program creates a binary search tree. It allows for
 * basic functions such as delete, insert, and find. It also prints the
 * In order, Pre order, and Post order traversals to the screen.
 * Notes: Used code from the Goodrich Data Structures and Algorithms book
 */

package prg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PRG1 {

	//private Node root;
	
	public static class Node{
		Node parent;
		Node leftChild;
		Node rightChild;
		int value;
		
		public Node(Node parent, Node leftChild, Node rightChild, int value) {
			this.parent = parent;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
			this.value = value;
		}
	}
	
	/*public void delete(Node root, int num) {
		Node del = find(root, num);
		root.parent = null;
		if(del.leftChild == null && del.rightChild == null) {
			del = null;
		}
		else if(del.leftChild != null && del.rightChild!= null) {
			del = null;
		}
		else if(del.leftChild != null && del.rightChild == null) {
			del = del.leftChild;
		}
		else {
			del = del.rightChild;
		}
	}*/
	
	public static void printTree(Node root) {
		System.out.println(root.value);
		if(root.leftChild!=null) {
			System.out.print(root.leftChild.value +  "  ");
			if(root.rightChild!=null) {
				System.out.println(root.rightChild.value);
			}
			System.out.println();
			if(root.leftChild.leftChild!=null) {
				printTree(root.leftChild);
			}
		}
		else if(root.rightChild!=null){
			System.out.println(root.rightChild.value);
			printTree(root.rightChild);
		}
	}
	
	public boolean find(Node root, int num) {
		if (root.value == num) {
			return true;
		}
		else if (root.value > num) {
			if(root.leftChild!=null) {
				return find(root.leftChild, num);
			}
			else {
				return false;
			}
		}
		else if(root.value < num){
			if(root.rightChild!=null) {
				return find(root.rightChild, num);
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public static void insert2(Node x, int num) {
		if (x.value == num) {
			new Node(null,null,null,num);
		}
		else if (x.value > num) {
			if (x.leftChild != null) {
				insert2(x.leftChild, num);
			}
			x.leftChild = new Node(x,null,null,num);
		}
		else {
			if (x.rightChild != null) {
				insert2(x.rightChild, num);
			}
			x.rightChild = new Node(x,null,null,num);
		}
	}
	
	public static void inOrder(Node root) {
		//InOrder traversal
		if(root!=null) {
			inOrder(root.leftChild);
			System.out.print(root.value+",");
			inOrder(root.rightChild);
		}
	}
	
	public static void preOrder(Node root) {
		//PreOrder traversal
		if(root!=null) {
			System.out.print(root.value+",");
			preOrder(root.leftChild);
			preOrder(root.rightChild);
		}
	}
	
	public static void postOrder(Node root) {
		//PostOrder traversal
		if(root!=null) {
			postOrder(root.leftChild);
			postOrder(root.rightChild);
			System.out.print(root.value+",");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new Node(null,null,null,1);
		try{
			Scanner sc = new Scanner(new File("input.txt"));
			String line = sc.next();
			String[] values = line.split(",");
			
			for (int j=0; j<values.length;j++) {
				if (j==0) {
					root = new Node(null,null,null,Integer.parseInt(values[j]));
					insert2(root, Integer.parseInt(values[j]));
					printTree(root);
					System.out.println();
				}
				else {
					insert2(root, Integer.parseInt(values[j]));
					printTree(root);
					System.out.println();
				}
			}
			sc.close();
		}catch(FileNotFoundException exc) {
			System.out.println("File not found");
		}
		
		System.out.println("InOrder");
		inOrder(root);
		System.out.println();
		System.out.println("PreOrder");
		preOrder(root);
		System.out.println();
		System.out.println("PostOrder");
		postOrder(root);
		
	}

}
