package com.example.SDA_2.Models.Notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationsQueue {
    private List<Notification> queue = new ArrayList<>();

    public void enqueueNotification(Notification notification) {
        queue.add(notification);
    }

    public List<Notification> getQueueContent() {
        return queue;
    }
}
