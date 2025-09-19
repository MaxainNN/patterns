package io.mkalugin.abstfactory;

public class AzureBlobStorage implements BlobStorage{
    @Override
    public void save(String name) {
        System.out.println("Save file: " + name  + " in Azure Blob.");
    }
}
