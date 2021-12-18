package com.dev.playground.solid.ocp;

/*
Open Close Principle:
Objects or Entities should be open for extension but closed for modification.
*/

//==BEFORE=========================================

/*
Here NotificationServicex  is open to extend its functionality but with modification that should not as per the OCP
*/
class NotificationServicex {
    void sendNotification(String medium) {
        if (medium.equals("email")) {
            // Logic to integrate mail api
        }
        if (medium.equals("mobile")) {
            // Logic to integrate mobile sms api
        }
    }
}

//==With OCP========================================

/*
Now NotificationService is open to extend its functionality without modifying it
*/
interface NotificationService{
    void sendNotification();
}

class EmailNotificationService implements NotificationService {

    @Override
    public void sendNotification() {
        // Logic to integrate mail api
    }
}

class MobileNotificationService implements NotificationService {

    @Override
    public void sendNotification() {
        // Logic to integrate mobile sms api
    }
}

class WhatsAppNotificationService implements NotificationService {

    @Override
    public void sendNotification() {
        // Logic to integrate whats app api
    }
}

//=============
public class OpenCloseEx1 {
    public static void main(String[] arr) {

    }
}
