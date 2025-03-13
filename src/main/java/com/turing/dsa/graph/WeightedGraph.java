package com.turing.dsa.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeightedGraph extends GraphAMatrix{
	
	int MAX_WEIGHT = Integer.MAX_VALUE;
	public void build() {
		
		int n = this.vertices.size();
		this.matrix = new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				this.matrix[i][j] = MAX_WEIGHT;
			}
		}
	}
	public void addEdge(String from, String to,int weight) {
		int fromIndex = this.vertices.indexOf(from);
		int toIndex = this.vertices.indexOf(to);
		
		this.matrix[fromIndex][toIndex] = weight;
		this.matrix[toIndex][fromIndex] = weight;
	}
	public boolean existEdge(String from, String to) {
		int fromIndex = this.vertices.indexOf(from);
		int toIndex = this.vertices.indexOf(to);
		
		return this.matrix[fromIndex][toIndex] != MAX_WEIGHT;
	}
	public void markedVisited(List<String> visitedVertices)
	{
		if(visitedVertices.size()>1)
		{
			for(int i=0;i< visitedVertices.size()-1;i++)
			{
				String from = visitedVertices.get(i);
				String to = visitedVertices.get(i+1);
				this.markedVisited(from, to);
			}
		}
	}
	public void markedVisited(String from, String to )
	{
		int fromIndex = this.vertices.indexOf(from);
		int toIndex = this.vertices.indexOf(to);
		
		this.matrix[fromIndex][toIndex] = MAX_WEIGHT;
		this.matrix[toIndex][fromIndex] = MAX_WEIGHT;
	}
	public List<Edge> getAdjacentVerticesForGraph(List<String> graphNodes)
	{
		this.markedVisited(graphNodes);
		List<Edge> adjacentVertices = new ArrayList<>();
		if(graphNodes.size()==1)
		{
			String startVertex = graphNodes.get(0);
			getAdjacentVerticeFromNode(startVertex, adjacentVertices);
		}
		else if(graphNodes.size()>1)
		{
			String startVertex = graphNodes.get(0);
			String endVertex = graphNodes.get(graphNodes.size()-1);
			getAdjacentVerticeFromNode(startVertex, adjacentVertices);
			getAdjacentVerticeFromNode(endVertex, adjacentVertices);
		}
		Collections.sort(adjacentVertices);
		return adjacentVertices;
	}

	private void getAdjacentVerticeFromNode(String startVertex, List<Edge> adjacentVertices) {
		
		System.out.println("StartVertex "+startVertex);
		for(String vertex : this.vertices)
		{
			if(!startVertex.equals(vertex))
			{
				int fromIndex = this.vertices.indexOf(startVertex);
				int toIndex = this.vertices.indexOf(vertex);
				
				if(this.existEdge(startVertex, vertex))
				{
					System.out.println("Edge exist "+ startVertex+" end "+vertex);
					int weight = this.matrix[fromIndex][toIndex];
					Edge edge = new Edge(startVertex,vertex,weight);
					System.out.println("Add edge "+edge);
					adjacentVertices.add(edge);
				}
			}
		
		}
	}
	public List<String> primAlgorithm()
	{
		List<String> visited = new ArrayList<String>();
		String firstVertex = this.vertices.get(0);
		
		visited.add(firstVertex);
		
		int noOfVertices =this.vertices.size();
		int noOfEdge = 0;
		
		while(noOfEdge < noOfVertices-1 )
		{
			List<Edge> edges = this.getAdjacentVerticesForGraph(visited);
			Edge smallestEdge = edges.get(0);
			
			String startVertex = visited.get(0);
			String endVertext = visited.get(visited.size()-1);
			
			if(smallestEdge.start.equals(endVertext))
			{
				visited.add(smallestEdge.end);
			}
			else if(smallestEdge.start.equals(startVertex))
			{
				visited.add(0,smallestEdge.end);
			}
			noOfEdge ++;
		}
		return visited;
	}
}
