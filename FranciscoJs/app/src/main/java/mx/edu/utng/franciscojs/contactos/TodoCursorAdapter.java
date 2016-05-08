package mx.edu.utng.franciscojs.contactos;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import mx.edu.utng.franciscojs.R;


/**
 * Created by A on 01/05/2015.
 */


    public class TodoCursorAdapter extends CursorAdapter {
        @TargetApi(Build.VERSION_CODES.HONEYCOMB)
        public TodoCursorAdapter(Context context, Cursor cursor) {
           super(context,cursor,0);

        }

        // The newView method is used to inflate a new view and return it,
        // you don't bind any data to the view at this point.
        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return LayoutInflater.from(context).inflate(R.layout.activity_buscar_contacto, parent, false);
        }

        // The bindView method is used to bind all data to a given view
        // such as setting the text on a TextView.
        @Override
        public void bindView(View view, Context context, Cursor cursor) {

            TextView idtxt = (TextView) view.findViewById(R.id.id_txt);
            TextView apellidotxt = (TextView) view.findViewById(R.id.apellido_txt);
            TextView nombretxt = (TextView) view.findViewById(R.id.nombre_txt);
           TextView edadtxt=(TextView)view.findViewById(R.id.edad_txt);
            TextView telefonotxt=(TextView)view.findViewById(R.id.tel_txt);
           TextView emailtxt=(TextView)view.findViewById(R.id.email_txt);
         TextView sangretxt = (TextView)view.findViewById(R.id.sangre_txt);


            // Extraccion de las propiedades del cursor


           int txtid = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
           String txtapellido = cursor.getString(cursor.getColumnIndexOrThrow("apellido"));
           String txtnombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
          String txtemail = cursor.getString(cursor.getColumnIndexOrThrow("email"));
          String txtsangre = cursor.getString(cursor.getColumnIndexOrThrow("tiposangre"));
            String txtedad = cursor.getString(cursor.getColumnIndexOrThrow("edad"));
            String txttelefono = cursor.getString(cursor.getColumnIndexOrThrow("telefono"));

           idtxt.setText(String.valueOf(txtid));
           apellidotxt.setText(txtapellido);
           nombretxt.setText(txtnombre);
           emailtxt.setText(txtemail);
           sangretxt.setText(txtsangre);
            edadtxt.setText(txtedad);
            telefonotxt.setText(txttelefono);

        }
    }



