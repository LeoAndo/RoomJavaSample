package jp.ac.jec.cm0199.roomjavasample;

import android.util.Log;
import android.util.Pair;

public final class Logger {

    private Logger() {
    }

    public static void i(String msg) {
        final Pair<String, String> data = createMessage(msg);
        Log.i(data.first, data.second);
    }

    public static void v(String msg) {
        final Pair<String, String> data = createMessage(msg);
        Log.v(data.first, data.second);
    }

    public static void d(String msg) {
        final Pair<String, String> data = createMessage(msg);
        Log.d(data.first, data.second);
    }

    public static void w(String msg) {
        final Pair<String, String> data = createMessage(msg);
        Log.w(data.first, data.second);
    }

    public static void w(String msg, Throwable throwable) {
        final Pair<String, String> data = createMessage(msg);
        Log.w(data.first, data.second, throwable);
    }

    public static void e(String msg) {
        final Pair<String, String> data = createMessage(msg);
        Log.e(data.first, data.second);
    }

    public static void e(String msg, Throwable throwable) {
        final Pair<String, String> data = createMessage(msg);
        Log.e(data.first, data.second, throwable);
    }

    private static Pair<String, String> createMessage(String msg) {
        final StackTraceElement stack = Thread.currentThread().getStackTrace()[4];
        final String fullName = stack.getClassName();
        final String tag = fullName.substring(fullName.lastIndexOf(".") + 1);
        final String message = '<' + stack.getMethodName() + ":" + stack.getLineNumber() + "> " + msg;
        return new Pair<>(tag, message);
    }
}