package com.itvillage.rxjava1.chapter03.chapter0303;

import com.itvillage.utils.DateUtil;
import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Single;

/**
 * Single 클래스를 사용하여 현재 날짜와 시각을 통지하는 예제 (람다)
 */
public class SingleLamdaExample {
    public static void main(String[] args){
        Single<String> single = Single.create(emitter -> emitter.onSuccess(DateUtil.getNowDate()));

        single.subscribe(
                data -> Logger.log(LogType.ON_SUCCESS, "# 날짜시각: " + data),
                error -> Logger.log(LogType.ON_ERROR, error)
        );
    }
}
