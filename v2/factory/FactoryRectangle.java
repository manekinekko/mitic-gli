package editeurDessin.v2.factory;

import editeurDessin.v2.shape.Rectangle;
import editeurDessin.v2.shape.Shape;

public class FactoryRectangle implements FactoryShape {

	@Override
	public Shape createShape() {
		return new Rectangle();
	}

}
