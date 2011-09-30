package editeurDessin.v2.factory;

import editeurDessin.v2.shape.Circle;
import editeurDessin.v2.shape.Shape;

public class FactoryCircle implements FactoryShape  {

	private boolean isFilled_;
	
	@Override
	public Shape createShape() {
		return new Circle(isFilled_);
	}
	
	public void setFill(boolean isFilled){
		isFilled_ = isFilled;
	}

}
