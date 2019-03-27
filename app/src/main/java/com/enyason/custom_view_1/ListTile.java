package com.enyason.custom_view_1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ListTile extends RelativeLayout implements View.OnClickListener {

    private ImageView trailing,leading;
    private TextView title;

    public ListTile(Context context) {
        super(context);
        init(context,null);
    }

    public ListTile(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);

    }

    public ListTile(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);

    }


    void init(Context context,AttributeSet attrs) {


        Drawable leadingIcon,trailingIcon;
        String text;

        if (attrs ==null) {

            return;
        }


        //get attributes from attrs.xml into array
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ListTile);

        //extract attributes from array into the variables
        leadingIcon = typedArray.getDrawable(R.styleable.ListTile_leading);
        trailingIcon = typedArray.getDrawable(R.styleable.ListTile_trailing);
        text = typedArray.getString(R.styleable.ListTile_title);


        //inflate layout
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View tile= inflater.inflate(R.layout.list_tile,this);



        tile.setBackground(getResources().getDrawable(R.drawable.background));

        //find views
        trailing = findViewById(R.id.trailing);
        leading = findViewById(R.id.leading);
        title = findViewById(R.id.title);

        //set view properties
        trailing.setImageDrawable(trailingIcon);
        leading.setImageDrawable(leadingIcon);
        title.setText(text);


        invalidate();


    }

    void setTrailing(Drawable icon){
        trailing.setImageDrawable(icon);
    }

    void setLeading(Drawable icon){
        leading.setImageDrawable(icon);
    }

    void setTitle(String s){
        title.setText(s.trim());
    }

    @Override
    public void onClick(View v) {


    }


    private void setMargins (View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();
        }
    }
}
