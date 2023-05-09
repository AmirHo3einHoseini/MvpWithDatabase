package com.example.mvpwithdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.mvpwithdatabase.databinding.ActivityMainBinding;
import com.example.mvpwithdatabase.model.User;
import com.example.mvpwithdatabase.presenter.Presenter;
import com.example.mvpwithdatabase.view.DatabaseOpenHelper;
import com.example.mvpwithdatabase.view.IView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {
    private Presenter presenter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SQLiteDatabase sqLiteDatabase = new DatabaseOpenHelper(this).getWritableDatabase();
        presenter = new Presenter(this);
        binding.edtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.btnSave.setOnClickListener(view -> {
            presenter.setUserName(binding.edtName.getText().toString());
            presenter.setUserLastName(binding.edtLastName.getText().toString());
            presenter.insertUser();

        });
    }

    @Override
    public void getUserList(List<User> userList) {

    }
}