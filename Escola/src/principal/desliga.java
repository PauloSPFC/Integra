package principal;

import java.io.IOException;

public class desliga {
	public static void main(String[] args) throws IOException {
		Runtime.getRuntime().exec("cmd /c shutdown -s -t 7200");
	}
}
