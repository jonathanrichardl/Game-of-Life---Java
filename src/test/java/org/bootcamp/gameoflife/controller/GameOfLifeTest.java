package org.bootcamp.gameoflife.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.bootcamp.gameoflife.model.Board;
import org.bootcamp.gameoflife.model.BoardGenerator;
import org.junit.jupiter.api.Test;

class GameOfLifeTest {

  @Test
  void nextState_givenAnUnderpopulationScenario_infersTheNewStateCorrectly() {
    String boardStr = "   \n # \n   \n";
    Board board = BoardGenerator.generateBoardFromString(boardStr);
    GameOfLife underpopulationTest = new GameOfLife(board);

    board = underpopulationTest.nextState();

    assertFalse(board.getCellLifeStatus(1, 1));
  }

  @Test
  void nextState_givenARevivalScenario_infersTheNewStateCorrectly() {
    String boardStr = "# #\n # \n# #\n";
    Board board = BoardGenerator.generateBoardFromString(boardStr);
    GameOfLife overpopulationTest = new GameOfLife(board);

    board = overpopulationTest.nextState();

    assertTrue(board.getCellLifeStatus(1, 0));
  }
}
