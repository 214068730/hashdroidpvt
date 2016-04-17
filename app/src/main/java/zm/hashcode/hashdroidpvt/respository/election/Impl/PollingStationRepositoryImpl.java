package zm.hashcode.hashdroidpvt.respository.election.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import zm.hashcode.hashdroidpvt.conf.databases.DBConstants;
import zm.hashcode.hashdroidpvt.domain.election.PollingStation;
import zm.hashcode.hashdroidpvt.respository.election.PollingStationRepository;


/**
 * Created by hashcode on 2016/04/16.
 */
public class PollingStationRepositoryImpl extends SQLiteOpenHelper implements PollingStationRepository {
    public static final String TABLE_NAME = "station";
    private SQLiteDatabase db;

    private Long id;
    private String name;
    private int voters;
    private Map<String, String> location;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_VOTERS = "voters";
    public static final String COLUMN_LOCATION = "location";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT  NOT NULL , "
            + COLUMN_VOTERS + " INTEGER  NOT NULL , "
            + COLUMN_LOCATION + " TEXT NOT NULL );";


    public PollingStationRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public PollingStation findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_NAME,
                        COLUMN_VOTERS,
                        COLUMN_LOCATION},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final PollingStation PollingStation = new PollingStation.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .voters(cursor.getInt(cursor.getColumnIndex(COLUMN_VOTERS)))
                    .location(getLocation(cursor.getString(cursor.getColumnIndex(COLUMN_LOCATION))))
                    .build();

            return PollingStation;
        } else {
            return null;
        }
    }

    private Map<String, String> getLocation(String value) {
        final Gson gson = new Gson();
        Type typeOfHashMap = new TypeToken<Map<String, String>>() {
        }.getType();
        return gson.fromJson(value, typeOfHashMap);
    }

    @Override
    public PollingStation save(PollingStation entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_LOCATION, getStringLocation(entity.getLocation()));
        values.put(COLUMN_NAME, entity.getName());
        values.put(COLUMN_VOTERS, entity.getVoters());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        PollingStation insertedEntity = new PollingStation.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    private String getStringLocation(Map<String, String> location) {
        Gson gson = new Gson();
        return gson.toJson(location);
    }

    @Override
    public PollingStation update(PollingStation entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_LOCATION, getStringLocation(entity.getLocation()));
        values.put(COLUMN_NAME, entity.getName());
        values.put(COLUMN_VOTERS, entity.getVoters());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public PollingStation delete(PollingStation entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<PollingStation> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<PollingStation> pollingStations = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                final PollingStation pollingStation = new PollingStation.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .voters(cursor.getInt(cursor.getColumnIndex(COLUMN_VOTERS)))
                        .location(getLocation(cursor.getString(cursor.getColumnIndex(COLUMN_LOCATION))))
                        .build();
                pollingStations.add(pollingStation);
            } while (cursor.moveToNext());
        }
        return pollingStations;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME, null, null);
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
