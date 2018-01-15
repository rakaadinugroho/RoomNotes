package id.rakaadinugroho.roomnotes.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import id.rakaadinugroho.roomnotes.entities.Note;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Raka on 1/13/18.
 */
@Dao
public interface NoteDao {
    @Query("SELECT * FROM note")
    Single<List<Note>> getNotes();

    @Insert
    void insertNote(Note... note);

    @Update
    void updateNote(Note... note);

    @Delete
    void deleteNote(Note... note);
}
