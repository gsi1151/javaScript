package mx.edu.utng.franciscojs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class DibujarImage extends AppCompatActivity {
    LinearLayout lienzoLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
super.onCreate(savedInstanceState);
        setContentView(R.layout.canvas);
        lienzoLayout = (LinearLayout)findViewById(R.id.lienzoLayout);
        Lienzo fondo=new Lienzo(this);
        lienzoLayout.addView(fondo);

    }
}
