package zystudio.mylib.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;

public class ImageUtil {

    public static void exportDrawableToSdCard(Drawable drawable) {
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        String externDirectory = Environment.getExternalStorageDirectory().toString();
        File outFile = new File(externDirectory, "demoImage" + System.currentTimeMillis() + ".png");
        Log.i("ertewu", "exportDrawableToSdCard occured:" + outFile.getPath());
        try {
            FileOutputStream outStream = new FileOutputStream(outFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream);
            outStream.flush();
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
