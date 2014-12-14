package Project2;
import java.util.Arrays;
import java.util.Random;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

import java.util.Date;

public class puzzle {
	public static Action moveLeft0 = new DynamicAction("left0");
	public static Action moveLeft20 = new DynamicAction("left20");	
	public static Action moveRight0 = new DynamicAction("right0");	
	public static Action moveRight20 = new DynamicAction("right20");	

	public static Action moveLeft1 = new DynamicAction("left1");
	public static Action moveLeft21 = new DynamicAction("left21");	
	public static Action moveRight1 = new DynamicAction("right1");	
	public static Action moveRight21 = new DynamicAction("right21");	

	public static Action moveLeft2 = new DynamicAction("left2");
	public static Action moveLeft22 = new DynamicAction("left22");	
	public static Action moveRight2 = new DynamicAction("right2");	
	public static Action moveRight22 = new DynamicAction("right22");	

	public static Action moveLeft3 = new DynamicAction("left3");
	public static Action moveLeft23 = new DynamicAction("left23");	
	public static Action moveRight3 = new DynamicAction("right3");	
	public static Action moveRight23 = new DynamicAction("right23");	

	public static Action moveLeft4 = new DynamicAction("left4");
	public static Action moveLeft24 = new DynamicAction("left24");	
	public static Action moveRight4 = new DynamicAction("right4");	
	public static Action moveRight24 = new DynamicAction("right24");	

	public static Action moveLeft5 = new DynamicAction("left5");
	public static Action moveLeft25 = new DynamicAction("left25");	
	public static Action moveRight5 = new DynamicAction("right5");	
	public static Action moveRight25 = new DynamicAction("right25");	

	public static Action moveLeft6 = new DynamicAction("left6");
	public static Action moveLeft26 = new DynamicAction("left26");	
	public static Action moveRight6 = new DynamicAction("right6");	
	public static Action moveRight26 = new DynamicAction("right26");	

	public static Action moveLeft7 = new DynamicAction("left7");
	public static Action moveLeft27 = new DynamicAction("left27");	
	public static Action moveRight7 = new DynamicAction("right7");	
	public static Action moveRight27 = new DynamicAction("right27");	

	public static Action moveLeft8 = new DynamicAction("left8");
	public static Action moveLeft28 = new DynamicAction("left28");	
	public static Action moveRight8 = new DynamicAction("right8");	
	public static Action moveRight28 = new DynamicAction("right28");
	
	private char[] state;
	
	int Cost;
	//generate a random board
	public puzzle(){
		Random rnd = new Random();
	    long seed = new Date().getTime();
		rnd.setSeed(seed);
		Cost=0;
	}
	public puzzle(char[] initalState){
		setBoard(initalState);
		Cost=0;
	}
	public puzzle(puzzle b){
		state=b.state;
	}
	public void move(int index, int move){
		int modifier = 0;
		if(move == -2){
			swap(index,index-2);
			modifier = 2;
		}else if(move == 2){
			swap(index, index+2);
			modifier = 2;
		}
		if(move == -1){
			swap(index,index-1);
			modifier = 1;
		}else if(move == 1){
			swap(index, index+1);
			modifier = 1;
		}
		Cost++;
		Cost+=modifier;
		System.out.println(state);
	}
	public int getCost() {
		return Cost;
	}
	public void resetCost(int cost) {
		Cost = 0;
	}
	private boolean swap(int initial, int destination){
		//System.out.println(state);
		if(destination < 0) {
			return false;
		}else if(destination > state.length-1){
			return false;
		}
		//System.out.println("Swapping");
		char temp = ' ';
		temp = state[initial];
		state[initial] = state[destination];
		state[destination] = temp;
		return true;
	}
	public boolean canMove(int intial, int destination){
		if(destination < 0) {
			return false;
		}else if(destination > state.length-1){
			return false;
		}
		return true;
	}
	@Override
	public int hashCode() {
		int result = 17;
		for (int i = 0; i < 8; i++) {
			int position = state[i];
			result = 37 * result + position;
		}
		return result;
	}

	public char[] getBoard() {
		return state;
	}
	private void setBoard(char[] board) {
		state = board;
	}
	@Override
	public String toString() {
		return new String(state);
	}


	public boolean isGoal(){
		char [] solved = {'B', 'B', 'B',' ',' ',' ','R','R','R'};
		if(Arrays.equals(solved,state))
			return true;
		return false;
	}
	
}