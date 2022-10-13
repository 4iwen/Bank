package org.delta.storage;

import org.delta.io.IO;

import javax.inject.Singleton;
import java.io.IOException;

@Singleton
public class FileSystemStorage implements Storage {
    @Override
    public void save(String dataToSave, String path) {
        try {
            IO.writeFile(path, dataToSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String read(String path) {
        try {
         return IO.readFile(path);
        } catch (IOException e) {
         throw new RuntimeException(e);
        }
    }
}
