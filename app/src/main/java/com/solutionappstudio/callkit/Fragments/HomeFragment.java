package com.solutionappstudio.callkit.Fragments;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.solutionappstudio.callkit.R;

/**
 * Created by ODII on 12/27/2018.
 */


public class HomeFragment extends Fragment {

    String diamondacctnumber = "0076308579";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.SEND_SMS, Manifest.permission.READ_CONTACTS}, 1);

        }


        //call kit self services

        //buy data services
        ImageView buydataservices = (ImageView) rootView.findViewById(R.id.imageView2);
        buydataservices.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Select Amount");
                builder.setItems(new String[]{
                       "Check Call Kit Data Balance",

                       "MTN 1GB (90days) at #600",
                       "MTN 2GB (90days) at #1,200",
                       "MTN 5GB (90days) at #2,500",

                       "GLO 2GB (30days) at #950",
                       "GLO 4.5GB (30days) at #1,950",
                       "GLO 7.2GB (30days) at #2,300",
                       "GLO 8.2GB (30days) at #2,800",
                       "GLO 12.5GB (30days) at #3,750",
                       "GLO 15.6GB (30days) at #4,600",
                       "GLO 25GB (30days) at #7,500",
                       "GLO 32.5GB (30days) at #9,000",
                       "GLO 52.5GB (30days) at #14,000",

                       "Airtel 1.5GB (30days) at #1,100",
                       "Airtel 3.5GB (30days) at #2,100",
                       "Airtel 5GB (30days) at #2,600",
                       "Airtel 7GB (30days) at #3,500",

                        "9Mobile 1GB (30days) at #800",
                        "9Mobile 1.5GB (30days) at #1,100",
                        "9Mobile 2GB (30days) at #1,400",
                        "9Mobile 3GB (30days) at #2,100",
                        "9Mobile 5GB (30days) at #3,500",
                        "9Mobile 11.5GB (30days) at #7,200",
                        "9Mobile 15GB (30days) at #9,000",
                        "9Mobile 27.5GB (30days) at #16,500"

                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which==0){
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                            builder1.setItems(new String[]{"MTN", "GLO", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (which==0){
                                        Intent call = new Intent(Intent.ACTION_CALL);
                                        call.setData(Uri.parse("tel:" + "*461*2*3*2%23"));
                                        startActivity(call);
                                    }else if (which==1){
                                        Intent call = new Intent(Intent.ACTION_CALL);
                                        call.setData(Uri.parse("tel:" + "*127*0%23"));
                                        startActivity(call);
                                    }else if (which==2){
                                        Intent call = new Intent(Intent.ACTION_CALL);
                                        call.setData(Uri.parse("tel:" + "*140%23"));
                                        startActivity(call);
                                    }else if (which==3){
                                        Intent call = new Intent(Intent.ACTION_CALL);
                                        call.setData(Uri.parse("tel:" + "*229*9%23"));
                                        startActivity(call);
                                    }
                                }
                            });

                            builder1.create().show();
                        }
                        else if (which==1){

                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view, null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView(buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"600"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"600"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });

                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==2){

                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();


                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*1200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*1200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*1200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"1200"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*1200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*1200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*1200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"1200"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*1200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*1200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });




                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });


                        }else if (which==3){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();



                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*2500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*2500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*2500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"2500"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*2500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*2500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*2500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"2500"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*2500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*2500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });


                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==4){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();



                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"950"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"950"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });



                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==5){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView(buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*1950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*1950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*1950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"1950"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*1950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*1950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*1950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"1950"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*1950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*1950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });





                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==6){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView(buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*2300*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*2300*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*2300*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"2300"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*2300*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*2300*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*2300*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"2300"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*2300*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*2300*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });



                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });

                                }
                            });

                        }else if (which==7){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*2800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*2800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*2800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"2800"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*2800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*2800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*2800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"2800"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*2800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*2800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });



                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==8){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();


                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*3750*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*3750*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*3750*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"3750"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*3750*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*3750*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*3750*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"3750"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*3750*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*3750*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });




                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });

                                }
                            });

                        }else if (which==9){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*4600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*4600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*4600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"4600"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*4600"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*4600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*4600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"4600"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*4600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*4600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });


                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==10){

                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view, null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView(buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*7500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*7500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*7500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"7500"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*7500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*7500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*7500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"7500"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*7500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*7500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });

                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==11){

                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view, null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView(buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*9000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*9000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*9000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"9000"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*9000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*9000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*9000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"9000"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*9000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*9000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });

                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==12){

                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view, null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView(buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*14000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*14000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*14000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"14000"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*14000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*14000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*14000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"14000"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*14000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*14000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });

                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==13){

                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view, null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView(buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"1100"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"1100"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });

                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        } else if (which==14){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"2100"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"2100"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });


                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==15){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*2600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*2600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*2600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"2600"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*2600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*2600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*2600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"2600"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*2600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*2600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });


                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==16){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*3500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*3500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*3500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"3500"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*3500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*3500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*3500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"3500"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*3500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*3500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });


                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==17){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"800"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"800"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });


                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==18){

                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view, null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView(buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"1100"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"1100"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });

                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        } else if (which==19){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*1400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*1400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*1400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"1400"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*1400"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*1400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*1400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"1400"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*1400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*1400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });


                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==20){

                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view, null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView(buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"2100"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"2100"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });

                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }


                        else if (which==21){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout) buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout) buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout) buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*3500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*3500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*3500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"3500"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*3500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*3500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*3500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"3500"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*3500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*3500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });


                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==22){

                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view, null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView(buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*7200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*7200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*7200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"7200"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*7200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*7200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*7200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"7200"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*7200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*7200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });

                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==23){

                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view, null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView(buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*9000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*9000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*9000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"9000"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*9000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*9000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*9000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"9000"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*9000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*9000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });

                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==24){

                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view, null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView(buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*16500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*16500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*16500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"16500"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*16500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*16500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*16500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"16500"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*16500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*16500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });

                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Phone No: 08001001000 (MTN/Airtel/GLO/9Mobile)");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }


                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }







                    }


                });
                builder.create().show();
            }
        });





        //===================================================================================================================
        //===================================================================================================================

        //airtime to cash

        ImageView convertairtime = (ImageView) rootView.findViewById(R.id.imageView6);
        convertairtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater factory = LayoutInflater.from(getActivity());
                View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                title.setText("How it Works");
                messagetext.setText("You send us Airtime to any of our Networks and then we send you 80%(MTN), 75%(9Mobile) and 60-65%(GLO) of the Airtime to your Bank Account" +
                        " \n Its Fun right? Click OK to Proceed");
                customdialog.setView(dialogView);
                customdialog.show();
                okbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customdialog.dismiss();
                        LayoutInflater factory = LayoutInflater.from(getActivity());
                        final View convertAirtimeView = factory.inflate(R.layout.layout_convertairtime_transaction,  null);
                        RelativeLayout convertairtimetocash = (RelativeLayout) convertAirtimeView.findViewById(R.id.convertairtimebutton);
                        RelativeLayout sendacctdetails = (RelativeLayout) convertAirtimeView.findViewById(R.id.sendacctdetails);
                        RelativeLayout callkitcustomercare = (RelativeLayout) convertAirtimeView.findViewById(R.id.callkitcustomercare);
                        final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                        customdialog.setView(convertAirtimeView);
                        customdialog.show();

                        convertairtimetocash.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                builder.setTitle("Select Network");
                                builder.setItems(new String[]{"MTN", "GLO", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                    String amt, pin;
                                    EditText messagetext1, messagetext2;
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if(which==0){

                                            LayoutInflater factory = LayoutInflater.from(getActivity());
                                            View dialogView = factory.inflate(R.layout.layout_dialog_input, null);
                                            TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                            messagetext1 = (EditText) dialogView.findViewById(R.id.textdialog);
                                            Button proceedbtn =(Button)dialogView.findViewById(R.id.proceedbtn);
                                            Button cancelbtn = (Button)dialogView.findViewById(R.id.cancelbutton);
                                            final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                            title.setText("Alert: Enter Amount");
                                            messagetext1.setHint("Enter the Amount of Airtime to be Converted");
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
                                                    title.setText("Alert: Enter Pin");
                                                    messagetext2.setHint("Enter Your Airtime Transfer PIN");
                                                    customdialog.setView(dialogView);
                                                    customdialog.show();
                                                    proceedbtn.setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View v) {
                                                            amt =messagetext1.getText().toString();
                                                            pin = messagetext2.getText().toString();
                                                            Intent call = new Intent(Intent.ACTION_CALL);
                                                            call.setData(Uri.parse("tel: " + "*600*09033433276*" +amt+"*"+pin+"%23"));
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
                                            cancelbtn.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    customdialog.dismiss();

                                                }
                                            });
                                        }else if (which==1){
                                            LayoutInflater factory = LayoutInflater.from(getActivity());
                                            View dialogView = factory.inflate(R.layout.layout_dialog_input, null);
                                            TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                            messagetext1 = (EditText) dialogView.findViewById(R.id.textdialog);
                                            Button proceedbtn =(Button)dialogView.findViewById(R.id.proceedbtn);
                                            Button cancelbtn = (Button)dialogView.findViewById(R.id.cancelbutton);
                                            final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                            title.setText("Alert: Enter Amount");
                                            messagetext1.setHint("Enter the Amount of Airtime to be Converted");
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
                                                    title.setText("Alert: Enter Pin");
                                                    messagetext2.setHint("Enter Your Airtime Transfer PIN");
                                                    customdialog.setView(dialogView);
                                                    customdialog.show();
                                                    proceedbtn.setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View v) {
                                                            amt =messagetext1.getText().toString();
                                                            pin = messagetext2.getText().toString();
                                                            Intent call = new Intent(Intent.ACTION_CALL);
                                                            call.setData(Uri.parse("tel: " + "*131*08116446110*" +amt+"*"+pin+"%23"));
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
                                            cancelbtn.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    customdialog.dismiss();

                                                }
                                            });
                                        }else if (which==2){

                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Alert");
                                            builder.setMessage("Sorry this feature is not available yet on Airtel");
                                            builder.create().show();
//                                                    LayoutInflater factory = LayoutInflater.from(getActivity());
//                                                    View dialogView = factory.inflate(R.layout.layout_dialog_input, null);
//                                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
//                                                    messagetext1 = (EditText) dialogView.findViewById(R.id.textdialog);
//                                                    Button proceedbtn =(Button)dialogView.findViewById(R.id.proceedbtn);
//                                                    Button cancelbtn = (Button)dialogView.findViewById(R.id.cancelbutton);
//                                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
//                                                    title.setText("Alert: Enter Amount");
//                                                    messagetext1.setHint("Enter the Amount of Airtime to be Converted");
//                                                    customdialog.setView(dialogView);
//                                                    customdialog.show();
//                                                    proceedbtn.setOnClickListener(new View.OnClickListener() {
//                                                        @Override
//                                                        public void onClick(View v) {
//                                                            customdialog.dismiss();
//                                                            LayoutInflater factory = LayoutInflater.from(getActivity());
//                                                            View dialogView = factory.inflate(R.layout.layout_dialog_input, null);
//                                                            TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
//                                                            messagetext2 = (EditText) dialogView.findViewById(R.id.textdialog);
//                                                            Button proceedbtn =(Button)dialogView.findViewById(R.id.proceedbtn);
//                                                            Button cancelbtn = (Button)dialogView.findViewById(R.id.cancelbutton);
//                                                            final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
//                                                            title.setText("Alert: Enter Pin");
//                                                            messagetext2.setHint("Enter Your Airtime Transfer PIN");
//                                                            customdialog.setView(dialogView);
//                                                            customdialog.show();
//                                                            proceedbtn.setOnClickListener(new View.OnClickListener() {
//                                                                @Override
//                                                                public void onClick(View v) {
//                                                                    amt =messagetext1.getText().toString();
//                                                                    pin = messagetext2.getText().toString();
//                                                                    Intent call = new Intent(Intent.ACTION_CALL);
//                                                                    call.setData(Uri.parse("tel: " + "*141*08127959885" +amt+"*"+pin+"%23"));
//                                                                    startActivity(call);
//                                                                    customdialog.dismiss();
//
//                                                                }
//                                                            });
//                                                            cancelbtn.setOnClickListener(new View.OnClickListener() {
//                                                                @Override
//                                                                public void onClick(View v) {
//                                                                    customdialog.dismiss();
//
//                                                                }
//                                                            });
//
//                                                        }
//                                                    });
//                                                    cancelbtn.setOnClickListener(new View.OnClickListener() {
//                                                        @Override
//                                                        public void onClick(View v) {
//                                                            customdialog.dismiss();
//
//                                                        }
//                                                    });
                                        }else if (which==3){
                                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                                    View dialogView = factory.inflate(R.layout.layout_dialog_input, null);
                                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                                    messagetext1 = (EditText) dialogView.findViewById(R.id.textdialog);
                                                    Button proceedbtn =(Button)dialogView.findViewById(R.id.proceedbtn);
                                                    Button cancelbtn = (Button)dialogView.findViewById(R.id.cancelbutton);
                                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                                    title.setText("Alert: Enter Amount");
                                                    messagetext1.setHint("Enter the Amount of Airtime to be Converted");
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
                                                            title.setText("Alert: Enter Pin");
                                                            messagetext2.setHint("Enter Your Airtime Transfer PIN");
                                                            customdialog.setView(dialogView);
                                                            customdialog.show();
                                                            proceedbtn.setOnClickListener(new View.OnClickListener() {
                                                                @Override
                                                                public void onClick(View v) {
                                                                    amt =messagetext1.getText().toString();
                                                                    pin = messagetext2.getText().toString();
                                                                    Intent call = new Intent(Intent.ACTION_CALL);
                                                                    call.setData(Uri.parse("tel: " + "*223*" +pin+"*"+amt+"*"+ "08181291295" + "%23"));
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
                                                    cancelbtn.setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View v) {
                                                            customdialog.dismiss();

                                                        }
                                                    });
                                        }
                                    }
                                });
                                builder.create().show();
                            }
                        });


                        sendacctdetails.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                LayoutInflater factory = LayoutInflater.from(getActivity());
                                View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                title.setText("Notification");
                                messagetext.setText("Click OK to Text us The Amount of Airtime You Sent and  Your Account Details to get your Money back instantly");
                                customdialog.setView(dialogView);
                                customdialog.show();
                                okbtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        customdialog.dismiss();
                                        Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                        getActivity().startActivity(smsIntent);

                                    }
                                });


                            }
                        });

                        callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                builder.setTitle("Select any of Our Customer Care Lines");
                                builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if (which==0){
                                            Intent call = new Intent(Intent.ACTION_CALL);
                                            call.setData(Uri.parse("tel: " + "08116446110"));
                                            startActivity(call);
                                        }else if (which==1){
                                            Intent call = new Intent(Intent.ACTION_CALL);
                                            call.setData(Uri.parse("tel: " + "09033433276"));
                                            startActivity(call);
                                        }else if (which==2){
                                            Intent call = new Intent(Intent.ACTION_CALL);
                                            call.setData(Uri.parse("tel: " + "08127959885"));
                                            startActivity(call);
                                        }else if (which == 3) {
                                            Intent call = new Intent(Intent.ACTION_CALL);
                                            call.setData(Uri.parse("tel: " + "08181291295"));
                                            startActivity(call);
                                        }

                                    }
                                });
                                builder.create().show();
                            }
                        });


                    }
                });



            }
        });














