package com.turing.dsa.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class UnionFind extends GraphEdgeRep{
	
	public List<String> getAdjacentNotVisitedVerticesFrom(String vertices)
	{
		List<String> adjancentVertices = new ArrayList<>();
		return adjancentVertices;
	}
	public List<Edge> getEdgeRechableFromVertices(String vertice,List<Edge> edgesList)
	{
		List<Edge> adjacentEdges = new ArrayList<Edge>();
		for(Edge edge : edgesList)
		{
			if(edge.start.equals(vertice) || edge.end.equals(vertice))
			{
				adjacentEdges.add(edge);
			}
		}
		
		return adjacentEdges;
	}
	public List<Edge> getAdjacentEdgesWhichisNotVisited(String vertex,
			List<Edge> visitedEdges, 
			List<Edge> edges)
	{
		List<Edge> adjacentEdges = new ArrayList<>();
		for(Edge edge : edges)
		{
			if(!visitedEdges.contains(edge))
			{
				if(vertex.equals(edge.start) || vertex.equals(edge.end))
				{
					adjacentEdges.add(edge);
				}
			}
			
		}
		return adjacentEdges;
	}
	public List<Edge> dfsAlgorithmForDisjoint(List<String> vertices,List<Edge> edges)
	{
		List<Edge> visited = new ArrayList<>();
		Stack<Edge> stack = new Stack<>();
		String current=edges.get(0).start;
		
		List<Edge> adjancetEdge = this.getAdjacentEdgesWhichisNotVisited(current,visited,edges);
		for(int i=adjancetEdge.size()-1;i>=0;i--)
		{
			stack.push(adjancetEdge.get(i));
		}
		
		
		while(!stack.empty())
		{
			Edge currentEdge = stack.pop(); 
			visited.add(currentEdge);
			this.markEdgeVisited(currentEdge);
			
			List<Edge> adjancetEdges = this.getAdjacentEdgesWhichisNotVisited(currentEdge.end,visited,edges);
			System.out.println("Adjacent edge size "+adjancetEdges.size()+" from "+currentEdge.end);
			for(int i=adjancetEdges.size()-1;i>=0;i--)
			{
				stack.push(adjancetEdges.get(i));
			}
		}
		
		return visited;
	}
	public ArrayList<String> getAllVerticesFromEdges(List<Edge> edges)
	{
		ArrayList<String> vertices = new ArrayList<>();
		for(Edge edge : edges)
		{
			if(!vertices.contains(edge.start))
			{
				vertices.add(edge.start);
			}
			if(!vertices.contains(edge.end))
			{
				vertices.add(edge.end);
			}
		}
		return vertices;
	}
	public List<ArrayList<String>> getDisjointSet() {
		
		List<ArrayList<String>> disjointSet = new ArrayList<ArrayList<String>>();
		
		List<Edge> edges = new ArrayList<Edge>();
		for(Edge edge: this.edges)
		{
			edges.add(edge);
		}
		
		while(!edges.isEmpty())
		{
			List<Edge> dsfEdges = this.dfsAlgorithmForDisjoint(this.vertices,edges);
			ArrayList<String> disjointVertices = this.getAllVerticesFromEdges(dsfEdges);
			Collections.sort(disjointVertices);
			edges.removeAll(dsfEdges);
			
			if(disjointVertices.size()>0)
			{
				disjointSet.add(disjointVertices);
			}
		}
		return disjointSet;
	}

}
