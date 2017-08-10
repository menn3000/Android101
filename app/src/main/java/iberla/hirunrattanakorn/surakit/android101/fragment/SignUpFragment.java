package iberla.hirunrattanakorn.surakit.android101.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import iberla.hirunrattanakorn.surakit.android101.R;

/**
 * Created by Menn on 8/8/2560.
 */

public class SignUpFragment extends Fragment {

    //Explicit
    private ImageView backImageView, saveImageView;
    private EditText nameEditText, userEditText, passwordEditText;



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


    } //onActivityCreated

    private void backController() {
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Back to Main Fragment
                getActivity().getSupportFragmentManager()
                       .popBackStack(); // back to the last back stack , kill me

            }//onClick
        });
    }

    private void initiealView() {
        backImageView = getView().findViewById(R.id.imvBack);
        saveImageView = getView().findViewById(R.id.imgSave);
        nameEditText = getView().findViewById(R.id.edtName);
        userEditText = getView().findViewById(R.id.edtUser);
        passwordEditText = getView().findViewById(R.id.edtPassword);

    }
}//Main Class
