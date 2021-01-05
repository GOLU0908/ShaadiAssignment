package com.shaadi.assignment.activities;


import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.android.volley.VolleyError;
import com.shaadi.assignment.R;
import com.shaadi.assignment.adapters.UserProfileAdapter;
import com.shaadi.assignment.customViews.CustomActionBar;
import com.shaadi.assignment.interfaces.NetworkRequest;
import com.shaadi.assignment.models.UserProfile;
import com.shaadi.assignment.networking.NetworkService;
import com.shaadi.assignment.utilities.EndPointAPI;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements NetworkRequest {

    CustomActionBar customActionBar;
    RecyclerView rvCustomList;
    UserProfileAdapter userProfileAdapter;
    ArrayList<UserProfile> userProfileArrayList;
    StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        customActionBar = findViewById(R.id.customActionBar);
        rvCustomList = findViewById(R.id.rvCustomList);
        if (userProfileArrayList == null)
            userProfileArrayList = new ArrayList<>();
        if (userProfileAdapter == null)
            userProfileAdapter = new UserProfileAdapter(this, userProfileArrayList);
        setAdapterView();
        getUserList();
    }

    private void getUserList() {
        if (isNetworkConnected())
            NetworkService.getInstance().NetworkObjectRequest(EndPointAPI.UserPrifleList, this, this);
        else
            showToast(getString(R.string.no_internet));

    }

    private void setAdapterView() {
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        rvCustomList.setLayoutManager(staggeredGridLayoutManager);
        rvCustomList.setAdapter(userProfileAdapter);
    }



    @Override
    public void OnSuccess(ArrayList<UserProfile> profileArrayList) {
        if (userProfileArrayList.size() > 0)
            userProfileArrayList.clear();
        userProfileArrayList.addAll(profileArrayList);
        userProfileAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnError(VolleyError volleyError) {
       // showToast(getString(R.string.something_wrong));
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage("Some thing went wrong Please try again")
                .setPositiveButton("Try again", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        getUserList();
                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}