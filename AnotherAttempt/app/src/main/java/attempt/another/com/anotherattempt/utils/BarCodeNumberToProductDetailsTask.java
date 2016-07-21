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

    private static String buildSearchString(String searchString, int start, int numOfResults) {
        String toSearch = Constants.searchURL + "key=" + Constants.apiKey + "&cx=" + Constants.apiKey + "&q=";

        // replace spaces in the search query with +
        String newSearchString = searchString.replace(" ", "%20");

        toSearch += newSearchString;

        // specify response format as json
        toSearch += "&alt=json";

        // specify starting result number
        toSearch += "&start=" + start;

        // specify the number of results you need from the starting position
        toSearch += "&num=" + numOfResults;

        //System.out.println("Seacrh URL: " + toSearch);
        return toSearch;
    }
}
