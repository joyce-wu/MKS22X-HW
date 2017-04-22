public class MyDeque{
    String[] ary;
    int size;
    int front, back;
    
    public MyDeque(){
	ary = new String[10];
    }

    private void resize(){
	String[] newAry = new String[size*2];
	for(int i = 0; i < ary.length; i++){
	    newAry[i] = ary[i];
	}
	ary = newAry;
	size *= 2;
    }

    public void addFirst(String s){
	if(s.equals(null)){
	    throw new NullPointerException();
	}if(size == ary.length){
	    resize();
	}else if(front == 0){
	    ary[ary.length-1] = s;
	    front = ary.length-1;
	}else{
	    ary[front-1] = s;
	    front -= 1;
	}
	size++;
    }

    public void addLast(String s){
	if(s.equals(null)){
	    throw new NullPointerException();
	}if(size == ary.length){
	    resize();
	}else if(back == ary.length-1){
	    ary[0] == s;
	    back = 0;
	}else{
	    ary[back+1] = s;
	    back -= 1;
	}
	size++;
    }

    public String removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	String org = ary[front];
	if(front == ary.length-1){
	    front = 0;
	}else{
	    front += 1;
	}
	size--;
	return org;
    }

    public String removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	String org = ary[back];
	if(back == 0){
	    back = ary.length-1;
	}else{
	    back -= 1;
	}
	size--;
	return org;
    }

    public String getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return ary[front];
    }

    public String getLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return ary[back];
    }
}
