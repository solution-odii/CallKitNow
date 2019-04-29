package com.solutionappstudio.callkit.Activities;

/**
 * Created by ODII on 12/29/2018.
 */

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.solutionappstudio.callkit.R;
import com.solutionappstudio.callkit.storage.Constants;
import com.solutionappstudio.callkit.storage.ContactsDB;
import com.solutionappstudio.callkit.others.Contacts;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactsList extends AppCompatActivity {

    ContactsAdapter adapter;
    static HashMap<Integer, Contacts> selectedContacts;
    ContactsDB cdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);
        getSupportActionBar().hide();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.SEND_SMS, Manifest.permission.READ_CONTACTS}, 1);

        }



        adapter= new ContactsAdapter();
        ListView listView = (ListView)findViewById(R.id.listView3);
        cdb=new ContactsDB(this);
        listView.setAdapter(adapter);
        selectedContacts=new HashMap<Integer, Contacts>();
        new FetchContacts().execute();
    }
    public void selectContacts(View v){

        for(Contacts c: selectedContacts.values()){
            if(cdb.addContact(c, Constants.GROUPID)){

            }else{
                show("Unable to add Contacts" + c.getNumber()+ "[" + c.getName() + "]");
            }
        }
        finish();
    }
    public void updateTitle(){
        ((TextView)findViewById(R.id.textView10)).setText("Select Contacts");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_contacts_list, menu);
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
            sharingIntent.putExtra(Intent.EXTRA_TEXT, "Download Call Kit Now"  + "\n"+ "The Best Self Service App" + "\n"+"https://play.google.com/store/apps/details?id=com.solutionappstudio.callkit");
            startActivity(Intent.createChooser(sharingIntent, "Share Call Kit with"));
        }

        return super.onOptionsItemSelected(item);
    }

    private void show(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    class ContactsAdapter extends BaseAdapter {
        ArrayList<Contacts> contacts;
        public ContactsAdapter()  {contacts=new ArrayList<Contacts>();}

        public void addContact(String name, String number){
            contacts.add(new Contacts("", name, number));
        }
        public void update() {notifyDataSetChanged();}

        public String getJSON() {return "";}

        @Override
        public int getCount() {return contacts.size(); }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.list_of_contacts, parent, false);
            }
            try{

                final Contacts cnt = contacts.get(position);
                final CheckBox rd = (CheckBox)convertView.findViewById(R.id.radioButton);
                rd.setText(cnt.getName());
                rd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked){
                            selectedContacts.put(position, cnt);
                        }else{
                            selectedContacts.remove(position);
                        }
                    }
                });
                TextView tv = (TextView)convertView.findViewById(R.id.textView5);
                tv.setText(cnt.getNumber());
            }catch (Exception e){
                show(e.toString());
            }
            return convertView;
        }
    }
    class FetchContacts extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            String[] projection = { ContactsContract.CommonDataKinds.Phone._ID, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER };
            Cursor cur = null;
            ContentResolver contactHelper = getContentResolver();
            try {

                cur = contactHelper.query (ContactsContract.CommonDataKinds.Phone.CONTENT_URI, projection, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");
                if(cur.getCount()>0){
                    cur.moveToFirst();
                    do{
                        String name = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                        String number = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        adapter.addContact(name, number);
                    }while (cur.moveToNext());
                    cur.close();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            } return "";
        }
        @Override
        protected void onPostExecute(String result){
            adapter.update();

        }
    }
}
