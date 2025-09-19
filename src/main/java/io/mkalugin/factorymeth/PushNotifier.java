package io.mkalugin.factorymeth;

public class PushNotifier extends Notifier {

    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}
