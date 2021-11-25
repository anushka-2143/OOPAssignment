package courseProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Dijkstra extends ShortestPathAlgorithm <CityDijkstra>{
	
	public Dijkstra(int city1, int city2, int n, int graph[][]){
		super(city2, n, graph);
		CityDijkstra source = new CityDijkstra(city1,0,null);
		cityObject.put(city1,source);
		queue.add(source);
	}      
	
    //finalResult will be called in the driver class
	public void finalResult(int city1, int city2) {
		CityDijkstra city = this.compute(city1, city2);
		if(city == null) {
			System.out.println("All reachable nodes were visited but the target was not found");
		}else {
			this.shortestDistAndPath(city1, city2,city);
		}
	}
	
	public List<Integer> getPath(CityDijkstra city){
		List<Integer> path = new ArrayList<>();
		while (city != null) {    
			path.add(city.getCity());
			city = city.getPrevious();
		}
		Collections.reverse(path);
		return path;
	}
	
	public void shortestDistAndPath(int city1, int city2,CityDijkstra city) {
		System.out.println("the shortest Distance calculated using Dijkstra Algorithm between city "+ city1+" and city "+ city2+" is :"+ city.getDistance());
		System.out.println("the shortest path computed using Dijkstra Algorithm between city "+ city1+" and city "+ city2+" is :"+ this.getPath(city) );
		
	}
	
	public CityDijkstra compute(int city1, int city2) {
		 while(!queue.isEmpty()) {
			 CityDijkstra presentNode = queue.poll();   
		     Integer city = presentNode.getCity();     
			 shortestPathFound.add(city); 
			 if(checkTarget(city)) { 
				 return presentNode;
			 }
			   
			 List<Integer> neighbors = new ArrayList<Integer>();
			 for(int i =0; i < totalCities;i++) {
				 if (graph[city][i] != -1) 
					 neighbors.add(i);
				 
			 }
			 for(int neighbor : neighbors) {
				 
				 if(shortestPathFound.contains(neighbor))
					 continue;
				 
				 //else calculate the shortest distance 
				 double totalDistance = graph[city][neighbor] + presentNode.getDistance();
				 
				 //check if the object of neighbor node already exist or not 
				 CityDijkstra adjacentCity = cityObject.get(neighbor);
				 if(adjacentCity == null) {
					 adjacentCity = new CityDijkstra(neighbor,totalDistance, presentNode);
					 cityObject.put(neighbor,adjacentCity);
					 queue.add(adjacentCity);
				 }
				 //if neighbor do exist then update the shortest distance
				 else if (totalDistance < adjacentCity.getDistance() ){  
					 queue.remove(adjacentCity);         					 
					 adjacentCity.setDistance(totalDistance);
					 adjacentCity.setPrevious(presentNode);
					 queue.add(adjacentCity);
				 }
			 }
		      
		   }
		 return null;
		}
		 
}
 