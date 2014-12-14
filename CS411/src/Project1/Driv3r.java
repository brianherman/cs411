package Project1;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import aima.core.agent.Action;
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.TreeSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.search.uninformed.BreadthFirstSearch;

public class Driv3r {
	
	public static SearchAgent goalFixer;

	public static void main(String args[]){
		
		System.out.println("CS 411 UIC Brian Herman 675462479");
		while(true){
			System.out.println("Choose algorithm");
			System.out.println("1. Breadth First Search");
			System.out.println("2. A Star Search");
			System.out.println("3. Exit");
			Scanner keyboard = new Scanner(System.in);
			int choice = keyboard.nextInt();
			System.out.print("Enter step limiter value: ");
			int stepLimiterValue = keyboard.nextInt();
			char [] initial = {'B', 'B', ' ','B','R','R','R'};
			keyboard.close();
			switch(choice){
			case 1:
				BFS(initial,stepLimiterValue);
				break;
			case 2:
				AStar(initial,stepLimiterValue);
				break;
			case 3:
				System.exit(0);
			}
		}

		

	}
	private static void BFS(char[] state, int stepLimiterValue){
		try {
			 Puzzle p = new Puzzle(state);
			 p.setBoard(state);
			 Problem problem = new Problem(p, FunctionFactory
		        .getActionsFunction(), FunctionFactory
		        .getResultFunction(), FunctionFactory.getGoalTest(), FunctionFactory.getStepCostFunction());
			
			 Search search = new BreadthFirstSearch(new TreeSearch());
			
			System.out.println("Inital State "+ Arrays.toString(p.getBoard()));
			SearchAgent agent = new SearchAgent(problem, search);

			agent = new SearchAgent(problem, search);
			
			System.out.println("Inital State "+ Arrays.toString(p.getBoard()));
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());

        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
	private static void AStar(char[] state, int stepLimiterValue){
		try {
			 Puzzle p = new Puzzle();
			 p.setBoard(state);
			Problem problem = new Problem(p, FunctionFactory
                .getActionsFunction(), FunctionFactory
                .getResultFunction(), FunctionFactory.getGoalTest(),FunctionFactory.getStepCostFunction());
			Search search = new AStarSearch(new GraphSearch(),
					new heuristicFunction());
			
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
}
