package org.bootcamp.gameoflife.model;

import java.util.HashMap;
import java.util.HashSet;

public class Board {

  private HashMap<Integer, HashSet<Integer>> aliveCells;
  private int width;
  private int height;

  public Board(HashMap<Integer, HashSet<Integer>> aliveCellsMap, int width, int height) {
    this.aliveCells = aliveCellsMap;
    this.width = width;
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public boolean getCellLifeStatus(int rowIndex, int colIndex) {
    if (aliveCells.containsKey(rowIndex)) {
      return aliveCells.get(rowIndex).contains(colIndex);
    }

    return false;
  }

  public void setCellLifeStatus(int rowIndex, int colIndex, boolean newLifeStatus) {
    if (checkIndexIsInbound(rowIndex, colIndex)) {
      expandBoardIfRequired(rowIndex, colIndex);

      HashSet<Integer> aliveCellColumns = aliveCells.get(rowIndex);

      if (newLifeStatus) {
        aliveCellColumns.add(colIndex);
      } else {
        aliveCellColumns.remove(colIndex);
      }
    }
  }

  public void resizeRight(int resizeFactor) {
    width += resizeFactor;
  }

  public void resizeBottom(int resizeFactor) {
    for (int additionalIndex = height; additionalIndex < height + resizeFactor; additionalIndex++) {
      aliveCells.put(additionalIndex, new HashSet<>());
    }
    height += resizeFactor;
  }

  @Override
  public String toString() {
    StringBuilder boardStringBuffer = new StringBuilder((width * height) + height);

    for (int rowIndex = 0; rowIndex < height; rowIndex++) {
      for (int colIndex = 0; colIndex < width; colIndex++) {
        boardStringBuffer.append(getCellLifeStatus(rowIndex, colIndex) ? '#' : ' ');
      }

      boardStringBuffer.append('\n');
    }

    return boardStringBuffer.toString();
  }

  private boolean checkIndexIsInbound(int rowIndex, int colIndex) {
    return rowIndex >= 0 && colIndex >= 0;
  }

  private void expandBoardIfRequired(int rowIndex, int colIndex) {
    if (rowIndex >= height) {
      resizeBottom(rowIndex + 1 - height);
    }

    if (colIndex >= width) {
      resizeRight(colIndex + 1 - width);
    }
  }
}
