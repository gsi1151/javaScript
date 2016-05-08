package mx.edu.utng.franciscojs;

import android.app.Activity;
import android.os.Bundle;


import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;


public class Calculadora extends Activity {
    public String sign="";
    public  String total="";
    public Double tempDouble,tempDouble2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        Button button0=(Button)findViewById(R.id.btn_cero);
        Button button1=(Button)findViewById(R.id.btn_one);
        Button button2=(Button)findViewById(R.id.btn_dos);
        Button button3=(Button)findViewById(R.id.btn_tres);
        Button button4=(Button)findViewById(R.id.btn_cuatro);
        Button button5=(Button)findViewById(R.id.btn_cinco);
        Button button6=(Button)findViewById(R.id.btn_seis);
        Button button7=(Button)findViewById(R.id.btn_siete);
        Button button8=(Button)findViewById(R.id.btn_ocho);
        Button button9=(Button)findViewById(R.id.btn_nueve);

        Button buttonBorrarC=(Button)findViewById(R.id.btn_limpiar);
        Button buttonIgualE=(Button)findViewById(R.id.btn_igual);

        Button buttonSumarA=(Button)findViewById(R.id.btn_mas);
        Button buttonRestarS=(Button)findViewById(R.id.btn_resta);
        Button buttonMultiplicarM=(Button)findViewById(R.id.btn_mult);
        Button buttonDividirD=(Button)findViewById(R.id.btn_div);




        button0.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView output = (TextView)findViewById(R.id.editText);
                        output.append("0");
                    }
                }
        );

        // Button 1
        button1.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView output = (TextView)findViewById(R.id.editText);
                        output.append("1");
                    }
                }
        );

        // Button 2
        button2.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView output = (TextView)findViewById(R.id.editText);
                        output.append("2");
                    }
                }
        );

        // Button 3
        button3.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView output = (TextView)findViewById(R.id.editText);
                        output.append("3");
                    }
                }
        );

        // Button 4
        button4.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView output = (TextView)findViewById(R.id.editText);
                        output.append("4");
                    }
                }
        );

        // Button 5
        button5.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView output = (TextView)findViewById(R.id.editText);
                        output.append("5");
                    }
                }
        );

        // Button 6
        button6.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView output = (TextView)findViewById(R.id.editText);
                        output.append("6");
                    }
                }
        );

        // Button 7
        button7.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView output = (TextView)findViewById(R.id.editText);
                        output.append("7");
                    }
                }
        );

        // Button 8
        button8.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView output = (TextView)findViewById(R.id.editText);
                        output.append("8");
                    }
                }
        );

        // Button 9
        button9.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView output = (TextView)findViewById(R.id.editText);
                        output.append("9");
                    }
                }
        );

        // Button Addition
        buttonSumarA.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView output = (TextView)findViewById(R.id.editText);
                        tempDouble = Double.parseDouble(output.getText().toString());
                        output.setText("");
                        sign = "+";
                    }
                }
        );

        // Button Subtraction
        buttonRestarS.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView output = (TextView)findViewById(R.id.editText);
                        tempDouble = Double.parseDouble(output.getText().toString());
                        output.setText("");
                        sign = "-";
                    }
                }
        );

        // Button Multiplication
        buttonMultiplicarM.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView output = (TextView)findViewById(R.id.editText);
                        tempDouble = Double.parseDouble(output.getText().toString());
                        output.setText("");
                        sign = "*";
                    }
                }
        );

        // Button Division
        buttonDividirD.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView output = (TextView)findViewById(R.id.editText);
                        tempDouble = Double.parseDouble(output.getText().toString());
                        output.setText("");
                        sign = "/";
                    }
                }
        );

        // Button Clear
        buttonBorrarC.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView output = (TextView)findViewById(R.id.editText);
                        output.setText("");
                    }
                }
        );

        // Button Equals
        buttonIgualE.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView output = (TextView)findViewById(R.id.editText);
                        tempDouble2 = Double.parseDouble(output.getText().toString());

                        if (sign == "+")
                        {
                            output.setText(Double.toString(tempDouble + tempDouble2));
                        }
                        else if (sign == "-")
                        {
                            output.setText(Double.toString(tempDouble - tempDouble2));
                        }
                        else if (sign == "*")
                        {
                            output.setText(Double.toString(tempDouble * tempDouble2));
                        }
                        else if (sign == "/")
                        {
                            if (tempDouble2 == 0)
                            {
                                // Cannot Divide By Zero
                                output.setText("Cannot Divide By Zero!");
                            }
                            else
                            {
                                output.setText(Double.toString(tempDouble / tempDouble2));
                            }
                        }

                        // Reset the Sign variable
                        sign = "";
                    }
                }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}




