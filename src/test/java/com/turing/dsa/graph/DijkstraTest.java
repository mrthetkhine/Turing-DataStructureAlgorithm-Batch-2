package com.turing.dsa.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class DijkstraTest {

	GraphAMatrix graph = new GraphAMatrix();
	DijkstraTest()
	{
		
		graph.addVertice("A");
		graph.addVertice("B");
		graph.addVertice("C");
		graph.addVertice("D");
		graph.addVertice("E");
		graph.addVertice("F");
		graph.addVertice("G");
		
		graph.build();
		
		graph.addEdge("A", "B", 3);
		graph.addEdge("A", "C", 5);
		graph.addEdge("A", "D", 1);
		
		graph.addEdge("B", "C", 2);
		
		graph.addEdge("C", "D", 2);
		graph.addEdge("C", "G", 4);
		
		graph.addEdge("D", "E", 1);
		graph.addEdge("D", "F", 6);
		
		graph.addEdge("E", "F", 3);
		graph.addEdge("E", "G", 3);
		
		
		graph.initDijkstra();
	}
	//Graph from https://www.savemyexams.com/a-level/computer-science/ocr/17/revision-notes/8-algorithms/8-1-algorithms/dijkstras-shortest-path-algorithm/
	@Test
	public void testGetMiniDistanceVerticeFromUnvisitedNodeBaseCase()
	{
		
		
		ArrayList<String> unvisited = new ArrayList<>();
		for(String vertice: graph.vertices)
		{
			unvisited.add(vertice);
		}
		VerticeDistance vd= graph.getVerticeWithSmallestDistanceFromUnvisited(unvisited);
		
		assertEquals("A",vd.vertice);
	}
	
	@Test
	public void testGetMiniDistanceCompleCase()
	{
		
		ArrayList<String> unvisited = new ArrayList<>();
		for(String vertice: graph.vertices)
		{
			unvisited.add(vertice);
		}
		unvisited.remove("A");
		
		graph.addTotalWeightToVertice("B", 3);
		graph.addTotalWeightToVertice("C", 5);
		graph.addTotalWeightToVertice("D", 1);
		VerticeDistance vd = graph.getVerticeWithSmallestDistanceFromUnvisited(unvisited);
		
		assertEquals("D",vd.vertice);
	}
	@Test
	public void testGetMiniDistanceCompleCaseWithPreious()
	{
		
		ArrayList<String> unvisited = new ArrayList<>();
		for(String vertice: graph.vertices)
		{
			unvisited.add(vertice);
		}
		unvisited.remove("A");
		
		graph.addTotalWeightToVertice("B", 7);
		graph.addTotalWeightToVertice("C", 9);
		graph.addTotalWeightToVerticeWithPrevious("D", 4,"A");
		graph.addTotalWeightToVerticeWithPrevious("E", 2,"D");
		
		VerticeDistance vd = graph.getVerticeWithSmallestDistanceFromUnvisited(unvisited);
		
		assertEquals("D",vd.vertice);
		assertEquals(4,vd.totalDistance);
	}
	@Test
	public void testUnvisitedNeighbour()
	{
		
		ArrayList<String> unvisited = new ArrayList<>();
		for(String vertice: graph.vertices)
		{
			unvisited.add(vertice);
		}
		//unvisited.remove("A");
		
		List<String> neighbour = graph.getUnvisitedNeighbourOfVertice("A", unvisited);
		assertTrue(neighbour.contains("B"));
		assertTrue(neighbour.contains("C"));
		assertTrue(neighbour.contains("D"));
	}
	@Test
	public void testUnvisitedNeighbourComplexCase()
	{
		
		ArrayList<String> unvisited = new ArrayList<>();
		for(String vertice: graph.vertices)
		{
			unvisited.add(vertice);
		}
		unvisited.remove("B");
		
		List<String> neighbour = graph.getUnvisitedNeighbourOfVertice("A", unvisited);
		assertFalse(neighbour.contains("B"));
		assertTrue(neighbour.contains("C"));
		assertTrue(neighbour.contains("D"));
	}
	
	@Test
	public void testDijkstra()
	{
		String[] previous = graph.dijkstraAlgorithm();
		assertEquals(null,previous[0]);
		assertEquals("A",previous[1]);
		assertEquals("D",previous[2]);
		assertEquals("A",previous[3]);
		assertEquals("D",previous[4]);
		assertEquals("E",previous[5]);
		assertEquals("E",previous[6]);
	}
}
