package com.turing.dsa.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class GraphAList {
	List<String> vertices =new ArrayList<>();

	List<List<String>> adjacencyList = new ArrayList<List<String>>();
	public void addVertice(String vertex) {
		if(!this.vertices.contains(vertex))
		{
			this.vertices.add(vertex);
		}
		
	}
	public void build()
	{
		for(String vertice: this.vertices)
		{
			List<String> adjList = new ArrayList<>();
			this.adjacencyList.add(adjList);
		}
	}
	public void addEdge(String from, String to) {
		int fromIndex = this.vertices.indexOf(from);
		List<String> adjList = this.adjacencyList.get(fromIndex);
		adjList.add(to);
		
		//this.addEdge(to, from);
		
	}
	public boolean existEdge(String from, String to) {
		int fromIndex = this.vertices.indexOf(from);
		List<String> adjList = this.adjacencyList.get(fromIndex);
		return adjList.contains(to);
	}
}
