import java.util.*;
/**
 * Binary Search Tree
 */
public class BinarySearchTree{
	private TreeNode root;
	
	/**
	 * Constructor
	 */
	public BinarySearchTree(){
		root = null;
	}
	
	/**
	 * Searches the BST for the given value.
	 * 
	 * @param value the value to find
	 * @return true if the value exists in the BST
	 */
	public boolean contains(int value){
		return contains(value, root);
	}
	
	private boolean contains(int value, TreeNode node){
		if(node == null){
			return false;
		}
		if(value == node.getData()){
			return true;
		}
		if(value < node.getData()){
			return contains(value, node.getRight());
		}
		return contains(value, node.getLeft());
	}
	
	/**
	 * Adds a new value to the BST.
	 * 
	 * @param value The new value to be added to the BST.
	 */
	public void add(int value){
		root = add(value, root);
	}
	
	private TreeNode add(int value, TreeNode temp){
		if(temp == null){
			temp = new TreeNode(value);
		}
		else if(value <= temp.getData()){
			temp.setLeft(add(value, temp.getLeft()));
		}else{
			temp.setRight(add(value, temp.getRight()));
		}
		return temp;
	}
	/**
	 * Removes the given value from the BST.
	 * 
	 * @param value The value to remove
	 * @throws NoSuchElementException if the root is null.
	 */
	public void remove(int value){
		if(root == null){
			throw new NoSuchElementException();
		}
		root = remove(value, root);
	}
	private TreeNode remove(int value, TreeNode temp){
		if(temp == null){
			return temp;
		}
		if(value < temp.getData()){
			temp.setLeft(remove(value, temp.getLeft()));
		}else if(value > temp.getData()){
			temp.setRight(remove(value, temp.getRight()));
		}else{
			if(temp.getLeft()==null&& temp.getRight()==null){
				return null;
			}
			if(temp.getLeft()!=null && temp.getRight()==null){
				return temp.getLeft();
			}
			if(temp.getLeft()==null && temp.getRight()!=null){
				return temp.getRight();
			}
			temp.setData(temp.getLeft().getData());
			temp.setLeft(remove(temp.getData(), temp.getLeft()));
		}
		return temp;
	}
	
	/**
	 * Prints the BST to the terminal horizontally. 
	 */
	public void printBST(){
		printBST(root, "");
	}
	
	private void printBST(TreeNode temp, String padding){
		if(temp == null){
			return;
		}
		printBST(temp.getRight(), padding+ "   ");
		System.out.println(padding + temp.getData());
		printBST(temp.getLeft(), padding+ "   ");
	}
	/**
	 * We have a private helper method. The public method does not take in a param
     * Our helper method takes in a parameter called newnode. Then we check to see
     * if our newnode is null, if it is we return null. If the left and right subtrees 
     * are null, then we return true. If they are not null, then we recursivly go 
     * through them. Else, we return false.
	 */
	public boolean isFull(){
		return isFull(root);
	}
	private boolean isFull(TreeNode newnode){ 
        if(newnode == null){
        return true; 
	    } if(newnode.getLeft() == null && newnode.getRight() == null ){
            return true; 
		} if((newnode.getLeft()!=null) && (newnode.getRight()!=null)){
            return (isFull(newnode.getLeft()) && isFull(newnode.getRight()));
		} else {
        return false; 
		}
    } 
    /**
     * We have a private helper method. The public method takes in a
     * @param tree2 that that is passed into our helper method. 
     * First we check to see if both of the trees are empty, 
     * then we check if one is and the other isn't.
     * Then we recursivley check both the left and right subtrees. 
     */
	public boolean equals(BinarySearchTree tree2){
		return equals(root, tree2.root);
	}
	private boolean equals(TreeNode node1, TreeNode node2) { 
		if (node1 == null && node2 == null){ 
			return true; 
		} if (node1 != null &&  node2 == null){
			return false; 
		} if (node1 == null && node2 != null){ 
			return false; 
		} else {  
		return equals(node1.getLeft(), node2.getLeft()) && equals(node1.getRight(), node2.getRight()); 
		} 
	}
    /**
     * We have a private helper method. The public method does not take in a param
     * Our helper method takes in a parameter called newnode. First we check to see if 
     * it is null, if it is then we return null. Then we check to see if the left and right are
     * null. If they are, then we return null. Else, we recursivly delete from the left, then right. 
     */
    public void removeLeaves() {
		root = removeLeaves(root);
	}
	public TreeNode removeLeaves(TreeNode newnode) {
		if (newnode == null){ 
			return null;
		}if (newnode.getLeft() == null && newnode.getRight() == null) {
				return null;
		}else{
			newnode.setLeft(removeLeaves(newnode.getLeft()));
			newnode.setRight(removeLeaves(newnode.getRight()));
			return newnode;
		}
	}
    /**
     * We have a private helper method. The public method takes in two
     * @param min and
     * @param max that that is passed into our helper method. First we 
     * check to see if newnode is null, if it is then we return null.
     * Then we check to see if node is less than our min. If it is then we recursivly go to the right side.
     * We do the same thing with the left, except we check if the max is greater than the the node. 
     * Then we set the left and the right equal to the next left and right. Finally, we return the node. 
     */
	public void trim(int min, int max) {
		root = trim(root, min, max);
	}
	private TreeNode trim(TreeNode newnode, int min, int max) {
		if (newnode == null){
			return null;		
	   }if (newnode.getData() < min){ 
			return trim(newnode.getRight(), min, max);
       }if (newnode.getData() > max){
			return trim(newnode.getLeft(), min, max);
	   }else{
		newnode.setRight(trim(newnode.getRight(), min, max));
		newnode.setLeft(trim(newnode.getLeft(), min, max));
		return newnode;
		}
	}
}

