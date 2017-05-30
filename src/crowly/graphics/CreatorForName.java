package crowly.graphics;
import java.lang.reflect.Method;

public class CreatorForName extends AbstractCreator
{
	@SuppressWarnings("unchecked")
	@Override
	public IGraphic createForName(String pType) 
	{
		Class classe;
		Object object = null;
		Method createGraphic;

		try 
		{
			classe = Class.forName("crowly.graphics."+pType);
			try 
			{			
				object = classe.newInstance();
				try 
				{
					createGraphic = classe.getMethod("Graficar", null);
				}
				catch(NoSuchMethodException e) {
					System.out.println("Error al acceder al metodo. "+ e);
				}
			}
			catch(IllegalAccessException e) {
				System.out.println("Error al instanciar el metodo. "+e);
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
