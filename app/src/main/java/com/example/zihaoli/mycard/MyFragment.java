package com.example.zihaoli.mycard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zihaoli.mycard.entity.Person;

/**
 * Created by zihaoli on 18/1/3.
 */

public class MyFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view=inflater.inflate(R.layout.fragment, container, false);
        TextView tvlastName = (TextView)view.findViewById(R.id.tvLastName);
        TextView tvfirstName = (TextView)view.findViewById(R.id.tvFirstName);
        TextView tvemail = (TextView)view.findViewById(R.id.tvEmail);
        TextView tvcompany = (TextView)view.findViewById(R.id.tvCompany);
        TextView tvstartDate = (TextView)view.findViewById(R.id.tvStartDate);
        TextView tvbio = (TextView)view.findViewById(R.id.tvBio);

        String lastName = (String)getArguments().get("lastName");
        String firstName = (String)getArguments().get("firstName");
        String email = (String)getArguments().get("email");
        String company = (String)getArguments().get("company");
        String startDate = (String)getArguments().get("startDate");
        String bio = (String)getArguments().get("bio");


        tvlastName.setText(lastName);
        tvfirstName.setText(firstName);
        tvemail.setText(email);
        tvcompany.setText(company);
        tvstartDate.setText(startDate);
        tvbio.setText(bio);

        return view;
    }
}
