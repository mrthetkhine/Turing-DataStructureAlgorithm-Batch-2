package com.turing.dsa.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

class VerticeDistance implements Comparable<VerticeDistance>
{
	String vertice;
	double totalDistance;
	
	public VerticeDistance(String vertice,double totalDistance)
	{
		this.vertice = vertice;
		this.totalDistance = totalDistance;
	}
	
	public int compareTo(VerticeDistance other)
	{
		return (int)(this.totalDistance - other.totalDistance);
	}

	
}
public class GraphAMatrix extends Graph{
	
	int[][]matrix ;
	
	double[] weights ;
	String[] previous;
	
	public void build() {
		
		int n = this.vertices.size();
		this.matrix = new int[n][n];
		this.weights = new double[n];
		this.previous = new String[n];
	}

	public void addEdge(String from, String to) {
		int fromIndex = this.vertices.indexOf(from);
		int toIndex = this.vertices.indexOf(to);
		
		this.matrix[fromIndex][toIndex] = 1;
		this.matrix[toIndex][fromIndex] = 1;
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
		
		return this.matrix[fromIndex][toIndex] != 0 || this.matrix[toIndex][fromIndex] !=0;
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
	double getTotalDistance(String vertice)
	{
		int verticeIndex = this.vertices.indexOf(vertice);
		String previous =null; 
		double distance =0;
		
		do
		{
			//System.out.println("Previous getTotalDistance "+previous);
			distance += this.weights[verticeIndex];
			previous =  this.previous[verticeIndex];
			if(previous !=null)
			{
				verticeIndex = this.vertices.indexOf(previous);
			}
		}while(previous != null);
		return distance;	
	}
	VerticeDistance getVerticeWithSmallestDistanceFromUnvisited(ArrayList<String> unvisited)
	{
		//System.out.println("Loop getVerticeWithSmallestDistanceFromUnvisited ");
		ArrayList<VerticeDistance> verticeAndDistances = new ArrayList<>();
		
		for(String unvisitedVertice: unvisited)
		{
			double totalDistance = this.getTotalDistance(unvisitedVertice);
			VerticeDistance verticeDistance = new VerticeDistance(unvisitedVertice,totalDistance);
			verticeAndDistances.add(verticeDistance);
			//System.out.println("Loop unvisited "+unvisitedVertice);
		}
		Collections.sort(verticeAndDistances);
		return verticeAndDistances.get(0);
		
	}
	public void initDijkstra()
	{
		for(int i=0;i< this.weights.length;i++)
		{
			this.weights[i] = Double.POSITIVE_INFINITY;
		}
		this.weights[0] = 0;
	}
	void addTotalWeightToVertice(String vertice,double weight)
	{
		int index = this.vertices.indexOf(vertice);
		this.weights[index] = weight;
	}
	void addTotalWeightToVerticeWithPrevious(String vertice,double weight,String previous)
	{
		int index = this.vertices.indexOf(vertice);
		this.weights[index] = weight;
		this.previous[index] = previous;
	}
	List<String> getUnvisitedNeighbourOfVertice(String from, ArrayList<String> unvisited)
	{
		List<String> unvisitedNeighBour = new ArrayList<>();
		for(String vertice: this.vertices)
		{
			if(unvisited.contains(vertice) && this.existEdge(from, vertice))
			{
				unvisitedNeighBour.add(vertice);
			}
		}
		return unvisitedNeighBour;
	}
	//pseudocode from http://www.gitta.info/Accessibiliti/en/html/Dijkstra_learningObject1.html
	public String[] dijkstraAlgorithm()
	{
		this.initDijkstra();
		//System.out.println("Weight >> 1 "+this.weights[1]);
		ArrayList<String> unvisited = new ArrayList<>();
		for(String vertice: this.vertices)
		{
			unvisited.add(vertice);
		}
		while(unvisited.size()>0)
		{
			VerticeDistance vd = this.getVerticeWithSmallestDistanceFromUnvisited(unvisited);
			//System.out.println("Smallest vertice >> "+vd.vertice +" with distance "+vd.totalDistance);
			unvisited.remove(vd.vertice);
			
			List<String> neighbour = this.getUnvisitedNeighbourOfVertice(vd.vertice, unvisited);
			for(String neighbourVertice : neighbour)
			{
				
				int index = this.vertices.indexOf(vd.vertice);
				int neighourIndex = this.vertices.indexOf(neighbourVertice);
				double alt = this.weights[index] + this.matrix[index][neighourIndex];
				
				//System.out.println("Neighour "+neighbourVertice+" Weight "+this.weights[index]+ " matrix "+this.matrix[index][neighourIndex]);
				//System.out.println("Alt "+alt + " org weight "+this.weights[index]);
				if(alt < this.weights[neighourIndex])
				{
					this.weights[neighourIndex] = alt;
					this.previous[neighourIndex] = vd.vertice;
					//System.out.println("Update "+neighbourVertice +" wieght "+alt);
				}
				
			}
		}
		return this.previous;
	}

}
