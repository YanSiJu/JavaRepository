package cn.ccsu.graph;

public class Edge {

	private Vertex start;
	private Vertex end;
	private int distance;

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	
	public Edge(Vertex start, Vertex end, int distance) {
		super();
		this.start = start;
		this.end = end;
		this.distance = distance;
	}

	public Vertex getStart() {
		return start;
	}

	public void setStart(Vertex start) {
		this.start = start;
	}

	public Vertex getEnd() {
		return end;
	}

	public void setEnd(Vertex end) {
		this.end = end;
	}

}
