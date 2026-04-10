package com.ntnn.leetcode;

/**
 * LeetCode 657. Robot Return to Origin
 * 
 * There is a robot starting at the position (0, 0), the origin, on a 2D plane.
 * Given a sequence of its moves, judge if this robot ends up at (0, 0) after
 * it completes its moves.
 * 
 * Valid moves are 'R' (right), 'L' (left), 'U' (up), and 'D' (down).
 * 
 * Time Complexity: O(n) where n is the length of the moves string
 * Space Complexity: O(1)
 * 
 * @author ntnn
 */
public class RobotReturnToOrigin {

    /**
     * Determines if the robot returns to the origin after completing all moves.
     * 
     * @param moves A string representing the sequence of moves
     * @return true if the robot returns to origin, false otherwise
     */
    public boolean judgeCircle(String moves) {
        // Track the robot's position (x, y)
        // Starting at origin (0, 0)
        int x = 0;
        int y = 0;
        
        // Process each move
        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'R':
                    x++;
                    break;
                case 'L':
                    x--;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
            }
        }
        
        // Robot is at origin if both x and y are 0
        return x == 0 && y == 0;
    }

    /**
     * Alternative solution using counting approach.
     * The robot returns to origin if and only if:
     * - Number of 'R' moves equals number of 'L' moves
     * - Number of 'U' moves equals number of 'D' moves
     * 
     * @param moves A string representing the sequence of moves
     * @return true if the robot returns to origin, false otherwise
     */
    public boolean judgeCircleCounting(String moves) {
        int[] count = new int[26];
        
        // Count each move type
        for (char move : moves.toCharArray()) {
            count[move - 'A']++;
        }
        
        // Check if horizontal and vertical movements balance out
        return count['R' - 'A'] == count['L' - 'A'] && 
               count['U' - 'A'] == count['D' - 'A'];
    }

    public static void main(String[] args) {
        RobotReturnToOrigin solution = new RobotReturnToOrigin();
        
        // Test case 1: "UD" - returns to origin
        String moves1 = "UD";
        System.out.println("Test 1: moves = \"" + moves1 + "\"");
        System.out.println("Result: " + solution.judgeCircle(moves1));
        System.out.println("Expected: true\n");
        
        // Test case 2: "LL" - does not return to origin
        String moves2 = "LL";
        System.out.println("Test 2: moves = \"" + moves2 + "\"");
        System.out.println("Result: " + solution.judgeCircle(moves2));
        System.out.println("Expected: false\n");
        
        // Test case 3: Empty string - at origin
        String moves3 = "";
        System.out.println("Test 3: moves = \"" + moves3 + "\"");
        System.out.println("Result: " + solution.judgeCircle(moves3));
        System.out.println("Expected: true\n");
        
        // Test case 4: Complex path that returns to origin
        String moves4 = "UDLRUDLR";
        System.out.println("Test 4: moves = \"" + moves4 + "\"");
        System.out.println("Result: " + solution.judgeCircle(moves4));
        System.out.println("Expected: true\n");
        
        // Test case 5: Complex path that does not return to origin
        String moves5 = "UUDDLRLRBA";
        System.out.println("Test 5: moves = \"" + moves5 + "\"");
        System.out.println("Result: " + solution.judgeCircle(moves5));
        System.out.println("Expected: false (invalid move 'B' would cause issues in real scenario)");
    }
}