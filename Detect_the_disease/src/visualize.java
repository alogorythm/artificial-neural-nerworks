import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;

	public class visualize extends ApplicationFrame {

		static JFrame frame = new JFrame("visualization");
		JPanel showing  = new JPanel();
		TimeSeries visualizing;
		JFreeChart visualChart;
		ChartPanel Visual;
		
		public visualize(String title) {
			super(title);
			frame.setPreferredSize(new Dimension(1400,800));
			showing.setPreferredSize(new Dimension(700,800));
			frame.add(showing);
			
			visualizing = new TimeSeries("",Millisecond.class);
			final TimeSeriesCollection visualizeDataset = new TimeSeriesCollection(visualizing);
			visualChart = createChart(visualizeDataset);
		}
		private JFreeChart createChart(final XYDataset dataset){
		final JFreeChart result = ChartFactory.createTimeSeriesChart(
				"",
				"",
				"",
				dataset,
				true,
				true,
				true
				);
		final XYPlot plot = result.getXYPlot();

		plot.setBackgroundPaint(Color.white);
		
		plot.setDomainGridlinesVisible(false);
		plot.setRangeGridlinesVisible(false);
		plot.setBackgroundPaint(new Color(41,41,41));
		plot.getRenderer().setSeriesPaint(0, Color.white);
//		plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
//		plot.setRangeGridlinePaint(Color.LIGHT_GRAY);
		ValueAxis xaxis = plot.getDomainAxis();
//		xaxis.setLabelAngle( 90 * (Math.PI / 180.0) ); // time rotate
		xaxis.setAutoRange(true);
		xaxis.setLabel("Time");
		//Domain axis would show data of 60 seconds for a time
//		xaxis.setFixedAutoRange(60000.0);  // size
		xaxis.setVerticalTickLabels(false); // vertical or horizon
		//////////		//////////		//////////		//////////		//////////		//////////		//////////		//////////		//////////		//////////		//////////
		xaxis.setAxisLinePaint(Color.white);
		xaxis.setLabelPaint(Color.white);
		xaxis.setTickLabelPaint(Color.white);
		xaxis.setTickMarkPaint(Color.white);
		//////////		//////////		//////////		//////////		//////////		//////////		//////////		//////////		//////////		//////////		//////////
		ValueAxis yaxis = plot.getRangeAxis();
		yaxis.setLabel("Price");
//		yaxis.setRange(8380000.0, 9010000.0); // y축 범위
		yaxis.setAutoRange(true);
		//////////		//////////		//////////		//////////		//////////		//////////		//////////		//////////		//////////		//////////		//////////
		yaxis.setAxisLinePaint(Color.white);
		yaxis.setLabelPaint(Color.white);
		yaxis.setTickLabelPaint(Color.white);
		yaxis.setTickMarkPaint(Color.white);
		//////////		//////////		//////////		//////////		//////////		//////////		//////////		//////////		//////////		//////////		//////////
//		setSize(new Dimension(800,400));
		

		return result;
	}

}

