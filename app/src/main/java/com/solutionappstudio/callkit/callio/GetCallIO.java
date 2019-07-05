package com.solutionappstudio.callkit.callio;

/**
 * Created by Solution on 6/4/2019.
 */


import android.app.NotificationManager;
import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import java.util.Date;

import com.solutionappstudio.callkit.R;


public class GetCallIO extends IncomingCallReceiver {

    @Override
    protected void onIncomingCallReceived(Context c, String number, Date start) {
        showDialog(c, "Call", "Do you want to receive call from " + number, true);
    }

    @Override
    protected void onIncomingCallAnswered(Context c, String number, Date start) {
        showDialog(c, "Call", "You have Answered " + number, true);
    }

    @Override
    protected void onIncomingCallEnded(Context c, String number, Date start, Date end) {
        showDialog(c, "Call", "Call from " + number, true);
    }

    @Override
    protected void onOutgoingCallStarted(Context c, String number, Date start) {
        showDialog(c, "Call", "Dialing " + number, true);
    }

    @Override
    protected void onOutgoingCallEnded(Context c, String number, Date start, Date end) {
        showDialog(c, "Call", "Dialing " + number + " Ended", true);
    }

    @Override
    protected void onMissedCall(Context c, String number, Date start) {
        showDialog(c, "Call", "Missed a call from " + number, true);
    }

    private void showDialog(Context c, String title, String msg, boolean isCancellable){
        Notify(c, msg);

    }


    private void Notify(Context c, String title){
        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(c)
                .setSmallIcon(R.drawable.callkitlogo)
                .setContentTitle("Call Kit")
                .setContentText(title)
                .setSound(defaultSoundUri)
                .setTicker(title);

        NotificationManager notificationManager=
                (NotificationManager) c.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuilder.build());

    }
}
