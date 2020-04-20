package com.example.matrixtrader.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.example.matrixtrader.R;
import com.example.matrixtrader.core.BaseActivity;

public class MatrixToolbar extends Toolbar {

    private View rootView;
    private TextView toolbarTitleTextView;
    private ImageView backButton;
    private String toolbarTitle;
    private int toolbarBackgroundColor,toolbarTitleColor;

    public MatrixToolbar(Context context) {
        super(context);
    }

    public MatrixToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MatrixToolbar,0,0);

        try {
            toolbarTitle = typedArray.getString(R.styleable.MatrixToolbar_toolbarTitle);
            toolbarTitleColor = typedArray.getColor(R.styleable.MatrixToolbar_toolbarTitleColor,
                    ContextCompat.getColor(BaseActivity.currentActivity,R.color.black));
            toolbarBackgroundColor = typedArray.getColor(R.styleable.MatrixToolbar_toolbarBackgroundColor,
                    ContextCompat.getColor(BaseActivity.currentActivity,R.color.white));

        }
        finally {
            typedArray.recycle();
        }

        initContext(context);
    }

    public MatrixToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initContext(Context context){
        rootView = inflate(context, R.layout.layout_matriks_toolbar, this);

        this.setPadding(0, 0, 0, 0);
        this.setContentInsetsAbsolute(0, 0);

        toolbarTitleTextView = (TextView) rootView.findViewById(R.id.titleTextView);
        backButton = (ImageView) rootView.findViewById(R.id.backButton);

        if(toolbarTitle != null && !toolbarTitle.isEmpty()){
            toolbarTitleTextView.setVisibility(VISIBLE);
            toolbarTitleTextView.setText(toolbarTitle);
            toolbarTitleTextView.setTextColor(toolbarTitleColor);
        }

        backButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseActivity.currentActivity.onBackPressed();
            }
        });
    }

    public void setToolbarTitle(String title){
        rootView.setVisibility(View.VISIBLE);
        toolbarTitleTextView.setVisibility(View.VISIBLE);
        if (title != null){
            toolbarTitleTextView.setText(title);
        }
    }
}
