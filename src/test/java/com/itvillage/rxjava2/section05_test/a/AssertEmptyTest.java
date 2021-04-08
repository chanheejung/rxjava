package com.itvillage.rxjava2.section05_test.a;

import com.itvillage.common.Car;
import com.itvillage.rxjava2.section04_test.SampleObservable;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * assertEmpty를 사용하여 해당 시점까지 통지된 데이터가 있는지 검증하는 예제
 */
public class AssertEmptyTest {
    // 테스트 실패 예제
    @Test
    public void getCarStreamEmptyFailTest(){
        // when
        Observable<Car> observable = SampleObservable.getCarStream();
        TestObserver<Car> observer = observable.test();

        // then 0.1초의 대기 시간동안 통지 받는다.
        observer.awaitDone(100L, TimeUnit.MILLISECONDS).assertEmpty();
    }

    // 테스트 성공 예제
    @Test
    public void getCarStreamEmptySuccessTest(){
        // when
        Observable<Car> observable = SampleObservable.getCarStream();
        // 1초 동안 통지를 지연 시킨다.
        TestObserver<Car> observer = observable.delay(1000L, TimeUnit.MILLISECONDS).test();

        // then
        // 0.1초안에는 통지되는 데이터가 없기에 assertEmpty()는 성공한다.
        observer.awaitDone(100L, TimeUnit.MILLISECONDS).assertEmpty();
    }
}
