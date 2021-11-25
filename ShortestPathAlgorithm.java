package courseProject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public abstract class ShortestPathAlgorithm<T> {
	PriorityQueue<T> queue = new PriorityQueue<>();
	//for parent
	Map<Integer,T> cityObject = new HashMap<>();
	//checking 
	Set<Integer> shortestPathFound = new HashSet<>();
	//target city
	int target;
	//first input
	int totalCities;
	//graph for saving cities
	int graph[][];
	
	
	public ShortestPathAlgorithm(int city2, int n, int g[][]){
		target = city2;
        totalCities = n;
        this.graph = g;
	}	
	
	public Boolean checkTarget(int city) {
		if(city == target)
			return true;
		else
			return false;
	}
	
	abstract public List<Integer> getPath(T city);

    abstract public void shortestDistAndPath(int city1, int city2, T city);
    abstract public T compute(int city1, int city2);
    
    abstract public void finalResult(int city1, int city2);
}
