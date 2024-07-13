package com.mridasoft.learning.io;

import java.io.*;
import static java.lang.System.out;

public class BufferMark1 {

    public static final String LINE = "Line 1\nLine 2\nLine 3\nLine 4\n";

    public static void main(String[] args) {

        try (BufferedReader in = new BufferedReader(new StringReader(LINE))) {

            // first check if this Reader support mark operation
            if (in.markSupported()) {

                out.println(in.readLine());
                in.mark(0);                     // mark 'Line 2'
                out.println(in.readLine());
                out.println(in.readLine());
                in.reset();                     // reset 'Line 2'
                out.println(in.readLine());
                in.reset();                     // reset 'Line 2'
                out.println(in.readLine());
                in.mark(0);                     // mark 'Line 3'
                out.println(in.readLine());
                in.reset();                     // reset 'Line 3'
                out.println(in.readLine());
                out.println(in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}