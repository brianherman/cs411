package Project1;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeMap;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;
import aima.core.search.framework.StepCostFunction;
import aima.core.search.framework.GoalTest;

public class FunctionFactory {
	private static ActionsFunction _actionsFunction = null;
	private static ResultFunction _resultFunction = null;
	private static StepCostFunction _stepCostFunction = null;
	private static GoalTest  _GoalStateFunction = null;

	public static ActionsFunction getActionsFunction() {
		if (null == _actionsFunction) {
			_actionsFunction = new EPActionsFunction();
		}
		return _actionsFunction;
	}
	public static GoalTest getGoalTest() {
		if (null == _GoalStateFunction) {
			_GoalStateFunction = new EPGoalTest();
		}
		return _GoalStateFunction;
	}

	public static ResultFunction getResultFunction() {
		if (null == _resultFunction) {
			_resultFunction = new EPResultFunction();
		}
		return _resultFunction;
	}
	public static StepCostFunction getStepCostFunction() {
		if (null == _stepCostFunction) {
			_stepCostFunction = new EPStepCost();
		}
		return _stepCostFunction;
	}
	
	private static class EPGoalTest implements GoalTest {
	public boolean isGoalState(Object gt) {
		 	Puzzle other = new Puzzle((Puzzle)gt);
		 	Puzzle initial = new Puzzle();
		 	if(initial.equals(other))
		 		return true;
		 	return false;
		}
	}
	private static class EPStepCost implements StepCostFunction {

		@Override
		public double c(Object stateFrom, Action a, Object stateTo) {
			double c = 0;
			Puzzle x = new Puzzle((Puzzle) stateFrom);
			Puzzle y = new Puzzle((Puzzle) stateTo);
			switch(a.toString()){
			case ("left"):
				c=1;
			break;
			case ("right"):
				c=1;
			break;
			case ("right2"):
				c=2;
			break;
			case ("left2"):
				c=2;
			break;
			case ("right3"):
				c=3;
			break;
			case ("left3"):
				c=3;
			break;
			}
			return c;
		}
	
	}
	private static class EPActionsFunction implements ActionsFunction {
		@Override
		public Set<Action> actions(Object a) {
			Puzzle board = new Puzzle((Puzzle)a);
			Set<Action> actions = new LinkedHashSet<Action>();
			//enumerate through all possible actions
			int si = getSpaceIndex(board);
			assert(si != -1);
			if(board.canMove(board)){
				actions.add(Puzzle.moveRight);
				actions.add(Puzzle.moveLeft);
				actions.add(Puzzle.moveRight2);
				actions.add(Puzzle.moveLeft2);
				actions.add(Puzzle.moveJumpLeftLeft);
				actions.add(Puzzle.moveJumpRightRight);
				
			}
			return actions;
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
	}
	private static class EPResultFunction implements ResultFunction {
		public int getSpaceIndex(Puzzle board){
			char[] theBoard = board.getBoard();
			int error=-1;
			for(int i=0; i<theBoard.length; i++){
				if(theBoard[i]==' ')
					return i;
			}
			return error;
		}
		public Object result(Object s, Action a) {
			Puzzle b = new Puzzle((Puzzle) s);
			int si = getSpaceIndex(b);
			if(Puzzle.moveRight.equals(a) && Puzzle.canMove(b)){
				Puzzle newBoard = new Puzzle(b);
				newBoard.move(si,si+1);
				return newBoard;
			}
			if(Puzzle.moveLeft.equals(a) &&  Puzzle.canMove(b)){
				Puzzle newBoard = new Puzzle(b);
				newBoard.move(si,si-1);
				return newBoard;
			}
			if(Puzzle.moveRight2.equals(a) &&  Puzzle.canMove(b)){
				Puzzle newBoard = new Puzzle(b);
				newBoard.move(si,si+2);
				return newBoard;
			}
			if(Puzzle.moveLeft2.equals(a) &&  Puzzle.canMove(b)){
				Puzzle newBoard = new Puzzle(b);
				newBoard.move(si,si-2);
				return newBoard;
			}
			if(Puzzle.moveJumpRightRight.equals(a) &&  Puzzle.canMove(b)){
				Puzzle newBoard = new Puzzle(b);
				newBoard.move(si,si+3);
				return newBoard;
			}
			if(Puzzle.moveJumpLeftLeft.equals(a) &&  Puzzle.canMove(b)){
				Puzzle newBoard = new Puzzle(b);
				newBoard.move(si,si-3);
				return newBoard;
			}
			
			return b;
		}
		
	}

	
	
}
