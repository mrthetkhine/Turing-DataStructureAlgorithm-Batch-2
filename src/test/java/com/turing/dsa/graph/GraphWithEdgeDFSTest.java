package com.turing.dsa.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

public class GraphWithEdgeDFSTest {
	GraphEdgeRep graph = new GraphEdgeRep();
	
	GraphWithEdgeDFSTest()
	{
		graph.addVertice("A");
		graph.addVertice("B");
		graph.addVertice("C");
		graph.addVertice("D");
		graph.addVertice("E");
		graph.addVertice("F");
		
		graph.addEdge("A", "B", 5);
		graph.addEdge("A", "C", 1);
		graph.addEdge("B", "E", 6);
		graph.addEdge("B", "F", 2);
		graph.addEdge("D", "E", 2);
	}
	@Test
	public void testAdjacentEdges()
	{
		List<Edge> edges = graph.getAdjacentEdges("A");
		
		assertEquals(2,edges.size());
		
		Edge edge0 = edges.get(0);
		assertEquals("A-B=5",edge0.toString());
		
		Edge edge1 = edges.get(1);
		assertEquals("A-C=1",edge1.toString());
	}
	@Test
	public void testAdjacentEdgesComplex()
	{
		List<Edge> edges = graph.getAdjacentEdges("E");
		
		assertEquals(2,edges.size());
		
		Edge edge0 = edges.get(0);
		assertEquals("B-E=6",edge0.toString());
		
		Edge edge1 = edges.get(1);
		assertEquals("D-E=2",edge1.toString());
	}
	@Test
	public void testNonVisitedAdjacentEdgesComplex()
	{
		
		Edge visited = graph.edges.get(0);
		//add A=B
		graph.markEdgeVisited(visited);
		
		List<Edge> edges = graph.getAdjacentEdgesWhichisNotVisited("A");
		
		assertEquals(1,edges.size());
		Edge edge0 = edges.get(0);
		assertEquals("A-C=1",edge0.toString());
	}
	@Test
	public void testAdjacentUnvistedVertice()
	{
		List<String> vertices = graph.getAdjacentUnvisitedVertices("E");
		assertEquals(2,vertices.size());
		
		assertEquals("B",vertices.get(0));
		assertEquals("D",vertices.get(1));
	}
	@Test
	public void testDFS()
	{
		/*
		 * A-B=5
		 * B-E=6
		 * D-E=2
		 * B-F=2
		 * A-C=1
		 * */
		List<Edge> edges = graph.dfsAlgorithm();
		assertEquals(5,edges.size());
		
		Iterator<Edge> iterator = edges.iterator();
		assertEquals("A-B=5",iterator.next().toString());
		assertEquals("B-E=6",iterator.next().toString());
		assertEquals("D-E=2",iterator.next().toString());
		assertEquals("B-F=2",iterator.next().toString());
		assertEquals("A-C=1",iterator.next().toString());
	}
}
