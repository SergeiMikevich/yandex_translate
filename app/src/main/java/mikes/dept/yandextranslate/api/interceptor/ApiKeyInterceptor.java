package mikes.dept.yandextranslate.api.interceptor;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.io.IOException;

import mikes.dept.yandextranslate.BuildConfig;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mikesdept on 23.4.17.
 */

public class ApiKeyInterceptor implements Interceptor {

    private final String mApiKey;

    private ApiKeyInterceptor() {
        mApiKey = BuildConfig.API_KEY;
    }

    @NonNull
    public static Interceptor create() {
        return new ApiKeyInterceptor();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (TextUtils.isEmpty(mApiKey)) {
            return chain.proceed(chain.request());
        }
        HttpUrl url = chain.request().url()
                .newBuilder()
                .addQueryParameter("key", mApiKey)
                .build();
        Request request = chain.request()
                .newBuilder()
                .url(url)
                .build();
        return chain.proceed(request);
    }

}
