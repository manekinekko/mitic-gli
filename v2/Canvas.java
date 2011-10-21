package editeurDessin.v2;

import java.awt.Color;

import javax.swing.JPanel;

import editeurDessin.v2.factory.FactoryShape;
import editeurDessin.v2.shape.Shape;

public class Canvas extends JPanel {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private Coordonnees coo_;

	// cache the last component
	private static JPanel selectedShape_;

	private Editeur editor_;

	private static FactoryShape shapeFactory_;

	public Canvas(Editeur editor) {
		
		setBackground(Color.yellow);
		addMouseListener(new CanvasListener(this));
		addMouseMotionListener(new CanvasListener(this));
		coo_ = new Coordonnees();
		editor_ = editor;
		setLayout(null);
	}

	public static void registerShape(FactoryShape shape){
		shapeFactory_ = shape;
	}
	
	public void addComponent() {
		try {
			selectedShape_ = shapeFactory_.createShape();
			add(selectedShape_);
			repaint();
		}
		catch(Exception ex){
			editor_.showFeedBack("Please select a shape");
		}
	}

	public static Shape getSelectedShape() {
		return (Shape) selectedShape_;
	}
	
	public static void setSelectedShape(Shape shape){
		selectedShape_ = shape;
	}

}
