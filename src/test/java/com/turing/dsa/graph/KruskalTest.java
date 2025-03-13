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
}
