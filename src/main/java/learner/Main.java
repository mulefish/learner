package learner;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        // Birth  location of the Agent
        int initialRow = 3;
        int initialCol = 3;
        // Grid bounds
        int rows = 10;
        int cols = 30;
        Board board = new Board(initialRow, initialCol, rows, cols);
        Reinforcement reinforcement = new Reinforcement(rows * cols, 4);
        Agent agent = new Agent(initialRow, initialCol, rows, cols, reinforcement, board);

        // No training! Brownian motion and count!
        int stepsWithoutTraining = runAgentAndCountSteps(agent, board);
        System.out.printf("PRE TRAINING STEPS: %d%n", stepsWithoutTraining);

        // Early stopping parameters
        int patience = 50;  // Number of episodes to wait for improvement
        int minImprovement = 5;  // Minimum steps reduction to consider improvement
        Queue<Integer> recentSteps = new LinkedList<>();
        int bestSteps = Integer.MAX_VALUE;

        int episodeLimit =  1000; // Likely will plateau before reaching this limit
        for (int episode = 0; episode < episodeLimit; episode++) {
            agent.row = initialRow;
            agent.col = initialCol;
            boolean reachedGoal = false;

            int steps = 0;
            while (!reachedGoal) {
                agent.performAction();
                steps++;
                reachedGoal = (agent.row == board.targetR && agent.col == board.targetC);
            }

            // Update bestSteps and add to recentSteps queue
            if (steps < bestSteps - minImprovement) {
                bestSteps = steps;
            }

            recentSteps.add(steps);
            if (recentSteps.size() > patience) {
                recentSteps.poll();  // Maintain queue size equal to patience
            }

            // Check for plateau: exit if the steps have plateaued
            if (recentSteps.size() == patience && hasPlateaued(recentSteps, minImprovement)) {
                System.out.printf("Early stopping at episode %d of %d potential episode: steps plateaued at around %d steps%n", episode, bestSteps, episodeLimit);
                break;
            }
        }

        // Now it has been trained! Check the steps tally!
        int stepsWithTraining = runAgentAndCountSteps(agent, board);
        System.out.printf("POST TRAINING STEPS: %d%n", stepsWithTraining);
    }

    // Helper function to check if steps have plateaued
    private static boolean hasPlateaued(Queue<Integer> recentSteps, int minImprovement) {
        int first = recentSteps.peek();  // Get first element
        for (int steps : recentSteps) {
            if (Math.abs(steps - first) > minImprovement) {
                return false;  // Not plateaued if difference is above the minimum improvement
            }
        }
        return true;  // Plateaued if all steps are close to the first element
    }

    // Method to test the agent and count steps to reach the goal
    public static int runAgentAndCountSteps(Agent agent, Board board) {
        int steps = 0;
        agent.row = 3;
        agent.col = 3;
        boolean reachedGoal = false;

        while (!reachedGoal) {
            agent.performAction();
            steps++;
            reachedGoal = (agent.row == board.targetR && agent.col == board.targetC);
        }

        return steps;
    }
}
