package com.example.renzhenming.testapplication;

import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RXJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);

       /* Student student1 = new Student("张三");

        Student student2 = new Student("lisi");
        Student student3 = new Student("wangwu");

        Student [] students = {student1,student2,student3};

        Observable.from(students)
                .map(new Func1<Student, String>() {
                    @Override
                    public String call(Student student) {
                        return student.name;
                    }
                })
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("学生姓名："+s);
                    }
                });*/
        /***********************************************************/
        //变换
        /*final ImageView mImageView = (ImageView) findViewById(R.id.image);
        Observable.just("image1")
                .map(new Func1<String, Bitmap>() {
                    @Override
                    public Bitmap call(String s) {
                        return BitmapFactory.decodeResource(getResources(),R.drawable.imag1);
                    }
                })
                .subscribe(new Action1<Bitmap>() {
                    @Override
                    public void call(Bitmap bitmap) {
                       mImageView.setImageBitmap(bitmap);
                    }
                });*/

        /***********************************************************/

        //异步的观察者模式
        /*Observable.just(1,2,3,4)
                .subscribeOn(Schedulers.io())               // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread())  // 指定 Subscriber 的回调发生在主线程
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println("number:"+integer);
                    }
                });*/

        /***********************************************************/

        //同步的观察者模式
        /*final ImageView mImageView = (ImageView) findViewById(R.id.image);
        final int imageId = R.drawable.imag1;
        Observable.create(new Observable.OnSubscribe<Drawable>() {
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Drawable drawable = ContextCompat.getDrawable(RXJavaActivity.this,imageId);
                subscriber.onNext(drawable);
                subscriber.onCompleted();
            }
        }).subscribe(new Observer<Drawable>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(RXJavaActivity.this, "Error!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(Drawable drawable) {
                mImageView.setImageDrawable(drawable);
            }
        });*/


        /***********************************************************/

        /*String names [] = {"hello","rxJava"};

        Observable.from(names).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("打印结果:"+s);
            }
        });*/

        /***********************************************************/

        /*Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {

            }
        };

        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        };

        Action0 onCompleteAction = new Action0() {
            @Override
            public void call() {

            }
        };

        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello");
                subscriber.onNext("hi");
                subscriber.onNext("rxJava");
                subscriber.onCompleted();
            }
        });

        observable.subscribe(onNextAction,onErrorAction,onCompleteAction);*/

        // 自动创建 Subscriber ，并使用 onNextAction 来定义 onNext()
        //observable.subscribe(onNextAction);
        // 自动创建 Subscriber ，并使用 onNextAction 和 onErrorAction 来定义 onNext() 和 onError()
        //observable.subscribe(onNextAction, onErrorAction);
        // 自动创建 Subscriber ，并使用 onNextAction、 onErrorAction 和 onCompletedAction 来定义 onNext()、 onError() 和 onCompleted()
        //observable.subscribe(onNextAction, onErrorAction, onCompleteAction);

        /***********************************************************/

        //String [] words = {"hello","hi","rxJava"};
        // 将会依次调用：
        // onNext("Hello");
        // onNext("Hi");
        // onNext("Aloha");
        // onCompleted();
        //Observable.from(words);

        /***********************************************************/
        // 将会依次调用：
        // onNext("Hello");
        // onNext("Hi");
        // onNext("Aloha");
        // onCompleted();
        //Observable.just("hello","hi","rxJava");
        /***********************************************************/
        /*Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello");
                subscriber.onNext("hi");
                subscriber.onNext("rxJava");
                subscriber.onCompleted();
            }
        });*/
        /***********************************************************/
        /*Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };*/
        /***********************************************************/
        /*Subscriber<String> subscriber = new Subscriber<String>() {


            @Override
            public void onStart() {
                super.onStart();
                //在 subscribe 所发生的线程被调用，而不能指定线程
            }

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };

        observable.subscribe(subscriber);*/
    }
}
