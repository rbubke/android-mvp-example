package com.starfinanz.helloword.core;

import java.lang.ref.WeakReference;

public interface Presenter<V extends View> {

    void setView(WeakReference<V> viewReference);
}
