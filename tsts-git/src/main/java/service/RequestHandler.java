package service;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class RequestHandler {


    private final File HERE = new File(".");

    public void init() {
        Git.init(HERE);
        System.out.println("Initialized empty Git repository in " + HERE.getAbsolutePath() + "/.git/");
    }


}