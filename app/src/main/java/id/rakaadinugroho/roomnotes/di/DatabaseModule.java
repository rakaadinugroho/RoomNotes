package id.rakaadinugroho.roomnotes.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import id.rakaadinugroho.roomnotes.database.ApplicationDatabase;

/**
 * Created by Raka on 1/13/18.
 */
@Module
public class DatabaseModule {
    @Provides
    @Singleton
    public ApplicationDatabase provideApplicationDatabase(Application application){
        return Room.databaseBuilder(application.getApplicationContext(), ApplicationDatabase.class, "mynotes").build();
    }
}
