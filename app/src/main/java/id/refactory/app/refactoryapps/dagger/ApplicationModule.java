package id.refactory.app.refactoryapps.dagger;

import android.app.Application;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dhanialrizky on 28/11/17.
 */

@Module
public class ApplicationModule {
    private Application application;

    public ApplicationModule(Application application) {this.application = application;}

    @Provides @Singleton
    public Application provideApplication() {return application;}

}
