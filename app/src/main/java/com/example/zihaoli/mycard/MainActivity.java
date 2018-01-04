package com.example.zihaoli.mycard;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.example.zihaoli.mycard.Utility.Util;
import com.example.zihaoli.mycard.entity.Person;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    private ViewPager viewPager;
    private FragmentManager fragmentManager;

    private class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {

            ArrayList<MyFragment> fragmentList = new ArrayList<>();
            ArrayList<Person> personList = (ArrayList<Person>)msg.obj;
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
                fragment.setArguments(bundle);
                fragmentList.add(fragment);

            }

            viewPager.setOffscreenPageLimit(fragmentList.size());//卡片数量
            viewPager.setPageMargin(10);//两个卡片之间的距离，单位dp

            if (viewPager!=null){
                viewPager.removeAllViews();
            }

            MyFragmentAdapter myFragmentPagerAdapter = new MyFragmentAdapter(getSupportFragmentManager(), fragmentList);

            viewPager.setAdapter(myFragmentPagerAdapter);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        viewPager = (ViewPager)this.findViewById(R.id.vpPersonList) ;
        final MyHandler handler = new MyHandler();


        //path = https://s3-us-west-2.amazonaws.com/udacity-mobile-interview/CardData.json
        Runnable r = new Runnable() {
            @Override
            public void run() {
                ArrayList<Person> personList = new ArrayList<>();
                String path = "https://s3-us-west-2.amazonaws.com/udacity-mobile-interview/CardData.json";
                String jsonString = Util.getJson(path);
                personList = Util.parseJson(jsonString);
                if(personList != null){
                    Message msg = handler.obtainMessage();
                    msg.obj = personList;
                    handler.sendMessage(msg);
                }

            }
        };
        r.run();
    }
}
