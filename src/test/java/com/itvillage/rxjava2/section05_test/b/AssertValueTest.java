package com.itvillage.rxjava2.section05_test.b;

import com.itvillage.common.CarMaker;
import com.itvillage.rxjava2.section04_test.SampleObservable;
import io.reactivex.Observable;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * assertValue를 이용한 데이터 검증 예제
 */
public class AssertValueTest {
    @Test
    public void assertValueTest(){
        Observable.just("a")
                .test()
                .assertValue("a");
    }

    @Test
    public void getCarMakerAssertValueTest(){
        SampleObservable.getCarMakerStream()
                .filter(carMaker -> carMaker.equals(CarMaker.SAMSUNG))
                .test()
                // 생성자에서 Schedulers.computation()로 별도의 함수로 실행하기 때문에 약간의 대기가 필요
                .awaitDone(1L, TimeUnit.MILLISECONDS)
                .assertValue(CarMaker.SAMSUNG);
    }
}
