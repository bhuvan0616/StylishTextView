package com.vertace;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by Bhuvanesh on 28-03-17.
 * Created for Vertace.
 */

public final class StylishText extends AppCompatTextView {
    public StylishText(Context context) {
        super(context);
    }

    public StylishText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(attrs);
    }

    public StylishText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(attrs);
    }

    /**
     * Font specified in the Layout is applied to the text
     *
     * @param attr attribute values.
     */
    private void setFont(AttributeSet attr) {
        if (attr != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attr, R.styleable.StylishText);
            String fontName = typedArray.getString(R.styleable.StylishText_font);
            if (fontName != null) {
                try {
                    Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + fontName + ".ttf");
                    setTypeface(typeface);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
            typedArray.recycle();
        }
    }

}
