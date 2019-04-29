package com.solutionappstudio.callkit.Fragments;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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

public class GloFragment extends Fragment {
    public void GLOFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_glo, container, false);

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
                call.setData(Uri.parse("tel:" + "121"));
                startActivity(call);
            }
        });
        airtimeBal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel:" + "%23124*1%23"));
                startActivity(call);
            }
        });

        dataBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: " + "*127*0%23"));
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
                        call.setData(Uri.parse("tel: " + "*123*" +cardPin+"%23"));
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
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Choose Amount");
                builder.setIcon(R.drawable.globuyairtimefrombank);
                builder.setItems(new String[]{"100", "200", "300", "400", "500", "750", "1,000", "1,500", "2,000", "5,000", "10,000"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which==0){
                            Intent call = new Intent(Intent.ACTION_CALL);
                            call.setData(Uri.parse("tel: " + "*805*100%23"));
                            startActivity(call);
                        }else if (which == 1){
                            Intent call = new Intent(Intent.ACTION_CALL);
                            call.setData(Uri.parse("tel: " + "*805*200%23"));
                            startActivity(call);
                        }else if (which == 2){
                            Intent call = new Intent(Intent.ACTION_CALL);
                            call.setData(Uri.parse("tel: " + "*805*300%23"));
                            startActivity(call);
                        }else if (which == 3){
                            Intent call = new Intent(Intent.ACTION_CALL);
                            call.setData(Uri.parse("tel: " + "*805*400%23"));
                            startActivity(call);
                        }else if (which == 4){
                            Intent call = new Intent(Intent.ACTION_CALL);
                            call.setData(Uri.parse("tel: " + "*805*500%23"));
                            startActivity(call);
                        }else if (which == 5){
                            Intent call = new Intent(Intent.ACTION_CALL);
                            call.setData(Uri.parse("tel: " + "*805*750%23"));
                            startActivity(call);
                        }else if (which == 6){
                            Intent call = new Intent(Intent.ACTION_CALL);
                            call.setData(Uri.parse("tel: " + "*805*1000%23"));
                            startActivity(call);
                        }else if (which == 7){
                            Intent call = new Intent(Intent.ACTION_CALL);
                            call.setData(Uri.parse("tel: " + "*805*1500%23"));
                            startActivity(call);
                        }else if (which == 8){
                            Intent call = new Intent(Intent.ACTION_CALL);
                            call.setData(Uri.parse("tel: " + "*805*2000%23"));
                            startActivity(call);
                        }else if (which == 9){
                            Intent call = new Intent(Intent.ACTION_CALL);
                            call.setData(Uri.parse("tel: " + "*805*5000%23"));
                            startActivity(call);
                        }else if (which == 10){
                            Intent call = new Intent(Intent.ACTION_CALL);
                            call.setData(Uri.parse("tel: " + "*805*10000%23"));
                            startActivity(call);
                        }
                    }
                });
                builder.create().show();
            }
        });


        buyData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: " + "*777%23"));
                startActivity(call);
            }
        });

        nightPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater factory = LayoutInflater.from(getActivity());
                View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                title.setText("Alert!");
                messagetext.setText("Request to buy Night plan 1GB @200");
                okbtn.setText("Proceed");
                customdialog.setView(dialogView);
                customdialog.show();
                okbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customdialog.dismiss();
                        Intent call = new Intent(Intent.ACTION_CALL);
                        call.setData(Uri.parse("tel: " + "*127*60%23"));
                        startActivity(call);

                    }
                });


            }
        });

        borrowAirtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: " + "*321%23"));
                startActivity(call);
            }
        });

        airtimeTransfer.setOnClickListener(new View.OnClickListener() {
            String phonenum, amt, pin;
            EditText messagetext1, messagetext2, messagetext3;
            @Override
            public void onClick(View v) {
                LayoutInflater factory = LayoutInflater.from(getActivity());
                View dialogView = factory.inflate(R.layout.layout_dialog_input, null);
                TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                messagetext1 = (EditText) dialogView.findViewById(R.id.textdialog);
                Button proceedbtn =(Button)dialogView.findViewById(R.id.proceedbtn);
                Button cancelbtn = (Button)dialogView.findViewById(R.id.cancelbutton);
                final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                title.setText("Alert: Enter Phone Number");
                messagetext1.setHint("Enter the Recipient's Phone Number");
                customdialog.setView(dialogView);
                customdialog.show();
                proceedbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customdialog.dismiss();
                        LayoutInflater factory = LayoutInflater.from(getActivity());
                        View dialogView = factory.inflate(R.layout.layout_dialog_input, null);
                        TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                        messagetext2 = (EditText) dialogView.findViewById(R.id.textdialog);
                        Button proceedbtn =(Button)dialogView.findViewById(R.id.proceedbtn);
                        Button cancelbtn = (Button)dialogView.findViewById(R.id.cancelbutton);
                        final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                        title.setText("Alert: Enter Amount");
                        messagetext2.setHint("Enter the Amount of Airtime to be Transferred");
                        customdialog.setView(dialogView);
                        customdialog.show();
                        proceedbtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                customdialog.dismiss();
                                LayoutInflater factory = LayoutInflater.from(getActivity());
                                View dialogView = factory.inflate(R.layout.layout_dialog_input, null);
                                TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                messagetext3 = (EditText) dialogView.findViewById(R.id.textdialog);
                                Button proceedbtn =(Button)dialogView.findViewById(R.id.proceedbtn);
                                Button cancelbtn = (Button)dialogView.findViewById(R.id.cancelbutton);
                                final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                title.setText("Alert: Enter Pin");
                                messagetext3.setHint("Enter Your Transfer PIN");
                                customdialog.setView(dialogView);
                                customdialog.show();
                                proceedbtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        customdialog.dismiss();
                                        phonenum=messagetext1.getText().toString();
                                        amt=messagetext2.getText().toString();
                                        pin=messagetext3.getText().toString();
                                        Intent call = new Intent(Intent.ACTION_CALL);
                                        call.setData(Uri.parse("tel: " + "*131*"+phonenum+"*"+amt+"*"+pin+"%23"));
                                        startActivity(call);

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
                        cancelbtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                customdialog.dismiss();

                            }
                        });

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

        dataShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater factory = LayoutInflater.from(getActivity());
                View dialogView = factory.inflate(R.layout.layout_dialog_input, null);
                TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                final EditText messagetext = (EditText) dialogView.findViewById(R.id.textdialog);
                Button proceedbtn =(Button)dialogView.findViewById(R.id.proceedbtn);
                Button cancelbtn = (Button)dialogView.findViewById(R.id.cancelbutton);
                final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                title.setText("Alert: Enter Phone Number");
                messagetext.setHint("Enter Friends's Phone Number");
                customdialog.setView(dialogView);
                customdialog.show();
                proceedbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customdialog.dismiss();
                        String phonenum;
                        phonenum=messagetext.getText().toString();
                        Intent call = new Intent(Intent.ACTION_CALL);
                        call.setData(Uri.parse("tel: " + "*127*01*"+phonenum+"%23"));
                        startActivity(call);

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

        tariff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Select Plan");
                builder.setItems(new String[]{"GLO 11k/s Prepaid Plan", "GLO Jollific8", "GLO Infinito", "GLO FREE Tomorrow Plan", "GLO Bumpa", "GLO Yakata"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which==0){
                            Intent call = new Intent(Intent.ACTION_CALL);
                            call.setData(Uri.parse("tel: " + "*211%23"));
                            startActivity(call);
                        }else if (which==1){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                            TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                            TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                            Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                            final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            title.setText("Notification");
                            messagetext.setText("Just buy a new sim and load your recharge card with *123*PIN#");
                            customdialog.setView(dialogView);
                            customdialog.show();
                            okbtn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    customdialog.dismiss();


                                }
                            });
                        }else if (which==2){
                            Intent call = new Intent(Intent.ACTION_CALL);
                            call.setData(Uri.parse("tel: " + "*100*9*2%23"));
                            startActivity(call);

                        }else if (which==3){
                            Intent call = new Intent(Intent.ACTION_CALL);
                            call.setData(Uri.parse("tel: " + "*300%23"));
                            startActivity(call);

                        }else if (which==4){
                            Intent call = new Intent(Intent.ACTION_CALL);
                            call.setData(Uri.parse("tel: " + "*100*10*1%23"));
                            startActivity(call);


                        }else if (which==5){
                            Intent call = new Intent(Intent.ACTION_CALL);
                            call.setData(Uri.parse("tel: " + "*220%23"));
                            startActivity(call);
                        }
                    }
                });
                builder.create().show();
            }
        });

        datagift.setOnClickListener(new View.OnClickListener() {
            String plannumber,phonenum;
            EditText messagetext1, messagetext2;

            @Override
            public void onClick(View v) {
                LayoutInflater factory = LayoutInflater.from(getActivity());
                View dialogView = factory.inflate(R.layout.layout_dialog_input, null);
                TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                messagetext1 = (EditText) dialogView.findViewById(R.id.textdialog);
                Button proceedbtn =(Button)dialogView.findViewById(R.id.proceedbtn);
                Button cancelbtn = (Button)dialogView.findViewById(R.id.cancelbutton);
                final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                title.setText("Alert: Enter Plan USSD");
                messagetext1.setHint("Enter the USSD Code for your current plan");
                customdialog.setView(dialogView);
                customdialog.show();
                proceedbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customdialog.dismiss();
                        LayoutInflater factory = LayoutInflater.from(getActivity());
                        View dialogView = factory.inflate(R.layout.layout_dialog_input, null);
                        TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                        messagetext2 = (EditText) dialogView.findViewById(R.id.textdialog);
                        Button proceedbtn =(Button)dialogView.findViewById(R.id.proceedbtn);
                        Button cancelbtn = (Button)dialogView.findViewById(R.id.cancelbutton);
                        final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                        title.setText("Alert: Enter Phone Number");
                        messagetext2.setHint("Enter Friends's Phone Number");
                        customdialog.setView(dialogView);
                        customdialog.show();
                        proceedbtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                customdialog.dismiss();
                                plannumber=messagetext1.getText().toString();
                                phonenum=messagetext2.getText().toString();
                                Intent call = new Intent(Intent.ACTION_CALL);
                                call.setData(Uri.parse("tel: " + "*127*"+plannumber+"*"+phonenum+"%23"));
                                startActivity(call);

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
                cancelbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customdialog.dismiss();

                    }
                });

            }
        });

        borrowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: " + "*321%23"));
                startActivity(call);
            }
        });

        mynumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: " + "1244"));
                startActivity(call);
            }
        });

        moreservices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: " + "*777%23"));
                startActivity(call);
            }
        });







        return rootview;
    }
}
