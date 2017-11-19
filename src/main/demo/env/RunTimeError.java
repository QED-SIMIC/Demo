package demo.env;

public class RunTimeError {

	// ------------------------------------------------------------------------
	public static void raiseStatic(String errorMessage) {

		throw new RuntimeException(errorMessage);
	}

	// ------------------------------------------------------------------------
	public static String exceptionToString(Exception ex) {

		StringBuffer sb = new StringBuffer();
		String exceptionImage = null;

		sb.append("\n +++");
		sb.append(ex.getMessage());
		sb.append("\n");
		sb.append("\n ---\n");

		for (StackTraceElement frame : ex.getStackTrace()) {
			sb.append(frame.toString());
			sb.append("\n");
		}
		exceptionImage = sb.toString();

		return exceptionImage;
	}

	// ------------------------------------------------------------------------
	public static String throwableToString(Throwable ex) {

		StringBuffer sb = new StringBuffer();
		String exceptionImage = null;

		sb.append("\n +++");
		sb.append(ex.getMessage());
		sb.append("\n");
		sb.append("\n ---\n");

		for (StackTraceElement frame : ex.getStackTrace()) {
			sb.append(frame.toString());
			sb.append("\n");
		}
		exceptionImage = sb.toString();

		return exceptionImage;
	}

}
