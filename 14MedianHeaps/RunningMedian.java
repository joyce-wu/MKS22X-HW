public class RunningMedian{
    MyHeap lessThan, moreThan;
    double median;

    public RunningMedian(){
	lessThan = new MyHeap();
	moreThan = new MyHeap();
    }

    public double getMedian(){
	return median;
    }
    
    public void add(int n){
	if(n < median){
	    lessThan.add(n);
	}else{
	    moreThan.add(n);
	}
	if(lessThan.size() - moreThan.size() == 2){
	    moreThan.add(lessThan.remove());
	}else if(lessThan.size() - moreThan.size() == -2){
	    lessThan.add(moreThan.remove());
	}
	median = lessThan.get(1) + moreThan.get(1) / 2.;
    }

}
