package by.bsuir.m0rk4.oop.task.fifth.archivation;

import by.bsuir.m0rk4.oop.task.fifth.core.service.DataArchivator;
import by.bsuir.m0rk4.oop.task.fifth.core.util.ExtensionReplacer;

import java.io.*;
import java.nio.file.Files;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class DataArchivatorImpl implements DataArchivator {

    private static final String ZIP_EXT = ".zip";
    private static final int BUFFER_SIZE = 4096 * 4096;

    @Override
    public void archivate(File serializedFile) {
        String serializedFileName = serializedFile.getName();
        String archivatedFilename = ExtensionReplacer.replace(serializedFileName, ZIP_EXT);
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(serializedFile));
             GZIPOutputStream outputStream = new GZIPOutputStream(new FileOutputStream(archivatedFilename))) {
            byte[] buf = new byte[BUFFER_SIZE];
            int read;
            while ((read = inputStream.read(buf, 0, BUFFER_SIZE)) != -1) {
                outputStream.write(buf, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.delete(serializedFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public File dearchivate(File zippedFile) {
        File tmpFile = new File(UUID.randomUUID().toString());
        try (GZIPInputStream inputStream = new GZIPInputStream(new FileInputStream(zippedFile));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(tmpFile))) {
            byte[] buf = new byte[BUFFER_SIZE];
            int read;
            while ((read = inputStream.read(buf, 0, BUFFER_SIZE)) != -1) {
                outputStream.write(buf, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tmpFile;
    }
}
