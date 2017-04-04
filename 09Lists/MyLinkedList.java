public class MyLinkedList{
    LNode start;
    LNode tail;
    int size;

    public MyLinkedList(){
	start = null;
	tail = null;
	size = 0;
    }

    private LNode getNthNode(int n){
	if(n < 0 || n >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode current = start;
	for(int i = 0; i<size-1; i++){
	    if(n == i){
		return current;
	    }else{
		current = current.next;
	    }
	}
    }

    private void addAfter(LNode location, LNode toBeAdded){
	if(location == tail){
	    add(toBeAdded.value);
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
	    target.prev.next = x.next;
	    target.next.prev = target.prev;
	}
    }
    
    public boolean add(int value){
	add(size, value);
	return true;
    }

    public int size(){
	return size;
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
	LNode newL = new LNode(value);
	if(index == 0){
	    newL.next = start;
	    start.prev = newL;
	    start = newL;
    	}else if(index == size()){
	}else{
	    LNode current = getNthNode(index);
	    
	}
    }

    public int remove(int index){
	remove(getNode(index));
    }

    public class LNode{
	int value;
	LNode next;
	LNode prev;
	
	public LNode(int val){
	    value = val;
	    next = null;
	    prev = null;
	}
	public LNode(int val, LNode node){
	    value = val;
	    next = node;
	    prev = null;
	}
    }

    public static void main(String[] args){
	MyLinkedList hi = new MyLinkedList();
	hi.add(7);
	hi.add(10);
	hi.add(11);
	for(int i = 0; i<15; i++){
	    hi.add(i);
       }
       System.out.println(hi.indexOf(10));
       System.out.println(hi.toString());
   }
}
