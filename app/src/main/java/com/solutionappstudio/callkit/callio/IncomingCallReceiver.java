package com.solutionappstudio.callkit.callio;

/**
 * Created by Solution on 6/4/2019.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import java.util.Date;

public abstract class IncomingCallReceiver extends BroadcastReceiver {

    private static String number="";
    private static int lastState= TelephonyManager.CALL_STATE_IDLE;
    private static Date callStartTime;
    private static boolean isIncoming;
    private static String savedNumber;
    public IncomingCallReceiver(){

    }
    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")){
            number=intent.getExtras().getString("android.intent.extra.PHONE_NUMBER");
            //outgoing call
        }else{
            String stateStr=intent.getExtras().getString(TelephonyManager.EXTRA_STATE);
            String number=intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
            int state=0;

            if(stateStr.equals(TelephonyManager.EXTRA_STATE_IDLE)){
                state=TelephonyManager.CALL_STATE_IDLE;
            }else if(stateStr.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)){
                state=TelephonyManager.CALL_STATE_OFFHOOK;
            }else if(stateStr.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                state=TelephonyManager.CALL_STATE_RINGING;
            }
            onCallStateChanged(context, state, number);
        }
    }

    protected abstract void onIncomingCallReceived(Context c, String number, Date start);
    protected abstract void onIncomingCallAnswered(Context c, String number, Date start);
    protected abstract void onIncomingCallEnded(Context c, String number, Date start, Date end);

    protected abstract void onOutgoingCallStarted(Context c, String number, Date start);
    protected abstract void onOutgoingCallEnded(Context c, String number, Date start, Date end);

    protected abstract void onMissedCall(Context c, String number, Date start);

    public void onCallStateChanged(Context c, int state, String number){
        if(lastState==state){
            return;
        }
        switch (state){
            case TelephonyManager.CALL_STATE_RINGING:
                isIncoming=true;
                callStartTime=new Date();
                savedNumber=number;
                onIncomingCallReceived(c,savedNumber,callStartTime);
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                if(lastState!=TelephonyManager.CALL_STATE_RINGING){
                    isIncoming=false;
                    callStartTime=new Date();
                    onOutgoingCallStarted(c, savedNumber, callStartTime);
                }else{
                    isIncoming=true;
                    callStartTime=new Date();
                    onIncomingCallAnswered(c,savedNumber,callStartTime);
                }
                break;
            case TelephonyManager.CALL_STATE_IDLE:
                if (lastState==TelephonyManager.CALL_STATE_RINGING){
                    onMissedCall(c,savedNumber,callStartTime);
                }else if (isIncoming){
                    onIncomingCallEnded(c,savedNumber,callStartTime, new Date());
                }else{
                    onOutgoingCallEnded(c, savedNumber, callStartTime, new Date());
                }
                break;

        }
        lastState=state;
    }

}
