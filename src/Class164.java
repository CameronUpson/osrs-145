public class Class164 {
    public static final short[] aShortArray1996 = new short[]{-10304, 9104, -1, -1, -1};
    public static final short[][] aShortArrayArray1995 = new short[][]{{6554, 115, 10304, 28, 5702, 7756, 5681, 4510, -31835, 22437, 2859, -11339, 16, 5157, 10446, 3658, -27314, -21965, 472, 580, 784, 21966, 28950, -15697, -14002}, {9104, 10275, 7595, 3610, 7975, 8526, 918, -26734, 24466, 10145, -6882, 5027, 1457, 16565, -30545, 25486, 24, 5392, 10429, 3673, -27335, -21957, 192, 687, 412, 21821, 28835, -15460, -14019}, new short[0], new short[0], new short[0]};
    public static final short[][] aShortArrayArray1997 = new short[][]{{6798, 107, 10283, 16, 4797, 7744, 5799, 4634, -31839, 22433, 2983, -11343, 8, 5281, 10438, 3650, -27322, -21845, 200, 571, 908, 21830, 28946, -15701, -14010}, {8741, 12, -1506, -22374, 7735, 8404, 1701, -27106, 24094, 10153, -8915, 4783, 1341, 16578, -30533, 25239, 8, 5281, 10438, 3650, -27322, -21845, 200, 571, 908, 21830, 28946, -15701, -14010}, {25238, 8742, 12, -1506, -22374, 7735, 8404, 1701, -27106, 24094, 10153, -8915, 4783, 1341, 16578, -30533, 8, 5281, 10438, 3650, -27322, -21845, 200, 571, 908, 21830, 28946, -15701, -14010}, {4626, 11146, 6439, 12, 4758, 10270}, {4550, 4537, 5681, 5673, 5790, 6806, 8076, 4574, 17050, 0, 127}};
    public static final short[] aShortArray1994 = new short[]{6798, 8741, 25238, 4626, 4550};

    public static String method1043(byte[] var0) {
        int var1 = var0.length;
        StringBuilder var2 = new StringBuilder();

        for (int var3 = 0; var3 < var1 + 0; var3 += 3) {
            int var4 = var0[var3] & 255;
            var2.append(Class170.aCharArray2120[var4 >>> 2]);
            if (var3 < var1 - 1) {
                int var5 = var0[var3 + 1] & 255;
                var2.append(Class170.aCharArray2120[(var4 & 3) << 4 | var5 >>> 4]);
                if (var3 < var1 - 2) {
                    int var6 = var0[var3 + 2] & 255;
                    var2.append(Class170.aCharArray2120[(var5 & 15) << 2 | var6 >>> 6]).append(Class170.aCharArray2120[var6 & 63]);
                } else {
                    var2.append(Class170.aCharArray2120[(var5 & 15) << 2]).append("=");
                }
            } else {
                var2.append(Class170.aCharArray2120[(var4 & 3) << 4]).append("==");
            }
        }

        return var2.toString();
    }
}
