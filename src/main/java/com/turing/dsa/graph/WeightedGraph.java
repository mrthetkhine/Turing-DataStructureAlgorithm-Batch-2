package com.turing.dsa.graph;

import java.util.ArrayList;
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
	public List<String> primAlgorithm()
	{
		List<String> visited = new ArrayList<String>();
		String firstVertex = this.vertices.get(0);
		
		visited.add(firstVertex);
		
		int noOfVertices =this.vertices.size();
		int noOfEdge = 0;
		
		while(noOfEdge < noOfVertices-1 )
		{
			int min = MAX_WEIGHT;
		}
		return visited;
	}
}
