package com.turing.dsa.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class GraphAMatrix {

	List<String> vertices =new ArrayList<>();
	
	int[][]matrix ;
	
	public void addVertice(String vertex) {
		if(!this.vertices.contains(vertex))
		{
			this.vertices.add(vertex);
		}
		
	}

	public void buildMatrix() {
		
		int n = this.vertices.size();
		this.matrix = new int[n][n];
	}

	public void addEdge(String from, String to) {
		int fromIndex = this.vertices.indexOf(from);
		int toIndex = this.vertices.indexOf(to);
		
		this.matrix[fromIndex][toIndex] = 1;
		this.matrix[toIndex][fromIndex] = 1;
	}

	public boolean existEdge(String from, String to) {
		int fromIndex = this.vertices.indexOf(from);
		int toIndex = this.vertices.indexOf(to);
		
		return this.matrix[fromIndex][toIndex] != 0;
	}

	public List<String> getAdjacentVertex(String from)
	{
		List<String> vertexs = new ArrayList<String>();
		
		for(String vertex : this.vertices)
		{
			if(!from.equals(vertex))
			{
				if(this.existEdge(from, vertex))
				{
					vertexs.add(vertex);
				}
			}
		}
		return vertexs;
	}
	public List<String> depthFirstSearch() {
		List<String> visited = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
		
		String root = this.vertices.get(0);
		stack.push(root);		
		
		while(!stack.isEmpty())
		{
			String vertex = stack.pop();
			if(!visited.contains(vertex))
			{
				visited.add(vertex);
			}
			List<String> adjacentVertices = this.getAdjacentVertex(vertex);
			
			for(int i=adjacentVertices.size()-1;i>=0;i--)
			{
				String adjVertex = adjacentVertices.get(i);
				if(!visited.contains(adjVertex))
				{
					stack.push(adjVertex);
				}
			}
		}
		return visited;
	}

}
