package courseProject;


public interface City<T> extends Comparable<T> {
	int getCity();
	void setPrevious(T p);
	T getPrevious();	
}

