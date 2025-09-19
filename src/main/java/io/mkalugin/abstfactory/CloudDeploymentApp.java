package io.mkalugin.abstfactory;

import java.util.Scanner;

public class CloudDeploymentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CloudFactory cloudFactory;
        System.out.println("Enter provider (aws, azure): ");
        String provider = scanner.nextLine().trim().toLowerCase();

        switch (provider) {
            case "aws":
                cloudFactory = new AwsFactory();
                System.out.println("AWS Cloud Provider");
                break;
            case "azure":
                cloudFactory = new AzureFactory();
                System.out.println("Azure Cloud Provider");
                break;
            default:
                System.out.println("Invalid Cloud Provider - " + provider);
                scanner.close();
                return;
        }

        DeploymentManager manager = new DeploymentManager(cloudFactory);
        manager.deploy();
        validateServices(manager, provider);

        scanner.close();
    }

    private static void validateServices(DeploymentManager manager, String expectedProvider) {
        ComputeInstance compute = manager.getCompute();
        BlobStorage storage = manager.getStorage();
        String computeType = compute.getClass().getSimpleName().toLowerCase();
        String storageType = storage.getClass().getSimpleName().toLowerCase();
        boolean computeValid = computeType.startsWith(expectedProvider);
        boolean storageValid = storageType.startsWith(expectedProvider);

        System.out.println("Compute service: " + computeType);
        System.out.println("Storage service: " + storageType);
        System.out.println("Validation: Compute is " + (computeValid ? "valid" : "invalid"));
        System.out.println("Validation: Storage is " + (storageValid ? "valid" : "invalid"));

        if (computeValid && storageValid) {
            System.out.println("Both services belong to the same platform: " + expectedProvider);
        } else {
            System.out.println("Services platform mismatch detected!");
        }
    }
}
