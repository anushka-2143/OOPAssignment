package courseProject;

public class CityDijkstra implements City <CityDijkstra> {
	private final int city;
	private double distance;
	private CityDijkstra previous;

	public CityDijkstra(int city, double distance, CityDijkstra previous){
		this.city = city;
		this.distance = distance;
		this.previous = previous;
	}
	public int getCity(){
    	return city;
    }
    public double getDistance(){
    	return distance;
    }
    public CityDijkstra getPrevious(){
    	return previous;
    }
    public void setDistance(double d) {
        distance = d;
    }
    public void setPrevious(CityDijkstra p) {
        previous = p;
    }
    @Override
    public int compareTo(CityDijkstra n) {
    	if(this.distance < n.getDistance())
     	   return -1;
     	else if(this.distance > n.getDistance())
     		return 1;
     	else
     		return 0;
    }
}
