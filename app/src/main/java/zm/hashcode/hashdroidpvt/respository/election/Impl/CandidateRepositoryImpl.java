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
import zm.hashcode.hashdroidpvt.domain.election.Candidate;
import zm.hashcode.hashdroidpvt.respository.election.CandidateRepository;


/**
 * Created by hashcode on 2016/04/16.
 */
public class CandidateRepositoryImpl extends SQLiteOpenHelper implements CandidateRepository {
    public static final String TABLE_NAME = "candidate";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CANDIDATEID = "candidateId";
    public static final String COLUMN_FIRSTNAME = "firstname";
    public static final String COLUMN_LASTNAME = "lastName";
    public static final String COLUMN_CANDIDATEIMAGE = "candidateImage";
    public static final String COLUMN_SYMBOLIMAGE = "symbolImage";
    public static final String COLUMN_ELECTIONTYPEID = "electionTypeId";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CANDIDATEID + " TEXT UNIQUE NOT NULL , "
            + COLUMN_FIRSTNAME + " TEXT NOT NULL , "
            + COLUMN_LASTNAME + " TEXT NOT NULL , "
            + COLUMN_CANDIDATEIMAGE + " BLOB , "
            + COLUMN_SYMBOLIMAGE + " BLOB , "
            + COLUMN_ELECTIONTYPEID + " TEXT NOT NULL );";


    public CandidateRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Candidate findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_CANDIDATEID,
                        COLUMN_FIRSTNAME,
                        COLUMN_LASTNAME,
                        COLUMN_CANDIDATEIMAGE,
                        COLUMN_SYMBOLIMAGE,
                        COLUMN_ELECTIONTYPEID},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Candidate candidate = new Candidate.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .symbolImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_SYMBOLIMAGE)))
                    .firstname(cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME)))
                    .lastName(cursor.getString(cursor.getColumnIndex(COLUMN_LASTNAME)))
                    .candidateImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_CANDIDATEIMAGE)))
                    .candidateId(cursor.getString(cursor.getColumnIndex(COLUMN_CANDIDATEID)))
                    .electionTypeId(cursor.getString(cursor.getColumnIndex(COLUMN_ELECTIONTYPEID)))
                    .build();

            return candidate;
        } else {
            return null;
        }
    }

    @Override
    public Candidate save(Candidate entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_CANDIDATEID, entity.getCandidateId());
        values.put(COLUMN_FIRSTNAME, entity.getFirstname());
        values.put(COLUMN_LASTNAME, entity.getLastName());
        values.put(COLUMN_CANDIDATEIMAGE, entity.getCandidateImage());
        values.put(COLUMN_SYMBOLIMAGE, entity.getSymbolImage());
        values.put(COLUMN_ELECTIONTYPEID, entity.getElectionTypeId());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Candidate insertedEntity = new Candidate.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Candidate update(Candidate entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_CANDIDATEID, entity.getCandidateId());
        values.put(COLUMN_FIRSTNAME, entity.getFirstname());
        values.put(COLUMN_LASTNAME, entity.getLastName());
        values.put(COLUMN_CANDIDATEIMAGE, entity.getCandidateImage());
        values.put(COLUMN_SYMBOLIMAGE, entity.getSymbolImage());
        values.put(COLUMN_ELECTIONTYPEID, entity.getElectionTypeId());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Candidate delete(Candidate entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Candidate> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Candidate> candidates = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Candidate candidate = new Candidate.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .symbolImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_SYMBOLIMAGE)))
                        .firstname(cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME)))
                        .lastName(cursor.getString(cursor.getColumnIndex(COLUMN_LASTNAME)))
                        .candidateImage(cursor.getBlob(cursor.getColumnIndex(COLUMN_CANDIDATEIMAGE)))
                        .candidateId(cursor.getString(cursor.getColumnIndex(COLUMN_CANDIDATEID)))
                        .electionTypeId(cursor.getString(cursor.getColumnIndex(COLUMN_ELECTIONTYPEID)))
                        .build();
                candidates.add(candidate);
            } while (cursor.moveToNext());
        }
        return candidates;
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
