package helloworld.starfinanz.com.helloword;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.starfinanz.helloword.helloworld.HelloWorldPresenter;
import com.starfinanz.helloword.helloworld.HelloWorldView;
import com.starfinanz.helloword.core.ClickListener;

import java.lang.ref.WeakReference;


public class HelloWordActivity extends Activity implements HelloWorldView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_word);
        new HelloWorldPresenter().setView(new WeakReference<HelloWorldView>(this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hello_word, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void setSubmitButtonClickListener(final ClickListener clickListener) {
        findViewById(R.id.submitButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClick();
            }
        });
    }

    @Override
    public void setResultText(String text) {
        TextView textView = (TextView) findViewById(R.id.resultTextView);
        textView.setText(text);
    }

    @Override
    public String getInputText() {
        EditText inputText = (EditText) findViewById(R.id.infoEditTextView);
        return inputText.getText().toString();
    }
}
