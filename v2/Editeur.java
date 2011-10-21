package editeurDessin.v2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import editeurDessin.v2.factory.FactoryCircle;
import editeurDessin.v2.factory.FactoryRectangle;
import editeurDessin.v2.factory.FactoryTriangle;

public class Editeur extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JLabel feedBackZone_;
	private static JPanel colorFillBorderArea_;
	private static JPanel colorFillArea_;
	
	public Editeur() {
		super();
		add(new Canvas(this));
		setPreferredSize(new Dimension(1000, 500));
		setBackground(Color.black);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 2));
		addMenu();

		setVisible(true);
		pack();
	}

	private JLabel buildFeedBackArea_() {
		JLabel fb = new JLabel();
		return fb;
	}

	public void showFeedBack(String message){
		feedBackZone_.setText(message);
	}
	
	public void addMenu() {

		JPanel menu = new JPanel();
		menu.setLayout(new GridLayout(6, 1));
		menu.setBackground(Color.white);

		feedBackZone_ = buildFeedBackArea_();
		menu.add(feedBackZone_);
		menu.add(buildShapesMenu_());
		menu.add(buildFillingMenu_());
		menu.add(buildColorWidget_());

		add(menu);

	}

	private JPanel buildFillingMenu_() {
		JLabel fillLabel = new JLabel("Choose the filling option: ");
		fillLabel.setLocation(0, 10);

		JRadioButton fillYes = new JRadioButton("Fill Shape");
		fillYes.addActionListener(new RadioListener(new FactoryCircle()));
		setDefaults_(fillYes);

		JRadioButton fillNo = new JRadioButton("Don't fill");
		fillNo.addActionListener(new RadioListener(new FactoryTriangle()));

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(fillYes);
		buttonGroup.add(fillNo);

		JPanel fillPanel = new JPanel();
		fillPanel.add(fillYes);
		fillPanel.add(fillNo);

		JPanel fillMenu = new JPanel();
		fillMenu.add(fillLabel);
		fillMenu.add(fillPanel);

		return fillMenu;
	}

	private JPanel buildShapesMenu_() {

		JLabel shapeLabel = new JLabel("Choose your shape: ");
		shapeLabel.setLocation(0, 10);

		JRadioButton radioRectangle = new JRadioButton("Rectangles");
		radioRectangle.addActionListener(new RadioListener(
				new FactoryRectangle()));
		setDefaults_(radioRectangle);

		JRadioButton radioCircle = new JRadioButton("Circles");
		radioCircle.addActionListener(new RadioListener(new FactoryCircle()));

		JRadioButton radioTriangle = new JRadioButton("Triangles");
		radioTriangle
				.addActionListener(new RadioListener(new FactoryTriangle()));

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radioRectangle);
		buttonGroup.add(radioCircle);
		buttonGroup.add(radioTriangle);

		JPanel radioPanel = new JPanel();
		radioPanel.add(radioTriangle);
		radioPanel.add(radioCircle);
		radioPanel.add(radioRectangle);

		JPanel shapeMenu = new JPanel();
		shapeMenu.add(shapeLabel);
		shapeMenu.add(radioPanel);

		return shapeMenu;
	}

	private JPanel buildColorWidget_() {

		JPanel colorMenu = new JPanel();
		colorMenu.add(buildFillColorChooser_());
		colorMenu.add(buildBorderColorChooser_());

		return colorMenu;
	}

	private JPanel buildFillColorChooser_() {

		final String label = "Choose Shape Fill Color";

		colorFillArea_ = new JPanel();
		colorFillArea_.setSize(100, 100);
		colorFillArea_.setBackground(Color.black);
		
		JButton colorButton = new JButton(label);
		colorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showColorChooser(label);
			}
		});

		JPanel colorPanel = new JPanel();
		colorPanel.setLayout(new GridLayout(2, 1));
		colorPanel.add(colorButton);
		colorPanel.add(colorFillArea_);
		return colorPanel;
	}

	private JPanel buildBorderColorChooser_() {

		final String label = "Choose Shape Border Color";

		colorFillBorderArea_ = new JPanel();
		colorFillBorderArea_.setSize(100, 100);
		colorFillBorderArea_.setBackground(Color.black);

		JButton colorButton = new JButton(label);
		colorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showColorChooser(label);
			}
		});

		JPanel colorPanel = new JPanel();
		colorPanel.setLayout(new GridLayout(2, 1));
		colorPanel.add(colorButton);
		colorPanel.add(colorFillBorderArea_);
		return colorPanel;
	}

	private void showColorChooser(String label) {
		Color bgColor = JColorChooser.showDialog(this, label, getBackground());
		
		if (bgColor != null) {
			Editeur.getFillColorArea().setBackground(bgColor);
			Canvas.getSelectedShape().setBackground(bgColor);
		}
	}

	public static JPanel getFillColorArea() {
		return colorFillArea_;
	}
	
	public static JPanel getFillBorderArea() {
		return colorFillBorderArea_;
	}

	private void setDefaults_(Component comp) {
		ActionEvent ae = new ActionEvent((Object) comp, ActionEvent.ACTION_PERFORMED, "");
		comp.dispatchEvent(ae);
		((AbstractButton) comp).doClick();
	}

	public static void main(String[] args) {
		new Editeur();
	}

}
