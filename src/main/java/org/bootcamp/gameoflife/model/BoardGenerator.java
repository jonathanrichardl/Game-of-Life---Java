package org.bootcamp.gameoflife.model;

import java.util.HashMap;
import java.util.HashSet;

class BoardGenerator {

  static Board generateBoardFromString(String boardString) {
    Board generatedBoard = new Board(generateAliveCellsMap(boardString),
        parseBoardWidth(boardString), parseBoardHeight(boardString));

    return generatedBoard;
  }

  static private HashMap<Integer, HashSet<Integer>> generateAliveCellsMap(String boardString) {
    HashMap<Integer, HashSet<Integer>> aliveCellsMap = new HashMap<>();
    int rowIndex = 0;
    int colIndex = 0;

    for (String rowStr : boardString.split("\n")) {
      HashSet<Integer> aliveCell = new HashSet<>();

      for (char elementChar : rowStr.toCharArray()) {
        if (elementChar == '#') {
          aliveCell.add(colIndex);
        }
        colIndex++;
      }

      aliveCellsMap.put(rowIndex, aliveCell);

      rowIndex++;

      colIndex = 0;
    }

    return aliveCellsMap;
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
