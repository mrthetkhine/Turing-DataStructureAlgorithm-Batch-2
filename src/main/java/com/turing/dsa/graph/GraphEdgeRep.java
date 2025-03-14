package com.turing.dsa.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class GraphEdgeRep{

	List<String> vertices =new ArrayList<>();
	List<Edge> edges = new ArrayList<>();
	List<Edge> visitedEdges = new ArrayList<>();
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
	public List<Edge> getAdjacentEdges(String vertex)
	{
		List<Edge> adjacentEdges = new ArrayList<>();
		for(Edge edge : this.edges)
		{
			if(vertex.equals(edge.start) || vertex.equals(edge.end))
			{
				adjacentEdges.add(edge);
			}
		}
		return adjacentEdges;
	}
	public void markEdgeVisited(Edge edge)
	{
		System.out.println("Visited "+edge);
		this.visitedEdges.add(edge);
		
	}
	public List<Edge> getAdjacentEdgesWhichisNotVisited(String vertex)
	{
		List<Edge> adjacentEdges = new ArrayList<>();
		for(Edge edge : this.edges)
		{
			if(!this.visitedEdges.contains(edge))
			{
				if(vertex.equals(edge.start) || vertex.equals(edge.end))
				{
					adjacentEdges.add(edge);
				}
			}
			
		}
		return adjacentEdges;
	}
	
	public List<String> getAdjacentUnvisitedVertices(String from)
	{
		List<String> adjacentVertices = new ArrayList<>();
		
		List<Edge> reachableUnvisitedEdge = this.getAdjacentEdgesWhichisNotVisited(from);
		for(Edge edge : reachableUnvisitedEdge)
		{
			if(edge.start.equals(from))
			{
				adjacentVertices.add(edge.end);
			}
			else 
			{
				adjacentVertices.add(edge.start);
			}
				
		}
		Collections.sort(adjacentVertices);
		return adjacentVertices;
	}
	public List<Edge> dfsAlgorithm()
	{
		List<Edge> visited = new ArrayList<>();
		Stack<Edge> stack = new Stack<>();
		String current=this.vertices.get(0);
		
		List<Edge> adjancetEdge = this.getAdjacentEdgesWhichisNotVisited(current);
		for(int i=adjancetEdge.size()-1;i>=0;i--)
		{
			stack.push(adjancetEdge.get(i));
		}
		
		
		while(!stack.empty())
		{
			Edge currentEdge = stack.pop(); 
			visited.add(currentEdge);
			this.markEdgeVisited(currentEdge);
			
			List<Edge> adjancetEdges = this.getAdjacentEdgesWhichisNotVisited(currentEdge.end);
			System.out.println("Adjacent edge size "+adjancetEdges.size()+" from "+currentEdge.end);
			for(int i=adjancetEdges.size()-1;i>=0;i--)
			{
				stack.push(adjancetEdges.get(i));
			}
		}
		
		return visited;
	}
	public static void main(String[]args)
	{
		System.out.println("A,B "+ "A".compareTo("B"));
		
	}
}
