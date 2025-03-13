package com.turing.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphEdgeRep{

	List<String> vertices =new ArrayList<>();
	List<Edge> edges = new ArrayList<>();
	
	public void addVertice(String vertex) {
		if(!this.vertices.contains(vertex))
		{
			this.vertices.add(vertex);
		}
		
	}
	public Edge addEdge(String start,String end,int weight)
	{
		int compartorResult = start.compareTo(end);
		String small="",large="";
		if(compartorResult < 0)
		{
			small = start;
			large= end;
		}
		else if(compartorResult > 0)
		{
			small = end;
			large = start;
		}
		Edge edge = new Edge(small,large,weight);
		this.edges.add(edge);
		return edge;
	}
	public static void main(String[]args)
	{
		System.out.println("A,B "+ "A".compareTo("B"));
		
	}
}
