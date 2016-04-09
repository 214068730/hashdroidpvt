package zm.hashcode.hashdroidpvt.respository.settings.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;

import zm.hashcode.hashdroidpvt.conf.databases.DBConstants;
import zm.hashcode.hashdroidpvt.domain.settings.Settings;
import zm.hashcode.hashdroidpvt.respository.settings.SettingsRespository;

/**
 * Created by hashcode on 2016/04/09.
 */
public class SettingsRespositoryImpl extends SQLiteOpenHelper implements SettingsRespository {
    public static final String TABLE_SETTINGS = "settings";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CODE = "code";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "passwd";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_SETTINGS + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CODE + " TEXT UNIQUE NOT NULL , "
            + COLUMN_USERNAME + " TEXT UNIQUE NOT NULL , "
            + COLUMN_PASSWORD + " TEXT NOT NULL );";


    public SettingsRespositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Settings findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_SETTINGS,
                new String[]{
                        COLUMN_ID,
                        COLUMN_CODE,
                        COLUMN_USERNAME,
                        COLUMN_PASSWORD},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Settings settings = new Settings.Builder()
                    .id(cursor.getLong(0))
                    .code(cursor.getString(1))
                    .username(cursor.getString(2))
                    .password(cursor.getString(3))
                    .build();

            return settings;
        } else {
            return null;
        }
    }

    @Override
    public Settings save(Settings entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_CODE, entity.getCode());
        values.put(COLUMN_USERNAME, entity.getUsername());
        values.put(COLUMN_PASSWORD, entity.getPassword());
        long id = db.insertOrThrow(TABLE_SETTINGS, null, values);
        Settings insertedEntity = new Settings.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Settings update(Settings entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_CODE, entity.getCode());
        values.put(COLUMN_USERNAME, entity.getUsername());
        values.put(COLUMN_PASSWORD, entity.getPassword());
        db.update(
                TABLE_SETTINGS,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Settings delete(Settings entity) {
        open();
        db.delete(
                TABLE_SETTINGS,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Settings> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectAll = " SELECT * FROM " + TABLE_SETTINGS;
        Set<Settings> settings = new HashSet<>();
        open();
        Cursor cursor = db.rawQuery(selectAll, null);
        if (cursor.moveToFirst()) {
            do {
                final Settings setting = new Settings.Builder()
                        .id(cursor.getLong(0))
                        .code(cursor.getString(1))
                        .username(cursor.getString(2))
                        .password(cursor.getString(3))
                        .build();
                settings.add(setting);
            } while (cursor.moveToNext());
        }

        return settings;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SETTINGS);
        onCreate(db);

    }
}
