package principal;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectOutputStreamAppendeable extends ObjectOutputStream{

	public ObjectOutputStreamAppendeable(OutputStream out) throws IOException {
		super(out);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void writeStreamHeader() throws IOException {
		// reseteamos el flujo y no escribo cabecera.
		reset();
	}

}
