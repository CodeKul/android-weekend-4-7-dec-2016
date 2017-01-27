package com.melayer.webcommunication;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by aniruddha on 27/1/17.
 */

public class Q {

    private static RequestQueue queue;

    private Q() {
        // no object creation
    }

    public static RequestQueue q(Context context) {
        if(queue == null) queue = Volley.newRequestQueue(context);
        return queue;
    }
}
