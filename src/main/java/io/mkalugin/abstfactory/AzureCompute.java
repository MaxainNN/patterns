package io.mkalugin.abstfactory;

public class AzureCompute implements ComputeInstance {
    @Override
    public void start() {
        System.out.println("Starting Azure Compute instance.");
    }
}
