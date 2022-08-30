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
        nextState.setCellLifeStatus(rowIndex, colIndex, false);
      }
    }

    this.board = nextState;

    return nextState;
  }
}
