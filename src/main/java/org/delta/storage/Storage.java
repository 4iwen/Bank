package org.delta.storage;

public interface Storage {
    void save(String dataToSave, String path);
    String read(String path);
}
