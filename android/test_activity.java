package project.server;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class test_activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_activity);

            JSONParser json = new JSONParser() {
            @Override
            public void onJSONLoaded(JSONObject jObj) {
            Log.d("LogsLar", "called"+jObj.toString());
                try {
                    //to get the values for keys
                    Log.d("LogsLar", jObj.getString("lastName"));
                }catch(Exception e){

                }
            }
            @Override
            public void JSONNotLoaded() {
            Log.d("LogsLar","JSONNotLoaded");

            }
            //only override if POST oder PUT
            protected UrlEncodedFormEntity getUploadContent() throws Exception{
                List<NameValuePair> postContent= new ArrayList<NameValuePair>();
                postContent.add(new BasicNameValuePair("lastName", "Mampf"));
               // postContent.add(new BasicNameValuePair("name", "Franz"));
                return new UrlEncodedFormEntity(postContent);
            }
        };
        //if you are working with the python test server, run it and put your IP address here
        //with transfer parameter : PUT, POST, GET, DELETE
        String transfer[] = {"http://169.254.197.239:5000/test/post","POST"};
        json.execute(transfer);


        //example for Delete
        JSONParser jsonParser2 = new JSONParser() {
            @Override
            public void onJSONLoaded(JSONObject jObj) {
                Log.d("LogsLar", jObj.toString());
            }

            @Override
            public void JSONNotLoaded() {

            }
        };
        String transfer1[] = {"http://169.254.197.239:5000/test/delete","DELETE"};
        jsonParser2.execute(transfer1);


//        http://169.254.197.239:5000/test/put/st

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.test_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
