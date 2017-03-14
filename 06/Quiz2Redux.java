import java.util.ArrayList;

public class Quiz2Redux{
    public static ArrayList<String> combinations(String s){
	ArrayList<String> words = new ArrayList<String>();
	combinationH(s, words, 0, "");
	return words;
    }

    public static void combinationH(String s, ArrayList<String> words, int index, String currentS){
	if(index >= s.length()){
	    words.add(currentS);
	    return;
	}
	combinationH(s, words, index+1, currentS);
	combinationH(s, words, index+1, currentS + s.substring(index, index+1));
    }

    public static void main(String[] args){
	System.out.println(Quiz2Redux.combinations("abc"));
	System.out.println(Quiz2Redux.combinations("xfewfaiwofklg"));
    }
}
