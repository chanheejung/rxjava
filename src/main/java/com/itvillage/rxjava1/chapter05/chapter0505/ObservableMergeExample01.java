package com.itvillage.rxjava1.chapter05.chapter0505;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * 두개 이상의 Observable을 merge하여 통지된 시간 순대로 출력하는 예제
 */
public class ObservableMergeExample01 {
    public static void main(String[] args) {
        Observable<Long> observable1 = Observable.interval(200L, TimeUnit.MILLISECONDS)
                .take(5);

        Observable<Long> observable2 = Observable.interval(400L, TimeUnit.MILLISECONDS)
                .take(5)
                .map(num -> num + 1000);

        /** 통지 시간이 같을 경우 merge 함수의 파라미터로 먼저 지정된 Oversable의 데이터 부터 통지 된다.*/
        Observable.merge(observable1, observable2)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(4000);
    }
}
