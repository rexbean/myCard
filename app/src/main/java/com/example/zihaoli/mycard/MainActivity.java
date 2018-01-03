package com.example.zihaoli.mycard;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.zihaoli.mycard.Utility.Util;
import com.example.zihaoli.mycard.entity.Person;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //path = https://s3-us-west-2.amazonaws.com/udacity-mobile-interview/CardData.json
        Runnable r = new Runnable() {
            @Override
            public void run() {
                ArrayList<Person> personList = new ArrayList<>();
                String path = "https://s3-us-west-2.amazonaws.com/udacity-mobile-interview/CardData.json";
                String jsonString = Util.getJson(path);
                personList = Util.parseJson(jsonString);
                if(personList != null){
                    //handler;
                    for(Person p : personList){
                        MyFragment fragment = new MyFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("lastName",p.getLastName());
                        bundle.putString("firstName",p.getFirstName());
                        bundle.putString("email",p.getEmail());
                        bundle.putString("company",p.getCompany());
                        bundle.putString("startDate",p.getStartDate());
                        bundle.putString("bio",p.getBio());
                        bundle.putString("avatar",p.getAvatar());
                    }




                }

            }
        };
        r.run();
    }
}
