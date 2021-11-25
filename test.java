public class test{
	private TreeNode root;
	
	/**
	 * Constructor
	 */
	public test(){
		root = null;
	}
	public static void main(String[] args) { 
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(5);
		bst.add(6);
		bst.add(4);
		bst.add(3);
		System.out.println(bst);
		bst.removeLeaves();
		System.out.println(bst);
      
	}
}
