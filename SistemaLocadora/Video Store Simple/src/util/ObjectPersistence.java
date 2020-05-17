package util;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public final class ObjectPersistence {
	
	/**
	 * Stores a serialized object into a file.
	 * @param file path and file name. 
	 * @param object serialized object 
	 * @throws Exception exception during flushing process.
	 */
	public static void store(final String file, final Object object) throws IOException {
		try {
			final FileOutputStream objFileOS = new FileOutputStream(file);
			final ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
			objOS.writeObject(object);
			objOS.flush();
			objOS.close();
			objFileOS.close();
		} catch (final IOException exc) {
			throw new IOException(
					"Error occurred in the store method in persistence process. Error: "+
					exc.getMessage());
		}
	}

	/**
	 * Loads from a serialized object to an object instance.
	 * @param file path and file name to be retrieved. 
	 * @return an object instance. 
	 * @throws Exception exception during loading process.
	 */
	public static Object retrieve(final String file) throws IOException {
		Object objGeneral = null;
		try {
			final File objFile = new File(file);
			if (objFile.exists()) {
				final FileInputStream objFileIS = new FileInputStream(file);
				final ObjectInputStream objIS = new ObjectInputStream(objFileIS);
				objGeneral = objIS.readObject();
				objIS.close();
				objFileIS.close();
			}
		} catch (final IOException exc) {
			throw new IOException(
					"Error occurred in the retrieve method in persistence process. Error: "+
					exc.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return objGeneral;
	}
}
