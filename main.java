import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class main {
    private static long sVN=1315;
    private static long sSTM=1111;
    private static long sRANDU=1111;


    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("crypto.txt"));

        for (int j = 0; j < 1000; j++) {
            String str = Long.toString(vonNeuman(sVN));
            writer.write(str+"\n");
        }
        /*
        for (int j = 0; j < 1000; j++) {

            String str = Long.toString(STM(sSTM));
            writer.write(str+"\n");
        }
        for (int j = 0; j < 1000; j++) {
            String str = Long.toString(RANDU(sRANDU));
            writer.write(str+"\n");
        }
        */
        writer.close();
    }

    private static long vonNeuman(long seed){
        seed = ((int) Math.pow(seed, 2));
        String stringSeed = Long.toString(seed);
        while (stringSeed.length() > 4) {
            stringSeed = stringSeed.substring(1, stringSeed.length() - 1);
        }
        sVN = Long.parseLong(stringSeed);
        return sVN;
    }

    private static long STM(long seed){
        int a = 16807;
        int b = 0;
        int m = ((int) Math.pow(2, 31));
        sSTM = (a * seed + b) % m;
        return sSTM;
    }

    private static long RANDU(long seed){
        int a = 65539;
        int b = 0;
        int m = ((int) Math.pow(2, 31))-1;
        sRANDU = (a * seed + b) % m;
        return sRANDU;
    }
}