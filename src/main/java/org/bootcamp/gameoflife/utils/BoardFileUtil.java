package org.bootcamp.gameoflife.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.bootcamp.gameoflife.model.Board;
import org.bootcamp.gameoflife.model.BoardGenerator;

public class BoardFileUtil {

  static Board generateBoardFromFile(String filePath) throws IOException {
    Path fileDirectory = Path.of(filePath);
    return BoardGenerator.generateBoardFromString(Files.readString(fileDirectory));
  }
}
