package single;

public class single {
	private single() {}
	private static class inner{
		private static single s = new single();
	}
	
	public static single getinstance() {
		return inner.s;
	}
}
