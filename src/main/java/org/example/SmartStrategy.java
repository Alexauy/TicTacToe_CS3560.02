package org.example;

public class SmartStrategy implements MoveStrategy{

    @Override
    public int[] pickMove(Board board, Mark mark) {
        //Check if there is a spot where the AI could put its mark to win
        for(int r = 0; r<3; r++){
            for(int c = 0; c<3; c++){
                if(board.isEmpty(r, c)){
                    Mark originalState = board.getMark(r, c);
                    board.testMark(r, c, mark);
                    if (board.winner() == mark) {
                        board.testMark(r, c, originalState);
                        return new int[]{r, c};
                    }
                    board.testMark(r, c, originalState);
                }
            }
        }

        //Check if there is a spot where we can block the human player
        Mark opponent = Mark.X;
        for(int r = 0; r<3; r++){
            for(int c = 0; c<3; c++){
                if(board.isEmpty(r, c)){
                    Mark originalState = board.getMark(r, c);
                    board.testMark(r, c, opponent);
                    if(board.winner() == opponent){
                        board.testMark(r, c, originalState);
                        return new int[]{r, c};
                    }
                    board.testMark(r, c, originalState);
                }
            }
        }

        //Otherwise use the random strategy to choose a spot to mark
        RandomStrategy rnd = new RandomStrategy();
        return rnd.pickMove(board, mark);
    }
}
