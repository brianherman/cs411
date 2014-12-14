package Project1;
import aima.core.search.framework.HeuristicFunction;


public class heuristicFunction implements HeuristicFunction{
	char [] initial = {'B', 'B', 'B',' ','R','R','R'};
	
	@Override
	public double h(Object b) {
		Puzzle board = (Puzzle)b;
		char[] theBoard = board.getBoard();		
		return d.DamerauLevenshteinDistance(theBoard.toString(), initial.toString());
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
