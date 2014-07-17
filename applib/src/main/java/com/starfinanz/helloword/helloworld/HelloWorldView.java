package com.starfinanz.helloword.helloworld;

import com.starfinanz.helloword.core.ClickListener;
import com.starfinanz.helloword.core.View;

public interface HelloWorldView extends View {

    void setSubmitButtonClickListener(ClickListener clickListener);

    void setResultText(String text);

    String getInputText();
}
