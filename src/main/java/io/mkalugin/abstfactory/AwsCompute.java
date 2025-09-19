package io.mkalugin.abstfactory;

public class AwsCompute implements ComputeInstance {
    @Override
    public void start() {
        System.out.println("Starting AWS Compute");
    }
}
