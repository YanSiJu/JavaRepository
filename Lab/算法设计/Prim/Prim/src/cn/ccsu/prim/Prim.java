package cn.ccsu.prim;

import cn.ccsu.graph.Edge;
import cn.ccsu.graph.Graph;
import cn.ccsu.graph.Vertex;

public class Prim {

	public void minSpanningTree(Graph g) {

		Vertex[] vertex = g.getVertex();
		Edge[] edge = g.getEdge();

		Vertex[] vertexTree = new Vertex[vertex.length];
		vertexTree[0] = vertex[0];
		int size = 1;
		Edge[] edgeTree = new Edge[edge.length];
		int edgeNum = 0;

		for (int i = 0; i < size; i++) {
			int min = Integer.MAX_VALUE;
			Vertex v = vertexTree[i];
			Edge minEdge = null;
			for (int j = 0; j < edge.length; j++) {
				Edge currentEdge = edge[j];

				if (currentEdge.getEnd().equals(v)
						|| currentEdge.getStart().equals(v)) {
					if (currentEdge.getDistance() < min) {
						min = currentEdge.getDistance();
						minEdge = currentEdge;
					}
				}
			}
			Vertex addedVertex = minEdge.getEnd().equals(v) ? minEdge
					.getStart() : minEdge.getEnd();
			vertexTree[size++] = addedVertex;
			edgeTree[edgeNum++] = minEdge;
		}
	}
}
