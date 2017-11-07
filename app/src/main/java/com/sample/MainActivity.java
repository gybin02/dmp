/*
 *
 *  *    Copyright (C) 2016 Amit Shekhar
 *  *    Copyright (C) 2011 Android Open Source Project
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 */

package com.sample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.meiyou.framework.DebugDB;
import com.sample.database.CarDBHelper;
import com.sample.database.ContactDBHelper;
import com.sample.database.ExtTestDBHelper;
import com.sample.utils.Utils;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ///初始化数据库工具
        Context context = getApplicationContext();
        
        DebugDB.initialize(context);

        //模拟数据
        Set<String> stringSet = new HashSet<>();
        stringSet.add("SetOne");
        stringSet.add("SetTwo");
        stringSet.add("SetThree");

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        SharedPreferences prefsOne = getSharedPreferences("countPrefOne", Context.MODE_PRIVATE);
        SharedPreferences prefsTwo = getSharedPreferences("countPrefTwo", Context.MODE_PRIVATE);

        sharedPreferences.edit().putString("testOne", "one").commit();
        sharedPreferences.edit().putInt("testTwo", 2).commit();
        sharedPreferences.edit().putLong("testThree", 100000L).commit();
        sharedPreferences.edit().putFloat("testFour", 3.01F).commit();
        sharedPreferences.edit().putBoolean("testFive", true).commit();
        sharedPreferences.edit().putStringSet("testSix", stringSet).commit();

        prefsOne.edit().putString("testOneNew", "one").commit();

        prefsTwo.edit().putString("testTwoNew", "two").commit();
        
        //模拟插入数据库
        ContactDBHelper contactDBHelper = new ContactDBHelper(context);
        if (contactDBHelper.count() == 0) {
            for (int i = 0; i < 100; i++) {
                String name = "name_" + i;
                String phone = "phone_" + i;
                String email = "email_" + i;
                String street = "street_" + i;
                String place = "place_" + i;
                contactDBHelper.insertContact(name, phone, email, street, null);
            }
        }

        CarDBHelper carDBHelper = new CarDBHelper(context);
        if (carDBHelper.count() == 0) {
            for (int i = 0; i < 50; i++) {
                String name = "name_" + i;
                String color = "RED";
                float mileage = i + 10.45f;
                carDBHelper.insertCar(name, color, mileage);
            }
        }

        ExtTestDBHelper extTestDBHelper = new ExtTestDBHelper(context);
        if (extTestDBHelper.count() == 0) {
            for (int i = 0; i < 20; i++) {
                String value = "value_" + i;
                extTestDBHelper.insertTest(value);
            }
        }

        Utils.setCustomDatabaseFiles(context);

        TextView view = (TextView) findViewById(R.id.tv_address);
        String addressLog = DebugDB.getAddressLog();
        view.setText(addressLog);
        
    }

    public void showDebugDbAddress(View view) {
        Utils.showDebugDBAddressLogToast(getApplicationContext());
    }
}
