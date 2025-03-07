package com.turing.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public abstract class Graph {
	List<String> vertices =new ArrayList<>();
	
	abstract void build();
	abstract List<String> getAdjacentVertex(String from);
	abstract void addEdge(String from, String to);
	abstract boolean existEdge(String from, String to);
	
	public void addVertice(String vertex) {
		if(!this.vertices.contains(vertex))
		{
			this.vertices.add(vertex);
		}
		
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
	public List<String> breathFirstSearch() {
		List<String> visited = new ArrayList<String>();
		Queue<String> queue = new LinkedList<String>();
		
		String root = this.vertices.get(0);
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			String vertex = queue.poll();
			if(!visited.contains(vertex))
			{
				visited.add(vertex);
			}
			List<String> adjacentVertices = this.getAdjacentVertex(vertex);
			
			for(String adjVertex :adjacentVertices )
			{
				if(!visited.contains(adjVertex))
				{
					queue.add(adjVertex);
				}
			}
		}
		return visited;
	}
}
