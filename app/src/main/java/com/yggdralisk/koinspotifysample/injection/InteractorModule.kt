package com.yggdralisk.koinspotifysample.injection

import com.yggdralisk.koinspotifysample.domain.LoginInteractor
import com.yggdralisk.koinspotifysample.domain.LoginStatusInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.dsl.module.module

val interactorModule = module {
    factory { LoginStatusInteractor(get(), Schedulers.io(), AndroidSchedulers.mainThread()) }
    factory { LoginInteractor(get()) }
}