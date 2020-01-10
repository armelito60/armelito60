import java.lang.Exception;

public class EmptyDeckException extends Throwable {

	EmptyDeckException(String message) {

		System.out.println(message);
	}
}
