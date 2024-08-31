package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.InflaterInputStream;
public class Git {
    private static final byte[] OBJECT_TYPE_BLOB = "blob".getBytes();
    private static final byte[] SPACE = " ".getBytes();
    private static final byte[] NULL = {0};
    private final File root;
    Git(File root) { this.root = root; }
    public File getDotGit() { return new File(root, ".git"); }
    public File getObjectsDirectory() { return new File(getDotGit(), "objects"); }
    public File getRefsDirectory() { return new File(getDotGit(), "refs"); }
    public File getHeadFile() { return new File(getDotGit(), "HEAD"); }

    public static void init(File file) {
        final File root = new File(".git");
        new File(root, "objects").mkdirs();
        new File(root, "refs").mkdirs();
        final File head = new File(root, "HEAD");

        try {
            head.createNewFile();
            Files.write(head.toPath(), "ref: refs/heads/main\n".getBytes());
            System.out.println("Initialized git directory");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Git open(File file) throws IOException {
        var git = new Git(file);
        var dotGit = git.getDotGit();
        if (!dotGit.exists()) {
            throw new IOException("No service.Git repository found at " +
                    file.getAbsolutePath());
        }
        return git;
    }

}