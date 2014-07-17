import com.starfinanz.helloword.core.ClickListener;
import com.starfinanz.helloword.helloworld.HelloWorldPresenter;
import com.starfinanz.helloword.helloworld.HelloWorldView;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.lang.ref.WeakReference;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

/**
 * Created by rob.extern on 10/07/14.
 */

public class HelloWorldPresenterTest {

    private static String TEST_STRING = "It works !";


    @Test
    public void shouldReadInputTextAndDisplayTextOnSubmitButtonCall() {
        HelloWorldPresenter presenter = new HelloWorldPresenter();
        HelloWorldView view = mock(HelloWorldView.class);
        stub(view.getInputText()).toReturn(TEST_STRING);
        emulateSubmitButtonClick(view);
        presenter.setView(new WeakReference<HelloWorldView>(view));
        verify(view).setResultText(TEST_STRING);
    }

    private void emulateSubmitButtonClick(HelloWorldView view) {
        doAnswer(new Answer() {
            public Void answer(InvocationOnMock invocation) {
                ClickListener clickListener = (ClickListener) invocation.getArguments()[0];
                clickListener.onClick();
                return null;
            }
        }).when(view).setSubmitButtonClickListener(Matchers.<ClickListener>anyObject());
    }
}
