package iberla.hirunrattanakorn.surakit.android101;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import iberla.hirunrattanakorn.surakit.android101.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add Fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.myContent, new MainFragment())
                    .commit();

        }


    }  // main method

}  //main clcss
