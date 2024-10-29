package learner;

public class Agent {
    int rows;
    int cols;
    int row;
    int col;
    Reinforcement reinforcement;
    Board board;

    public Agent(int row, int col, int rows, int cols, Reinforcement reinforcement, Board board) {
        this.row = row;
        this.col = col;
        this.rows = rows;
        this.cols = cols;
        this.reinforcement = reinforcement;
        this.board = board;
    }

    public void performAction() {
        int state = reinforcement.positionToState(row, col);
        int action = reinforcement.chooseAction(state);

        int[] newPosition = getNewPosition(row, col, action);
        int newState = reinforcement.positionToState(newPosition[0], newPosition[1]);

        // Calculate reward
        int reward = (newPosition[0] == board.targetR && newPosition[1] == board.targetC) ? reinforcement.rewardGoal : reinforcement.rewardStep;

        // Update Q-table
        reinforcement.updateQTable(state, action, reward, newState);

        // Move to new position
        row = newPosition[0];
        col = newPosition[1];
        board.setFootsteps(row, col);  // No viz = no good! Mark path on board!

        // Are we finished?
        if (reward == reinforcement.rewardGoal) {
            reinforcement.decayEpsilon();
        }
    }

    private int[] getNewPosition(int row, int col, int action) {
        switch (action) {
            case 0: return new int[] {Math.max(row - 1, 0), col};        // Up
            case 1: return new int[] {Math.min(row + 1, rows - 1), col}; // Down
            case 2: return new int[] {row, Math.max(col - 1, 0)};        // Left
            case 3: return new int[] {row, Math.min(col + 1, cols - 1)}; // Right
            default: return new int[] {row, col};
        }
    }
}