//================================================================================================================================
//================================================================================================================================
        //airtime services
        ImageView buyairtime = (ImageView) rootView.findViewById(R.id.imageView5);
        buyairtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Select Amount");
                builder.setItems(new String[]{"100 Airtime at #98", "200 Airtime at #195", "400 Airtime at #395",
                        "500 Airtime at #495", "750 Airtime at #740", "1,000 Airtime at #990", "1,500 Airtime at #1480",
                        "5000 Airtime at #4950", "10,000 Airtime at #9900"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which==0){

                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*98*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*98*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*98*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"98"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*98*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*98*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*98*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"98"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*98*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*98*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });

                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited and the Network Service");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==1){

                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout) buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();


                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*195*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*195*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*195*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"195"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*195"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*195*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*195*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"195"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*195*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*195*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });




                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited & the Network Service");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });


                        }else if (which==2){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();



                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*395*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*395*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*395*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"395"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*395*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*395*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*395*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"395"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*395*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*395*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });


                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited & the Network Service");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==3){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();



                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*495*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*495*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*495*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"495"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*495*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*495*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*495*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"495"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*495*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*495*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });



                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited & the Network Service");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==4){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*740*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*740*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*740*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"740"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*740*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*740*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*740*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"740"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*740*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*740*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });





                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited & the Network Service");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==5){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*990*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*990*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*990*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"990"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*990"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*990*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*990*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"990"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*990*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*990*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });



                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited & the Network Service");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });

                                }
                            });

                        }else if (which==6){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*1480*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*1480*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*1480*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"1480"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*1480*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*1480*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*1480*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"1480"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*1480*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*1480*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });



                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited & the Network Service");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==7){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();


                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*4950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*4950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*4950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"4950"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*4950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*4950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*4950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"4950"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*4950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*4950*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });




                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited & the Network Service");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });

                                }
                            });

                        }else if (which==8){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*9900*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*9900*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*9900*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"9900"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*9900*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*9900*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*9900*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"9900"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*9900*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*9900*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });


                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Phone Number to be Credited & the Network Service");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }
                    }
                });
                builder.create().show();
            }
        });



























