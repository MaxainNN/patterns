package io.mkalugin.factorymeth;

public class PushNotification extends Notification {
    @Override
    public void send(String text) {
        System.out.println("Sending push with text :  " + text);
    }
}
