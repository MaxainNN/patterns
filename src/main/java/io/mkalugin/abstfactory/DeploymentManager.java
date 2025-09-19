package io.mkalugin.abstfactory;

public class DeploymentManager {
    private final ComputeInstance compute;
    private final BlobStorage storage;

    public DeploymentManager(CloudFactory factory) {
        this.compute = factory.createCompute();
        this.storage = factory.createStorage();
    }

    public void deploy() {
        compute.start();
        storage.save("deployment-config.json");
        System.out.println("Deployment completed successfully!");
    }

    public ComputeInstance getCompute() {
        return compute;
    }

    public BlobStorage getStorage() {
        return storage;
    }
}
