package com.googlehackathon.conflict;

import android.app.Application;

import com.parse.Parse;

public class ConflictReportingApplication extends Application {
    
    @Override
    public void onCreate() {
        Parse.initialize(this, "ESPTaSiJjemtu0XZXgaKvwBnIiMiD60N6OyyY7BQ", "uY3uQ3tHVPLzKS5iFtRc4JiYQu9AKx2zNc8XeAZk");
    }
}
