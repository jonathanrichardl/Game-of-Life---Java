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

  @Test
  void setCellLifeStatus_givenAliveCellOfAnInboundCell_newCellStatusIsSet() {
    String boardStr = "###\n   \n###\n# #\n";
    Board testBoard = BoardGenerator.generateBoardFromString(boardStr);

    testBoard.setCellLifeStatus(1, 2, true);

    String expectedBoardStr = "###\n  #\n###\n# #\n";

    assertEquals(expectedBoardStr, testBoard.toString());
  }

  @Test
  void setCellLifeStatus_givenDeadCellOfAnInboundCell_newCellStatusIsSet() {
    String boardStr = "###\n   \n###\n# #\n";
    Board testBoard = BoardGenerator.generateBoardFromString(boardStr);

    testBoard.setCellLifeStatus(0, 0, false);

    String expectedBoardStr = " ##\n   \n###\n# #\n";

    assertEquals(expectedBoardStr, testBoard.toString());
  }
}
