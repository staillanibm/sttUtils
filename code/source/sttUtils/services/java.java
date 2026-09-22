package sttUtils.services;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
// --- <<IS-END-IMPORTS>> ---

public final class java

{
	// ---( internal utility methods )---

	final static java _instance = new java();

	static java _newInstance() { return new java(); }

	static java _cast(Object o) { return (java)o; }

	// ---( server methods )---




	public static final void readFileAsString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(readFileAsString)>> ---
		// @sigtype java 3.5
		// [i] field:0:required location
		// [o] field:0:required content
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	location = IDataUtil.getString( pipelineCursor, "location" );
		pipelineCursor.destroy();
		
		String content = null;
		try
		{
			content = new String( Files.readAllBytes( Paths.get( location ) ), StandardCharsets.UTF_8 );
		}
		catch ( IOException e )
		{
			throw new ServiceException( e );
		}
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "content", content );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}
}

