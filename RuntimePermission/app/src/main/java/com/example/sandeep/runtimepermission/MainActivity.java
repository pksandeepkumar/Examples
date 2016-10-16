package com.example.sandeep.runtimepermission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_WRITE_STORAGE = 112;

    private static final int STORAGE_PERMISSION_RC = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setPermissionForReadPermission() {
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_RC);
            return;
        }
    }


    public void reqPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_WRITE_STORAGE
                        );

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

    public void createFolder( View view) {

        setPermissionForReadPermission();

        reqPermission();

        boolean hasPermission = (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
        if (!hasPermission) {
            Toast.makeText(this, "Has not permission!!!", Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_WRITE_STORAGE);
        } else {
            Toast.makeText(this, "Has not permission!!!", Toast.LENGTH_LONG).show();
            return;
        }


        String path = Environment.getExternalStorageDirectory().getPath()
                + File.separator + "RunTimePermissionFolder";
        makeDir(path);

        if( chekFolderExist(path)) {
            Toast.makeText(this, "Folder created!!!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Something went wrong!!!", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case REQUEST_WRITE_STORAGE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    //reload my activity with permission granted or use the features what required the permission
                } else
                {
                    Toast.makeText(this, "The app was not allowed to write to your storage. Hence, it cannot function properly. Please consider granting it this permission", Toast.LENGTH_LONG).show();
                }
            }

            case STORAGE_PERMISSION_RC: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //permission granted  start reading
                } else {
                    Toast.makeText(this, "No permission to read external storage.", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }


    public void makeDir( String folderPath) {
        File eDinetteDir =  new File(folderPath);
        if (null != eDinetteDir) {
            if (!eDinetteDir.exists()) {
                eDinetteDir.mkdir();
            }
        }
    }

    public boolean chekFolderExist( String folderPath ) {
        File dir =  new File(folderPath);
        if (null != dir) {
            if (!dir.exists()) {
                return true;
            }
        }
        return false;
    }

    public void deleteDir( String folderPath) {
        File eDinetteDir =  new File(folderPath);
        if (null != eDinetteDir) {
            if (!eDinetteDir.exists()) {
                eDinetteDir.delete();
            }
        }
    }
}
