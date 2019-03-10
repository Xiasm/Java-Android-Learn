package com.xsm.androidexperience;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stack<String> stack = new Stack<>();

        Queue queue = new LinkedBlockingQueue();

        HashMap<String, String> map = new HashMap<>();
        map.put("", "");

        startActivity(new Intent());
    }
}
