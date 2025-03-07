package com.turing.dsa.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class GraphAMatrix extends Graph{
	
	int[][]matrix ;
	
	
	public void build() {
		
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
	

}
