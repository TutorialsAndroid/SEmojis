package developer.semojis.Helper;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.DynamicDrawableSpan;
import android.util.AttributeSet;
import developer.semojis.R;

public class EmojiconTextView extends androidx.appcompat.widget.AppCompatTextView {
    private int mEmojiconSize;
    private int mEmojiconAlignment;
    private int mEmojiconTextSize;
    private int mTextStart = 0;
    private int mTextLength = -1;
    private boolean mUseSystemDefault = false;

    public EmojiconTextView(Context context) {
        super(context);
        init(null);
    }

    public EmojiconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public EmojiconTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        mEmojiconTextSize = (int) getTextSize();
        if (attrs == null) {
            mEmojiconSize = (int) getTextSize();
        } else {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.Emojicon);
            mEmojiconSize = (int) a.getDimension(R.styleable.Emojicon_emojiconSize, getTextSize());
            mEmojiconAlignment = a.getInt(R.styleable.Emojicon_emojiconAlignment, DynamicDrawableSpan.ALIGN_BOTTOM);
            mTextStart = a.getInteger(R.styleable.Emojicon_emojiconTextStart, 0);
            mTextLength = a.getInteger(R.styleable.Emojicon_emojiconTextLength, -1);
            mUseSystemDefault = a.getBoolean(R.styleable.Emojicon_emojiconUseSystemDefault, mUseSystemDefault);
            a.recycle();
        }
        setText(getText());
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        if (!TextUtils.isEmpty(text)) {
            SpannableStringBuilder builder = new SpannableStringBuilder(text);
            EmojiconHandler.addEmojis(getContext(), builder, mEmojiconSize, mEmojiconAlignment, mEmojiconTextSize, mTextStart, mTextLength, mUseSystemDefault);
            text = builder;
        }
        super.setText(text, type);
    }

    /**
     * Set the size of emojicon in pixels.
     */
    public void setEmojiconSize(int pixels) {
        mEmojiconSize = pixels;
        super.setText(getText());
    }
}
