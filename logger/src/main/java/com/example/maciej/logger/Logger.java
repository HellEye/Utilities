package com.example.maciej.logger;

import android.util.Log;

/**
 * Created by Maciej on 05.05.2018.
 */

public class Logger {
	private static String localAnnotation="";
	public static void startLog(){
		String className= new Exception().getStackTrace()[1].getClassName();
		localAnnotation = className.substring(0,className.indexOf(".", 12));
	}
	private static String getPosition(Throwable th) {
		StackTraceElement ste = th.getStackTrace()[1];
		return "(" + ste.getFileName() + ":" + ste.getLineNumber() + ")";
	}
	
	private static String getIndent(Throwable th) {
		StringBuilder out = new StringBuilder();
		String[] stack = new String[th.getStackTrace().length];
		for (int i = 0; i < stack.length; i++)
			stack[i] = th.getStackTrace()[i].toString();
		int stackSize = 0;
		for (String aStack : stack)
			if (aStack.contains(localAnnotation) && !aStack.contains("access$")) stackSize++;
		for (int i = 0; i < stackSize - 1; i++)
			out.append("  ");
		return out.toString();
	}
	
	public static void d(String tag, String message) {
		Log.d("myApp"+String.format("%15s", tag), String.format("%-80s %s", getIndent(new Exception()) + message, getPosition(new Exception())));
	}//debug
	
	public static void v(String tag, String message) {
		Log.v("myApp"+String.format("%15s", tag), String.format("%-80s %s", getIndent(new Exception()) + message, getPosition(new Exception())));
	}//verbose
	
	public static void e(String tag, String message) {
		Log.e("myApp"+String.format("%15s", tag), String.format("%-80s %s", getIndent(new Exception()) + message, getPosition(new Exception())));
	}//error
	
	public static void i(String tag, String message) {
		Log.i("myApp"+String.format("%15s", tag), String.format("%-80s %s", getIndent(new Exception()) + message, getPosition(new Exception())));
	}//info
	
	public static void w(String tag, String message) {
		Log.w("myApp"+String.format("%15s", tag), String.format("%-80s %s", getIndent(new Exception()) + message, getPosition(new Exception())));
	}//warning
	
	public static void wtf(String tag, String message) {
		Log.wtf("myApp"+String.format("%15s", tag), String.format("%-80s %s", getIndent(new Exception()) + message, getPosition(new Exception())));
	}//What a Terrible Failure
	
	public static void d(String tag, String message, Throwable th) {
		Log.d("myApp"+String.format("%15s", tag), String.format("%-80s %s", getIndent(new Exception()) + message, getPosition(new Exception())), th);
	}//debug
	
	public static void v(String tag, String message, Throwable th) {
		Log.v("myApp"+String.format("%15s", tag), String.format("%-80s %s", getIndent(new Exception()) + message, getPosition(new Exception())), th);
	}//verbose
	
	public static void e(String tag, String message, Throwable th) {
		Log.e("myApp"+String.format("%15s", tag), String.format("%-80s %s", getIndent(new Exception()) + message, getPosition(new Exception())), th);
	}//error
	
	public static void i(String tag, String message, Throwable th) {
		Log.i("myApp"+String.format("%15s", tag), String.format("%-80s %s", getIndent(new Exception()) + message, getPosition(new Exception())), th);
	}//info
	
	public static void w(String tag, String message, Throwable th) {
		Log.w("myApp"+String.format("%15s", tag), String.format("%-80s %s", getIndent(new Exception()) + message, getPosition(new Exception())), th);
	}//warning
	
	public static void wtf(String tag, String message, Throwable th) {
		Log.wtf("myApp"+String.format("%15s", tag), String.format("%-80s %s", getIndent(new Exception()) + message, getPosition(new Exception())), th);
	}//What a Terrible Failure
}
