package in.codebreaker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by Bhuvanesh on 28-03-17.
 *
 */

public final class StylishTextView extends AppCompatTextView {
    public StylishTextView(Context context) {
        super(context);
    }

    public StylishTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(attrs);
    }

    public StylishTextView(Context context, AttributeSet attrs, int defStyleAttr) {
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
            TypedArray typedArray = getContext().obtainStyledAttributes(attr, R.styleable.StylishTextView);
            String fontName = typedArray.getString(R.styleable.StylishTextView_font);
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
