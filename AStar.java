package courseProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class AStar extends ShortestPathAlgorithm <CityAStar>{
	//for saving coordinates
	HashMap <Integer, List<Integer>> xAndYCoordinates = new HashMap <Integer, List<Integer>>();
	
	public AStar(int city1, int city2, int n, int graph[][],HashMap <Integer, List<Integer>>coordinates){
		super(city2, n, graph);
		xAndYCoordinates = coordinates;
		CityAStar source = new CityAStar(city1,this.calculateHeuristic(city1,city2),0.0,null);//g for source is 0 
        cityObject.put(city1,source);
        queue.add(source);
       
	}
	
	//finalResult will be called in the driver class
		public void finalResult(int city1, int city2) {
			CityAStar city = this.compute(city1, city2);
			if(city == null) {
				System.out.println("All reachable nodes were visited but the target was not found!");
			}else {
				this.shortestDistAndPath(city1, city2,city);
			}
		}
		
		public List<Integer> getPath(CityAStar city){
			List<Integer> path = new ArrayList<>();
			while (city != null) {
				path.add(city.getCity());
				city = city.getPrevious();
			}
			Collections.reverse(path);
			return path;
		}
		
		public void shortestDistAndPath(int city1, int city2,CityAStar city) {
			System.out.println("the shortest Distance calculated using AStar Algorithm between city "+ city1+" and city "+ city2+" is :"+ city.getTotalCostSum());
			System.out.println("the shortest path computed using AStar Algorithm between city "+ city1+" and city "+ city2+" is :"+ this.getPath(city) );
				
		}
		
		public double calculateHeuristic(int source, int target) {
			List<Integer> sourceCoordinates = xAndYCoordinates.get(source);
			List<Integer> targetCoordinates = xAndYCoordinates.get(target);
	        double distanceX = sourceCoordinates.get(0) - targetCoordinates.get(0);
	        double distanceY = sourceCoordinates.get(1) - targetCoordinates.get(1);
	        return Math.sqrt((distanceX * distanceX) + (distanceY * distanceY)); 
	    }
		
		public CityAStar compute(int city1, int city2) {
	        while(!queue.isEmpty()) {
	        	
	        	CityAStar presentNode = queue.poll();
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
	             
	             //else calculate the g,h,f values
	             //check if the object of neighbor node already exist or not 
	             
	             CityAStar adjacentCity = cityObject.get(neighbor);
	             double distFromStart = graph[city][neighbor] + presentNode.getTotalDistFromStart();
	             double heuristic = this.calculateHeuristic(neighbor,city2);
	             double totalCost = distFromStart + heuristic;
	             if(adjacentCity == null) {
	                 adjacentCity = new CityAStar(neighbor,heuristic,distFromStart, presentNode);
	                 cityObject.put(neighbor,adjacentCity);
	                 queue.add(adjacentCity);
	             }
	             //if neighbor do exist then update the shortest distance
	             else if ((distFromStart < adjacentCity.getTotalDistFromStart()) && (adjacentCity != null)){
	            	 queue.remove(adjacentCity);
	                 adjacentCity.setTotalCostSum(totalCost);
	                 adjacentCity.setTotalDistFromStart(distFromStart);
	                 adjacentCity.setPrevious(presentNode);
	                 queue.add(adjacentCity);
	             }
	         } 
	   		    
	       }
	        return null;
	   }
	
}