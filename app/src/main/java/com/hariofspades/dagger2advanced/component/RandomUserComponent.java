package com.hariofspades.dagger2advanced.component;

import com.hariofspades.dagger2advanced.interfaces.RandomUserApplicationScope;
import com.hariofspades.dagger2advanced.interfaces.RandomUsersApi;
import com.hariofspades.dagger2advanced.module.PicassoModule;
import com.hariofspades.dagger2advanced.module.RandomUsersModule;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * @author wzc
 * @date 2018/6/4
 */
@RandomUserApplicationScope
@Component(modules = {RandomUsersModule.class, PicassoModule.class})
public interface RandomUserComponent {

    RandomUsersApi getRandomUserService();

    Picasso getPicasso();
}
