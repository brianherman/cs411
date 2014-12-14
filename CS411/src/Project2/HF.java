package Project2;
import aima.core.search.framework.HeuristicFunction;
public class HF implements HeuristicFunction{
	char [] initial = {'B', 'B', 'B',' ',' ',' ','R','R','R'};

	@Override
	public double h(Object b) {
		puzzle board = (puzzle)b;
		double h=0;
		char[] theBoard = board.getBoard();
		for(int i=0; i<theBoard.length; i++){
			h =+ Math.abs(initial[i]-theBoard[i]);
		}
		
		return h;
	}

}
