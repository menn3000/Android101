package iberla.hirunrattanakorn.surakit.android101.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.zip.Inflater;

import iberla.hirunrattanakorn.surakit.android101.R;

/**
 * Created by Menn on 8/8/2560.
 */

public class MainFragment extends Fragment {

    //Explict
    private EditText userEditText, passwordEditText;
    private TextView textView;
    private Button button;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }// on CreateView ทำหน้าที่ในการสร้าง หน้ากาก หรือ view ไปแปะที่ Activity


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //initial view
        initialView();

        //TextView Controller
        textViewController();


    } //onActivityCreated จะทำงาน พร้อม Activity เราจะเริ่มต้นการทำงานของ code ที่นี้

    private void textViewController() {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Move to SignUpFragment

                Log.d("10augV1", "Click OK");

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.myContent, new SignUpFragment())
                        .addToBackStack(null)
                        .commit();
            }//onClick
        });
    }

    private void initialView() {
        userEditText = getView().findViewById(R.id.edtUser);
        passwordEditText = getView().findViewById(R.id.edtPassword);
        textView = getView().findViewById(R.id.txtNewRegister);
        button = getView().findViewById(R.id.btnSignin);
    }


} //Main Class
