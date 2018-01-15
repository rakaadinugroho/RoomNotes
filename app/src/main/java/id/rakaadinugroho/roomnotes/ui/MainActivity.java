package id.rakaadinugroho.roomnotes.ui;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import id.rakaadinugroho.roomnotes.R;
import id.rakaadinugroho.roomnotes.dao.NoteDao;
import id.rakaadinugroho.roomnotes.database.ApplicationDatabase;
import id.rakaadinugroho.roomnotes.entities.Note;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    ApplicationDatabase applicationDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Generate Data
        applicationDatabase = ApplicationDatabase.getApplicationDatabase(this);
        Random random   = new Random(100);
        int data    = random.nextInt();
        applicationDatabase.noteDao().insertNote(new Note("Simple Title " + data, "Description " + data));

        applicationDatabase.noteDao().getNotes()
                .subscribeOn(Schedulers.io())
                .subscribe(
                        notes -> loadMyData(notes),
                        throwable -> loadGagal(throwable)
                );
    }

    private void loadMyData(List<Note> notes) {
        for (Note note :
                notes) {
            Log.d(TAG, "loadMyData: " + note.id + " . " + note.titleDesc);
        }
    }

    private void loadGagal(Throwable t){
        Toast.makeText(this, "gagal", Toast.LENGTH_SHORT).show();
    }
}
