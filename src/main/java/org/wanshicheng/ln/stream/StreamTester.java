package org.wanshicheng.ln.stream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Timothy Wan
 * @date 2016/11/17 14:54
 */
public class StreamTester {
    public static void generaterCharacters(OutputStream out) {
        int firstPrintableCharater = 33;
        int numberOfPrintableCharacters = 94;
        int numberOfCharactersPerLine = 72;
        int start = firstPrintableCharater;
        while (true) {
            for (int i=start; i<start+numberOfPrintableCharacters; i++) {
                try {
                    out.write(((i - firstPrintableCharater) % numberOfCharactersPerLine) + firstPrintableCharater);
                    out.write('\r');
                    out.write('\n');
                    start = ((start + 1) - firstPrintableCharater) % numberOfPrintableCharacters + firstPrintableCharater;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        OutputStream out = new ByteArrayOutputStream();
        try {
            out.write(100);
        } catch (IOException e) {
            e.printStackTrace();
        }
        generaterCharacters(out);
    }


}
