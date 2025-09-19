package io.mkalugin.abstfactory;

public class AwsBlobStorage implements BlobStorage {
    @Override
    public void save(String name) {
        System.out.println("Save file: " + name  + " in AWS Blob.");
    }
}
