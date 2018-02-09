package com.swarawan.greendao;

import android.app.Application;

import com.swarawan.greendao.database.DaoMaster;
import com.swarawan.greendao.database.DaoMaster.DevOpenHelper;
import com.swarawan.greendao.database.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by rioswarawan on 2/9/18.
 */

public class App extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DevOpenHelper helper = new DevOpenHelper(this, "db-books");
        Database database = helper.getWritableDb();
        DaoMaster master = new DaoMaster(database);
        daoSession = master.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
