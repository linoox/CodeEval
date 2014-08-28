import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.nio.ByteOrder;




public class Main {

    static void checkEndianness() {

        if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN)) {
            System.out.print("BigEndian");
        } else {
            System.out.print("LittleEndian");
        }

    }   


	public static void main (String[] args) {

        checkEndianness();

	}
}

