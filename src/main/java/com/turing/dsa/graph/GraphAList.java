package com.turing.dsa.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.BooleanSupplier;

public class GraphAList extends Graph {

	List<List<String>> adjacencyList = new ArrayList<List<String>>();
	
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
		
		int toIndex = this.vertices.indexOf(to);
		adjList = this.adjacencyList.get(toIndex);
		adjList.add(from);
		
	}
	public boolean existEdge(String from, String to) {
		int fromIndex = this.vertices.indexOf(from);
		List<String> adjList = this.adjacencyList.get(fromIndex);
		return adjList.contains(to);
	}
	public List<String> getAdjacentVertex(String from) {
		int fromIndex = this.vertices.indexOf(from);
		List<String> adjList = this.adjacencyList.get(fromIndex);
		return adjList;
	}
	
	
}
