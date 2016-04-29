package zm.hashcode.hashdroidpvt.respository.person.Impl;

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
import zm.hashcode.hashdroidpvt.domain.person.Person;
import zm.hashcode.hashdroidpvt.respository.person.PersonRepository;


/**
 * Created by hashcode on 2016/04/16.
 */
public class PersonRepositoryImpl extends SQLiteOpenHelper implements PersonRepository {
    public static final String TABLE_NAME = "person";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FIRSTNAME = "firstName";
    public static final String COLUMN_EMAILADDRESS = "emailAddress";
    public static final String COLUMN_LASTNAME = "lastName";
    public static final String COLUMN_AUTHVALUE = "authvalue";
    public static final String COLUMN_ORGANISATION = "organisation";
    public static final String COLUMN_TOKEN = "token";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_FIRSTNAME + " TEXT  NOT NULL , "
            + COLUMN_EMAILADDRESS + " TEXT UNIQUE NOT NULL , "
            + COLUMN_LASTNAME + " TEXT  NOT NULL , "
            + COLUMN_AUTHVALUE + " TEXT NOT NULL,"
            + COLUMN_ORGANISATION + " TEXT NOT NULL,"
            + COLUMN_TOKEN + " TEXT NOT NULL  ) ";


    public PersonRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Person findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_FIRSTNAME,
                        COLUMN_EMAILADDRESS,
                        COLUMN_LASTNAME,
                        COLUMN_AUTHVALUE,
                        COLUMN_ORGANISATION,
                        COLUMN_TOKEN},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Person Person = new Person.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .authvalue(cursor.getString(cursor.getColumnIndex(COLUMN_AUTHVALUE)))
                    .emailAddress(cursor.getString(cursor.getColumnIndex(COLUMN_EMAILADDRESS)))
                    .firstName(cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME)))
                    .lastName(cursor.getString(cursor.getColumnIndex(COLUMN_LASTNAME)))
                    .organisation(cursor.getString(cursor.getColumnIndex(COLUMN_ORGANISATION)))
                    .token(cursor.getString(cursor.getColumnIndex(COLUMN_TOKEN)))
                    .build();
            return Person;
        } else {
            return null;
        }
    }

    @Override
    public Person save(Person entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_AUTHVALUE, entity.getAuthvalue());
        values.put(COLUMN_EMAILADDRESS, entity.getEmailAddress());
        values.put(COLUMN_FIRSTNAME, entity.getFirstName());
        values.put(COLUMN_LASTNAME, entity.getLastName());
        values.put(COLUMN_ORGANISATION, entity.getOrganisation());
        values.put(COLUMN_TOKEN, entity.getToken());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Person insertedEntity = new Person.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Person update(Person entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_AUTHVALUE, entity.getAuthvalue());
        values.put(COLUMN_EMAILADDRESS, entity.getEmailAddress());
        values.put(COLUMN_FIRSTNAME, entity.getFirstName());
        values.put(COLUMN_LASTNAME, entity.getLastName());
        values.put(COLUMN_ORGANISATION, entity.getOrganisation());
        values.put(COLUMN_TOKEN, entity.getToken());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Person delete(Person entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Person> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Person> Person = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                final Person setting = new Person.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .authvalue(cursor.getString(cursor.getColumnIndex(COLUMN_AUTHVALUE)))
                        .emailAddress(cursor.getString(cursor.getColumnIndex(COLUMN_EMAILADDRESS)))
                        .firstName(cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME)))
                        .lastName(cursor.getString(cursor.getColumnIndex(COLUMN_LASTNAME)))
                        .organisation(cursor.getString(cursor.getColumnIndex(COLUMN_ORGANISATION)))
                        .token(cursor.getString(cursor.getColumnIndex(COLUMN_TOKEN)))
                        .build();
                Person.add(setting);
            } while (cursor.moveToNext());
        }
        return Person;
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
