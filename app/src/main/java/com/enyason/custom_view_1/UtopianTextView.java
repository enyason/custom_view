package com.enyason.custom_view_1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;


public class UtopianTextView extends android.support.v7.widget.AppCompatTextView implements View.OnClickListener {
    public UtopianTextView(Context context) {
        super(context);
        init();
    }

    public UtopianTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public UtopianTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }


    void init() {

        setText("UtopianDroid");
        setTextSize(20);
        setOnClickListener(this);
        setTextColor(getResources().getColor(R.color.colorPrimary));
        setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.ic_android), null, null);

    }

    @Override
    public void onClick(View v) {
      Toast.makeText(getContext(),"Hello Utopian",Toast.LENGTH_SHORT).show();
        Uri webPage = Uri.parse("https://utopian.io");
        Intent intent = new Intent(Intent.ACTION_VIEW, webPage);

        if (intent.resolveActivity(getContext().getPackageManager()) != null) {

            getContext().startActivity(intent);
        }
    }
}
