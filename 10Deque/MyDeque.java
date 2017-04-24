import java.util.*;

public class MyDeque{
    String[] ary;
    int size;
    int front, back;
    
    public MyDeque(){
	ary = new String[10];
	size = 0;
    }

    private void resize(){
	String[] newAry = new String[size*2];
	for(int i = 0, j = front; j < size+front; j++, i++){
	    newAry[i] = ary[j % ary.length];
	}
	ary = newAry;
	front = 0;
	back = size-1;
    }

    public void addFirst(String s){
	if(s == null){
	    throw new NullPointerException();
	}if(size == ary.length){
	    resize();
	}if(size == 0){
	    ary[0] = s;
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
	if(s == null){
	    throw new NullPointerException();
	}if(size == ary.length){
	    resize();
	}if(size != 0){
	    back = (back+1) % ary.length;
	}
	ary[back] = s;
	size++;
    }

    public String removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	String org = ary[front];
	front = (front + 1) % ary.length;
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

    public String toString(){
	String ans = "[";
	for(int i = 0; i < ary.length-1; i++){
	    ans += ary[i] + ", ";
	}
	ans += ary[ary.length-1] + "]";
	return ans;
    }
    
}
