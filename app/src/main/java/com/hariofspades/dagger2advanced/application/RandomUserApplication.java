package com.hariofspades.dagger2advanced.application;

import android.app.Activity;
import android.app.Application;

import com.hariofspades.dagger2advanced.component.DaggerRandomUserComponent;
import com.hariofspades.dagger2advanced.component.RandomUserComponent;
import com.hariofspades.dagger2advanced.module.ContextModule;

import timber.log.Timber;

/**
 * @author wzc
 * @date 2018/6/5
 */
public class RandomUserApplication extends Application {

    public RandomUserComponent getRandomUserApplicationComponent() {
        return mRandomUserApplicationComponent;
    }

    private RandomUserComponent mRandomUserApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        mRandomUserApplicationComponent = DaggerRandomUserComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public static RandomUserApplication get(Activity activity) {
        return (RandomUserApplication) activity.getApplication();
    }
}
