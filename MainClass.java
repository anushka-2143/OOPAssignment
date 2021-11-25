package courseProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try{
					int city1, city2;
					Scanner sc= new Scanner(System.in);
			        int totalCities=sc.nextInt(); //user will enter total number of cities
			        
			        int totalSecondInputs= sc.nextInt();  //user need to enter distance between how many cities the user will enter
			        
			        int graph[][]= new int[totalCities][totalCities];
			        for (int[] row : graph)
			            Arrays.fill(row, -1);
			        
			        for(int i=0; i<totalSecondInputs; i++){
			           city1= sc.nextInt();
			           city2= sc.nextInt();
			           graph[city1][city2]= sc.nextInt();
			          
			        }
			        HashMap<Integer, List<Integer>> coordinates= new HashMap<Integer, List<Integer>>(); //the coordinates of the cities will be stored in this HashMap
			        
			        for(int k=0; k<totalCities; k++){
			            int cityName= sc.nextInt();
			            List<Integer> arr = new ArrayList<Integer>();
			            arr.add(sc.nextInt());
			            arr.add(sc.nextInt());
			            coordinates.put(cityName, arr);
			     }
			        
			        int source= sc.nextInt();
			        int target= sc.nextInt();
			       
			        System.out.println("DIJKSTRA ALGORITHM RESULT");
			        Dijkstra dijkstraDistance = new Dijkstra(source, target, totalCities, graph);
			        dijkstraDistance.finalResult(source, target);
			        System.out.println("\n--------------------------------------------------------------\n\nASTAR ALGORITHM RESULT");
			        AStar aStarDistance= new AStar(source, target, totalCities, graph, coordinates);
			        aStarDistance.finalResult(source, target);
			        sc.close();
				}   
				catch (Exception e){
					System.out.println("Exception thrown:\n" + e);
					System.out.println("Stack Trace:\n");
					e.printStackTrace();
				}
				
	}

}

/*
TEST CASE 1

7
8
0 1 4
0 2 3
1 5 5 
2 3 7
2 4 10
3 4 2
4 6 5
5 6 16
0 0 0
1 2 1
2 3 1
3 7 2
4 10 2
5 4 0
6 12 5
0 6

CORRECT ANS : 17 and {0,2,3,4,6}
*/
