package mikes.dept.yandextranslate.repository;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

/**
 * Created by mikesdept on 23.4.17.
 */

public class RepositoryProvider {

    private static YandexTranslateRepository sRepository;

    private RepositoryProvider(){

    }

    @NonNull
    public static YandexTranslateRepository provideYandexTranslateRepository(){
        if(sRepository == null){
            sRepository = new DefaultYandexTranslateRepository();
        }
        return sRepository;
    }

    @MainThread
    public static void init(){
        sRepository = new DefaultYandexTranslateRepository();
    }

}
