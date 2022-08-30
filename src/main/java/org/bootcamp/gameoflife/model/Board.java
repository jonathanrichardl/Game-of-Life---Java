package org.bootcamp.gameoflife.model;

import java.util.HashMap;
import java.util.HashSet;

public class Board {

  private HashMap<Integer, HashSet<Integer>> aliveCells;
  private int width;
  private int height;

  public Board(HashMap<Integer, HashSet<Integer>> aliveCellsMap, int width, int height) {
    this.width = width;
  }

  public int getWidth() {
    return width;
  }
}
