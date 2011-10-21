package editeurDessin.v1;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class EditeurListener implements MouseMotionListener, MouseListener {

	private ZoneDessin editeur_;
	
	
	public EditeurListener(ZoneDessin ed){
		editeur_ = ed;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		editeur_.addComponent(new Rectangle(e));		
//		System.out.println("Pression souris sur : "+coo_);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		System.out.println("Relache souris sur : "+coo_);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		editeur_.getComponent().setSizer((int)e.getX(), (int)e.getY());
//		System.out.println(coo_);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
