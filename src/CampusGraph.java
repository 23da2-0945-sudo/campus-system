import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Undirected graph modelling the campus: locations are vertices, roads/paths
 * are edges. Implemented with an adjacency list (Requirements 7, 8, 9, 10, 11).
 */
public class CampusGraph {

    // LinkedHashMap keeps insertion order, which makes the "display network" output stable
    private final Map<String, Set<String>> adjacency = new LinkedHashMap<>();

    public boolean addLocation(String location) {
        String key = location.trim();
        if (adjacency.containsKey(key)) return false; // duplicate location
        adjacency.put(key, new LinkedHashSet<>());
        return true;
    }

    public boolean removeLocation(String location) {
        if (!adjacency.containsKey(location)) return false;
        adjacency.remove(location);
        // also remove this location from every other vertex's neighbour set
        for (Set<String> neighbours : adjacency.values()) {
            neighbours.remove(location);
        }
        return true;
    }

    public boolean hasLocation(String location) {
        return adjacency.containsKey(location);
    }

    /** Adds an undirected connection/road between two existing locations. */
    public String addConnection(String from, String to) {
        if (!adjacency.containsKey(from) || !adjacency.containsKey(to)) {
            return "One or both locations do not exist. Add them first.";
        }
        if (from.equals(to)) {
            return "A location cannot be connected to itself.";
        }
        if (adjacency.get(from).contains(to)) {
            return "This connection already exists.";
        }
        adjacency.get(from).add(to);
        adjacency.get(to).add(from);
        return null; // null means success
    }

    public String removeConnection(String from, String to) {
        if (!adjacency.containsKey(from) || !adjacency.containsKey(to)) {
            return "One or both locations do not exist.";
        }
        if (!adjacency.get(from).contains(to)) {
            return "No such connection exists.";
        }
        adjacency.get(from).remove(to);
        adjacency.get(to).remove(from);
        return null;
    }

    public void displayNetwork() {
        if (adjacency.isEmpty()) {
            System.out.println("No campus locations have been added yet.");
            return;
        }
        System.out.println("---- Campus Network (adjacency list) ----");
        for (Map.Entry<String, Set<String>> e : adjacency.entrySet()) {
            String neighbours = e.getValue().isEmpty() ? "(no connections)" : String.join(", ", e.getValue());
            System.out.println(e.getKey() + " -> " + neighbours);
        }
    }

    /** Breadth-first traversal starting from a given location. */
    public List<String> bfs(String start) {
        List<String> order = new ArrayList<>();
        if (!adjacency.containsKey(start)) return order;

        Set<String> visited = new LinkedHashSet<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            order.add(current);
            for (String neighbour : adjacency.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        return order;
    }

    /** Depth-first traversal starting from a given location. */
    public List<String> dfs(String start) {
        List<String> order = new ArrayList<>();
        if (!adjacency.containsKey(start)) return order;
        Set<String> visited = new LinkedHashSet<>();
        dfsRec(start, visited, order);
        return order;
    }

    private void dfsRec(String current, Set<String> visited, List<String> order) {
        visited.add(current);
        order.add(current);
        for (String neighbour : adjacency.get(current)) {
            if (!visited.contains(neighbour)) {
                dfsRec(neighbour, visited, order);
            }
        }
    }

    public int locationCount() { return adjacency.size(); }
}
