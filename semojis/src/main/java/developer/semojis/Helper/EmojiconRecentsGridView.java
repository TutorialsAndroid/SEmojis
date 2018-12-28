package developer.semojis.Helper;

import android.content.Context;
import android.widget.GridView;
import developer.semojis.R;
import developer.semojis.emoji.Emojicon;

public class EmojiconRecentsGridView  extends EmojiconGridView implements EmojiconRecents {

    private final EmojiAdapter mAdapter;

    EmojiconRecentsGridView(Context context,
                            EmojiconRecents recents, EmojiconsPopup emojiconsPopup) {
        super(context, null, recents, emojiconsPopup);
        EmojiconRecentsManager recents1 = EmojiconRecentsManager
                .getInstance(rootView.getContext());
        mAdapter = new EmojiAdapter(rootView.getContext(),  recents1);
        mAdapter.setEmojiClickListener(new OnEmojiconClickedListener() {

            @Override
            public void onEmojiconClicked(Emojicon emojicon) {
                if (mEmojiconPopup.onEmojiconClickedListener != null) {
                    mEmojiconPopup.onEmojiconClickedListener.onEmojiconClicked(emojicon);
                }
            }
        });
        GridView gridView = rootView.findViewById(R.id.Emoji_GridView);
        gridView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void addRecentEmoji(Context context, Emojicon emojicon) {
        EmojiconRecentsManager recents = EmojiconRecentsManager
                .getInstance(context);
        recents.push(emojicon);

        // notify data set changed
        if (mAdapter != null)
            mAdapter.notifyDataSetChanged();
    }

}