package io.mkalugin.factorymeth;

import java.util.Scanner;

public class FactoryMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String notifierType = scanner.nextLine().toUpperCase();

        try {
            Notifier notifier = createNotifier(notifierType);
            String message = "Order completed.";
            notifier.sendNotification(message);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    private static Notifier createNotifier(String type) {
        switch (type) {
            case "SMS":
                return new SmsNotifier();
            case "PUSH":
                return new PushNotifier();
            case "EMAIL":
                return new EmailNotifier();
            default:
                throw new IllegalArgumentException("Invalid type : " + type);
        }
    }
}
