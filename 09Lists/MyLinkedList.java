public class MyLinkedList{
    LNode start;
    int size;

    public MyLinkedList(){
	start = null;
	size = 0;
    }
    
    public boolean add(int value){
	if(size == 0){
	    start = new LNode(value);
	}else{
	    LNode current = start;
	    for(int i = 0; i < size-1; i++){
		current = current.next;
	    }
	    LNode a = new LNode(value);
	    current.next = a;
	}
	size++;
	return true;
    }

    public int size(){
	return size;
    }

    public int get(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	LNode current = start;
	for(int i = 0; i < size; i++){
	    if(i == index){
		return current.value;
	    }else{
		current = current.next;
	    }
	}
	return -1;
    }

    public int set(int index, int newValue){
	LNode current = start;
	int oldValue = get(index);
	for(int i = 0; i < size; i++){
	    if(i == index){
		current.value = newValue;
	    }else{
		current = current.next;
	    }
	}
	return oldValue;
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
    	if(index == 0){
    	    LNode old = start;
    	    start.value = value;
    	    start.next = old;
	    
    	}
    	LNode current = start;
    	for(int i = 0; i < size; i++){
    	    if(i == index-1){
		LNode old = current;
		current = current.next;
		LNode newL = new LNode(value);
		old.next = newL;
		newL.next = current;		
    	    }
	}
    }

    public int remove(int index){
	if(index == 0){
	    int oldVal = start.value;
	    LNode nextL = start.next;
	    start.value = nextL.value;
	    start.next = nextL.next;
	    size--;
	}else{
	    LNode current = start;
	    for(int i = 0; i < size; i++){
		if(i == index-1){
		    LNode oldL = current;
		    int oldVal = current.next.value;
		    current = current.next.next;
		    oldL.next = current;
		}
	    }
	}
	return oldVal;		    
    }

    public class LNode{
	int value;
	LNode next;
	public LNode(int val){
	    value = val;
	    next = null;
	}
	public LNode(int val, LNode node){
	    value = val;
	    next = node;
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
