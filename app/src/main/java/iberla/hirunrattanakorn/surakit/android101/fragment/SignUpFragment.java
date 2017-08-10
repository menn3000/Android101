package iberla.hirunrattanakorn.surakit.android101.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
    private ImageView backImageView, saveImageView, uploadImageView, pictureImageView;
    private EditText nameEditText, userEditText, passwordEditText;
    private String nameString, userString, passwordString, pathPictureString;
    private String tag = "10augV1";
    private Uri uri;
    private boolean aBoolean = true;


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

        //Picture Controller
        pictureController();


    } //onActivityCreated

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode,
                                 Intent data) {
        // event fire after activity result
        // requestCode is the Tag we passed as tag
        // resultCode is status success or failed

        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == getActivity().RESULT_OK) {
            Log.d(tag, "Result_OK");
            aBoolean = false;
            uri = data.getData();

            //Show Image
            showImage();
            //Find Path and Name of Picture


            String[] strings = new String[]{MediaStore.Images.Media.DATA};
            Cursor cursor = getActivity().getContentResolver()
                    .query(uri, strings, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                int index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                pathPictureString = cursor.getString(index);
            } else {
                //มีรูปเดียวทั้งเครื่อฃ
                pathPictureString = uri.getPath();
            }//if

            Log.d(tag, "pathPicture ==>" + pathPictureString);

        } //if


    }//onActivityResult

    private void showImage() {
        try {
            Bitmap bitmap = BitmapFactory.decodeStream(getActivity()
                    .getContentResolver()
                    .openInputStream(uri));
            pictureImageView.setImageBitmap(bitmap);

        } catch (Exception e) {
            Log.d(tag, "e Show Image ==> " + e.toString());
        }//try
    }

    private void pictureController() {
        pictureImageView = getView().findViewById(R.id.imvPicture);
        pictureImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Choose Picture
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*"); // ask user to select gallery program to work with
                startActivityForResult(Intent.createChooser(intent, "Please choose app"), 1); // 1 is tag , value type must be integer,  will be return as Request code

            }//onClick
        });
    }

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
                } else if (aBoolean == true) {
                    // no picture selected
                    MyAlert myAlert = new MyAlert(getActivity()); //getActivity return context that passed to constructor
                    myAlert.myDialog(getString(R.string.title_not_selected),
                            getString(R.string.not_selected));
                } else {
                    //valid
                    Log.d(tag, "No Space and Picture selected");
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
        pictureImageView = getView().findViewById(R.id.imvPicture);
    }//initiealView

}//Main Class
