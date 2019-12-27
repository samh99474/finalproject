package com.example.myapplication_mapnavigationdrawer.ui.send;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SendViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SendViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(" \n 停車場訂位APP是由一個開發團隊所研發\n" +
                "宗旨為了造福人類停車的需求方便" +
                "加速停車場停車效率\n" +
                "感謝您使用此APP\n" +
                "\n\n我們的團隊成員有 : \n" +
                "謝尚泓 106360101\n" +
                "曾義凱 106360108\n" +
                "黃佑恩 106360120\n" +
                "莫世祐 106360148\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}