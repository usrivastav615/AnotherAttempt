package attempt.another.com.anotherattempt.utils;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by utsrivas on 7/20/2016.
 */
public class BarCodeNumberToProductDetailsTask extends AsyncTask<String, Void, String> {

    protected String doInBackground(String... urls) {
        try {
            URL url = new URL(urls[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            StringBuffer buffer = new StringBuffer();
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(String result) {
        // TODO: check this.exception
        // TODO: do something with the feed

        try {
            JSONObject googleResults = new JSONObject(result);
            JSONArray items = googleResults.getJSONArray("items");
            for(int i = 0; i < items.length(); i++)
            {
                JSONObject googleSearchResultItem = items.getJSONObject(i);
                String title = googleSearchResultItem.getString("title");
                String t2 = title;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
