package io.mkalugin.factorymeth;

public class SmsNotification extends Notification {
    @Override
    public void send(String text) {
        System.out.println("Sending sms with text :  " + text);
    }
}
