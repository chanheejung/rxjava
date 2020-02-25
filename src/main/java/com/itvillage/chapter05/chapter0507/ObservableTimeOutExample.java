package com.itvillage.chapter05.chapter0507;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * 각 데이터 통지 시, 지정한 시간안에 데이터가 통지 되지 않으면 에러를 발생시키는 예제
 * - 네트워크 연결 지연 등으로 인한 처리를 위해 retry 관련 함수에 함께 사용하기 좋은 연산자임.
 */
public class ObservableTimeOutExample {
    public static void main(String[] args) {
        Observable.range(1, 4)
                .flatMap(num -> Observable.interval(1000L, TimeUnit.MILLISECONDS).map(i -> num * i))
                .timeout(500L, TimeUnit.MILLISECONDS)
                .subscribe(
                        Logger::on,
                        Logger::oe
                );

        TimeUtil.sleep(1500L);
    }
}