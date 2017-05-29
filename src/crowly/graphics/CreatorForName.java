package crowly.graphics;
import java.lang.reflect.Method;

public class CreatorForName extends AbstractCreator
{

	@Override
	public IGraphic create(int pType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IGraphic createForName(String pType) 
	{
		Class classe;
		Object object = null;
		Method createGraphic;

		try {
			classe = Class.forName("crowly.graphics."+pType);
			try {			
				object = classe.newInstance();
				try {
					createGraphic = classe.getMethod("Graficar", null);
				}
				catch(NoSuchMethodException e) {
					System.out.println("Error al acceder al m�todo. "+ e);
				}
			}
			catch(IllegalAccessException e) {
				System.out.println("Error al instanciar el m�todo. "+e);
			}
			catch(InstantiationException e) {
				System.out.println("No se ha encontrado la clase. "+e);
			}
		}catch(ClassNotFoundException e) {
			System.out.println("Error al instanciar el objecto. "+e);
		}
		return (IGraphic) object;			
	}
}
