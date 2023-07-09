import java.util.*;

class Graph {
	private int numVertices;				// number of vertices
	private Map<Vertex, List<Vertex>> adj;	// adjacency list

	Graph() { 
		numVertices = 0;
		adj = new HashMap<>();
	}

	public void addVertex(String name) {
		// Check if Vertex is already in graph
		Vertex vertex = new Vertex(name);
		if (!adj.containsKey(vertex)) {
			adj.put(vertex, new ArrayList<>());
			numVertices++;
		}
	}

	public void addEdge(String source, String destination) {
		Vertex u = new Vertex(source);
		Vertex v = new Vertex(destination);
		adj.get(u).add(v);	// our implementation uses a digraph
	}

	public List<Vertex> getNeighbors(Vertex u) {
		return adj.get(u);
	}

	public void findPath(String s, String d) {
		Vertex source = new Vertex(s);
		Vertex destination = new Vertex(d);
		// LinkedHashSet to preserve insertion order
		Set<Vertex> visited = new LinkedHashSet<>();
		boolean found = dfsRecursive(source, destination, visited);
		if (found) {
			// print the path
			boolean first = true;
			for (Vertex v : visited) {
				if (first) {
					System.out.printf("%s", v.getName());
					first = false;	// Flag for first vertex, used in priting path
				} else {
					System.out.printf(" -> %s", v.getName());
				}
			}
		} else {
			System.out.printf("No path from %s to %s", s, d);
		}
		System.out.println();
	}

	private boolean dfsRecursive(Vertex current, Vertex destination, 
									Set<Vertex> visited) {
		if (visited.contains(current)) return false;	// Backtrack if visited
		visited.add(current);	// mark current vertex as visited

		// Destination is reached
		if (current.equals(destination)) return true;

		// Visit adjacent vertices
		for (Vertex neighbor : getNeighbors(current)) {
			if (dfsRecursive(neighbor, destination, visited)) return true;
		}
		return false;	// Destination cannot be reached
	}

	public void printLocations() {
		System.out.println("Number of locations: " + numVertices);
		for (Vertex v : adj.keySet()) {
			System.out.println(v.getName());
		}
	}
}
