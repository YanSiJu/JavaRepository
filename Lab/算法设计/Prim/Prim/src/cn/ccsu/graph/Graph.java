package cn.ccsu.graph;

public class Graph {

	private Vertex[] vertex;
	private Edge[] edge;

	public Vertex[] getVertex() {
		return vertex;
	}

	public void setVertex(Vertex[] vertex) {
		this.vertex = vertex;
	}

	public Edge[] getEdge() {
		return edge;
	}

	public void setEdge(Edge[] edge) {
		this.edge = edge;
	}

	public Graph(Vertex[] vertex, Edge[] edge) {
		super();
		this.vertex = vertex;
		this.edge = edge;
	}

}
