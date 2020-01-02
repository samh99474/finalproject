package com.example.myapplication_mapnavigationdrawer.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication_mapnavigationdrawer.R;

import static android.app.PendingIntent.getActivity;
import static androidx.core.app.ActivityCompat.startActivityForResult;
import static androidx.core.content.ContextCompat.startActivity;

public class SlideshowViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private TextView tv_meal;
    private Button btn;
    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }

    protected void onCreate(Bundle savedInstanceState) {
        tv_meal = tv_meal.findViewById (R.id.tv_meal);
        btn = btn.findViewById (R.id.button2);
        btn.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

            }
        } );
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if(data == null ) return;

        if (resultCode == 101){
            Bundle b = data.getExtras ();
            String str1 = b.getString ( "ed_1" );
            String str2 = b.getString ( "ed_2" );
            String str3 = b.getString ( "ed_3" );
            String str4 = b.getString ( "ed_4" );

            tv_meal.setText ( String.format ( "姓名:  %s\\n\\n車陴:  %s\\n\\n年齡:  %s\\n\\n電郵:  %s\n\n" ,
                    str1 , str2 , str3,str4 ) );

        }
    }
}