package crowly.graphics;

public class CreatorID extends AbstractCreator
{

	@Override
	public IGraphic create(int pType) {
		IGraphic graphic;
		
		switch(pType)
		{
		case BAR_ID:
			graphic = new Bar();
			break;
		case LINE_ID:
			graphic = new Line();
			break;
		case SCATTER_ID:
			graphic = new Scatter();
			break;
		default:
			graphic = null;
		}
		return graphic;
	}

	@Override
	public IGraphic createForName(String pType) {
		// TODO Auto-generated method stub
		return null;
	}

}
