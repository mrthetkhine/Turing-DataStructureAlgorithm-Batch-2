package com.turing.dsa.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class KruskalTest {
	@Test
	public void testAddEge(){
		GraphEdgeRep graph = new GraphEdgeRep();
		Edge edge = graph.addEdge("A", "B", 10);
		assertEquals("A",edge.start);
		assertEquals("B",edge.end);
		
		edge = graph.addEdge("B", "A", 10);
		assertEquals("A",edge.start);
		assertEquals("B",edge.end);
	}
	@Test
	public void testKrusalAlgorithm()
	{
		GraphEdgeRep graph = new GraphEdgeRep();
		/*
		 *  A-B=5
			A-C=1
			B-C=4
			B-D=9
			B-E=6
			B-F=2
			C-F=3
			D-E=2

		 * */
		graph.addEdge("A", "B", 5);
		graph.addEdge("A", "C", 1);
		graph.addEdge("B", "C", 4);
		graph.addEdge("B", "D", 9);
		graph.addEdge("B", "E", 6);
		graph.addEdge("B", "F", 2);
		graph.addEdge("C", "F", 2);
		graph.addEdge("D", "E", 2);
		
	}
}
