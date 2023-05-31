package com.woorisiren.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Console {

    private static final BufferedReader br;
    private static final BufferedWriter bw;

    static {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static String read() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void print(String s) {
        try {
            bw.write(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void println(String s) {
        try {
            bw.write(s);
            bw.write('\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
