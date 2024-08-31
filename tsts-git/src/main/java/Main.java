import service.RequestHandler;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {
  static RequestHandler handler = new RequestHandler();
  public static void main(String[] args) throws IOException, NoSuchAlgorithmException {


     final String command = args[0];

     switch (command) {
       case "init" -> handler.init();
       case "cat-file" -> handler.catFile(args[2]);
         case "hash-object" -> handler.hashFile(args[2]);
       default -> System.out.println("Unknown command: " + command);
     }
  }
}
