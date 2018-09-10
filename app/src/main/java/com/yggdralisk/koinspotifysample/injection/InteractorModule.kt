package com.yggdralisk.koinspotifysample.injection

import com.yggdralisk.koinspotifysample.domain.LoginInteractor
import com.yggdralisk.koinspotifysample.domain.LoginStatusInteractor
import com.yggdralisk.koinspotifysample.domain.ReleasesInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.dsl.module.module

private const val IO_SCHEDULER = "IO_SCHEDULER"
private const val MAIN_THREAD_SCHEDULER = "MAIN_THREAD_SCHEDULER"

val interactorModule = module {
    factory { LoginStatusInteractor(get(), get(IO_SCHEDULER), get(MAIN_THREAD_SCHEDULER)) }
    factory { LoginInteractor(get(), get(IO_SCHEDULER), get(MAIN_THREAD_SCHEDULER)) }
    factory { ReleasesInteractor(get(), get(), get(IO_SCHEDULER), get(MAIN_THREAD_SCHEDULER)) }
    single(IO_SCHEDULER) { Schedulers.io() }
    single(MAIN_THREAD_SCHEDULER) { AndroidSchedulers.mainThread() }
}