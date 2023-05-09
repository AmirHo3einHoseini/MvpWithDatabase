package com.example.mvpwithdatabase.presenter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mvpwithdatabase.MainActivity;
import com.example.mvpwithdatabase.model.IModel;
import com.example.mvpwithdatabase.model.User;
import com.example.mvpwithdatabase.view.DatabaseOpenHelper;
import com.example.mvpwithdatabase.view.IView;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.List;

public class Presenter {

    private IView view;
    private User user = new User();
    private SQLiteDatabase database;

    public Presenter(IView view) {
        this.view = view;
        database = new DatabaseOpenHelper(((MainActivity) view)).getWritableDatabase();
    }


    public void setUserName(String name) {
        user.setName(name);
    }

    public void setUserLastName(String lastName) {
        user.setLastName(lastName);
    }

    public void getLastUserId() {
        String query = "SELECT  last_insert_rowid()";
        Cursor cursor = this.database.rawQuery(query, null);
        int lastUserId = cursor.getCount() > 1 ? cursor.getInt(0) + 1 : 1;
        user.setId(lastUserId);
    }

    public void insertUser() {
        List<User> users = new ArrayList<>();
        getLastUserId();
        String q = "SELECT * FROM user";
        String query = "INSERT INTO user(Id,Name,LastName) VALUES ( " + user.getId() + ",'" + user.getName() + "'," + "'" + user.getLastName() + "'" + ")";
        Cursor cursor = this.database.rawQuery(query, null);

    }


}
