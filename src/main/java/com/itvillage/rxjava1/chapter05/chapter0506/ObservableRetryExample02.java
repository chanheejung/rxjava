package com.itvillage.rxjava1.chapter05.chapter0506;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * 에러 발생시 재시도를 즉시 하지 않고, 지연 시간을 주고 재시도를 하는 예제
 */
public class ObservableRetryExample02 {
    private final static int RETRY_MAX = 5;
    public static void main(String[] args) {
        Observable.just(5)
                .flatMap(
                        num -> Observable
                                .interval(200L, TimeUnit.MILLISECONDS)
                                .map(i -> {
                                    long result;
                                    try{
                                        result = num / i;
                                    }catch(ArithmeticException ex){
                                        Logger.log(LogType.PRINT, "error: " + ex.getMessage());
                                        throw ex;
                                    }
                                    return result;
                                })
                                /** retryCount:재시도횟수, ex:예외*/
                                .retry((retryCount, ex) -> {
                                    Logger.log(LogType.PRINT, "# 재시도 횟수: " + retryCount);
                                    // 서버-클라이언트 요청의 재처리시 일정간격을 준다.
                                    TimeUtil.sleep(1000L);
                                    return retryCount < RETRY_MAX ? true : false;
                                })
                                .onErrorReturn(throwable -> -1L)

                ).subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );


        TimeUtil.sleep(6000L);
    }
}
