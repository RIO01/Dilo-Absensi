package com.ooi.diloabsensi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ooi.diloabsensi.IntentIntegrator;
import com.ooi.diloabsensi.IntentResult;

public class Absensi extends AppCompatActivity implements View.OnClickListener {


    private Button scanButton;
    private TextView contentTextView, formatTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absensi);

        scanButton = (Button) findViewById(R.id.scan_btn);
        contentTextView = (TextView) findViewById(R.id.scan_content_tv);
        formatTextView = (TextView) findViewById(R.id.scan_format_tv);

        scanButton.setOnClickListener(this);

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult scanningIntentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (scanningIntentResult != null) {
            String scanContent = scanningIntentResult.getContents();
            String scanFormat = scanningIntentResult.getFormatName();

            if(scanContent != null && scanFormat != null) {
                contentTextView.setText("Content : " + scanContent);
                formatTextView.setText("Format : " + scanFormat);
            } else {
                Toast.makeText(getApplicationContext(), "No scan data received!", Toast.LENGTH_SHORT).show();
            }
        } else {

            Toast.makeText(getApplicationContext(), "No scan data received!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.scan_btn:
                IntentIntegrator scanIntegrator = new IntentIntegrator(this);
                scanIntegrator.initiateScan();
                break;
        }
    }
}