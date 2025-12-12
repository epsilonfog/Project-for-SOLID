package services;

class SmsSender implements MessageSender {
    @Override
    public void sendEmail(String to, String message) {
        System.out.println("Sending SMS to " + to + ": " + message);
    }
}
