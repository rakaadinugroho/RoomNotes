package id.rakaadinugroho.roomnotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;
import java.util.Random;

import id.rakaadinugroho.roomnotes.database.ApplicationDatabase;
import id.rakaadinugroho.roomnotes.entities.Note;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    ApplicationDatabase applicationDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        applicationDatabase = ApplicationDatabase.getApplicationDatabase(getApplication());

        // Generate Data
        Random random   = new Random(100);
        int data    = random.nextInt();
        applicationDatabase.noteDao().insertNote(new Note("Simple Title " + data, "Description " + data));

        List<Note> notes    = applicationDatabase.noteDao().getNotes();
        for (Note note : notes) {
            Log.d(TAG, "my data: " + note.id + " / " + note.titleNote + " desc " + note.titleDesc );
        }
    }
}
