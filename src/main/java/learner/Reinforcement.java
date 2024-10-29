package learner;

import java.util.Random;

public class Reinforcement {
    int numStates;
    int numActions;
    double[][] qTable;
    double alpha = 0.1;          // Learning rate
    double gamma = 0.9;          // Discount factor
    double epsilon = 1.0;        // Exploration rate
    double epsilonDecay = 0.9;

    int[] targetPosition = {9, 9};
    int rewardGoal = 100;
    int rewardStep = -1;
    Random random = new Random();

    public Reinforcement(int numStates, int numActions) {
        this.numStates = numStates;
        this.numActions = numActions;

        // Initialize Q-table with zeros
        qTable = new double[numStates][numActions];
    }

    // Convert (row, col) to a state index
    public int positionToState(int row, int col) {
        return row * 10 + col;
    }

    // Choose action using epsilon-greedy policy
    public int chooseAction(int state) {
        if (random.nextDouble() < epsilon) {
            return random.nextInt(numActions);  // Explore
        } else {
            return getBestAction(state);  // Exploit
        }
    }

    // Get the best action for a given state
    private int getBestAction(int state) {
        int bestAction = 0;
        double bestValue = qTable[state][0];
        for (int i = 1; i < numActions; i++) {
            if (qTable[state][i] > bestValue) {
                bestValue = qTable[state][i];
                bestAction = i;
            }
        }
        return bestAction;
    }

    // Update Q-value for a state-action pair
    public void updateQTable(int state, int action, int reward, int nextState) {
        int bestNextAction = getBestAction(nextState);
        double tdTarget = reward + gamma * qTable[nextState][bestNextAction];
        double tdError = tdTarget - qTable[state][action];
        qTable[state][action] += alpha * tdError;
    }

    // Decay epsilon to reduce exploration over time
    public void decayEpsilon() {
        epsilon *= epsilonDecay;
    }
}
