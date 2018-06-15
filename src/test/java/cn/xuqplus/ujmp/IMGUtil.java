package cn.xuqplus.ujmp;

public class IMGUtil {

    public static int getImageRgb(int i) {
        String argb = Integer.toHexString(i);//将十进制的颜色值转为十六进制
        //argb分别代表透明,红,绿,蓝 分别占16进制2位
        int r = Integer.parseInt(argb.substring(2, 4), 16);//后面参数为使用进制
        int g = Integer.parseInt(argb.substring(4, 6), 16);
        int b = Integer.parseInt(argb.substring(6, 8), 16);
        int result = ((r + g + b) / 3);
        return result;
    }

    public static int getGray(int arr[][], int x, int y, int w, int h) {
        int r = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                int i0 = i, j0 = j;
                if (i0 < 0) i0 = 0;
                if (i0 > w - 1) i0 = w - 1;
                if (j0 < 0) j0 = 0;
                if (j0 > h - 1) j0 = h - 1;
                r += arr[i0][j0];
            }
        }
        return r / 9;
    }
}
