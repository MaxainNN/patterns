package io.mkalugin.factorymeth;

public class EmailNotification extends Notification {
    @Override
    public void send(String text) {
        System.out.println("Sending email with text :  " + text);
    }
}
