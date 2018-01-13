package id.rakaadinugroho.roomnotes.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import id.rakaadinugroho.roomnotes.dao.NoteDao;
import id.rakaadinugroho.roomnotes.entities.Note;

/**
 * Created by Raka on 1/13/18.
 */
@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class ApplicationDatabase extends RoomDatabase {
    private static ApplicationDatabase instance;

    public abstract NoteDao noteDao();

    // Create database
    public static ApplicationDatabase getApplicationDatabase(Context context){
        if (instance == null){
            instance    = Room.databaseBuilder(context, ApplicationDatabase.class, "mynotes")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
