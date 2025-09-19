package io.mkalugin.abstfactory;

public interface CloudFactory {
    ComputeInstance createCompute();
    BlobStorage createStorage();
}
