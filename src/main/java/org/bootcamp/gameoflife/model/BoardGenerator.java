package org.bootcamp.gameoflife.model;

public class BoardGenerator {

  static Board generateBoardFromString(String boardString) {
    Board generatedBoard = new Board(null, parseBoardWidth(boardString),
        parseBoardHeight(boardString));

    return generatedBoard;
  }

  static private int parseBoardWidth(String boardString) {
    int width = 0;

    for (String rowElements : boardString.split("\\\n")) {
      width = Math.max(width, rowElements.length());
    }

    return width;
  }

  static private int parseBoardHeight(String boardString) {
    return boardString.split("\\\n").length;
  }
}
