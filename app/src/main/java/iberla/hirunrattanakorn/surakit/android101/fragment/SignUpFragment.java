package iberla.hirunrattanakorn.surakit.android101.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import iberla.hirunrattanakorn.surakit.android101.Manager.MyAlert;
import iberla.hirunrattanakorn.surakit.android101.R;

/**
 * Created by Menn on 8/8/2560.
 */

public class SignUpFragment extends Fragment {

    //Explicit
    private ImageView backImageView, saveImageView, uploadImageView;
    private EditText nameEditText, userEditText, passwordEditText;
    private String nameString, userString, passwordString;
    private String tag = "10augV1";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        return view;

    }//onCreateView

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Initieal View

        initiealView();

        //Back controller
        backController();

        //Save Controller
        saveController();


    } //onActivityCreated

    private void saveController() {
        saveImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get Value from EditText
                nameString = nameEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();

                // Check space validation
                if (nameString.equals("") || userString.equals("") || passwordString.equals("")) {
                    //not valid
                    Log.d(tag, "Have Space");
                    MyAlert myAlert = new MyAlert(getActivity()); //getActivity return context that passed to constructor
                    myAlert.myDialog(getString(R.string.title_have_space),
                            getString(R.string.message_have_space));
                } else {
                    //valid
                    Log.d(tag, "No Space");
                }// end if


            }//onClick
        });//setOnClickListener
    }//saveController

    private void backController() {
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Back to Main Fragment
                getActivity().getSupportFragmentManager()
                        .popBackStack(); // back to the last back stack , kill me


            }//onClick
        });
    }//backController

    private void initiealView() {
        backImageView = getView().findViewById(R.id.imvBack);
        saveImageView = getView().findViewById(R.id.imgSave);
        nameEditText = getView().findViewById(R.id.edtName);
        userEditText = getView().findViewById(R.id.edtUser);
        passwordEditText = getView().findViewById(R.id.edtPassword);
        uploadImageView = getView().findViewById(R.id.imvUpload);
    }
}//Main Class
