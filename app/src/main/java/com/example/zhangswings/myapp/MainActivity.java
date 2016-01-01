package com.example.zhangswings.myapp;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnDate;
    private int mYear;
    private int mMonth;
    private int mDay;
    private Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendar=Calendar.getInstance();
        mYear=calendar.get(Calendar.YEAR);
        mMonth=calendar.get(Calendar.MONTH);
        mDay=calendar.get(Calendar.DAY_OF_MONTH);
        btnDate= (Button) findViewById(R.id.btn_date);
        btnDate.setText(new StringBuilder().append(mYear).append("-")
                .append((mMonth + 1) < 10 ? "0"+ (mMonth + 1) : (mMonth + 1))
                .append("-")
                .append((mDay < 10) ? "0" + mDay : mDay) );
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        // TODO Auto-generated method stub
                        mYear = year;
                        mMonth = month;
                        mDay = day;
                        //更新EditText控件日期 小于10加0
                        btnDate.setText(new StringBuilder().append(mYear).append("-")
                                .append((mMonth + 1) < 10 ? "0" + (mMonth + 1) : (mMonth + 1))
                                .append("-")
                                .append((mDay < 10) ? "0" + mDay : mDay));
                        showToast(btnDate.getText().toString());
                    }

                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });
    }
    /**
     * 显示Toast消息
     *
     * @param msg
     */
    private Toast mToast;

    private void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }
}
