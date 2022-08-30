package org.bootcamp.gameoflife.controller;

import org.bootcamp.gameoflife.model.Board;
import org.bootcamp.gameoflife.model.BoardGenerator;

public class GameOfLife {

  private Board board;
  private int height;
  private int width;

  public GameOfLife(Board board) {
    this.board = board;
    this.width = board.getWidth();
    this.height = board.getHeight();
  }

  public Board nextState() {
    Board nextState = BoardGenerator.copyBoard(board);

    for (int rowIndex = 0; rowIndex < height; rowIndex++) {
      for (int colIndex = 0; colIndex < width; colIndex++) {
        inferAndReplaceCellNewState(nextState, rowIndex, colIndex);
      }
    }

    this.board = nextState;

    return nextState;
  }

  private void inferAndReplaceCellNewState(Board nextState, int rowIndex, int colIndex) {
    int aliveNeighborsCount = getAliveNeighborCount(rowIndex, colIndex);

    if (aliveNeighborsCount < 2) {
      nextState.setCellLifeStatus(rowIndex, colIndex, false);
    } else if (aliveNeighborsCount == 3) {
      nextState.setCellLifeStatus(rowIndex, colIndex, true);
    }
  }

  private int getAliveNeighborCount(int rowIndex, int colIndex) {
    int aliveCount = 0;

    for (int i = Math.max(0, rowIndex - 1); i <= Math.min(rowIndex + 1, height - 1); i++) {
      for (int j = Math.max(0, colIndex - 1); j <= Math.min(colIndex + 1, width - 1); j++) {
        if ((i != rowIndex || j != colIndex) && board.getCellLifeStatus(i, j)) {
          aliveCount++;
        }
      }
    }

    return aliveCount;
  }
}
