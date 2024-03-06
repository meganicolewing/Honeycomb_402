package sprint1;

public class IDSingleton {
	private int id;
	private static IDSingleton idSingle;
	private IDSingleton() {
		id = 0;
	}
	public static String getNextID() {
		if(idSingle==null) {
			idSingle = new IDSingleton();
		}
		return Integer.toString(idSingle.id++);
	}
}
