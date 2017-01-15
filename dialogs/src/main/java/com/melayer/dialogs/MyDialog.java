package com.melayer.dialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by aniruddha on 15/1/17.
 */

public class MyDialog extends DialogFragment {

    public static final String TAG_ALERT = "alert";
    public static final String TAG_DATE_PICKER = "datePicker";
    public static final String TAG_TIME_PICKER = "timePicker";
    public static final String TAG_PROGRESS = "progress";
    public static final String TAG_CUSTOM = "custom";

    private LayoutInflater inflater;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inflater = LayoutInflater.from(getActivity());
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        Dialog dialog = null;

        if(getTag().equals(TAG_ALERT)) dialog = alertDialog();
        else if(getTag().equals(TAG_DATE_PICKER)) dialog = datePicker();
        else if(getTag().equals(TAG_TIME_PICKER)) dialog = timePicker();
        else if(getTag().equals(TAG_PROGRESS)) dialog = progressDialog();
        else dialog = customDialog();

        return dialog;
    }

    private Dialog alertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle("Title")
                .setMessage("Message")
                .setPositiveButton("Yes",(di, which) -> mt("Yes Clicked"))
                .setNegativeButton("No", (di, which) -> mt("No Clicked"));
        AlertDialog dialog = builder.create();

        return dialog;
    }

    private Dialog datePicker() {

        Calendar cal = new GregorianCalendar();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dpd = new DatePickerDialog(getActivity(), this::onDateSelected, 2017 ,0 ,day);
        return dpd;
    }

    private Dialog timePicker() {
        TimePickerDialog tpd = new TimePickerDialog(getActivity(),this::onTimeSelected,6,57,true);
        return tpd;
    }

    private Dialog progressDialog() {
        ProgressDialog pd = new ProgressDialog(getActivity());
        pd.setTitle("Title");
        pd.setMessage("Message");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        return pd;
    }

    private Dialog customDialog(){

        View view = inflater.inflate(R.layout.custom_dialog,null,false);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(view);

        Dialog dialog = builder.create();

        return dialog;
    }

    private void onTimeSelected(TimePicker timePicker, int hour, int minutes) {
        mt(hour +" : "+minutes);
    }

    private void onDateSelected(DatePicker datePicker, int year, int month, int day) {
        mt(day +" - "+ month +" - "+ year);
    }

    private void mt(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
