import java.util.*;

public class MyLinkedList implements Iterable<Integer>{
    LNode start, tail;
    int size;

    public class LinkedListIterator implements Iterator<Integer>{
	private MyLinkedList list;
	private int index;

	public LinkedListIterator(MyLinkedList list){
	    this.list = list;
	}
	public boolean hasNext(){
	    return index < list.size();
	}
	public Integer next(){
	    if(hasNext()){
		index++;
		return list.get(index-1);
	    }else{
		throw new NoSuchElementException();
	    }
	}
	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }
    
    public MyLinkedList(){
    }
    
    public int size(){
	return size;
    }

    public Iterator<Integer> iterator(){
	return new LinkedListIterator(this);
    }

    private LNode getNthNode(int n){
	if(n < 0 || n >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode current = start;
	for(int i = 0; i<size(); i++){
	    if(n == i){
		return current;
	    }else{
		current = current.next;
	    }
	}
	return start;
    }
    
    private void addAfter(LNode location, LNode toBeAdded){
	if(location == tail){
	    tail.next = toBeAdded;
	    toBeAdded.prev = tail;
	    tail = toBeAdded;
	}else{
	    toBeAdded.next = location.next;
	    toBeAdded.prev = location;
	    toBeAdded.next.prev = toBeAdded;
	    location.next = toBeAdded;
	}
    }
    
    public void remove(LNode target){
	if(start == target){
	    start = start.next;
	    start.prev = null;
	}else if(tail == target){
	    tail = tail.prev;
	    tail.next = null;
	}else{
	    target.prev.next = target.next;
	    target.next.prev = target.prev;
	}
	size--;
    }
    
    public String toString(){
	if(size == 0){
	    return "[]";
	}if(size == 1){
	    return "[" + start.value + "]";
	}
	String ans = "[";
	LNode current = start;
	ans += current.value + ", ";
	for(int i = 0; i < size-2; i++){
	    current = current.next;
	    ans += current.value + ", "; 
	}
	current = current.next;
	ans += current.value + "]";
     	return ans;
    }
        
    public boolean add(int value){
	add(size, value);
	return true;
    }
    
    public int get(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	return getNthNode(index).value;
    }

    public int set(int index, int newValue){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	int old = getNthNode(index).value;
	getNthNode(index).value = newValue;
	return old;
    }
    
    public int indexOf(int value){
	LNode current = start;
	for(int i = 0; i < size; i++){
	    if(current.value == value){
		return i;
	    }else{
		current = current.next;
	    }
	}
	return -1;
    }

    public void add(int index, int value){
	if(index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	LNode newL = new LNode(value);
	if(index == 0){
	    if(size == 0){
		start = newL;
		tail = newL;
	    }else{
		newL.next = start;
		start.prev = newL;
		start = newL;
	    }
	}else if(index == size()){
	    addAfter(tail, newL);
	}else{
	    addAfter(getNthNode(index-1), newL);	    
	}
	size++;
    }

    public int remove(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	int value = get(index);
	remove(getNthNode(index));
	return value;
    }

    public String toStringDebug(){
	if(size == 0){
	    return "[]";
	}if(size == 1){
	    return "[(null)" + start.value + "(null)]";
	}
	String ans = "[";
	LNode current = start;
	ans += "(null)" + start.value + "(" + start.next.value + "), ";
	for(int i = 0; i < size-2; i++){
	    current = current.next;
	    ans += "(" + current.prev.value + ")" + current.value + "(" + current.next.value + "), ";
	}
	current = current.next;
	ans += "(" + current.prev.value + ")" + current.value + "(null)]";
	return ans;
    }

    private class LNode{
	int value;
	LNode next,prev;
	
	public LNode(int val){
	    value = val;
	}
	public String toString(){
	    return value+" ";
	}
    }

    public static void main(String[] args){
	MyLinkedList hi = new MyLinkedList();
	System.out.println(hi.toStringDebug());
	hi.add(7);
	hi.add(10);
	hi.add(-2);
	hi.add(1000000);
	hi.add(222);
	hi.add(4);
	hi.add(20001);
	hi.add(20001);
	System.out.println(hi.toString());
	for(int hello:hi){
	    System.out.println(hello);
	}
    }
}
