package com.example.sasham.passwordkeeper;

import android.app.Application;

import com.example.sasham.passwordkeeper.model.DaoMaster;
import com.example.sasham.passwordkeeper.model.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Sasha M on 17.03.2018.
 */

public class App extends Application {

    private static final java.lang.String PASS_DB_NAME = "pass_db";
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper openHelper=new DaoMaster.DevOpenHelper(this,PASS_DB_NAME);
        Database database =openHelper.getWritableDb();
        daoSession=new DaoMaster(database).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
