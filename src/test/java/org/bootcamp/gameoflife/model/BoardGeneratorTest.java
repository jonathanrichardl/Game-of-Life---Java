package org.bootcamp.gameoflife.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class BoardGeneratorTest {

  @Test
  void generateBoardFromString_givenValidBoardString_boardIsGeneratedAndBoardWidthIsDetermined() {
    String boardStr = "###\n   \n###\n# #";
    Board testBoard = BoardGenerator.generateBoardFromString(boardStr);

    assertEquals(3, testBoard.getWidth());
  }

  @Test
  void generateBoardFromString_givenValidBoardString_boardIsGeneratedAndBoardHeightIsDetermined() {
    String boardStr = "###\n   \n###\n# #";
    Board testBoard = BoardGenerator.generateBoardFromString(boardStr);

    assertEquals(4, testBoard.getHeight());
  }

  @Test
  void generateBoardFromString_givenValidBoardString_boardIsGeneratedAndCanReturnLifeStatus() {
    BoardGenerator testGenerator = new BoardGenerator();
    String boardStr = "###\n   \n###\n# #";
    Board testBoard = testGenerator.generateBoardFromString(boardStr);

    assertEquals(true, testBoard.getCellLifeStatus(0, 0));
  }

  @Test
  void copyBoard_givenAValidBoard_returnsACopyOfTheBoard() {
    String boardStr = "###\n   \n###\n# #";
    Board toCopy = BoardGenerator.generateBoardFromString(boardStr);

    Board copyBoard = BoardGenerator.copyBoard(toCopy);

    assertNotEquals(toCopy, copyBoard);
  }
}
