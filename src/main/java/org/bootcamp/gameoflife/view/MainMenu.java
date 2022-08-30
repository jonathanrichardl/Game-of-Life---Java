package org.bootcamp.gameoflife.view;

import java.io.IOException;
import org.bootcamp.gameoflife.controller.GameOfLife;
import org.bootcamp.gameoflife.model.Board;
import org.bootcamp.gameoflife.utils.BoardFileUtil;

public class MainMenu {

  public static void main(String[] args) throws InterruptedException, IOException {
    Board board = generateBoard(args);
    GameOfLife controller;

    controller = new GameOfLife(board);

    while (true) {
      clear();
      System.out.println(board);

      board = controller.nextState();

      Thread.sleep(50);
    }
  }

  private static String getFileName(String[] args) {
    if (args.length == 0) {
      System.out.println("Missing Scenario File");
      System.exit(1);
    }

    return args[0];
  }

  private static Board generateBoard(String[] args) {
    Board board = null;
    String scenarioFile;

    scenarioFile = getFileName(args);

    try {
      board = BoardFileUtil.generateBoardFromFile(scenarioFile);
    } catch (IOException e) {
      System.out.println("Invalid Input File : " + scenarioFile);
      System.exit(1);
    }

    return board;
  }

  private static void clear() throws IOException {
    Runtime.getRuntime().exec("clear");
    System.out.flush();
  }
}
