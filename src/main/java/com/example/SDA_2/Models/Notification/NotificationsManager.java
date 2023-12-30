package com.example.SDA_2.Models.Notification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NotificationsManager {
    private Map<String, NotificationTemplate> templates = new HashMap<>();
    private Map<String, NotificationChannel> channels = new HashMap<>();
    private NotificationsQueue notificationsQueue = new NotificationsQueue();


    public void initialize()
    {
        templates.put("orderPlacement", new OrderShipmentNotification());
        templates.put("orderShipment", new OrderShipmentNotification());

        channels.put("email", new EmailNotificationChannel());
        channels.put("sms", new SMSNotificationChannel());
    }

    public void createAndEnqueueNotification(String templateType, String recipient, String... placeholders) {
        NotificationTemplate template = templates.get(templateType);
        String message = template.generateNotification(placeholders);

        String channelType = "email";
        NotificationChannel channel = channels.get(channelType);


        channel.sendNotification(recipient, message);

        notificationsQueue.enqueueNotification(new Notification());
    }

    public List<Notification> listNotificationsQueueContent() {
        return notificationsQueue.getQueueContent();
    }
}
