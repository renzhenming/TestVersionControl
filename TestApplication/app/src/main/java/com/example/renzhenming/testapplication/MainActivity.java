package com.example.renzhenming.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //修改一行代码
        System.out.println("hello");
        //更新master代码
        System.out.println("更新master代码");
        //第三次提交
        System.out.println("第三次提交");
        //第四次提交
        System.out.println("第四次提交");
        //第五次提交
        System.out.println("第五次提交");
        //删除无用分支
        System.out.println("删除无用分支");

        //git checkout -- file
        //5/23第一次提交
        System.out.println("5/23第一次提交");
        //5/23第2次提交
        System.out.println("5/23第2次提交");
        //merge失败
        System.out.println("merge失败");
        //merge成功一次
        System.out.println("merge成功一次");
        //再次merge
        System.out.println("再次merge");
        //5/23第一次提交
        System.out.println("5/23第一次提交");
        //5/23第2次提交
        System.out.println("5/23第2次提交");
        //merge失败
        System.out.println("merge失败");
        //merge成功一次
        System.out.println("merge成功一次");
        //再次merge
        System.out.println("最后一次测试乐乐乐乐乐乐乐乐乐");

        //撤销提交到本地的代码
        System.out.println("撤销提交到本地的代码");

        //xxxxx
        System.out.println("xxxxxxx");
        //yyyyy
        System.out.println("yyyyy");
        //yyyyy
        System.out.println("继续提交到ren分支");
        //合并分支
        System.out.println("合并分支");
        System.out.println("提交到master分支，然后合并到ren分支");
    }
}
