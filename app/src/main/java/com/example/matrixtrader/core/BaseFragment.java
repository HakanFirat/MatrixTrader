package com.example.matrixtrader.core;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    private View view;

    protected abstract int getLayoutId();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutId(),container,false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewsOnViewCreated(view);

    }

    protected abstract void initViewsOnViewCreated(View view);

    protected void navigateTo(int navigateTo, Bundle bundle){
        Navigation.findNavController(view).navigate(navigateTo,bundle);
    }
}
