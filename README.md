# REPO: 
https://github.com/mulefish/learner

#  What is this? 
A: reinforcement learning.  
B: 10 by 30 grid
C: Agent to find the Goal - random ->  training ( build 'q table' ) -> trained

# PRE TRAINING STEPS: 9771
Board state before training:
47 52 36 21 25 33 28 33 15 22 35 31 31 58 75 55 44 34 22 10 24 14 12 10 8 9 23 25 23 15
44 50 56 38 40 49 31 26 20 31 29 38 32 52 71 69 55 35 24 13 20 21 15 9 11 10 19 17 16 10
33 27 53 48 46 55 40 32 19 25 24 35 28 49 52 57 57 56 36 15 16 19 18 13 14 11 21 20 6 5
25 30 50 X 42 41 37 35 24 30 22 22 28 38 29 37 40 56 41 28 23 20 17 15 16 15 13 16 11 6
44 51 49 46 60 41 35 39 32 29 34 41 41 30 26 36 35 46 29 29 31 30 16 11 15 18 11 16 20 18
72 58 45 64 73 45 35 34 36 38 43 27 22 20 33 37 35 34 33 33 20 23 25 30 20 15 12 10 11 20
102 85 63 76 61 49 41 36 42 42 31 21 21 24 29 41 40 30 27 30 28 25 23 23 17 13 16 14 5 8
75 75 49 50 46 48 37 26 50 43 37 36 34 41 39 41 39 35 32 33 30 18 19 21 21 18 17 12 3 3
92 72 65 62 55 54 51 33 40 35 45 42 41 45 50 50 50 28 22 20 18 17 16 20 29 20 12 9 2 3
67 65 93 89 60 58 34 35 24 17 25 42 31 32 49 44 49 35 23 27 16 15 17 14 24 19 11 1 . !

# POST TRAINING STEPS: 32
Board state after training:
. . . . . . . . . . . . . . . . . . . . . . . . . . . . . .
. . . . . . . . . . . . . . . . . . . . . . . . . . . . . .
. . . . . . . . . . . . . . . . . . . . . . . . . . . . . .
. . . . . . . . . . . . . . . . . . . . . . . . . . . . . .
. . . X . . . . . . . . . . . . . . . . . . . . . . . . . .
. . . 1 1 1 1 . . . . . . . . . . . . . . . . . . . . . . .
. . . . . . 1 . . . . . . . . . . . . . . . . . . . . . . .
. . . . . . 1 1 . . . . . . . . . . . . . . . . . . . . . .
. . . . . . . 1 . . . . . . . . . . . . . . . . . . . . . .
. . . . . . . 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 !

