package com.ooi.diloabsensi;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    int mLayoutId;
    OnDatePickedListener mCallback;

    public interface OnDatePickedListener{
        public void onDatePicked(int year,int month,int day);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mCallback=(OnDatePickedListener)context;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnTimePickedListener.");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        if(mCallback!=null){
            mCallback.onDatePicked(i,i1,i2);
        }
    }
}
