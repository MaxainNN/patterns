package io.mkalugin.factorymeth;

public class EmailNotifier extends Notifier{
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
