package com.turing.dsa.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AdjacencyListGraphTest {
	/*
	 * 	A-B 
	 * 	A-C
	 *  B-D
	 *  B-E
	 *  C-F
	 *  
	 * */
	@Test
	public void testGraphEdgeExist()
	{
		Graph graph = new GraphAList();
		graph.addVertice("A");
		graph.addVertice("B");
		graph.addVertice("C");
		graph.addVertice("D");
		graph.addVertice("E");
		graph.addVertice("F");
		
		graph.build();
		
		graph.addEdge("A","B");
		graph.addEdge("A","C");
		graph.addEdge("B","D");
		graph.addEdge("B","E");
		graph.addEdge("C","F");
		
		assertTrue(graph.existEdge("A","B"));
		assertTrue(graph.existEdge("B","A"));
	}
	@Test
	public void testDFSAdjacenceyNodes()
	{
		Graph graph = new GraphAList();
		graph.addVertice("A");
		graph.addVertice("B");
		graph.addVertice("C");
		graph.addVertice("D");
		graph.addVertice("E");
		graph.addVertice("F");
		
		graph.build();
		
		graph.addEdge("A","B");
		graph.addEdge("A","C");
		graph.addEdge("B","D");
		graph.addEdge("B","E");
		graph.addEdge("C","F");
		graph.addEdge("D","E");//add cycle
		
		
		List<String> adjacentVertex = graph.getAdjacentVertex("A");
		Iterator<String> iterator  = adjacentVertex.iterator();
		assertEquals("B",iterator.next());
		assertEquals("C",iterator.next());
		assertFalse(iterator.hasNext());
		
		adjacentVertex = graph.getAdjacentVertex("B");
		iterator  = adjacentVertex.iterator();
		assertEquals("A",iterator.next());
		assertEquals("D",iterator.next());
		assertEquals("E",iterator.next());
		assertFalse(iterator.hasNext());
		
		
	}
	/*
	 * 	A-B 
	 * 	A-C
	 *  B-D
	 *  B-E
	 *  C-F
	 *  D-E
	 * */
	
	@Test
	public void testDFS()
	{
		GraphAList graph = new GraphAList();
		graph.addVertice("A");
		graph.addVertice("B");
		graph.addVertice("C");
		graph.addVertice("D");
		graph.addVertice("E");
		graph.addVertice("F");
		
		graph.build();
		
		graph.addEdge("A","B");
		graph.addEdge("A","C");
		graph.addEdge("B","D");
		graph.addEdge("B","E");
		graph.addEdge("C","F");
		graph.addEdge("D","E");//add cycle
		
		/*
		 * A,B,D,E,C,F
		 * */
	
		List<String> dfsVertices = graph.depthFirstSearch();
		Iterator<String> iterator  = dfsVertices.iterator();
		assertEquals("A",iterator.next());
		assertEquals("B",iterator.next());
		assertEquals("D",iterator.next());
		assertEquals("E",iterator.next());
		assertEquals("C",iterator.next());
		assertEquals("F",iterator.next());
		
	}
	/*
	 * 	A-B 
	 * 	A-C
	 *  B-D
	 *  B-E
	 *  C-F
	 *  D-E
	 * */
	
	@Test
	public void testBFS()
	{
		//Graph graph = new GraphAList();
		Graph graph = new GraphAMatrix();
		graph.addVertice("A");
		graph.addVertice("B");
		graph.addVertice("C");
		graph.addVertice("D");
		graph.addVertice("E");
		graph.addVertice("F");
		
		graph.build();
		
		graph.addEdge("A","B");
		graph.addEdge("A","C");
		graph.addEdge("B","D");
		graph.addEdge("B","E");
		graph.addEdge("C","F");
		graph.addEdge("D","E");//add cycle
		
		/*
		 * A,B,C,D,E,F
		 * */
	
		List<String> dfsVertices = graph.breathFirstSearch();
		Iterator<String> iterator  = dfsVertices.iterator();
		assertEquals("A",iterator.next());
		assertEquals("B",iterator.next());
		assertEquals("C",iterator.next());
		assertEquals("D",iterator.next());
		assertEquals("E",iterator.next());
		assertEquals("F",iterator.next());
		
	}
}
