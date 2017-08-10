package iberla.hirunrattanakorn.surakit.android101.Manager;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.http.OkHeaders;

/**
 * Created by Menn on 10/8/2560.
 */

public class PostNewUserToServer extends AsyncTask<String, Void, String> {

    // AsyncTask  will always check Internet connection and try the job
    //in background
    //1st string is data to pass
    //Void is no display the process
    //2nd String is the return string

    private Context context;

    public PostNewUserToServer(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {


        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("Name", strings[0])
                    .add("User", strings[1])
                    .add("Password", strings[2])
                    .add("PathPicture", strings[3])
                    .build();

            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[4]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();

            return response.body().string();


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}// Main Class
