package com.hariofspades.dagger2advanced.module;

import android.content.Context;

import com.hariofspades.dagger2advanced.interfaces.ApplicationContext;
import com.hariofspades.dagger2advanced.interfaces.RandomUserApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * @author wzc
 * @date 2018/6/4
 */
@Module
public class ContextModule {
    private final Context mContext;

    public ContextModule(Context context) {
        mContext = context;
    }
    @ApplicationContext
    @RandomUserApplicationScope
    @Provides
    public Context context() {
        return mContext.getApplicationContext();
    }
}
