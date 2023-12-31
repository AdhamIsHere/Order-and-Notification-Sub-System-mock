package com.example.SDA_2.Models.Notification;

import com.example.SDA_2.Models.Notification.Channel.EmailNotificationChannel;
import com.example.SDA_2.Models.Notification.Channel.NotificationChannel;
import com.example.SDA_2.Models.Notification.Channel.NotificationsQueue;
import com.example.SDA_2.Models.Notification.Channel.SMSNotificationChannel;
import com.example.SDA_2.Models.Notification.noooo.*;
import com.example.SDA_2.Models.Order.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NotificationsManager {
    private Map<String, NotificationTemplate> templates = new HashMap<>();
    private Map<String, NotificationChannel> channels = new HashMap<>();
    private NotificationsQueue notificationsQueue = new NotificationsQueue();


    public void initialize()
    {
        templates.put("orderCancelling" , new OrderCancellingNotification());
        templates.put("orderPlacement", new OrderPlacementNotification());
        templates.put("orderShipment", new OrderShipmentNotification());

        channels.put("email", new EmailNotificationChannel());
        channels.put("sms", new SMSNotificationChannel());
    }

    public void createAndEnqueueNotification(String templateType, Order order , String channelType)
    {
        NotificationTemplate template = templates.get(templateType);
        String message = template.generateNotification(order);
        NotificationChannel channel = channels.get(channelType);

        channel.sendNotification(order.getOwner().getName(), message);



        ConcreteNotificationFactory notification = new ConcreteNotificationFactory();
        notification.createNotification(templateType);


        notificationsQueue.enqueueNotification((Notification) notification);
    }

    public List<Notification> listNotificationsQueueContent() {
        return notificationsQueue.getQueueContent();
    }
}
