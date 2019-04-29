package com.solutionappstudio.callkit.Activities;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.solutionappstudio.callkit.Adapters.ViewPagerAdapter;
import com.solutionappstudio.callkit.Fragments.AboutFragment;
import com.solutionappstudio.callkit.Fragments.AirtelFragment;
import com.solutionappstudio.callkit.Fragments.BankFragment;
import com.solutionappstudio.callkit.Fragments.GloFragment;
import com.solutionappstudio.callkit.Fragments.HomeFragment;
import com.solutionappstudio.callkit.Fragments.MTNFragment;
import com.solutionappstudio.callkit.Fragments.Mobile9Fragment;
import com.solutionappstudio.callkit.R;
import com.solutionappstudio.callkit.others.Contacts;
import com.solutionappstudio.callkit.storage.Constants;
import com.solutionappstudio.callkit.storage.ContactsDB;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.ic_home

    };


    // for the contacts fragment
    private static ContactsDB cdb;
    static Activity c;
    static ContactsAdapter ccd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.SEND_SMS, Manifest.permission.READ_CONTACTS}, 1);

        }

        c = this;

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //Adding Fragments
        adapter.AddFragment(new HomeFragment(), "");
        adapter.AddFragment(new BankFragment(), "Bank Services");
        adapter.AddFragment(new MTNFragment(), "MTN");
        adapter.AddFragment(new GloFragment(), "GLO");
        adapter.AddFragment(new AirtelFragment(), "Airtel");
        adapter.AddFragment(new Mobile9Fragment(), "9Mobile");


        //Adapter Setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        //adding icons to the tabs
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);

        //for the contacts groups
        try {
            cdb = new ContactsDB(this);
        } catch (Exception e) {

        }


        //the intents for contacts, dialer and message
        ImageView contact = (ImageView) findViewById(R.id.imageButton2);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_APP_CONTACTS);
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Default Contact App is Restricting Call Kit Access", Toast.LENGTH_LONG).show();
                }

            }
        });

        ImageView dialer = (ImageView) findViewById(R.id.imageButton3);
        dialer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Default Dialer App is Restricting Call Kit Access", Toast.LENGTH_LONG).show();
                }


            }
        });

        ImageView message = (ImageView) findViewById(R.id.imageButton4);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_DEFAULT);
                    intent.setType("vnd.android-dir/mms-sms");
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Default Message App is Restricting Call Kit Access", Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share) {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, "Download Call Kit Now" + "\n" + "The Best Self Service App" + "\n" + "https://play.google.com/store/apps/details?id=com.solutionappstudio.callkit");
            startActivity(Intent.createChooser(sharingIntent, "Share Call Kit with"));
        } else if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        ContactsFragment cfrg=new ContactsFragment();


        if (id == R.id.home) {
//            Intent intent = getPackageManager().getLaunchIntentForPackage("com.solutionappstudio.callkit");
//            startActivity(intent);
            Intent intent = getIntent();
            finish();
            startActivity(intent);

        } else if (id == R.id.family) {
            FragmentManager frag = getSupportFragmentManager();
            frag.beginTransaction()
                    .replace(R.id.changer, cfrg)
                    .addToBackStack(null)
                    .commit();
            cfrg.setContactType(ContactType.FAMILY);
        } else if (id == R.id.friends) {
            FragmentManager frag = getSupportFragmentManager();
            frag.beginTransaction()
                    .replace(R.id.changer, cfrg)
                    .addToBackStack(null)
                    .commit();
            cfrg.setContactType(ContactType.FRIENDS);

        } else if (id == R.id.work) {
            FragmentManager frag = getSupportFragmentManager();
            frag.beginTransaction()
                    .replace(R.id.changer, cfrg)
                    .addToBackStack(null)
                    .commit();
            cfrg.setContactType(ContactType.WORK);

        } else if (id == R.id.favorites) {
            FragmentManager frag = getSupportFragmentManager();
            frag.beginTransaction()
                    .replace(R.id.changer, cfrg)
                    .addToBackStack(null)
                    .commit();
            cfrg.setContactType(ContactType.FAVORITES);

        } else if (id == R.id.checkupdate) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.solutionappstudio.callkit"));
            startActivity(intent);

        } else if (id == R.id.feedback) {
            LayoutInflater factory = LayoutInflater.from(MainActivity.this);
            View rootView = factory.inflate(R.layout.fragment_feedback, null);
            final AlertDialog customdialog = new AlertDialog.Builder(MainActivity.this).create();
            customdialog.setView(rootView);
            customdialog.show();
            RelativeLayout callkitcustomercare = (RelativeLayout) rootView.findViewById(R.id.callkitcustomercare);
            callkitcustomercare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Select any of Our Customer Care Lines");
                    builder.setItems(new String[]{"GLO", "MTN", "Airtel", "9Mobile"}, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (which == 0) {
                                Intent call = new Intent(Intent.ACTION_CALL);
                                call.setData(Uri.parse("tel: " + "08116446110"));
                                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                    // TODO: Consider calling
                                    //    ActivityCompat#requestPermissions
                                    // here to request the missing permissions, and then overriding
                                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                    //                                          int[] grantResults)
                                    // to handle the case where the user grants the permission. See the documentation
                                    // for ActivityCompat#requestPermissions for more details.
                                    return;
                                }
                                startActivity(call);
                            } else if (which == 1) {
                                Intent call = new Intent(Intent.ACTION_CALL);
                                call.setData(Uri.parse("tel: " + "09033433276"));
                                startActivity(call);
                            } else if (which == 2) {
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

            RelativeLayout feedback = (RelativeLayout) rootView.findViewById(R.id.sendfeedback);
            feedback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.setType("text/email");
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{"callkitsolution@gmail.com"});
                    email.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                    email.putExtra(Intent.EXTRA_TEXT, "Hello CallKit Admin," + "");
                    startActivity(Intent.createChooser(email, "Send Feedback:"));
                }
            });


        } else if (id == R.id.about) {
            AboutFragment afrg = new AboutFragment();
            FragmentManager frag = getSupportFragmentManager();
            frag.beginTransaction()
                    .replace(R.id.changer, afrg)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.share) {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, "Download Call Kit Now" + "\n" + "The Best Self Service App" + "\n" + "https://play.google.com/store/apps/details?id=com.solutionappstudio.callkit");
            startActivity(Intent.createChooser(sharingIntent, "Share Call Kit with"));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // Contacts Loading Session


    public static class ContactsFragment extends Fragment {


        private ContactType globaltype;

        public void ContactsFragment() {

            globaltype = ContactType.FAMILY;
        }

        public void setContactType(ContactType type) {
            globaltype = type;

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.home_group_contacts_listview, container, false);


            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_CONTACTS}, 1);
            }


            ListView listView = (ListView) rootView.findViewById(R.id.listView);
            listView.setAdapter(ccd = new ContactsAdapter(globaltype));
            ImageView imageView = (ImageView) rootView.findViewById(R.id.plusicon);
            String groupid = "";
            String groupTitle = "";
            TextView head = (TextView) rootView.findViewById(R.id.textView11);
            if (globaltype == ContactType.FAMILY) {
                groupid = "1";
                groupTitle = "FAMILY CONTACTS";
            } else if (globaltype == ContactType.FRIENDS) {
                groupid = "2";
                groupTitle = "FRIENDS CONTACTS";
            } else if (globaltype == ContactType.WORK) {
                groupid = "3";
                groupTitle = "WORK CONTACTS";
            } else if (globaltype == ContactType.FAVORITES) {
                groupid = "4";
                groupTitle = "FAVORITE CONTACTS";
            }
            final String gfinal = groupid;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(c, ContactsList.class);
                    Constants.GROUPID = gfinal;
                    c.startActivity(intent);
                }
            });
            head.setText(groupTitle);

            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);

        }

        @Override
        public void onResume() {
            super.onResume();
            try {
                ccd.updateContacts();
            } catch
                    (Exception e) {
                //  show(e.toString()+"__");
            }

        }


    }


    static class ContactsAdapter extends BaseAdapter {

        ContactType mycontacts = ContactType.FAMILY;

        ArrayList<Contacts> info;
        String groupid = "1";

        public ContactsAdapter(ContactType type) {
            mycontacts = type;

            if (mycontacts == ContactType.FAMILY) {
                groupid = "1";
            } else if (mycontacts == ContactType.FRIENDS) {
                groupid = "2";
            } else if (mycontacts == ContactType.WORK) {
                groupid = "3";
            } else if (mycontacts == ContactType.FAVORITES) {
                groupid = "4";
            } else if (mycontacts == ContactType.OTHERS) {
                groupid = "5";
            }
            info = cdb.getContacts(groupid);
        }

        public void updateContacts() {
            info = cdb.getContacts(groupid);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return info.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {

                convertView = LayoutInflater.from(c).inflate(R.layout.contact_member_view, parent, false);
            }

            final Contacts cc = info.get(position);
            TextView text = (TextView) convertView.findViewById(R.id.textView4);
            text.setText(cc.getName());

            ImageView call, msg;
            ImageView rv;
            call = (ImageView) convertView.findViewById(R.id.imageView2);
            msg = (ImageView) convertView.findViewById(R.id.imageView);
            rv = (ImageView) convertView.findViewById(R.id.button);


            final int pstn = position;
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    android.app.AlertDialog.Builder adb = new android.app.AlertDialog.Builder(c);
                    adb.setIcon(R.drawable.callbutton);
                    adb.setItems(new String[]{"Call Now", "Scheduled Call",
                            "Internet Call", "Video Call"}, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (which == 0) {
                                Intent call = new Intent(Intent.ACTION_CALL);
                                call.setData(Uri.parse("tel:" + cc.getNumber()));
                                c.startActivity(call);
                            }
                            dialog.cancel();
                        }
                    });
                    adb.create().show();
                }
            });
            msg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", cc.getNumber(), null));
                    c.startActivity(smsIntent);
                }
            });

            rv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cdb.deleteContact(cc.getIndex());
                    updateContacts();
                }
            });
            return convertView;

        }
    }


    enum ContactType{
        FAMILY,FRIENDS,WORK,FAVORITES, OTHERS;
    }

}
