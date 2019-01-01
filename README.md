## SEmojis

[SEmojis] is a library to implement and render emojis.

[![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15)

[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-SEmojis-green.svg?style=flat )]( https://android-arsenal.com/details/1/7411 )

## Library available on JitPack
[![](https://jitpack.io/v/TutorialsAndroid/SEmojis.svg)](https://jitpack.io/#TutorialsAndroid/SEmojis)

## Java Usage

To Listen to keyboard status 
```
emojIcon.setKeyboardListener(new EmojIconActions.KeyboardListener() {
@Override
public void onKeyboardOpen() {
    Log.e("Keyboard","open");
  }

@Override
public void onKeyboardClose() {
  Log.e("Keyboard","close");
}
});
```

## XML Usage

```
<developer.semojis.Helper.EmojiconEditText
        android:id="@+id/emojicon_edit_text"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        emojicon:emojiconSize="28sp" />
        
        
<developer.semojis.Helper.EmojiconTextView
        android:id="@+id/emojicon_text_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" 
        emojicon:emojiconSize="28sp"/>

```

## Usage

* `EmojiconTextView`: a `TextView` which can render emojis.
* `EmojiconEditText`: a `EditText` which can render emojis.
* `EmojiconMultiAutoCompleteTextView`: a `MultiAutoCompleteTextView` which can render emojis.

## Building in Android Studio

Via Gradle:

```

repositories {
   maven { url 'https://jitpack.io' }
}
  implementation 'com.github.TutorialsAndroid:SEmojis:v0.1'
```
## Output

![alt text](https://github.com/TutorialsAndroid/SEmojis/blob/master/art/mockup001.png)

![alt text](https://github.com/TutorialsAndroid/SEmojis/blob/master/art/mockup002.png)

## Acknowledgements

SEmojis is using emojis graphics from [emoji-cheat-sheet.com](https://github.com/arvida/emoji-cheat-sheet.com/tree/master/public/graphics/emojis).

## License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

```
Copyright 2018 SEmojis

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
