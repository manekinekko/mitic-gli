package editeurDessin.v2.factory;

import editeurDessin.v2.shape.Shape;
import editeurDessin.v2.shape.Triangle;

public class FactoryTriangle implements FactoryShape {

	@Override
	public Shape createShape() {
		return new Triangle();
	}

}
