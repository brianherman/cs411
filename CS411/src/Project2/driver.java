package Project2;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.informed.AStarSearch;

//import aima.core.environment.eightpuzzle.EightPuzzleFunctionFactory;

public class driver {
	public static void main(String args[]){
		System.out.println("CS 411 UIC Brian Herman 675462479");
		char [] initial = {'B', 'B', ' ','B',' ',' ','R','R','R'};
		puzzle d = new puzzle(initial);
		System.out.println(d.getBoard());
        try {
			Problem problem = new Problem(d, SF
                .getActionsFunction(), SF
                .getResultFunction(), new GT());
			Search search = new AStarSearch(new GraphSearch(),
					new HF());
			
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());

        } catch (Exception e) {
        	e.printStackTrace();
        }

	}
	
	  private static void printInstrumentation(Properties properties) {
			Iterator<Object> keys = properties.keySet().iterator();
			while (keys.hasNext()) {
				String key = (String) keys.next();
				String property = properties.getProperty(key);
				System.out.println(key + " : " + property);
			}
	 
		}
	 
		private static void printActions(List<Action> actions) {
			for (int i = 0; i < actions.size(); i++) {
				String action = actions.get(i).toString();
				System.out.println(action);
			}
		}

public void metaProgram(){
    // CODE GENERATOR
	for(int i=0; i<9; i++){
	System.out.print("if(board.canMove(i,1)){\n"
	+"	actions.add(puzzle.moveRight"+i+");\n"
	+"}\n"
	+"if(board.canMove(i,-1)){\n"
	+"	actions.add(puzzle.moveLeft"+i+");\n"
	+"}"
	+"if(board.canMove(i,2)){\n"
	+"	actions.add(puzzle.moveRight2"+i+");\n"
	+"}\n"
	+"if(board.canMove(i,-2)){\n"
	+"	actions.add(puzzle.moveLeft2"+i+");\n"
	+"}\n");
	
}
for(int i=0; i<9; i++){
String s =""
		+"if(puzzle.moveRight"+i+".equals(a) && board.canMove(i,1)){\n"
		+"		puzzle newBoard = new puzzle(board);\n"
	
		+"	return newBoard;\n"
		+"}else\n"
		+"if(puzzle.moveRight2"+i+".equals(a) && board.canMove(i,-1)){\n"
		+"	puzzle newBoard = new puzzle(board);\n"

		+"return newBoard;\n"
		+"}else\n"
		+"if(puzzle.moveLeft"+i+".equals(a) && board.canMove(i,2)){\n"
		+"puzzle newBoard = new puzzle(board);\n"

		+"return newBoard;\n"
		+"}else\n"
		+"if(puzzle.moveLeft2"+i+".equals(a) && board.canMove(i,-2)){\n"
		+"puzzle newBoard = new puzzle(board);\n"

		+"	return newBoard;\n"
		+"}\n";
	System.out.println(s);
	}
for(int i=0; i<9; i++){
	System.out.println("\tpublic static Action moveLeft"+i+" = new DynamicAction(\"left"+i+"\");\r"
			+ "\n\tpublic static Action moveLeft2"+i+" = new DynamicAction(\"left2"+i+"\");"
			+ "\t\r"
			+ "\n\tpublic static Action moveRight"+i+" = new DynamicAction(\"right"+i+"\");"
			+ "\t\r"
			+ "\n\tpublic static Action moveRight2"+i+" = new DynamicAction(\"right2"+i+"\");"
			+ "\t\r\n");	

}
}
}
