package com.itvillage.rxjava2.section04_test;

import org.junit.BeforeClass;

public class RxJavaTest {
    protected static SampleObservable sampleObservable;

    @BeforeClass
    public static void setup(){
        sampleObservable = new SampleObservable();
    }
}
