package org.bootcamp.gameoflife.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
