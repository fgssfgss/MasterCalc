package com.homelinux.berkut.calculator;

import android.content.Context;
import android.widget.EditText;

/**
 * Created by Aberk on 01.07.2015.
 */
public class MyTextEdit extends EditText {
    public MyTextEdit(Context context) {
        super(context);
    }

    @Override
    public boolean onCheckIsTextEditor() {
        return false;
    }
}
