import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.*;
import java.lang.*;
/**
 * JUnit Tests for Chapter 17
 */

public class Chapter17Test {

	/**
	 * Reset the base data structures just in case
	 */
	@BeforeEach 
	void reset(){
		return;
	}
	
	/**
	 * An empty JUnit test case
	 */
	@Test 
	public void testExample(){		
		assertTrue(true);
	}
	/**
	 * Test cases for isFull 
	 */
	@Test 
	public void full() {
		BinarySearchTree tree = new BinarySearchTree();
		assertTrue(tree.isFull());
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		assertFalse(tree.isFull());
	}
	/**
	 * Test cases for equals
	 */
	@Test 
	public void equal() {
		BinarySearchTree tree1 = new BinarySearchTree();
		BinarySearchTree tree2 = new BinarySearchTree();
		assertTrue(tree1.equals(tree2));
		tree1.add(1);
		tree1.add(2);
		tree2.add(1);
		tree2.add(2);
		assertTrue(tree1.equals(tree2));
		tree2.add(3);
		assertFalse(tree1.equals(tree2));
	}
	/**
	 * Test cases for removeLeaves
	 */
	@Test 
	public void remleave() {
		BinarySearchTree tree3 = new BinarySearchTree();
		BinarySearchTree tree4 = new BinarySearchTree();
		tree3.removeLeaves();
		assertTrue(tree3.equals(tree4));
		tree3.add(2);
		tree3.removeLeaves();
		assertTrue(tree3.equals(tree4));
		tree3.add(3);
		tree3.add(4);
		tree3.add(5);
		assertFalse(tree3.equals(tree4));
	}
	/**
	 * Test cases for trim
	 */
	@Test 
	public void trimming() {
		BinarySearchTree tree5 = new BinarySearchTree();
		BinarySearchTree tree6 = new BinarySearchTree();
		assertTrue(tree5.equals(tree6));
		tree5.add(1);
		assertFalse(tree5.equals(tree6));
		tree5.add(2);
		tree5.add(3);
		tree5.add(4);
		tree5.add(5);
		tree5.add(6);
		tree5.add(7);
		tree5.contains(1);
		tree5.contains(2);
		tree5.contains(3);
		tree5.contains(4);
		tree5.contains(5);
		tree5.contains(6);
		tree5.contains(7);
		tree5.trim(3, 6);
		tree6.add(3);
		tree6.add(4);
		tree6.add(5);
		tree6.add(6);
		assertTrue(tree5.equals(tree6));
	}
}
