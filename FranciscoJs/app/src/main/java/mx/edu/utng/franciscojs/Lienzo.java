package mx.edu.utng.franciscojs;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by master on 30/04/2016.
 */
public class Lienzo extends View {
    public Lienzo(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRGB(0,255,0);
        int ancho = canvas.getWidth();
        int alto = canvas.getHeight();

        Bitmap bmp= BitmapFactory.decodeResource(getResources(),
                R.drawable.utngdos);
        canvas.drawBitmap(bmp,(ancho-250)/2,(alto-200)/2,null);


    }
}
