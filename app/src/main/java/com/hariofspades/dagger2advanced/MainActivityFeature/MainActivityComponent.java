package com.hariofspades.dagger2advanced.MainActivityFeature;

import com.hariofspades.dagger2advanced.MainActivity;
import com.hariofspades.dagger2advanced.component.RandomUserComponent;

import dagger.Component;

/**
 * @author wzc
 * @date 2018/6/5
 */
@Component(modules = MainActivityModule.class, dependencies = RandomUserComponent.class)
@MainActivityScope
public interface MainActivityComponent {

//    RandomUserAdapter getRandomUserAdapter();
//
//    RandomUsersApi getRandomUserService();

    void injectMainActivity(MainActivity mainActivity);
}
