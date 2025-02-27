package com.turing.dsa.twothreefour;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.turing.dsa.two3fourtree.Node;
import com.turing.dsa.two3fourtree.TwoThreeFourTree;

public class TwoThreeFourTest {
	//@Test
	public void testInsertBaseCase()
	{
		TwoThreeFourTree tree = new TwoThreeFourTree();
		tree.insert(100);
		
		Node root =tree.getRoot();
		assertEquals(100,root.keys[0]);
		assertEquals(2,root.noOfNode);
	}
	//@Test
	public void testInsertSmallBaseCase()
	{
		TwoThreeFourTree tree = new TwoThreeFourTree();
		tree.insert(100);
		tree.insert(90);
		
		Node root =tree.getRoot();//[90,100]
		assertEquals(90,root.keys[0]);
		assertEquals(100,root.keys[1]);
		assertEquals(3,root.noOfNode);
	}
	//@Test
	public void testInsertLargeBaseCase()
	{
		TwoThreeFourTree tree = new TwoThreeFourTree();
		Node insertedNode = null;
		tree.insert(100);
		insertedNode = tree.insert(120);
		
		Node root =tree.getRoot();//[100,120]
		assertEquals(100,root.keys[0]);
		assertEquals(120,root.keys[1]);
		assertEquals(3,root.noOfNode);
	}
	//@Test
	public void testInsertSmallBaseCaseFourNode()
	{
		TwoThreeFourTree tree = new TwoThreeFourTree();
		tree.insert(100);
		tree.insert(150);
		Node insertedNode = tree.insert(120);
		
		//Node root =tree.getRoot();//[100,120,150]
		assertEquals(100,insertedNode.keys[0]);
		assertEquals(120,insertedNode.keys[1]);
		assertEquals(150,insertedNode.keys[2]);
		assertEquals(4,insertedNode.noOfNode);
	}
	
	
	//@Test
	public void testInsertSplitBaseCase()
	{
		TwoThreeFourTree tree = new TwoThreeFourTree();
		tree.insert(100);
		tree.insert(150);
		tree.insert(120);
		
		////[100,120,150]
		
		Node insertedNode = tree.insert(200);
		
		/*
		 * 		
		 * 			 [120]
		 * 		[100] [150,200]
		 * */
		Node parent = insertedNode.parent;
		assertEquals(120,parent.keys[0]);
		
		Node child0 = parent.children.get(0);
		assertEquals(100,child0.keys[0]);
		
		Node child1 = parent.children.get(1);
		assertEquals(150,child1.keys[0]);
		assertEquals(200,child1.keys[1]);
	
	}
	//@Test
	public void testInsertSplitBaseCaseAddChild1()
	{
		TwoThreeFourTree tree = new TwoThreeFourTree();
		tree.insert(100);
		tree.insert(150);
		tree.insert(120);
		tree.insert(200);
		
		/*
		 * 		
		 * 			 [120]
		 * 		[100] [150,200]
		 * */
		
		
		Node insertedNode = tree.insert(201);
		
		/*
		 * 		
		 * 			   [120]
		 * 		[100] [150,200,201]
		 * */
		
		
		Node parent = insertedNode.parent;
		assertEquals(120,parent.keys[0]);
		
		Node child0 = parent.children.get(0);
		assertEquals(100,child0.keys[0]);
		
		Node child1 = parent.children.get(1);
		assertEquals(150,child1.keys[0]);
		assertEquals(200,child1.keys[1]);
		assertEquals(201,child1.keys[2]);
	
	}
	//@Test
	public void testInsertSplitBaseCaseAddChild1Split()
	{
		TwoThreeFourTree tree = new TwoThreeFourTree();
		tree.insert(100);
		tree.insert(150);
		tree.insert(120);
		tree.insert(200);
		tree.insert(201);
		
		/*
		 * 		
		 * 			   [120]
		 * 		[100]    [150,200,201]
		 * */
		
		
		Node insertedNode = tree.insert(202);
		
		/*
		 * 		
		 * 			   [120,200]
		 * 		[100] [150] [201,202]
		 * */
		
		
		Node parent = insertedNode.parent;
		assertEquals(120,parent.keys[0]);
		assertEquals(200,parent.keys[1]);
		
		Node child0 = parent.children.get(0);
		assertEquals(100,child0.keys[0]);
		
		Node child1 = parent.children.get(1);
		assertEquals(150,child1.keys[0]);
		
		Node child2 = parent.children.get(2);
		assertEquals(201,child2.keys[0]);
		assertEquals(202,child2.keys[1]);
	
	}
	//@Test
	public void testInsertSplitBaseCaseAddChild1Split2()
	{
		TwoThreeFourTree tree = new TwoThreeFourTree();
		tree.insert(100);
		tree.insert(150);
		tree.insert(120);
		tree.insert(200);
		tree.insert(201);
		tree.insert(202);
		tree.insert(101);
		tree.insert(102);
		
	
		
		/*
		 * 		
		 * 			   [120,200]
		 * 		[100,101,102] [150] [201,202]
		 * */
		
		Node insertedNode = tree.insert(103);
		
		/*
		 * 		
		 * 			   [101,120,200]
		 * 		[100] [102,103] [150] [201,202]
		 * */
		
		Node parent = insertedNode.parent;
		assertEquals(101,parent.keys[0]);
		assertEquals(120,parent.keys[1]);
		assertEquals(200,parent.keys[2]);
		
		Node child0 = parent.children.get(0);
		assertEquals(100,child0.keys[0]);
		
		Node child1 = parent.children.get(1);
		assertEquals(102,child1.keys[0]);
		assertEquals(103,child1.keys[1]);
		
		Node child2 = parent.children.get(2);
		assertEquals(150,child2.keys[0]);
		
		Node child3 = parent.children.get(3);
		assertEquals(201,child3.keys[0]);
		assertEquals(202,child3.keys[1]);
	}
	@Test
	public void testInsertSplitDown()
	{
		TwoThreeFourTree tree = new TwoThreeFourTree();
		tree.insert(100);
		tree.insert(150);
		tree.insert(120);
		

		/*
		 * 			[100,120,150]->200
		 * 	
		 * 		
		 * */
		Node insertedNode = tree.insert(200);
		
	
		/*
		 * 				[120] -
		 			[101] [150,200]
		 * 		
		 * */
		
		Node parent = insertedNode.parent;
		assertEquals(120,parent.keys[0]);
	
	
		Node child0 = parent.children.get(0);
		assertEquals(100,child0.keys[0]);
		
		Node child1 = parent.children.get(1);
		assertEquals(150,child1.keys[0]);
		assertEquals(200,child1.keys[1]);
		
	
	}
	@Test
	public void testInsertSplitDownDepthUp2()
	{
		TwoThreeFourTree tree = new TwoThreeFourTree();
		tree.insert(100);
		tree.insert(150);
		tree.insert(120);
		
		tree.insert(200);
		tree.insert(201);
	
		/*
		 * 				[120] ->203
		 			[101] [150,200,201]
		 * 		
		 * */
		Node insertedNode = tree.insert(203);
		
		/*
		 * 				[120,200]
		 			[101] [150][201,203]
		 * 		
		 * */
		Node parent = insertedNode.parent;
		assertEquals(120,parent.keys[0]);
		assertEquals(200,parent.keys[1]);
	
	
		Node child0 = parent.children.get(0);
		assertEquals(100,child0.keys[0]);
		
		Node child1 = parent.children.get(1);
		assertEquals(150,child1.keys[0]);
		
		Node child2 = parent.children.get(2);
		assertEquals(201,child2.keys[0]);
		assertEquals(203,child2.keys[1]);
		
	
	}
	@Test
	public void testInsertSplitDownDepthUpTwo()
	{
		TwoThreeFourTree tree = new TwoThreeFourTree();
		tree.insert(100);
		tree.insert(150);
		tree.insert(120);
		
		tree.insert(200);
		tree.insert(201);
		tree.insert(203);
		tree.insert(204);
		
		/*
		 * 				[120,200]
		 			[100] [150][201,203,204]
		 * 		
		 * */
		
		Node insertedNode = tree.insert(205);
		
		/*
		 * 			
                                [200]
                        	[120]    [203]
		 			[100] [150]    [201] [204,205]
		 * 		
		 * */
		Node root = tree.getRoot();
		assertEquals(200,root.keys[0]);
		
		Node child0 = root.children.get(0);
		assertEquals(120,child0.keys[0]);
		
		Node child1 = root.children.get(1);
		assertEquals(203,child1.keys[0]);
		
		Node searchNode = tree.searchForInsert(206);
		System.out.println("Search Node "+searchNode);
		
		System.out.println("Children of child 0 "+child0 +" child size" +child0.children.size());
		System.out.println("Children of child 1 "+child1 +" child size "+ child1.children.size());
		
		
		Node level1Child0 = child0.children.get(0);
		assertEquals(100,level1Child0.keys[0]);
		
		Node level1Child1 = child0.children.get(1);
		assertEquals(150,level1Child1.keys[0]);
		
		Node level1Child10 = child1.children.get(0);
		assertEquals(201,level1Child10.keys[0]);
		
		Node level1Child11 = child1.children.get(1);
		assertEquals(204,level1Child11.keys[0]);
		assertEquals(205,level1Child11.keys[1]);
		
	}
}
