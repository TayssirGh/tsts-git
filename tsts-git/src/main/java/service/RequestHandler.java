package service;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.zip.InflaterInputStream;

public class RequestHandler {


    private final File HERE = new File(".");

    public void init() {
        Git.init(HERE);
        System.out.println("Initialized empty Git repository in " + HERE.getAbsolutePath() + "/.git/");
    }
    public void catFile(String hash) throws IOException {
        final var git = Git.open(HERE);
        final var bytes = git.catFile(hash);
        System.out.writeBytes(bytes);
    }



}