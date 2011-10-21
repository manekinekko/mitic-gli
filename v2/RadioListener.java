package editeurDessin.v2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import editeurDessin.v2.factory.FactoryShape;

public class RadioListener implements ActionListener, ChangeListener {
	
	private FactoryShape shape_;

	public RadioListener(FactoryShape shape){
		this.shape_ = shape;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		Canvas.registerShape(shape_);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Canvas.registerShape(shape_);
	}

}
