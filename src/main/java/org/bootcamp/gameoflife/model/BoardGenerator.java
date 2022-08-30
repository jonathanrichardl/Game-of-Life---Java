package org.bootcamp.gameoflife.model;

public class BoardGenerator {

  static Board generateBoardFromString(String boardString) {
    return new Board(null, parseBoardWidth(boardString), 0);
  }

  static private int parseBoardWidth(String boardString) {
    int width = 0;

    for (String rowElements : boardString.split("\\\n")) {
      width = Math.max(width, rowElements.length());
    }

    return width;
  }
}
