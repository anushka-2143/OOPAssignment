package courseProject;

class CityAStar implements City<CityAStar>{
    private final int city;
	private double totalCostSum;//f
	private double totalDistFromStart; //g
	private final double minimumDistToTarget;//h
//f = g+h
private CityAStar previous;

public CityAStar(int city, double h ,double g, CityAStar previous){
	this.city = city;
	this.minimumDistToTarget = h;
	this.totalDistFromStart = g;
	this.previous = previous;
	totalCostSum = totalDistFromStart + minimumDistToTarget;
}
public int getCity(){
	return city;
}
public double getTotalCostSum(){
	return totalCostSum;
}
public CityAStar getPrevious(){
	return previous;
}
public double getMinimumDistToTarget(){
	return minimumDistToTarget;
}
public double getTotalDistFromStart(){
	return totalDistFromStart;
}
public void setTotalDistFromStart(double totalDistFromStart) {
    this.totalDistFromStart = totalDistFromStart;
}
public void setTotalCostSum(double totalCostSum) {
    this.totalCostSum = totalCostSum;
}
public void setPrevious(CityAStar p) {
    previous = p;
}
@Override
public int compareTo(CityAStar n) {
	if(this.totalCostSum < n.getTotalCostSum())
	   return -1;
	else if(this.totalCostSum > n.getTotalCostSum())
		return 1;
	else
		return 0;
}
}