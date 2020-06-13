package IO;
import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {

    private OutputStream out;

    public MyCompressorOutputStream(OutputStream out) {
        this.out = out;
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        String num = "";
        for(int i=0; i < 24; i++){
            out.write(b[i]);
        }
        int cols = (int)b[4]+(int)b[5]+(int)b[6]+(int)b[7]+512;
        int colNum =cols;
        int theNum;
        int i=24;
        while(i<b.length) {

            if(num.length()<8 && num.length()<colNum){
                num += ((Byte)b[i]).toString();
            }
            if((i==b.length-1 || num.length()==8 || num.length()==colNum)){

                theNum = Integer.parseInt(num,2);
                colNum=colNum-num.length();
                out.write(theNum);
                num = "";

            }

            if(colNum<=0)
                colNum=cols;
            i++;
        }

    }
}
