package cl.zecovery.android.sidcoalert.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.NotificationCompat;

import cl.zecovery.android.sidcoalert.R;
import cl.zecovery.android.sidcoalert.activity.NotificationActivity;

/**
 * Created by fran on 11-03-16.
 */
public class DisplayNotification {

    private int notificationIdOne = 1111;
    private Intent notificationIntent;

    public DisplayNotification() {
    }

    public void sendSimpleNotification(Context c) {

        notificationIntent = new Intent(c, NotificationActivity.class);

        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(c);
        taskStackBuilder.addParentStack(NotificationActivity.class);
        taskStackBuilder.addNextIntent(notificationIntent);

        PendingIntent pendingIntent =
                taskStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager notificationManager = (NotificationManager) c.getSystemService(Context.NOTIFICATION_SERVICE);
        Resources res = c.getResources();

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(c);
        mBuilder
                .setContentText(res.getString(R.string.notification_text))
                .setContentTitle(res.getString(R.string.notification_title))
                .setTicker(res.getString(R.string.notification_ticker))
                .setAutoCancel(true)
                .setColor(0xff123456)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_stat_notification)
                .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.warning_icon));

        notificationManager.notify(notificationIdOne, mBuilder.build());
    }
}
