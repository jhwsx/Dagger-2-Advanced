package com.hariofspades.dagger2advanced.module;

import android.content.Context;

import com.hariofspades.dagger2advanced.interfaces.ApplicationContext;
import com.hariofspades.dagger2advanced.interfaces.RandomUserApplicationScope;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * @author wzc
 * @date 2018/6/4
 */
@Module(includes = OkHttpClientModule.class)
public class PicassoModule {
    @RandomUserApplicationScope
    @Provides
    public Picasso picasso(@ApplicationContext Context context, OkHttp3Downloader okHttpDownloader) {
        return new Picasso.Builder(context).downloader(okHttpDownloader).build();
    }
    @RandomUserApplicationScope
    @Provides
    public OkHttp3Downloader okHttpDownloader(OkHttpClient okHttpClient) {
        return new OkHttp3Downloader(okHttpClient);
    }
}
