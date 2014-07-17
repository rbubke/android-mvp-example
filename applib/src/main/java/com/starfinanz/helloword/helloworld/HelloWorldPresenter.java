package com.starfinanz.helloword.helloworld;

import com.starfinanz.helloword.core.ClickListener;
import com.starfinanz.helloword.core.Presenter;

import java.lang.ref.WeakReference;

public class HelloWorldPresenter implements Presenter<HelloWorldView> {

    private WeakReference<HelloWorldView> viewReference;

    @Override
    public void setView(WeakReference<HelloWorldView> viewReference) {
        this.viewReference = viewReference;
        initializeView();
    }

    private void initializeView() {
        viewReference.get().setSubmitButtonClickListener(new ClickListener() {
            @Override
            public void onClick() {
                HelloWorldView view = viewReference.get();
                if (view != null)
                    view.setResultText(view.getInputText());
            }
        });

    }
}
