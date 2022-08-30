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

  @Test
  void setCellLifeStatus_givenNegativeRowIndex_doesNothing() {
    String boardStr = "###\n   \n###\n# #\n";
    Board testBoard = BoardGenerator.generateBoardFromString(boardStr);

    testBoard.setCellLifeStatus(-1, 0, true);

    assertEquals(boardStr, testBoard.toString());
  }

  @Test
  void setCellLifeStatus_givenNegativeColumnIndex_doesNothing() {
    String boardStr = "###\n   \n###\n# #\n";
    Board testBoard = BoardGenerator.generateBoardFromString(boardStr);

    testBoard.setCellLifeStatus(0, -1, true);

    assertEquals(boardStr, testBoard.toString());
  }

  @Test
  void setCellLifeStatus_givenNewStatusOfAnOutOfBoundRowIndexCell_boardIsExpanded() {
    String boardStr = "###\n   \n###\n# #\n";
    Board testBoard = BoardGenerator.generateBoardFromString(boardStr);

    testBoard.setCellLifeStatus(4, 1, true);

    String expectedBoardStr = "###\n   \n###\n# #\n # \n";

    assertEquals(expectedBoardStr, testBoard.toString());
  }

  @Test
  void resizeRight_givenPositiveResizeFactor_toStringReturnsExpandedBoard() {
    String boardStr = "###\n   \n###\n# #\n";
    Board testBoard = BoardGenerator.generateBoardFromString(boardStr);

    testBoard.resizeRight(2);

    String expectedBoardStr = "###  \n     \n###  \n# #  \n";

    assertEquals(expectedBoardStr, testBoard.toString());
  }

  @Test
  void resizeBottom_givenPositiveResizeFactor_toStringReturnsExpandedBoard() {
    String boardStr = "###\n   \n###\n# #\n";
    Board testBoard = BoardGenerator.generateBoardFromString(boardStr);

    testBoard.resizeBottom(2);

    String expectedBoardStr = "###\n   \n###\n# #\n   \n   \n";

    assertEquals(expectedBoardStr, testBoard.toString());
  }
}
