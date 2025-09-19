package io.mkalugin.factorymeth;

public abstract class Notifier {
    public abstract Notification createNotification();

    public void sendNotification(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }
}
