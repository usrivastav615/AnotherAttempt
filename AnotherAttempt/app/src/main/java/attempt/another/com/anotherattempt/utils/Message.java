package attempt.another.com.anotherattempt.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by utsrivas on 7/22/2016.
 */
public class Message {

    public static void message(Context context, String message)
    {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

}
