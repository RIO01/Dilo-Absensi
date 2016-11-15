package com.ooi.diloabsensi;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.icu.util.Calendar;
import android.net.Uri;
import android.nfc.Tag;
import android.provider.MediaStore;
import android.support.annotation.BinderThread;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InputAcara extends AppCompatActivity implements TimePickerFragment.OnTimePickedListener,DatePickerFragment.OnDatePickedListener {

    @Bind(R.id.input_tanggal)
    EditText tanggal;
    @Bind(R.id.input_waktu)
    EditText waktu;
    @Bind(R.id.edit_acara)
    EditText acara;
    @Bind(R.id.edit_deskripsi)
    EditText deskripsi;
    @Bind(R.id.ivgambar)
    ImageView gambar;
    @Bind(R.id.uploadgbrbtn)
    Button upload;

    @Override
    public void onTimePicked(int hours, int min) {
        waktu.setText(String.valueOf(hours) + " : " + String.valueOf(min));
    }

    @Override
    public void onDatePicked(int year,int month,int day){
        tanggal.setText(String.valueOf(year) + "-" + String.valueOf(month)+  "-" + String.valueOf(day));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_acara);

        ButterKnife.bind(this);

        waktu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timepick = new TimePickerFragment();
                timepick.show(getSupportFragmentManager(), "timepick");
            }
        });

        tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datepick = new DatePickerFragment();
                datepick.show(getSupportFragmentManager(), "datepick");
            }
        });

            upload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent, "Select Picture"),1);
                }
            });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                gambar.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



