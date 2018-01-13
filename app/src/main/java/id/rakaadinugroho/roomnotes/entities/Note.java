package id.rakaadinugroho.roomnotes.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Raka on 1/13/18.
 */
@Entity(tableName = "note")
public class Note {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "title_note")
    public String titleNote;

    @ColumnInfo(name = "title_desc")
    public String titleDesc;

    public Note(String titleNote, String titleDesc) {
        this.titleNote = titleNote;
        this.titleDesc = titleDesc;
    }
}
