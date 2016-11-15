package com.ooi.diloabsensi;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {
    OnTimePickedListener mCallback;
    Integer mLayoutId = null;

    public interface OnTimePickedListener {
        public void onTimePicked(int hour, int minute);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnTimePickedListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnTimePickedListener.");
        }
    }

    /* (non-Javadoc)
     * @see android.app.DialogFragment#onCreateDialog(android.os.Bundle)
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    /* (non-Javadoc)
     * @see android.app.TimePickerDialog.OnTimeSetListener#onTimeSet(android.widget.TimePicker, int, int)
     */
    public void onTimeSet(TimePicker view, int hour, int minute) {
        if(mCallback != null)
        {
            mCallback.onTimePicked(hour, minute);
        }
    }
}
