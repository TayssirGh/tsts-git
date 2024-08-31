package service;

import java.io.*;
import java.nio.file.Files;
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
    public byte[] catFile(String hash) throws FileNotFoundException, IOException {
        String dirHash = hash.substring(0, 2);
        String fileHash = hash.substring(2);
        File blobFile = new File("./.git/objects/" + dirHash + "/" + fileHash);
        try (   var inputStream = new FileInputStream(blobFile);
                var inflaterInputStream = new InflaterInputStream(inputStream);)
        {
            var builder = new StringBuilder();

            int value;
            while ((value = inflaterInputStream.read()) != -1 && value != ' ') {
                builder.append((char) value);
            }

            builder = new StringBuilder();
            while ((value = inflaterInputStream.read()) != -1 && value != 0) {
                builder.append((char) value);
            }

            var objectLength = Integer.parseInt(builder.toString());
            return inflaterInputStream.readNBytes(objectLength);
        }
    }
}