package com.shaadi.assignment.interfaces;


import com.android.volley.VolleyError;
import com.shaadi.assignment.models.UserProfile;

import java.util.ArrayList;

public interface NetworkRequest {
    public void OnSuccess(ArrayList<UserProfile> profileArrayList);

    public void OnError(VolleyError volleyError);
}
