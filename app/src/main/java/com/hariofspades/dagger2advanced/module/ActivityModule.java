package com.hariofspades.dagger2advanced.module;

import android.app.Activity;
import android.content.Context;

import com.hariofspades.dagger2advanced.interfaces.RandomUserApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * @author wzc
 * @date 2018/6/5
 */
@Module
public class ActivityModule {
    private final Context mContext;

    public ActivityModule(Activity context) {
        mContext = context;
    }

    @Named("activity_context")
    @RandomUserApplicationScope
    @Provides
    public Context context() {
        return mContext;
    }

}
