package rcpClient;



import java.lang.reflect.Method;
import java.util.*;

/*
[
    {
        "a": [1,1],
        "b": [2,2],
        "c": [3,3]
    },
    {
        "a": ["b"],
        "b": ["c"]
    },
    "a",
    "c"
]
*/

/**
 * Dijkstra's algorithm - find shortest paths on a graph
 */
import java.util.*;

import HandleService.ReturnObjectArray;
import RpcService.HelloWorldService;
public class myTestDemo{
	
	    /**
	     * @param vertices the graph's vertices and coordinates {"A1": [34,118], "B1": [35,118]}
	     * @param edges the graph's directed edges {"A1": ["A2"], "A2": ["A1"]}
	     * @param start the start vertex
	     * @param goal the goal vertex
	     */
	/*    public List<String> apply(Map<String,Double[]> vertices, Map<String,String[]> edges, String start, String goal) {
	        // Initialize
	        final HashMap<String,Double> shortestDist = new HashMap<String,Double>();
	        final HashMap<String,String> parent = new HashMap<String,String>();
	        final Set<String> closed = new HashSet<String>();
	        final PriorityQueue<String> pq = new PriorityQueue<String>(11, new Comparator<String>() {
	            public int compare(String p1, String p2) {
	                return (int) Math.signum(shortestDist.get(p1) - shortestDist.get(p2));
	            }
	        });
	        shortestDist.put(start, 0.0);
	        pq.add(start);
	        while(!pq.isEmpty()) {
	            String s = pq.poll();
	            closed.add(s);
	            String[] neighbors = edges.get(s);
	            
	            if(neighbors != null) {
	                for(String t : neighbors) {
	                    if(!closed.contains(t)) {
	                        assert shortestDist.containsKey(s);
	                        final double stDist = shortestDist.get(s) + distance(vertices, s,t);
	                        Double d = shortestDist.get(t);
	                        if(d == null) d = Double.POSITIVE_INFINITY;
	                        if(stDist < d) {
	                            pq.remove(t);
	                            shortestDist.put(t, stDist);
	                            pq.add(t);
	                            parent.put(t, s);
	                        }
	                    }
	                }
	            }
	        }

	        //System.out.println("shortestDist = " + shortestDist);
	        //System.out.println("parents = " + parent);
	        
	        // Return the shortest path from src to dest
	        if(parent.containsKey(goal)) {
	            final List<String> path = new ArrayList<String>();
	            String temp = goal;

	            path.add(temp);
	            while(!temp .equals (start)) {
	                temp = parent.get(temp);
	                path.add(0, temp);
	            }
	            return path;
	        } else {
	            return null;
	        }
	    }*/
	
	 public List<List<Integer>> apply(Double[][] adjacencyMatrix) throws Exception
	    {
	        int n = adjacencyMatrix.length;
	        for (int i = 0; i < n; i++)
	            if (adjacencyMatrix[i].length != n)
	                throw new IllegalArgumentException("adjacencyMatrix must be square");
	        
	        // A record of the next vertex in any path. Initially, all paths are direct.
	        int[][] nextVertices = new int[n][n];
	        for (int i = 0; i < n; i++)
	            for (int j = 0; j < n; j++)
	                nextVertices[i][j] = j;
	        
	        // A temporary matrix used in each step of Floyd--Warshall.
	        Double[][] newMatrix = new Double[n][n];
	        
	        for (int k = 0; k < n; k++) {
	            // Potentially shorten all i,j-paths by allowing them shortcuts via vertex k.
	            for (int j = 0; j < n; j++) {
	                for (int i = j; i < n; i++) { // Start with i=j to avoid problematic extra relaxations.
	                    Double oldDist = adjacencyMatrix[i][j];
	                    
	                    Double newDist = adjacencyMatrix[i][k] + adjacencyMatrix[k][j];
	                    if (newDist < oldDist) {
	                        newMatrix[i][j] = newDist;
	                        nextVertices[i][j] = nextVertices[i][k]; // To go from i to j, we first visit k.
	                    }
	                    else {
	                        newMatrix[i][j] = oldDist;
	                    }
	                  
	                 
	                }
	            }
	            Double[][] temp = adjacencyMatrix;
	            adjacencyMatrix = newMatrix;
	            newMatrix = temp;
	        }
	        
	        // Find and record negative-weight cycles.
	        List<List<Integer>> cycles = new LinkedList<List<Integer>>();
	        boolean[] visited = new boolean[n]; // Keep track of vertices that have been seen already.
	        
	        for (int i = 0; i < n; i++) {
	            if (adjacencyMatrix[i][i] >= 0) continue; // No negative-weight cycles with this vertex.
	            
	            List<Integer> path = new LinkedList<Integer>();
	            visited[i] = true;
	            path.add(i);
	            // Walk back around to the starting vertex, building up the path.
	            int current = nextVertices[i][i];
	            while (!visited[current] && current != i) {
	                visited[current] = true;
	                path.add(current);
	                current = nextVertices[current][i];
	            }
	            if (current != i) continue; // Bumped into an already-visited vertex.
	            path.add(i);
	            
	            cycles.add(path);
	        }
	        
	        return cycles;
	    }

	    // Euclidean distance
	    double distance(Map<String,Double[]> vertices, String s, String t) {
	        Double[] pt1 = vertices.get(s);
	        Double[] pt2 = vertices.get(t);
	        double deltaX = pt1[0] - pt2[0];
	        double deltaY = pt1[1] - pt2[1];
	        return deltaX * deltaX + deltaY * deltaY;
	    }
	    
	    String array(int[]a,String[]b,double[]c,int d,String f){
	    	return "nihao wode xingan";
	    }
	    
	    public static void main(String args[]) throws Exception  {
	    	HelloWorldService hh=new HelloWorldService();
	    	String json="[[[0,-1,9],[9,0,-1],[-1,0,9]]]";
	    	hh.invokeMethod("Raynarong.NegativeWeightCycles.NegativeWeightCycles", json);
	    	myTestDemo demo=new myTestDemo();
	    	Class ownerClass=demo.getClass();
	    	   Object a=new Object();
	    	   Double ddd=5.0;
	    	    
	    	    	try{
	    	       	Method[] methods=ownerClass.getDeclaredMethods();
	    	       	Object result;
	    	       	for(Method method: methods){
	    	       		if(method.getName()=="apply"){

	    	         		Class[]types=method.getParameterTypes();  

	    	       		Object[] arg=ReturnObjectArray.getDTOArray("Raynarong.NegativeWeightCycles.NegativeWeightCycles",json);
	    	       		  System.out.println("classtype:"+types[0].getSimpleName());
	    	       		  System.out.println("argsType:"+arg[0].getClass());
	    	       		  System.out.println("doubleType:"+Double[][].class);
	    	       		  a=method.invoke(demo, arg);   
	    	       		 System.out.println("返回值为："+a);
	    	       		}
	    	       	}    
	    	       	 
	    	       	
	    	       }catch (Exception e) {
	    	           e.printStackTrace();
	    	       }
	    			      
	    	    
	    	
	    }

	}



