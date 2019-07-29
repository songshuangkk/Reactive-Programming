package com.songshuang.rp.observable;

import io.reactivex.Observable;

import java.math.BigInteger;
import java.util.Iterator;

public class GenerateNumbersIterator implements Iterator {

  private BigInteger current = BigInteger.ZERO;

  private BigInteger num;

  public GenerateNumbersIterator(BigInteger num) {
    this.num = num;
  }

  @Override
  public boolean hasNext() {
    return current.compareTo(num) < 0;
  }

  @Override
  public Object next() {
    current = current.add(BigInteger.ONE);
    return current;
  }

  public static void main(String[] args) {
//    GenerateNumbersIterator generateNumbersIterator = new GenerateNumbersIterator(BigInteger.valueOf(10L));
//    while (generateNumbersIterator.hasNext()) {
//      System.out.printf("%s\n", generateNumbersIterator.next());
//    }

    Observable<Object> objectObservable = Observable.create(observer -> {
      observer.onNext("处理的数字是: " + Math.random() * 100);
      observer.onComplete();
    });

    objectObservable.subscribe(consumer -> {
      System.out.printf("我处理的元素是: %s\n", consumer);
    });

    objectObservable.subscribe(consumer -> {
      System.out.printf("我处理的元素是: %s\n", consumer);
    });
  }
}
