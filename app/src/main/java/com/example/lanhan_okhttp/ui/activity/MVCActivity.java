package com.example.lanhan_okhttp.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lanhan_okhttp.R;
import com.example.lanhan_okhttp.utils.HttpUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MVCActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mUserName;
    private EditText mPassword;
    private Button mLogin;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mUserName = (EditText) findViewById(R.id.mUserName);
        mPassword = (EditText) findViewById(R.id.mPassword);
        mLogin = (Button) findViewById(R.id.mLogin);

        mLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mLogin:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String mUserNameString = mUserName.getText().toString().trim();
        if (TextUtils.isEmpty(mUserNameString)) {
            Toast.makeText(this, "mUserNameString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String mPasswordString = mPassword.getText().toString().trim();
        if (TextUtils.isEmpty(mPasswordString)) {
            Toast.makeText(this, "mPasswordString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something

        HttpUtils.getInstance().sendGet("?mUserNameString=" + mUserNameString + "&mPasswordString=" + mPasswordString, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mLogin.setText("登录失败！");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       mLogin.setText("登录成功！");
                   }
               });
            }
        });

    }
}
