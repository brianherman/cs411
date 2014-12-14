package Project2;
import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;

public class SF {
	private static ActionsFunction _actionsFunction = null;
	private static ResultFunction _resultFunction = null;

	public static ActionsFunction getActionsFunction() {
		if (null == _actionsFunction) {
			_actionsFunction = new EPActionsFunction();
		}
		return _actionsFunction;
	}

	public static ResultFunction getResultFunction() {
		if (null == _resultFunction) {
			_resultFunction = new EPResultFunction();
		}
		return _resultFunction;
	}

	private static class EPActionsFunction implements ActionsFunction {
		@Override
		public Set<Action> actions(Object a) {
			puzzle board = (puzzle)a;
			Set<Action> actions = new LinkedHashSet<Action>();
			//enumerate through all possible actions
			if(board.canMove(0,1)){
				actions.add(puzzle.moveRight0);
			}
			if(board.canMove(0,-1)){
				actions.add(puzzle.moveLeft0);
			}if(board.canMove(0,2)){
				actions.add(puzzle.moveRight20);
			}
			if(board.canMove(0,-2)){
				actions.add(puzzle.moveLeft20);
			}
			if(board.canMove(1,1)){
				actions.add(puzzle.moveRight1);
			}
			if(board.canMove(1,-1)){
				actions.add(puzzle.moveLeft1);
			}if(board.canMove(1,2)){
				actions.add(puzzle.moveRight21);
			}
			if(board.canMove(1,-2)){
				actions.add(puzzle.moveLeft21);
			}
			if(board.canMove(2,1)){
				actions.add(puzzle.moveRight2);
			}
			if(board.canMove(2,-1)){
				actions.add(puzzle.moveLeft2);
			}if(board.canMove(2,2)){
				actions.add(puzzle.moveRight22);
			}
			if(board.canMove(2,-2)){
				actions.add(puzzle.moveLeft22);
			}
			if(board.canMove(3,1)){
				actions.add(puzzle.moveRight3);
			}
			if(board.canMove(3,-1)){
				actions.add(puzzle.moveLeft3);
			}if(board.canMove(3,2)){
				actions.add(puzzle.moveRight23);
			}
			if(board.canMove(3,-2)){
				actions.add(puzzle.moveLeft23);
			}
			if(board.canMove(4,1)){
				actions.add(puzzle.moveRight4);
			}
			if(board.canMove(4,-1)){
				actions.add(puzzle.moveLeft4);
			}if(board.canMove(4,2)){
				actions.add(puzzle.moveRight24);
			}
			if(board.canMove(4,-2)){
				actions.add(puzzle.moveLeft24);
			}
			if(board.canMove(5,1)){
				actions.add(puzzle.moveRight5);
			}
			if(board.canMove(5,-1)){
				actions.add(puzzle.moveLeft5);
			}if(board.canMove(5,2)){
				actions.add(puzzle.moveRight25);
			}
			if(board.canMove(5,-2)){
				actions.add(puzzle.moveLeft25);
			}
			if(board.canMove(6,1)){
				actions.add(puzzle.moveRight6);
			}
			if(board.canMove(6,-1)){
				actions.add(puzzle.moveLeft6);
			}if(board.canMove(6,2)){
				actions.add(puzzle.moveRight26);
			}
			if(board.canMove(6,-2)){
				actions.add(puzzle.moveLeft26);
			}
			if(board.canMove(7,1)){
				actions.add(puzzle.moveRight7);
			}
			if(board.canMove(7,-1)){
				actions.add(puzzle.moveLeft7);
			}if(board.canMove(7,2)){
				actions.add(puzzle.moveRight27);
			}
			if(board.canMove(7,-2)){
				actions.add(puzzle.moveLeft27);
			}
			if(board.canMove(8,1)){
				actions.add(puzzle.moveRight8);
			}
			if(board.canMove(8,-1)){
				actions.add(puzzle.moveLeft8);
			}if(board.canMove(8,2)){
				actions.add(puzzle.moveRight28);
			}
			if(board.canMove(8,-2)){
				actions.add(puzzle.moveLeft28);
			}
			return actions;
		}
	}
	private static class EPResultFunction implements ResultFunction {
		public Object result(Object s, Action a) {
			puzzle board = (puzzle) s;
			//	System.out.println(board.getBoard());
			if(puzzle.moveRight0.equals(a) && board.canMove(0,1)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(0,1);
				return newBoard;
			}
			if(puzzle.moveRight20.equals(a) && board.canMove(0,-1)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(0,-1);
				return newBoard;
			}
			if(puzzle.moveLeft0.equals(a) && board.canMove(0,2)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(0,2);
				return newBoard;
			}
			if(puzzle.moveLeft20.equals(a) && board.canMove(0,-2)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(0,-2);
				return newBoard;
			}

			if(puzzle.moveRight1.equals(a) && board.canMove(1,1)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(1,1);
				return newBoard;
			}
			if(puzzle.moveRight21.equals(a) && board.canMove(1,-1)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(1,-1);
				return newBoard;
			}
			if(puzzle.moveLeft1.equals(a) && board.canMove(1,2)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(1,2);
				return newBoard;
			}
			if(puzzle.moveLeft21.equals(a) && board.canMove(1,-2)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(1,-2);
				return newBoard;
			}

			if(puzzle.moveRight2.equals(a) && board.canMove(2,1)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(2,1);
				return newBoard;
			}
			if(puzzle.moveRight22.equals(a) && board.canMove(2,-1)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(2,-1);
				return newBoard;
			}
			if(puzzle.moveLeft2.equals(a) && board.canMove(2,2)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(2,2);
				return newBoard;
			} if(puzzle.moveLeft22.equals(a) && board.canMove(2,-2)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(2,-2);
				return newBoard;
			}

			if(puzzle.moveRight3.equals(a) && board.canMove(3,1)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(3,1);
				return newBoard;
			}
			if(puzzle.moveRight23.equals(a) && board.canMove(3,-1)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(3,-1);
				return newBoard;
			}
			if(puzzle.moveLeft3.equals(a) && board.canMove(3,2)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(3,2);
				return newBoard;
			}
			if(puzzle.moveLeft23.equals(a) && board.canMove(3,-2)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(3,-2);
				return newBoard;
			}

			if(puzzle.moveRight4.equals(a) && board.canMove(4,1)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(4,1);
				return newBoard;
			}
			if(puzzle.moveRight24.equals(a) && board.canMove(4,-1)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(4,-1);
				return newBoard;
			}
			if(puzzle.moveLeft4.equals(a) && board.canMove(4,2)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(4,2);
				return newBoard;
			}
			if(puzzle.moveLeft24.equals(a) && board.canMove(4,-2)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(4,-2);
				return newBoard;
			}

			if(puzzle.moveRight5.equals(a) && board.canMove(5,1)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(5,1);
				return newBoard;
			}
			if(puzzle.moveRight25.equals(a) && board.canMove(5,-1)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(5,-1);
				return newBoard;
			}
			if(puzzle.moveLeft5.equals(a) && board.canMove(5,2)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(5,2);
				return newBoard;
			}
			if(puzzle.moveLeft25.equals(a) && board.canMove(5,-2)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(5,-2);
				return newBoard;
			}

			if(puzzle.moveRight6.equals(a) && board.canMove(6,1)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(6,1);
				return newBoard;
			}
			if(puzzle.moveRight26.equals(a) && board.canMove(6,-1)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(6,-1);
				return newBoard;
			}
			if(puzzle.moveLeft6.equals(a) && board.canMove(6,2)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(6,2);
				return newBoard;
			}
			if(puzzle.moveLeft26.equals(a) && board.canMove(6,-2)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(6,-2);
				return newBoard;
			}

			if(puzzle.moveRight7.equals(a) && board.canMove(7,1)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(7,1);
				return newBoard;
			}
			if(puzzle.moveRight27.equals(a) && board.canMove(7,-1)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(7,-1);
				return newBoard;
			}
			if(puzzle.moveLeft7.equals(a) && board.canMove(7,2)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(7,2);
				return newBoard;
			}
			if(puzzle.moveLeft27.equals(a) && board.canMove(7,-2)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(7,-2);
				return newBoard;
			}

			if(puzzle.moveRight8.equals(a) && board.canMove(8,1)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(8,1);
				return newBoard;
			}
			if(puzzle.moveRight28.equals(a) && board.canMove(8,-1)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(8,-1);
				return newBoard;
			}
			if(puzzle.moveLeft8.equals(a) && board.canMove(8,2)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(8,2);
				return newBoard;
			}
			if(puzzle.moveLeft28.equals(a) && board.canMove(8,-2)){
				puzzle newBoard = new puzzle(board);
				newBoard.move(8,-2);
				return newBoard;
			}

			return s;
		}
	}
}
