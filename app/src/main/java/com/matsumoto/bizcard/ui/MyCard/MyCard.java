package com.matsumoto.bizcard.ui.MyCard;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.matsumoto.bizcard.R;
import com.matsumoto.bizcard.ui.Setting.Seting;


public class MyCard extends Fragment {


    private MyCardViewModel mViewModel;

    public static MyCard newInstance() {
        return new MyCard();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_card_fragment, container, false);

//        自分のQRコード画像があった場合はそれを表示し、ない場合はユーザー登録をさせる（Settingフラグメントへ遷移）
        mViewModel = new MyCardViewModel();
        if(mViewModel.isExistQRImage()){
            mViewModel.setMyQrImage(view);
        }else{
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment, Seting.newInstance());
            fragmentTransaction.commit();
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MyCardViewModel.class);
        // TODO: Use the ViewModel
    }

}
