package com.googlehackathon.conflict;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.google.common.io.Files;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ProgressCallback;
import com.parse.SaveCallback;

public class ConflictReportingActivity extends Activity {
    protected static final int REQ_TAKE_PHOTO = 0x10;

    protected File mCameraFile;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        AQuery aq = new AQuery(this);

        aq.id(R.id.btn_takephoto).clicked(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent camIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                mCameraFile = getCameraFile();
                camIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mCameraFile));
                camIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                startActivityForResult(camIntent, REQ_TAKE_PHOTO);
            }
        });
    }

    private File getCameraFile() {
        File dir = new File(Environment.getExternalStorageDirectory() + "/Android/data/com.googlehackathon.conflict/temp");
        dir.mkdirs();

        File file = new File(dir, String.format("camera_tmp_%d.jpg", System.currentTimeMillis()));

        return file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQ_TAKE_PHOTO && mCameraFile != null && mCameraFile.length() > 0) {

            try {
                final ParseFile imgFile = new ParseFile(mCameraFile.getName(), Files.toByteArray(mCameraFile));

                imgFile.saveInBackground(new SaveCallback() {

                    @Override
                    public void done(ParseException e) {
                        Toast.makeText(ConflictReportingActivity.this, "finished uploading : "+ imgFile.getUrl(), Toast.LENGTH_LONG).show();
                    
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(imgFile.getUrl()));
                        startActivity(browserIntent);
                    }

                }, new ProgressCallback() {

                    @Override
                    public void done(Integer pctDone) {
                        Log.v(getClass().getSimpleName(), "percent done: " + pctDone);
                    }

                });

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }
    }
}