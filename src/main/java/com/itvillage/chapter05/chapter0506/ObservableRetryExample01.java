package com.itvillage.chapter05.chapter0506;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableRetryExample01 {
    public static void main(String[] args) {
        Observable.just(5)
                .flatMap(
                        num -> Observable
                                .interval(200L, TimeUnit.MILLISECONDS) /** 0.2초 간격으로 0부터 통지*/
                                .map(i -> {
                                    long result;
                                    // 일반적으로 map내부에서 try~catch를 사용하지 않지만, retry 동작을 잘 보여주기 위한 예시이다.
                                    try{
                                        result = num / i;
                                    }catch(ArithmeticException ex){
                                        Logger.log(LogType.PRINT, "error: " + ex.getMessage());
                                        throw ex;
                                    }
                                    return result;
                                })
                                .retry(5)
                                .onErrorReturn(throwable -> -1L)
                ).subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );

        TimeUtil.sleep(5000L);
    }
}
