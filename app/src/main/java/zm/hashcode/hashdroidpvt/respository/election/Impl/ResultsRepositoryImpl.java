package zm.hashcode.hashdroidpvt.respository.election.Impl;

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
import zm.hashcode.hashdroidpvt.conf.util.AppUtil;
import zm.hashcode.hashdroidpvt.domain.election.Results;
import zm.hashcode.hashdroidpvt.respository.election.ResultsRepository;

/**
 * Created by hashcode on 2016/04/16.
 */
public class ResultsRepositoryImpl extends SQLiteOpenHelper implements ResultsRepository {
    public static final String TABLE_NAME = "results";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_RESULTS = "results";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_AGENT = "agent";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_IMAGE = "image";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_RESULTS + " TEXT  NOT NULL , "
            + COLUMN_LOCATION + " TEXT  NOT NULL , "
            + COLUMN_DATE + " DATE  NOT NULL , "
            + COLUMN_STATUS + " TEXT  NOT NULL , "
            + COLUMN_AGENT + " TEXT  NOT NULL , "
            + COLUMN_IMAGE + " BLOB );";


    public ResultsRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Results findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_RESULTS,
                        COLUMN_LOCATION,
                        COLUMN_DATE,
                        COLUMN_STATUS,
                        COLUMN_AGENT,
                        COLUMN_IMAGE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Results Results = new Results.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .results(AppUtil.getValue(cursor.getString(cursor.getColumnIndex(COLUMN_RESULTS))))
                    .agent(cursor.getString(cursor.getColumnIndex(COLUMN_AGENT)))
                    .date(AppUtil.getDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE))))
                    .image(cursor.getBlob(cursor.getColumnIndex(COLUMN_IMAGE)))
                    .location(cursor.getString(cursor.getColumnIndex(COLUMN_LOCATION)))
                    .statusx(cursor.getString(cursor.getColumnIndex(COLUMN_STATUS)))
                    .build();

            return Results;
        } else {
            return null;
        }
    }



    @Override
    public Results save(Results entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_AGENT, entity.getAgent());
        values.put(COLUMN_DATE, entity.getDate().toString());
        values.put(COLUMN_IMAGE, entity.getImage());
        values.put(COLUMN_LOCATION, entity.getLocation());
        values.put(COLUMN_RESULTS, AppUtil.getStringValue(entity.getResults()));
        values.put(COLUMN_STATUS, entity.getStatus());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Results insertedEntity = new Results.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Results update(Results entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_AGENT, entity.getAgent());
        values.put(COLUMN_DATE, entity.getDate().toString());
        values.put(COLUMN_IMAGE, entity.getImage());
        values.put(COLUMN_LOCATION, entity.getLocation());
        values.put(COLUMN_RESULTS, AppUtil.getStringValue(entity.getResults()));
        values.put(COLUMN_STATUS, entity.getStatus());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Results delete(Results entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Results> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Results> results = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Results result = new Results.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .results(AppUtil.getValue(cursor.getString(cursor.getColumnIndex(COLUMN_RESULTS))))
                        .agent(cursor.getString(cursor.getColumnIndex(COLUMN_AGENT)))
                        .date(AppUtil.getDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE))))
                        .image(cursor.getBlob(cursor.getColumnIndex(COLUMN_IMAGE)))
                        .location(cursor.getString(cursor.getColumnIndex(COLUMN_LOCATION)))
                        .statusx(cursor.getString(cursor.getColumnIndex(COLUMN_STATUS)))
                        .build();
                results.add(result);
            } while (cursor.moveToNext());
        }
        return results;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