//================================================================================================================================
//================================================================================================================================




        //bill payment services

        ImageView billspayment = (ImageView)rootView.findViewById(R.id.imageView3);
        billspayment.setOnClickListener(new View.OnClickListener() {
            String diamondacctnumber="0076308579";
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Select Amount");
                builder.setItems(new String[]{"Startimes Nova at #900", "Startimes Basic at #1,300", "Startimes Smart at #1,900",
                        "Startimes Classic at #2,600", "Startimes Unique at #3,800", "GoTV Lite Monthly at #400", "GoTV Value at #1,250",
                        "GoTV Plus at #1,900", "GoTV Max at #3,200", "DSTV Access at #2,000",
                        "DSTV Family at #4,000", "DSTV Access+HD/Extra at #4,200", "DSTV Family+HD/Extra at #6,200",
                        "DSTV Compact at #6,800", "DSTV Compact+HD/Extra at #9,000", "DSTV Compact Plus at #10,650",
                        "DSTV Compact Plus+HD/Extra at #12,850", "DSTV Premium at #15,800", "DSTV Premium+HD/Extra at #18,000"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which==0){

                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"1100"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"1100"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*1100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });

                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Decoder/SmartCard Number to be Credited and the Subscription Type " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Decoder/SmartCard No: 08001001000 " +
                                            "\n Sub Type: GoTV Plus/Dstv Compact");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==1){

                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();


                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*1500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*1500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*1500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"1500"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*1500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*1500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*1500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"1500"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*1500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*1500*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });




                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Decoder/SmartCard Number to be Credited and the Subscription Type " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Decoder/SmartCard No: 08001001000 " +
                                            "\n Sub Type: GoTV Plus/Dstv Compact");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });


                        }else if (which==2){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();



                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"2100"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"2100"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });


                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Decoder/SmartCard Number to be Credited and the Subscription Type " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Decoder/SmartCard No: 08001001000 " +
                                            "\n Sub Type: GoTV Plus/Dstv Compact");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==3){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();



                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*2800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*2800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*2800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"2800"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*2800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*2800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*2800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"2800"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*2800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*2800*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });



                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Decoder/SmartCard Number to be Credited and the Subscription Type " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Decoder/SmartCard No: 08001001000 " +
                                            "\n Sub Type: GoTV Plus/Dstv Compact");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==4){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*4000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*4000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*4000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"4000"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*4000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*4000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*4000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"4000"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*4000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*4000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });





                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Decoder/SmartCard Number to be Credited and the Subscription Type " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Decoder/SmartCard No: 08001001000 " +
                                            "\n Sub Type: GoTV Plus/Dstv Compact");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==5){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"600"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"600"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*600*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });



                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Decoder/SmartCard Number to be Credited and the Subscription Type " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Decoder/SmartCard No: 08001001000 " +
                                            "\n Sub Type: GoTV Plus/Dstv Compact");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });

                                }
                            });

                        }else if (which==6){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*1450*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*1450*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*1450*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"1450"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*1450*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*1450*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*1450*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"1450"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*1450*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*1450*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });



                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Decoder/SmartCard Number to be Credited and the Subscription Type " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Decoder/SmartCard No: 08001001000 " +
                                            "\n Sub Type: GoTV Plus/Dstv Compact");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==7){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();


                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"2100"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"2100"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*2100*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });




                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Decoder/SmartCard Number to be Credited and the Subscription Type " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Decoder/SmartCard No: 08001001000 " +
                                            "\n Sub Type: GoTV Plus/Dstv Compact");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });

                                }
                            });

                        }else if (which==8){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*3400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*3400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*3400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"3400"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*3400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*3400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*3400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"3400"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*3400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*3400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });


                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Decoder/SmartCard Number to be Credited and the Subscription Type " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Decoder/SmartCard No: 08001001000 " +
                                            "\n Sub Type: GoTV Plus/Dstv Compact");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==9){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*2200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*2200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*2200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"2200"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*2200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*2200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*2200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"2200"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*2200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*2200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });


                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Decoder/SmartCard Number to be Credited and the Subscription Type " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Decoder/SmartCard No: 08001001000 " +
                                            "\n Sub Type: GoTV Plus/Dstv Compact");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==10){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*4200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*4200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*4200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"4200"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*4200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*4200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*4200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"4200"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*4200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*4200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });


                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Decoder/SmartCard Number to be Credited and the Subscription Type " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Decoder/SmartCard No: 08001001000 " +
                                            "\n Sub Type: GoTV Plus/Dstv Compact");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==11){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*4400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*4400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*4400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"4400"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*4400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*4400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*4400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"4400"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*4400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*4400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });


                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Decoder/SmartCard Number to be Credited and the Subscription Type " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Decoder/SmartCard No: 08001001000 " +
                                            "\n Sub Type: GoTV Plus/Dstv Compact");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==12){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*6400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*6400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*6400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"6400"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*6400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*6400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*6400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"6400"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*6400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*6400*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });


                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Decoder/SmartCard Number to be Credited and the Subscription Type " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Decoder/SmartCard No: 08001001000 " +
                                            "\n Sub Type: GoTV Plus/Dstv Compact");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==13){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*7000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*7000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*7000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"7000"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*7000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*7000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*7000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"7000"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*7000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*7000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });


                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Decoder/SmartCard Number to be Credited and the Subscription Type " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Decoder/SmartCard No: 08001001000 " +
                                            "\n Sub Type: GoTV Plus/Dstv Compact");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==14){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*9200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*9200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*9200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"9200"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*9200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*9200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*9200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"9200"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*9200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*9200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });


                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Decoder/SmartCard Number to be Credited and the Subscription Type " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Decoder/SmartCard No: 08001001000 " +
                                            "\n Sub Type: GoTV Plus/Dstv Compact");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==15){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*10850*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*10850*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*10850*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"10850"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*10850*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*10850*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*10850*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"10850"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*10850*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*10850*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });


                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Decoder/SmartCard Number to be Credited and the Subscription Type " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Decoder/SmartCard No: 08001001000 " +
                                            "\n Sub Type: GoTV Plus/Dstv Compact");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==16){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*13050*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*13050*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*13050*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"13050"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*13050*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*13050*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*13050*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"13050"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*13050*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*13050*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });


                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Decoder/SmartCard Number to be Credited and the Subscription Type " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Decoder/SmartCard No: 08001001000 " +
                                            "\n Sub Type: GoTV Plus/Dstv Compact");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==17){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*16000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*16000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*16000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"16000"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*16000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*16000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*16000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"16000"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*16000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*16000*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });


                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Decoder/SmartCard Number to be Credited and the Subscription Type " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Decoder/SmartCard No: 08001001000 " +
                                            "\n Sub Type: GoTV Plus/Dstv Compact");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }else if (which==18){
                            LayoutInflater factory = LayoutInflater.from(getActivity());
                            final View buyAirtimeView = factory.inflate(R.layout.layout_transaction_view,  null);
                            RelativeLayout makepayment = (RelativeLayout)buyAirtimeView.findViewById(R.id.makepayment);
                            RelativeLayout sendtransactiondetails = (RelativeLayout)buyAirtimeView.findViewById(R.id.sendtransactiondetails);
                            RelativeLayout callkitcustomercare = (RelativeLayout)buyAirtimeView.findViewById(R.id.callkitcustomercare);
                            final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                            customdialog.setView( buyAirtimeView);
                            customdialog.show();

                            makepayment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Call Kit Account Details" +
                                            "\n Acc Name: Odii Chinedum " +
                                            "\n Acc Num: 0076308579 " +
                                            "\n Bank Name: Diamond " +
                                            "\n\n Click OK and Proceed to make payment");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Select your Bank");
                                            builder.setItems(new String[]{"Access Bank", "Diamond Bank", "EcoBank", "FCMB", "Fidelity Bank",
                                                    "First Bank", "GTBank", "Sterling Bank", "UBA", "Union Bank", "Zenith Bank"}, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (which==0){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*901*2*18200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==1){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*426*18200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==2){
//                                                        Intent call = new Intent(Intent.ACTION_CALL);
//                                                        call.setData(Uri.parse("tel: "+"*426*"+gtbacctnumber+"%23"));
//                                                        startActivity(call);
                                                    }
                                                    else if (which==3){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*329*18200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==4){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*770*"+diamondacctnumber+"*"+"18200"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==5){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*894*18200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==6){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*737*2*18200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==7){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*822*5*18200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==8){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*919*4*"+diamondacctnumber+"*"+"18200"+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==9){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*826*2*18200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                    else if (which==10){
                                                        Intent call = new Intent(Intent.ACTION_CALL);
                                                        call.setData(Uri.parse("tel: "+"*966*18200*"+diamondacctnumber+"%23"));
                                                        startActivity(call);
                                                    }
                                                }
                                            });

                                            builder.create().show();

                                        }
                                    });



                                }
                            });


                            sendtransactiondetails.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutInflater factory = LayoutInflater.from(getActivity());
                                    View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                    TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                    Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                    title.setText("Notification");
                                    messagetext.setText("Click OK to Text us Your Account Name, Amount You Sent, the Decoder/SmartCard Number to be Credited and the Subscription Type " +
                                            "\n For example " +
                                            "\n Name: Your Name " +
                                            "\n Amt Sent: 1000 " +
                                            "\n Decoder/SmartCard No: 08001001000 " +
                                            "\n Sub Type: GoTV Plus/Dstv Compact");
                                    customdialog.setView(dialogView);
                                    customdialog.show();
                                    okbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            customdialog.dismiss();
                                            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                            getActivity().startActivity(smsIntent);

                                        }
                                    });


                                }
                            });

                            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Select any of Our Customer Care Lines");
                                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which==0){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08116446110"));
                                                startActivity(call);
                                            }else if (which==1){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "09033433276"));
                                                startActivity(call);
                                            }else if (which==2){
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08127959885"));
                                                startActivity(call);
                                            }else if (which == 3) {
                                                Intent call = new Intent(Intent.ACTION_CALL);
                                                call.setData(Uri.parse("tel: " + "08181291295"));
                                                startActivity(call);
                                            }

                                        }
                                    });
                                    builder.create().show();
                                }
                            });

                        }


                    }
                });
                builder.create().show();

            }
        });






        //===================================================================================================================
        //===================================================================================================================

        //Swap Airtime

        ImageView swapairtime = (ImageView) rootView.findViewById(R.id.imageView8);
        swapairtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater factory = LayoutInflater.from(getActivity());
                View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                title.setText("How it Works");
                messagetext.setText("This feature allows you to send airtime from one Mobile Network to another Network with 20-25% commission \n" +
                        "E.g 25% charge from MTN to any other network, 20% charge from 9Mobile to any other network, 25% charge from GLO to any other network \n" +
                        "\n" +
                        "You send us Airtime to any of our Networks, text us the number to be credited and boom its done" +
                        " \n \n" +
                        " Its Fun right? Click OK to Proceed");
                customdialog.setView(dialogView);
                customdialog.show();
                okbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customdialog.dismiss();
                        LayoutInflater factory = LayoutInflater.from(getActivity());
                        final View convertAirtimeView = factory.inflate(R.layout.layout_convertairtime_transaction,  null);
                        RelativeLayout convertairtimetocash = (RelativeLayout) convertAirtimeView.findViewById(R.id.convertairtimebutton);
                        RelativeLayout sendacctdetails = (RelativeLayout) convertAirtimeView.findViewById(R.id.sendacctdetails);
                        RelativeLayout callkitcustomercare = (RelativeLayout) convertAirtimeView.findViewById(R.id.callkitcustomercare);
                        final  AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                        customdialog.setView(convertAirtimeView);
                        customdialog.show();

                        convertairtimetocash.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                builder.setTitle("Select Network");
                                builder.setItems(new String[]{"MTN", "GLO", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                    String amt, pin;
                                    EditText messagetext1, messagetext2;
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if(which==0){

                                            LayoutInflater factory = LayoutInflater.from(getActivity());
                                            View dialogView = factory.inflate(R.layout.layout_dialog_input, null);
                                            TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                            messagetext1 = (EditText) dialogView.findViewById(R.id.textdialog);
                                            Button proceedbtn =(Button)dialogView.findViewById(R.id.proceedbtn);
                                            Button cancelbtn = (Button)dialogView.findViewById(R.id.cancelbutton);
                                            final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                            title.setText("Alert: Enter Amount");
                                            messagetext1.setHint("Enter the Amount of Airtime to be Converted");
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
                                                    title.setText("Alert: Enter Pin");
                                                    messagetext2.setHint("Enter Your Airtime Transfer PIN");
                                                    customdialog.setView(dialogView);
                                                    customdialog.show();
                                                    proceedbtn.setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View v) {
                                                            amt =messagetext1.getText().toString();
                                                            pin = messagetext2.getText().toString();
                                                            Intent call = new Intent(Intent.ACTION_CALL);
                                                            call.setData(Uri.parse("tel: " + "*600*09033433276*" +amt+"*"+pin+"%23"));
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
                                            cancelbtn.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    customdialog.dismiss();

                                                }
                                            });
                                        }else if (which==1){
                                            LayoutInflater factory = LayoutInflater.from(getActivity());
                                            View dialogView = factory.inflate(R.layout.layout_dialog_input, null);
                                            TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                            messagetext1 = (EditText) dialogView.findViewById(R.id.textdialog);
                                            Button proceedbtn =(Button)dialogView.findViewById(R.id.proceedbtn);
                                            Button cancelbtn = (Button)dialogView.findViewById(R.id.cancelbutton);
                                            final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                            title.setText("Alert: Enter Amount");
                                            messagetext1.setHint("Enter the Amount of Airtime to be Converted");
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
                                                    title.setText("Alert: Enter Pin");
                                                    messagetext2.setHint("Enter Your Airtime Transfer PIN");
                                                    customdialog.setView(dialogView);
                                                    customdialog.show();
                                                    proceedbtn.setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View v) {
                                                            amt =messagetext1.getText().toString();
                                                            pin = messagetext2.getText().toString();
                                                            Intent call = new Intent(Intent.ACTION_CALL);
                                                            call.setData(Uri.parse("tel: " + "*131*08116446110*" +amt+"*"+pin+"%23"));
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
                                            cancelbtn.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    customdialog.dismiss();

                                                }
                                            });
                                        }else if (which==2){

                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                            builder.setTitle("Alert");
                                            builder.setMessage("Sorry this feature is not available yet on Airtel");
                                            builder.create().show();
//                                                    LayoutInflater factory = LayoutInflater.from(getActivity());
//                                                    View dialogView = factory.inflate(R.layout.layout_dialog_input, null);
//                                                    TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
//                                                    messagetext1 = (EditText) dialogView.findViewById(R.id.textdialog);
//                                                    Button proceedbtn =(Button)dialogView.findViewById(R.id.proceedbtn);
//                                                    Button cancelbtn = (Button)dialogView.findViewById(R.id.cancelbutton);
//                                                    final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
//                                                    title.setText("Alert: Enter Amount");
//                                                    messagetext1.setHint("Enter the Amount of Airtime to be Converted");
//                                                    customdialog.setView(dialogView);
//                                                    customdialog.show();
//                                                    proceedbtn.setOnClickListener(new View.OnClickListener() {
//                                                        @Override
//                                                        public void onClick(View v) {
//                                                            customdialog.dismiss();
//                                                            LayoutInflater factory = LayoutInflater.from(getActivity());
//                                                            View dialogView = factory.inflate(R.layout.layout_dialog_input, null);
//                                                            TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
//                                                            messagetext2 = (EditText) dialogView.findViewById(R.id.textdialog);
//                                                            Button proceedbtn =(Button)dialogView.findViewById(R.id.proceedbtn);
//                                                            Button cancelbtn = (Button)dialogView.findViewById(R.id.cancelbutton);
//                                                            final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
//                                                            title.setText("Alert: Enter Pin");
//                                                            messagetext2.setHint("Enter Your Airtime Transfer PIN");
//                                                            customdialog.setView(dialogView);
//                                                            customdialog.show();
//                                                            proceedbtn.setOnClickListener(new View.OnClickListener() {
//                                                                @Override
//                                                                public void onClick(View v) {
//                                                                    amt =messagetext1.getText().toString();
//                                                                    pin = messagetext2.getText().toString();
//                                                                    Intent call = new Intent(Intent.ACTION_CALL);
//                                                                    call.setData(Uri.parse("tel: " + "*141*08127959885" +amt+"*"+pin+"%23"));
//                                                                    startActivity(call);
//                                                                    customdialog.dismiss();
//
//                                                                }
//                                                            });
//                                                            cancelbtn.setOnClickListener(new View.OnClickListener() {
//                                                                @Override
//                                                                public void onClick(View v) {
//                                                                    customdialog.dismiss();
//
//                                                                }
//                                                            });
//
//                                                        }
//                                                    });
//                                                    cancelbtn.setOnClickListener(new View.OnClickListener() {
//                                                        @Override
//                                                        public void onClick(View v) {
//                                                            customdialog.dismiss();
//
//                                                        }
//                                                    });
                                        }else if (which==3){
                                            LayoutInflater factory = LayoutInflater.from(getActivity());
                                            View dialogView = factory.inflate(R.layout.layout_dialog_input, null);
                                            TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                            messagetext1 = (EditText) dialogView.findViewById(R.id.textdialog);
                                            Button proceedbtn =(Button)dialogView.findViewById(R.id.proceedbtn);
                                            Button cancelbtn = (Button)dialogView.findViewById(R.id.cancelbutton);
                                            final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                            title.setText("Alert: Enter Amount");
                                            messagetext1.setHint("Enter the Amount of Airtime to be Converted");
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
                                                    title.setText("Alert: Enter Pin");
                                                    messagetext2.setHint("Enter Your Airtime Transfer PIN");
                                                    customdialog.setView(dialogView);
                                                    customdialog.show();
                                                    proceedbtn.setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View v) {
                                                            amt =messagetext1.getText().toString();
                                                            pin = messagetext2.getText().toString();
                                                            Intent call = new Intent(Intent.ACTION_CALL);
                                                            call.setData(Uri.parse("tel: " + "*223*" +pin+"*"+amt+"*"+ "08181291295" + "%23"));
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
                                            cancelbtn.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    customdialog.dismiss();

                                                }
                                            });
                                        }
                                    }
                                });
                                builder.create().show();
                            }
                        });


                        sendacctdetails.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                LayoutInflater factory = LayoutInflater.from(getActivity());
                                View dialogView = factory.inflate(R.layout.layout_alert_dialog, null);
                                TextView messagetext = (TextView)dialogView.findViewById(R.id.textdialog);
                                TextView title = (TextView)dialogView.findViewById(R.id.titledialog);
                                Button okbtn =(Button)dialogView.findViewById(R.id.okbtn);
                                final AlertDialog customdialog = new AlertDialog.Builder(getActivity()).create();
                                title.setText("Notification");
                                messagetext.setText("Click OK to Text us The Amount of Airtime You Sent and  Your Account Details to get your Money back instantly");
                                customdialog.setView(dialogView);
                                customdialog.show();
                                okbtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        customdialog.dismiss();
                                        Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "08145161463", null));
                                        getActivity().startActivity(smsIntent);

                                    }
                                });


                            }
                        });

                        callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                builder.setTitle("Select any of Our Customer Care Lines");
                                builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if (which==0){
                                            Intent call = new Intent(Intent.ACTION_CALL);
                                            call.setData(Uri.parse("tel: " + "08116446110"));
                                            startActivity(call);
                                        }else if (which==1){
                                            Intent call = new Intent(Intent.ACTION_CALL);
                                            call.setData(Uri.parse("tel: " + "09033433276"));
                                            startActivity(call);
                                        }else if (which==2){
                                            Intent call = new Intent(Intent.ACTION_CALL);
                                            call.setData(Uri.parse("tel: " + "08127959885"));
                                            startActivity(call);
                                        }else if (which == 3) {
                                            Intent call = new Intent(Intent.ACTION_CALL);
                                            call.setData(Uri.parse("tel: " + "08181291295"));
                                            startActivity(call);
                                        }

                                    }
                                });
                                builder.create().show();
                            }
                        });


                    }
                });



            }
        });









        return rootView;
    }
}
