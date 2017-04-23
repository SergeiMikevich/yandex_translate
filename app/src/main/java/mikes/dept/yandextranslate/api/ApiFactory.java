package mikes.dept.yandextranslate.api;

import android.support.annotation.NonNull;

import mikes.dept.yandextranslate.BuildConfig;
import mikes.dept.yandextranslate.api.interceptor.LoggingInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mikesdept on 23.4.17.
 */

public class ApiFactory {

    private static OkHttpClient sClient;

    private static volatile YandexTranslateService sService;

    private ApiFactory() {
    }

    public static void recreate() {
        sClient = null;
        sClient = getClient();
        sService = buildRetrofit().create(YandexTranslateService.class);
    }

    @NonNull
    public static YandexTranslateService getYandexTranslateService() {
        YandexTranslateService service = sService;
        if (service == null) {
            synchronized (ApiFactory.class) {
                service = sService;
                if (service == null) {
                    service = sService = buildRetrofit().create(YandexTranslateService.class);
                }
            }
        }
        return service;
    }

    @NonNull
    private static Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @NonNull
    private static OkHttpClient getClient() {
        OkHttpClient client = sClient;
        if (client == null) {
            synchronized (ApiFactory.class) {
                client = sClient;
                if (client == null) {
                    client = sClient = buildClient();
                }
            }
        }
        return client;
    }

    @NonNull
    private static OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(LoggingInterceptor.create())
                .build();
    }

}
