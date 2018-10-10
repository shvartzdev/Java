package ru.wirbel.lab01.myapp;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Application {

public static final String DEFAULT_CONSOLE_ENCODING = "UTF-8";
public static final String CONSOLE_ENCODING_PROPERTY = "consoleEncoding";
private static void setConsoleEncoding() {
// чтение системной переменной
String consoleEncoding = System.getProperty(CONSOLE_ENCODING_PROPERTY,
DEFAULT_CONSOLE_ENCODING);
try {
// установить кодировку стандартной консоли вывода
System.setOut(new PrintStream(
System.out,
true,
consoleEncoding)
);
} catch (UnsupportedEncodingException ex) {
System.err.println(
"Unsupported encoding set for console: " + consoleEncoding
);
}
}


	public static void main(String[] args) {
		setConsoleEncoding();
		System.out.println("Русский текст");
	}
}