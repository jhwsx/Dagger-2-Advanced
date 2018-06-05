package com.hariofspades.dagger2advanced.module;

import android.content.Context;
import android.support.annotation.NonNull;

import com.hariofspades.dagger2advanced.interfaces.ApplicationContext;
import com.hariofspades.dagger2advanced.interfaces.RandomUserApplicationScope;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * @author wzc
 * @date 2018/6/4
 */
@Module(includes = ContextModule.class)
public class OkHttpClientModule {
    @RandomUserApplicationScope
    @Provides
    public OkHttpClient okHttpClient(Cache cache, HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient()
                .newBuilder()
                .cache(cache)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }
    @RandomUserApplicationScope
    @Provides
    public Cache cache(File cacheFile) {
        return new Cache(cacheFile, 10 * 1000 * 1000);
    }

    @RandomUserApplicationScope
    @Provides
    public File cacheFile(@ApplicationContext Context context) {
        File cacheFile = new File(context.getCacheDir(), "HttpCache");
        cacheFile.mkdirs();
        return cacheFile;
    }
    @RandomUserApplicationScope
    @Provides
    public HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new
                HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(@NonNull String message) {
                Timber.i(message);
            }
        });

        return httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    }

}
