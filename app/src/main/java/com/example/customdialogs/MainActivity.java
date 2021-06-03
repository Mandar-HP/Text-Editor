package com.example.customdialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private TextView edttxt,editorDispTxt;
    private Button edtBtn;



    private Util textFromMainAct;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }







    public void init(){

        // ATTACHING THE REFFERENCES :
        edtBtn = findViewById(R.id.editbtn);
        edttxt = findViewById(R.id.edittextmainact);






        

        edtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // DECALRE CONTEXT AND PASS STRING VALUE IN IT  :

                textFromMainAct = new Util(edttxt.getText().toString());



                // CREATING DIALOG INTERFACE :
                Editor_Dialog editordialog = new Editor_Dialog(MainActivity.this);
                editordialog.setTitle("Your Entered Text :");
                editordialog.setInterfaceAsListener(new Connecting());


                // ASSOCIATING LAYOUT :
                //editordialog.setContentView(R.layout.editor_dialog);

                editorDispTxt = editordialog.findViewById(R.id.editrTextview);
               
                // TO RECEIVE DATA LIKE INTENT :

                editorDispTxt.setText(textFromMainAct.getTextboxInfo());


                editordialog.show();


            }
        });

    }




    private class Connecting  implements Editor_Dialog.srcMethodInterface{


        private String getStrng,firstLetterStrng,remainLetterStrng,reverseStrng;



        @Override
        public void Ucasemethod() {


            //Snackbar.make(edtBtn,"You have invoked the Interface", BaseTransientBottomBar.LENGTH_LONG).show();

            //Toast.makeText(MainActivity.this,"Interface invoked",Toast.LENGTH_LONG).show();

            getStrng = editorDispTxt.getText().toString();

            editorDispTxt.setText(getStrng.toUpperCase());


        }

        @Override
        public void LcaseMethod() {

            getStrng = editorDispTxt.getText().toString();

            editorDispTxt.setText(getStrng.toLowerCase());

        }

        @Override
        public void InitCapMethod() {

            getStrng = editorDispTxt.getText().toString();

            firstLetterStrng = getStrng.substring(0,1).toUpperCase();

            remainLetterStrng = getStrng.substring(1);


            editorDispTxt.setText(firstLetterStrng.concat(remainLetterStrng));
        }

        @Override
        public void ReverseorderMethod() {

            getStrng = editorDispTxt.getText().toString();

            StringBuffer receivedStrng = new StringBuffer(getStrng);

            editorDispTxt.setText(receivedStrng.reverse());
        }

        @Override
        public void SetBtnMethod() {

            getStrng = editorDispTxt.getText().toString();

            edttxt.setText(getStrng);


        }



    }




}