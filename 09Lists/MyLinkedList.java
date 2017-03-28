public class MyLinkedList{
    LNode start;
    int size;

    public MyLinkedList(){
	start = null;
	size = 0;
    }
    
    public boolean add(int value){
	LNode current = start;
	for(int i = 0; i < size; i++){
	    current = current.next;
	}
	LNode a = new LNode(value);
	current.next = a;
	size++;
	return true;
    }

    public int size(){
	return size;
    }

    public int get(int index){
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
	}
	String ans = "[";
	LNode current = start;
	ans += current.value + ", ";
	for(int i = 0; i < size-1; i++){
	    current = current.next;
	    ans += current.value + ", "; 
	}
	current = current.next;
	ans += current.value + "]";
	return ans;
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
}
