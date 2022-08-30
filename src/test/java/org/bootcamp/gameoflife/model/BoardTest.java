package org.bootcamp.gameoflife.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BoardTest {

  @Test
  void getCellLifeStatus_retrieveOutOfBoundCell_returnsFalse() {
    String boardStr = "###\n   \n###\n# #";
    Board testBoard = BoardGenerator.generateBoardFromString(boardStr);

    assertEquals(false, testBoard.getCellLifeStatus(10, 5));
  }

  @Test
  void toString_givenAValidBoard_returnsCorrectStringRepresentation() {
    String boardStr = "###\n   \n###\n# #\n";
    Board testBoard = BoardGenerator.generateBoardFromString(boardStr);

    assertEquals(boardStr, testBoard.toString());
  }
}