package com.example.customdialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Editor_Dialog extends Dialog {

    private TextView disptxt;
    private RadioButton Ucasebtn, Lcasebtn, Initcapbtn;
    private Button Setbtn, CancelBtn;
    private CheckBox reversechkbx;



    private Context mainactContext;

    //OBJECT DECLARATION :


    private Util editorUtilObj;





    // SUPER CONSTRUCTOR :
    public Editor_Dialog(@NonNull Context context) {
        super(context);

        setContentView(R.layout.editor_dialog);

        mainactContext = context;

        init();

    }


    public void init(){
        disptxt = findViewById(R.id.editrTextview);
        Ucasebtn = findViewById(R.id.UppercaseRadioBtn);
        Lcasebtn = findViewById(R.id.LowercaseRadioBtn);
        Initcapbtn = findViewById(R.id.InitCapRadioBtn);
        Setbtn = findViewById(R.id.EditorSetBtn);
        CancelBtn = findViewById(R.id.editorCancelBtn);
        reversechkbx = findViewById(R.id.editorCheckbx);

        // ASSOCIATING LISTENERS :
        Setbtn.setOnClickListener(new CombinedListener());
        Ucasebtn.setOnClickListener(new CombinedListener());
        Lcasebtn.setOnClickListener(new CombinedListener());
        Initcapbtn.setOnClickListener(new CombinedListener());
        reversechkbx.setOnClickListener(new CombinedListener());
        CancelBtn.setOnClickListener(new CombinedListener());

    }


    // SETTING UP INTERFACE CONTAINING METHODS :

        public interface srcMethodInterface{



        // Upper Case :
        void Ucasemethod();



        // Lower Case :
        void LcaseMethod();


        // InitCap :
        void InitCapMethod();


        // Reverse Order :
       void ReverseorderMethod();


       // Set Btn :
       void SetBtnMethod();





    }



    // METHOD TO PASS OBJECT OF CLASS FROM MAIN ACTIVITY TO INTERFACE :

    private srcMethodInterface ObjOfsrcmethdInterface;

    public void setInterfaceAsListener(srcMethodInterface interfaceAsListener) {
        this.ObjOfsrcmethdInterface = interfaceAsListener;
    }



    // SETTING UP LISTENERS :

    public class CombinedListener  extends MainActivity implements View.OnClickListener{

        @Override
        public void onClick(View v) {

                if (v == Ucasebtn) {
                    ObjOfsrcmethdInterface.Ucasemethod();
                }

                if (v == Setbtn){
                    editorUtilObj = new Util(disptxt.getText().toString());
                    ObjOfsrcmethdInterface.SetBtnMethod();
                    dismiss();
                }

                if (v == Initcapbtn){
                    ObjOfsrcmethdInterface.InitCapMethod();
                }

                if (v == Lcasebtn){
                    ObjOfsrcmethdInterface.LcaseMethod();
                }

                if (v == reversechkbx){
                    ObjOfsrcmethdInterface.ReverseorderMethod();
                }

                if (v == CancelBtn){
                    dismiss();
                }



        }

    }





}
