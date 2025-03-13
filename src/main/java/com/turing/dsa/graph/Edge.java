package com.turing.dsa.graph;

public class Edge implements Comparable<Edge>{
	String start;
	String end;
	int weight;
	public Edge(String start, String end, int weight)
	{
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	@Override
	public int compareTo(Edge another) {
	
		return this.weight - another.weight;
	}
	@Override
	public String toString() {
		return start+"-"+end+"="+weight;
	}
}
