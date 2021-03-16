package com.itvillage.chapter01.chapter0101;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ToDoSample {
    public static void main(String[] args) throws InterruptedException {
        Observable.just(100, 200, 300, 400, 500)

                .doOnNext(data -> System.out.println(getThreadName() + " : " + "#doOnNext() : " + data))
                /** subscribeOn : 생산자쪽의 데이터 흐름을 제어하기 위해 사용하는 연산자
                 *  구독(subscribe)에서 사용할 스레드를 지정
                 *  다른 스케줄러를 지정해서 Observable이 처리해야 할 연산자들을 실행 시킨다. */
                /** Schedulers.io() - 동기 I/O를 별도로 처리시켜 비동기 효율을 얻기 위한 스케줄러 */
                .subscribeOn(Schedulers.io())

                /** observeOn : 소비자쪽에서 전달받은 데이터 처리를 제어하기 위해 사용하는 연산자
                 *  Observable이 다음처리를 진행할때 사용할 스레드를 지정
                 *  ObserveOn 연산자는 Observable이 옵저버에게 알림을 보낼때 사용 할 스케줄러를 명시 */
                .observeOn(Schedulers.computation())

                .filter(number -> number > 300)
                .subscribe(num -> System.out.println(getThreadName() + " : result : " + num));

        Thread.sleep(500);
    }

    public static String getThreadName(){
        return Thread.currentThread().getName();
    }
}
