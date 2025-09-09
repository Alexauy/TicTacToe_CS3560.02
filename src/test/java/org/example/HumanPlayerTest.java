package org.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanPlayerTest {
    Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    void testWinRow() {
        board.testMark(0, 0, Mark.X);
        board.testMark(0, 1, Mark.X);
        board.testMark(0, 2, Mark.X);
        assertEquals(Mark.X, board.winner());
    }

    @Test
    void testWinRow2() {
        board.testMark(1, 0, Mark.X);
        board.testMark(1, 1, Mark.X);
        board.testMark(1, 2, Mark.X);
        assertEquals(Mark.X, board.winner());
    }

    @Test
    void testWinRow3() {
        board.testMark(2, 0, Mark.X);
        board.testMark(2, 1, Mark.X);
        board.testMark(2, 2, Mark.X);
        assertEquals(Mark.X, board.winner());
    }

    @Test
    void testWinCol1() {
        board.testMark(0, 0, Mark.X);
        board.testMark(1, 0, Mark.X);
        board.testMark(2, 0, Mark.X);
        assertEquals(Mark.X, board.winner());
    }

    @Test
    void testWinCol2() {
        board.testMark(0, 1, Mark.X);
        board.testMark(1, 1, Mark.X);
        board.testMark(2, 1, Mark.X);
        assertEquals(Mark.X, board.winner());
    }

    @Test
    void testWinCol3() {
        board.testMark(0, 2, Mark.X);
        board.testMark(1, 2, Mark.X);
        board.testMark(2, 2, Mark.X);
        assertEquals(Mark.X, board.winner());
    }

    @Test
    void testWinDiag1() {
        board.testMark(0, 0, Mark.X);
        board.testMark(1, 1, Mark.X);
        board.testMark(2, 2, Mark.X);
        assertEquals(Mark.X, board.winner());
    }

    @Test
    void testWinDiag2() {
        board.testMark(2, 0, Mark.X);
        board.testMark(1, 1, Mark.X);
        board.testMark(0, 2, Mark.X);
        assertEquals(Mark.X, board.winner());
    }
}
