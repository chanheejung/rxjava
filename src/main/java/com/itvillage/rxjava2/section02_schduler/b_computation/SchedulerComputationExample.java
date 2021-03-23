package com.itvillage.rxjava2.section02_schduler.b_computation;

import com.itvillage.common.SampleData;
import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.Arrays;
import java.util.Collections;

/**
 * Schedulers.computatioin() 을 이용해서 계산 작업을 처리하는 예제
 */
public class SchedulerComputationExample {
    public static void main(String[] args) {
        // 각각 서울, 부산, 인천의 시간별 미세먼지(PM10) 농도 수치 발행
        Observable<Integer> observable1 = Observable.fromIterable(SampleData.seoulPM10List);
        Observable<Integer> observable2 = Observable.fromIterable(SampleData.busanPM10List);
        Observable<Integer> observable3 = Observable.fromIterable(SampleData.incheonPM10List);

        // 1~24시 시간 발행
        Observable<Integer> observable4 = Observable.range(1, 24);

        // zip : 결합연산자, 각각의 observable에서 통지하는 순서에 맞는 데이터들을 통지받는다
        Observable source = Observable.zip(observable1, observable2, observable3, observable4,
                (data1, data2, data3, hour) -> hour + "시: " + Collections.max(Arrays.asList(data1, data2, data3)));

        /* 1번째 구독 */
        source.subscribeOn(Schedulers.computation())
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        /* 2번째 구독 */
        source.subscribeOn(Schedulers.computation())
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(500L);
    }
}
