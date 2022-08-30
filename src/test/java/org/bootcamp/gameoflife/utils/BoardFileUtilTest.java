package org.bootcamp.gameoflife.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import org.bootcamp.gameoflife.model.Board;
import org.junit.jupiter.api.Test;

class BoardFileUtilTest {

  @Test
  void generateBoardFromFile_givenAValidFilePath_returnsConstructedBoard() throws IOException {
    BoardFileUtil test = new BoardFileUtil();
    Board testBoard = test.generateBoardFromFile("resources/blinker.txt");
    String expectedBoardStr = "   \n###\n   \n";

    assertEquals(expectedBoardStr, testBoard.toString());
  }
}
