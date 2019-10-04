package semoji.developer;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import developer.semojis.actions.EmojIconActions;
import developer.semojis.Helper.EmojiconEditText;
import developer.semojis.Helper.EmojiconTextView;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private EmojiconEditText emojiconEditText;
    private EmojiconTextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain);

        View rootView = findViewById(R.id.root_view);
        ImageView emojiButton = findViewById(R.id.emoji_btn);
        ImageView submitButton = findViewById(R.id.submit_btn);
        emojiconEditText =  findViewById(R.id.emojicon_edit_text);
        EmojiconEditText emojiconEditText2 = findViewById(R.id.emojicon_edit_text2);
        textView =  findViewById(R.id.textView);
        EmojIconActions emojIcon = new EmojIconActions(this, rootView, emojiconEditText, emojiButton);
        emojIcon.ShowEmojIcon();
        emojIcon.setKeyboardListener(new EmojIconActions.KeyboardListener() {
            @Override
            public void onKeyboardOpen() {
                Log.e("Keyboard", "open");
            }

            @Override
            public void onKeyboardClose() {
                Log.e("Keyboard", "close");
            }
        });

        emojIcon.addEmojiconEditTextList(emojiconEditText2);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                String newText = Objects.requireNonNull(emojiconEditText.getText()).toString();
                textView.setText(newText);
            }
        });
    }
}