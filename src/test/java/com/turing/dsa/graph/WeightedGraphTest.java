package com.turing.dsa.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WeightedGraphTest {
	WeightedGraph graph = new WeightedGraph();
	
	WeightedGraphTest()
	{
		graph.addVertice("A");
		graph.addVertice("B");
		graph.addVertice("C");
		graph.addVertice("D");
		graph.addVertice("E");
		graph.addVertice("F");
		
		graph.build();
		
		graph.addEdge("A","B",5);
		graph.addEdge("A","C",1);
		graph.addEdge("B","D",9);
		graph.addEdge("B","E",6);
		graph.addEdge("C","F",3);
		graph.addEdge("D","E",2);
	}

	
	@Test
	public void testGetAdajacentVerticesBaseCase()
	{
		List<String> vertices = new ArrayList<>();
		vertices.add("A");
		
		List<Edge> adjacentVertices = this.graph.getAdjacentVerticesForGraph(vertices);
	
		/*
		 * A-C 1
		 * A-B 5
		 * */
		assertEquals(2, adjacentVertices.size());
		
		Edge edge0 = adjacentVertices.get(0);
		assertEquals("C",edge0.end);
		assertEquals(1,edge0.weight);
		
		Edge edge1 = adjacentVertices.get(1);
		assertEquals("B",edge1.end);
		assertEquals(5,edge1.weight);
	}
	@Test
	public void testGetAdajacentVerticesFromGraph()
	{
		List<String> vertices = new ArrayList<>();
		vertices.add("A");
		vertices.add("C");
		
		List<Edge> adjacentVertices = this.graph.getAdjacentVerticesForGraph(vertices);
	
		/*
		 * C-F 3
		 * A-B 5
		 * */
		assertEquals(2, adjacentVertices.size());
		
		Edge edge0 = adjacentVertices.get(0);
		assertEquals("C-F=3",edge0.toString());//C-F=3
		
		Edge edge1 = adjacentVertices.get(1);
		assertEquals("A-B=5",edge1.toString());//A-B=5
		
	}
	@Test
	public void testGetAdajacentVerticesFromGraphComplex()
	{
		List<String> vertices = new ArrayList<>();
		vertices.add("A");
		vertices.add("C");
		vertices.add("F");
		
		List<Edge> adjacentVertices = this.graph.getAdjacentVerticesForGraph(vertices);
	
		/*
		 * A-B=5
		 * 
		 * */
		assertEquals(1, adjacentVertices.size());
		
		Edge edge0 = adjacentVertices.get(0);
		assertEquals("A-B=5",edge0.toString());
		
		
	}
	@Test
	public void testGetAdajacentVerticesFromGraphComplex2()
	{
		List<String> vertices = new ArrayList<>();
		vertices.add("B");
		vertices.add("A");
		vertices.add("C");
		vertices.add("F");
		
		
		List<Edge> adjacentVertices = this.graph.getAdjacentVerticesForGraph(vertices);
	
		/*
		 * B-E=6
		 * B-D=9
		 * */
		assertEquals(2, adjacentVertices.size());
		
		Edge edge0 = adjacentVertices.get(0);
		assertEquals("B-E=6",edge0.toString());
		
		Edge edge1 = adjacentVertices.get(1);
		assertEquals("B-D=9",edge1.toString());
	}
	@Test
	public void testPrimAlgorithm()
	{
		
		//{D,E,B,A,C,F}
		List<String> mst = this.graph.primAlgorithm();
		assertEquals(6, mst.size());
		
		mst.forEach(item->System.out.println("Vertex "+item));
		Iterator<String> iterator = mst.iterator();
		assertEquals("D",iterator.next());
		assertEquals("E",iterator.next());
		assertEquals("B",iterator.next());
		assertEquals("A",iterator.next());
		assertEquals("C",iterator.next());
		assertEquals("F",iterator.next());
		
		assertEquals(false,iterator.hasNext());
	}
}
