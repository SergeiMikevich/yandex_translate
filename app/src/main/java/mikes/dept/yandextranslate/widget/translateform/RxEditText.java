package mikes.dept.yandextranslate.widget.translateform;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import java.util.concurrent.TimeUnit;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.PublishSubject;

/**
 * Created by mikesdept on 24.4.17.
 */

public class RxEditText extends AppCompatEditText {

    private PublishSubject<String> editTextSubject = PublishSubject.create();
    private Subscription subscription;

    public RxEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RxEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RxEditText(Context context) {
        super(context);
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        if (editTextSubject != null) {
            editTextSubject.onNext(text.toString());
        }
    }

    public void setOnRxTextChangeListener(RxEditTextChangeListener listener, int debounce) {
        if (subscription != null) {
            subscription.unsubscribe();
        }
        subscription = editTextSubject.asObservable()
                .debounce(debounce, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .doOnNext(listener::onTextChanged)
                .subscribe();
    }

    public interface RxEditTextChangeListener {
        void onTextChanged(String text);
    }

}
