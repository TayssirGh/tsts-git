import service.RequestHandler;

import java.io.*;
import java.nio.file.Files;
import java.util.zip.InflaterInputStream;

public class Main {
  static RequestHandler handler = new RequestHandler();
  public static void main(String[] args) {


     final String command = args[0];

     switch (command) {
       case "init" -> handler.init();
       default -> System.out.println("Unknown command: " + command);
     }
  }
}
