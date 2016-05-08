package mx.edu.utng.franciscojs.pdfgrafics;

import android.app.Activity;
import android.os.Bundle;

import com.androidplot.xy.CatmullRomInterpolator;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.PointLabelFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

import java.util.Arrays;

import mx.edu.utng.franciscojs.DatabaseHelperPoints;
import mx.edu.utng.franciscojs.R;


/**
 * A simple XYPlot
 */
public class GrapicsActivity extends Activity
{
    DatabaseHelperPoints helper = new DatabaseHelperPoints(this);
    private XYPlot plot;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grafica_activity);

        // initialize our XYPlot reference:
        plot = (XYPlot) findViewById(R.id.plot);


        int res= helper.traerResult(1);
        int resII= helper.traerResult(2);
        int resIII= helper.traerResult(3);
        int resIV= helper.traerResult(4);
        int resV= helper.traerResult(5);


        Number[] series1Numbers = {res,resII,resIII,resIV,resV};
        XYSeries series1 = new SimpleXYSeries(Arrays.asList(series1Numbers),
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Avances de JPA java");

        LineAndPointFormatter series1Format = new LineAndPointFormatter();
        series1Format.setPointLabelFormatter(new PointLabelFormatter());
        series1Format.configure(getApplicationContext(),
                R.xml.line_point_formatter_with_labels);

        series1Format.setInterpolationParams(
                new CatmullRomInterpolator.Params(4, CatmullRomInterpolator.Type.Centripetal));

        plot.addSeries(series1, series1Format);
        plot.setTicksPerRangeLabel(3);
        plot.getGraphWidget().setDomainLabelOrientation(-45);
    }
}