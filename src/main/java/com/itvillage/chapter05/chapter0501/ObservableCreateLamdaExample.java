package com.itvillage.chapter05.chapter0501;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

public class ObservableCreateLamdaExample {
    public static void main(String[] args) {
        Observable.create(emitter -> {
            emitter.onNext("Canada");
            emitter.onNext("USA");
            emitter.onNext("Korea");
            emitter.onComplete();
        })
                // 원본
//                .subscribe(System.out::println);
                // 추가 error(), complete() 구현
                .subscribe(
                        data -> System.out.println(data),
                        error -> System.out.println("Error : " + error),
                        () -> System.out.println("Complete")
                );
    }
}
