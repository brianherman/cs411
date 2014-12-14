package Project2;
import aima.core.search.framework.GoalTest;
public class GT implements GoalTest{
	@Override
	public boolean isGoalState(Object gt) {
		puzzle board = (puzzle)gt;
		return board.isGoal();
	}
}
