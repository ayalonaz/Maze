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
        boolean isSameNumZero = true;
        boolean isSameNumOne = true;
        int countZeros = 100;
        int countOnes = 100;
        int k=24;
        while(i<b.length) {

//            if (k < b.length && b[k] == (byte) 0 && (countZeros >= 16  || countOnes >=16)) {
//                isSameNumZero = true;
//                k++;
//                countZeros = 1;
//                countOnes = 0;
//                while (isSameNumZero && k < b.length){
//                    if(b[k] == (byte)0)
//                        countZeros++;
//                    else
//                        isSameNumZero = false;
//                    k++;
//                }
//            }
//            else if(k < b.length && b[k] == (byte) 1 && (countZeros >= 16 || countOnes >=16)){
//                isSameNumOne = true;
//                k++;
//                countOnes = 1;
//                countZeros = 0;
//                while(isSameNumOne){
//                    if(b[k] == (byte) 1 && k < b.length)
//                        countOnes++;
//                    else
//                        isSameNumOne = false;
//                    k++;
//                }
//            }
//            if(countOnes >= 16 || countZeros >= 16){
//                i=k;
//                if(countOnes>=16){
////                    byte [] ones= new byte[2];
////                    ones[0] = (byte)-11;
////                    ones[1] = (byte)countOnes;
////                    out.write(ones,0,2);
//////                    System.out.println("one: "+countOnes);
//////                    System.out.println("com: -11" );
//                    String one="-11";
//                    out.write(Integer.parseInt(one));
//                    out.flush();
//                    out.write(countOnes);
//                    out.flush();
//
//                }
//                else{
//
//                    String zero="-10";
//                    out.write(Integer.parseInt(zero));
//                    out.flush();
//                    out.write(countZeros);
//                    out.flush();
//                }
//                continue;
//            }
            if(num.length()<8 && num.length()<colNum){
                num += ((Byte)b[i]).toString();
            }
            if((i==b.length-1 || num.length()==8 || num.length()==colNum)){

                theNum = Integer.parseInt(num,2);
                colNum=colNum-num.length();
                countOnes=100;
                countZeros=100;
                out.write(theNum);
                num = "";
//                if(k<i)
//                    k=i+1;
            }

            if(colNum<=0)
                colNum=cols;
            i++;
        }

    }
}
