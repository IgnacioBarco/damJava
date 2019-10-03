
/**
 *
 * @author Nacho
 */
public class programa10 {

    public static void main(String[] args) {
        
        System.out.println("------- Conversiones entre enteros y coma flotante -------");
        float x = 4.5f;
        float y = 3.0f;
        int i = 2;
        int j = (int)(i*x);      
        double dx = 2.0d;
        double dz = (double)(dx*y);
        System.out.println("Producto de int por float: j= i*x = "+j);
        System.out.println("Producto de float por double: dz = dx * y = "+dz);
           
        System.out.println("\n------- Operaciones con byte -------");
        byte bx = 5;
        byte by = 2;
        byte bz = (byte)(bx - by);
        System.out.println("byte: "+bx+" - "+by+" = "+bz );
        bx = -128;
        by = 1;
        bz = (byte)(-bx - by); 
        System.out.println("byte "+bx+" - "+by+" = "+bz);
        System.out.println("(int)(-128 - 1) = "+(int)(bx-by));
        
        System.out.println("\n------- Operaciones con short -------");
        short sx = 5;
        short sy = 2;
        short sz = (short)(sx - sy);
        System.out.println("short: 10 - 1 = "+sz);
        sx = 32767;
        sy = 1;
        sz = (short)(sx + sy);
        System.out.println("short 32767 + 1 = "+sz);
        
        System.out.println("\n------- Operaciones con char -------");
        char cx = '\u000F';
        char cy = '\u0001';
        int z = cx-cy;
        System.out.println("char: - = "+z);
        z = cx-1;
        System.out.println("char(0x000F) - 1 = "+z);
        cx = '\uFFFF';
        z= cx;
        System.out.println("(int)() = "+z);
        sx = (short)cx;
        System.out.println("(short)() = "+sx);
        sx= -32768;
        cx = (char)sx;
        z = sx;
        System.out.println("-32768 short-char-int = "+z);
        sx = -1;
        cx = (char)sx;
        z=cx;
        System.out.println("-1 short-char-int = "+z);
    }
    
}
