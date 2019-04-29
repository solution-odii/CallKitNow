package com.solutionappstudio.callkit.Fragments;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.solutionappstudio.callkit.R;

/**
 * Created by ODII on 12/27/2018.
 */

public class AirtelFragment extends Fragment {
    public void AirtelFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // To inflate the layout resource file for airtelfragment
        View rootview = inflater.inflate(R.layout.fragment_airtel, container, false);


        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE},1);


        RelativeLayout customerCare = (RelativeLayout) rootview.findViewById(R.id.customer);
        RelativeLayout airtimeBal = (RelativeLayout)rootview.findViewById(R.id.airtime);
        RelativeLayout dataBalance = (RelativeLayout)rootview.findViewById(R.id.databalance);
        RelativeLayout recharge = (RelativeLayout)rootview.findViewById(R.id.recharge);
        RelativeLayout bankRecharge = (RelativeLayout)rootview.findViewById(R.id.buyairtime);
        RelativeLayout buyData = (RelativeLayout)rootview.findViewById(R.id.buydata);
        RelativeLayout nightPlan = (RelativeLayout)rootview.findViewById(R.id.nightplan);
        RelativeLayout borrowAirtime = (RelativeLayout)rootview.findViewById(R.id.borrowairtime);
        RelativeLayout airtimeTransfer = (RelativeLayout)rootview.findViewById(R.id.airtimetransfer);
        RelativeLayout dataShare = (RelativeLayout)rootview.findViewById(R.id.datashare);
        RelativeLayout tariff = (RelativeLayout)rootview.findViewById(R.id.tariff);
        RelativeLayout datagift = (RelativeLayout)rootview.findViewById(R.id.datagift);
        RelativeLayout borrowData = (RelativeLayout)rootview.findViewById(R.id.borrowdata);
        RelativeLayout mynumber = (RelativeLayout)rootview.findViewById(R.id.mynumber);
        RelativeLayout moreservices = (RelativeLayout)rootview.findViewById(R.id.moreservices);

        customerCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel:" + "111"));
                startActivity(call);
            }
        });
        airtimeBal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel:" + "*123%23"));
                startActivity(call);
            }
        });

        dataBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: " + "*140%23"));
                startActivity(call);
            }
        });

        //setting up the recharge with pin buttton
        recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater factory = LayoutInflater.from(getActivity());
                View dialogView = factory.inflate(R.layout.layout_dialog_input, null);
                TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                final EditText messagetext = (EditText) dialogView.findViewById(R.id.textdialog);
                Button proceedbtn =(Button)dialogView.findViewById(R.id.proceedbtn);
                Button cancelbtn = (Button)dialogView.findViewById(R.id.cancelbutton);
                final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                title.setText("Alert: Enter Card Pin");
                messagetext.setHint("Enter the Pin on the Recharge Card");
                customdialog.setView(dialogView);
                customdialog.show();
                proceedbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String cardPin;
                        cardPin = messagetext.getText().toString();
                        Intent call = new Intent(Intent.ACTION_CALL);
                        call.setData(Uri.parse("tel: " + "*126*" +cardPin+"%23"));
                        startActivity(call);
                        customdialog.dismiss();

                    }
                });
                cancelbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customdialog.dismiss();

                    }
                });



            }
        });

        //setting the bank recharge button
        bankRecharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater factory = LayoutInflater.from(getActivity());
                View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                title.setText("Notification");
                messagetext.setText("Sorry this Feature is not yet Available on this Network, Click to Home and Click on your Bank to Recharge");
                customdialog.setView(dialogView);
                customdialog.show();
                okbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customdialog.dismiss();


                    }
                });

//                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                builder.setTitle("Choose Amount");
//                builder.setIcon(R.drawable.airtelbankrecharge);
//                builder.setItems(new String[]{"100", "200", "300", "400", "500", "750", "1,000", "1,500", "2,000", "5,000", "10,000"}, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        if (which==0){
//                            Intent call = new Intent(Intent.ACTION_CALL);
//                            call.setData(Uri.parse("tel: " + "*904*100%23"));
//                            startActivity(call);
//                        }else if (which == 1){
//                            Intent call = new Intent(Intent.ACTION_CALL);
//                            call.setData(Uri.parse("tel: " + "*904*200%23"));
//                            startActivity(call);
//                        }else if (which == 2){
//                            Intent call = new Intent(Intent.ACTION_CALL);
//                            call.setData(Uri.parse("tel: " + "*904*300%23"));
//                            startActivity(call);
//                        }else if (which == 3){
//                            Intent call = new Intent(Intent.ACTION_CALL);
//                            call.setData(Uri.parse("tel: " + "*904*400%23"));
//                            startActivity(call);
//                        }else if (which == 4){
//                            Intent call = new Intent(Intent.ACTION_CALL);
//                            call.setData(Uri.parse("tel: " + "*904*500%23"));
//                            startActivity(call);
//                        }else if (which == 5){
//                            Intent call = new Intent(Intent.ACTION_CALL);
//                            call.setData(Uri.parse("tel: " + "*904*750%23"));
//                            startActivity(call);
//                        }else if (which == 6){
//                            Intent call = new Intent(Intent.ACTION_CALL);
//                            call.setData(Uri.parse("tel: " + "*904*1000%23"));
//                            startActivity(call);
//                        }else if (which == 7){
//                            Intent call = new Intent(Intent.ACTION_CALL);
//                            call.setData(Uri.parse("tel: " + "*904*1500%23"));
//                            startActivity(call);
//                        }else if (which == 8){
//                            Intent call = new Intent(Intent.ACTION_CALL);
//                            call.setData(Uri.parse("tel: " + "*904*2000%23"));
//                            startActivity(call);
//                        }else if (which == 9){
//                            Intent call = new Intent(Intent.ACTION_CALL);
//                            call.setData(Uri.parse("tel: " + "*904*5000%23"));
//                            startActivity(call);
//                        }else if (which == 10){
//                            Intent call = new Intent(Intent.ACTION_CALL);
//                            call.setData(Uri.parse("tel: " + "*904*10000%23"));
//                            startActivity(call);
//                        }
//                    }
//                });
//                builder.create().show();
            }
        });


        buyData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: " + "*121%23"));
                startActivity(call);
            }
        });

        nightPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: " + "*312%23"));
                startActivity(call);
            }
        });

        borrowAirtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: " + "*500%23"));
                startActivity(call);
            }
        });

        airtimeTransfer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: " + "*141%23"));
                startActivity(call);
            }
        });

        dataShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: " + "*141%23"));
                startActivity(call);
            }
        });

        tariff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: " + "*121%23"));
                startActivity(call);
            }
        });

        datagift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: " + "*141%23"));
                startActivity(call);
            }
        });

        borrowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: " + "*500%23"));
                startActivity(call);
            }
        });

        mynumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: " + "*282%23"));
                startActivity(call);
            }
        });

        moreservices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: " + "*121%23"));
                startActivity(call);
            }
        });







        return rootview;
    }
}

