package com.itvillage.rxjava2.section02_schduler.e_single;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class SchedulerSingleExample {
    public static void main(String[] args) {
        Observable<String> observable = Observable.just("1", "2", "3", "4", "5");

        observable.subscribeOn(Schedulers.computation())
                .map(data -> "## " + data + " ##")
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        observable.subscribeOn(Schedulers.computation())
                .map(data -> "$$ " + data + " $$")
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(300L);
    }
}
