package com.turing.dsa.graph;

import org.junit.jupiter.api.Test;

public class WeightedGraphTest {

	@Test
	public void testGetAdjacentVertexStartWith()
	{
		WeightedGraph graph = new WeightedGraph();
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
}
