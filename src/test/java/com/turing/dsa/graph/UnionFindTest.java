package com.turing.dsa.graph;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
public class UnionFindTest {
	/*
	 *  A-C =1
		B-F =2
		D-E =2
		C-F =3

	 * */
	
	@Test
	public void testFind()
	{
		UnionFind unionFind =new UnionFind();
		
		unionFind.addVertice("A");
		unionFind.addVertice("B");
		unionFind.addVertice("C");
		unionFind.addVertice("D");
		unionFind.addVertice("E");
		unionFind.addVertice("F");
		
		
		unionFind.addEdge("A","C",1);
		unionFind.addEdge("B","F",2);
		unionFind.addEdge("D","E",2);
		unionFind.addEdge("C","F",3);
		
		List<ArrayList<String>> disjointSet = unionFind.getDisjointSet();
		assertEquals(2,disjointSet.size());
		
		//[A,B,C,F]
		List<String> set0 = disjointSet.get(0);
		for(String vertice: set0)
		{
			System.out.println("Set 0 "+vertice);
		}
		assertEquals(4,set0.size());
		
		//[D,E]
		List<String> set1 = disjointSet.get(1);
		assertEquals(2,set1.size());
		
		for(String vertice: set1)
		{
			System.out.println("Set 1 "+vertice);
		}
	}
	//@Test
	public void testFindBaseCase()
	{
		UnionFind unionFind =new UnionFind();
		
		unionFind.addVertice("A");
		unionFind.addVertice("B");
		unionFind.addVertice("C");
		unionFind.addVertice("D");
		unionFind.addVertice("E");
		unionFind.addVertice("F");
		
		
		unionFind.addEdge("A","C",1);
		unionFind.addEdge("E","F",3);
		unionFind.addEdge("C","D",2);
		unionFind.addEdge("B","E",2);
		
		/*
		 * [A,C,D]
		 * [B,E,F]
		 * */
		List<ArrayList<String>> disjointSet = unionFind.getDisjointSet();
		assertEquals(2,disjointSet.size());
		
		List<String> set0 = disjointSet.get(0);
		assertEquals(3,set0.size());
		
		List<String> set1 = disjointSet.get(1);
		assertEquals(3,set1.size());
	}
	
	
	//@Test
	public void testDFSInConnectedGraph()
	{
		UnionFind unionFind =new UnionFind();
		
		unionFind.addVertice("A");
		unionFind.addVertice("B");
		unionFind.addVertice("C");
		unionFind.addVertice("D");
		unionFind.addVertice("E");
		unionFind.addVertice("F");
		
		
		unionFind.addEdge("A","C",1);
		unionFind.addEdge("A","E",2);
		unionFind.addEdge("E","F",3);
		unionFind.addEdge("C","D",2);
		unionFind.addEdge("B","E",2);
		List<Edge> edges =  unionFind.dfsAlgorithmForDisjoint(unionFind.vertices,unionFind.edges);
		assertEquals(5,edges.size());
		/*
		assertEquals("A-C=1",edges.get(0).toString());
		assertEquals("A-E=2",edges.get(1).toString());
		assertEquals("C-D=2",edges.get(2).toString());
		*/
		for(Edge edge : edges)
		{
			System.out.println("Edge DFS "+edge);	
		}
	}
	//@Test
	public void testDFSInDisConnectedGraph()
	{
		UnionFind unionFind =new UnionFind();
		
		unionFind.addVertice("A");
		unionFind.addVertice("B");
		unionFind.addVertice("C");
		unionFind.addVertice("D");
		unionFind.addVertice("E");
		unionFind.addVertice("F");
		
		
		unionFind.addEdge("A","C",1);
		//unionFind.addEdge("A","E",2);
		unionFind.addEdge("E","F",3);
		unionFind.addEdge("C","D",2);
		unionFind.addEdge("D","E",2);
		List<Edge> edges =  unionFind.dfsAlgorithmForDisjoint(unionFind.vertices,unionFind.edges);
		assertEquals(4,edges.size());
		
		for(Edge edge : edges)
		{
			System.out.println("Edge DFS Disconnected graph "+edge);	
		}
	}
}
