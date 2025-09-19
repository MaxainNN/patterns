package io.mkalugin.abstfactory;

public class AzureFactory implements CloudFactory {
    @Override
    public ComputeInstance createCompute() {
        return new AzureCompute();
    }

    @Override
    public BlobStorage createStorage() {
        return new AzureBlobStorage();
    }
}
