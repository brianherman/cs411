package Project1;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

public class Puzzle {
	public static Action moveLeft = new DynamicAction("left");
	public static Action moveLeft2 = new DynamicAction("left2");
	public static Action moveRight = new DynamicAction("right");
	public static Action moveRight2 = new DynamicAction("right2");

	public static Action moveJumpLeftLeft = new DynamicAction("left3");
	public static Action moveJumpRightRight = new DynamicAction("right3");;

	 char [] state = new char[7];
	public Puzzle() {
		state[0]='W';
		state[1]='W';
		state[2]='W';
		state[3]=' ';
		state[4]='B';
		state[5]='B';
		state[6]='B';
	}

	public Puzzle(char[] initalState) {
		setBoard(initalState);
	}

	public Puzzle(Puzzle b) {
		setBoard(b.state);
	}

	public boolean move(int index, int move) {
		
		if (move == -1) {
			return swap(index, index - 1);
		}
		if (move == -2) {
			return swap(index,index - 2);
		} else if (move == 2) {
			return swap(index,index+ 2);
		} else if (move == 3) {
			return swap(index, index+3);
		}
		if (move == -1) {
			return swap(index,index - 1);
		} else if (move == -2) {
			return swap(index,index - 2);
		} else if (move == -3) {
			return swap(index,index + 3);
		}
		return false;
	}

	private boolean swap(int initial, int destination) {		
		if (destination < 0) {
			return false;
		} else if (destination > state.length - 1) {
			return false;
		}
		char temp = ' ';
		temp = state[initial];
		state[initial] = state[destination];
		state[destination] = temp;
		return true;
	}
	public int getSpaceIndex(Puzzle board){
		char[] theBoard = board.getBoard();
		int error=-1;
		for(int i=0; i<theBoard.length; i++){
			if(theBoard[i]==' ')
				return i;
		}
		return error;
	}

	public static boolean canMove(Puzzle p){
		System.out.println(p.toString());
	    String re1="(.)";	
	    String re2="(.)";	
	    String re3="(.)";	
	    String re4=".*?";	
	    String re5=".";	
	    String re6=".*?";
	    String re7="(.)";	
	    String re8="(.)";	
	    String re9="(.)";
	    // BASICALLY THIS IS A MATRIX OF REGULAR EXPRESSSIONS
	    Pattern p1 = Pattern.compile(re5+re2+re3+re4+re1+re6+re7+re8+re9,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Pattern p2 = Pattern.compile(re1+re5+re3+re4+re2+re6+re7+re8+re9,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Pattern p3 = Pattern.compile(re1+re2+re5+re4+re3+re6+re7+re8+re9,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Pattern p4 = Pattern.compile(re1+re2+re3+re5+re4+re6+re7+re8+re9,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Pattern p5 = Pattern.compile(re1+re2+re3+re4+re5+re6+re7+re8+re9,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Pattern p6 = Pattern.compile(re1+re2+re3+re4+re6+re5+re7+re8+re9,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Pattern p7 = Pattern.compile(re1+re2+re3+re4+re7+re6+re5+re8+re9,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Pattern p8 = Pattern.compile(re1+re2+re3+re4+re8+re6+re7+re5+re9,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Pattern p9 = Pattern.compile(re1+re2+re3+re4+re9+re6+re7+re8+re5,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    char[] s =  p.getBoard();
	    String m = s.toString();
	    System.out.println(m);
	    Matcher m1 = p1.matcher(m);
	    Matcher m2 = p2.matcher(m);
	    Matcher m3 = p3.matcher(m);
	    Matcher m4 = p4.matcher(m);
	    Matcher m5 = p5.matcher(m);
	    Matcher m6 = p6.matcher(m);
	    Matcher m7 = p7.matcher(m);
	    Matcher m8 = p8.matcher(m);
	    Matcher m9 = p9.matcher(m);

	    if(m1.matches() && m2.matches() &&m3.matches()&&m4.matches()&&m5.matches()&&m6.matches()&&m7.matches()&&m8.matches()&&m9.matches())
	    	return true;	    	
	    return false;

	}	
	
	@Override
	public boolean equals(Object obj) {
		if(!obj.toString().equals(state.toString()))
	    	return false;
	    return true;

	}

	public char[] getBoard() {
		return state;
	}

	void setBoard(char[] board) {
		state = board;
	}
	@Override
	public String toString() {
		return new String(state);
	}


}


