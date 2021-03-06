package com.jagex;

public class MapFunction extends DoublyNode {
    public static ReferenceCache<Sprite> spriteCache = new ReferenceCache<>(256);
    public static MapFunction[] mapFunctions;
    static ReferenceTable spriteTable;
    public final int index;
    public String aString2091;
    public int anInt217;
    public int anInt236;
    public String[] aStringArray2095 = new String[5];
    public String aString2094;
    public Class166 aClass166_2092;
    public int spriteId = -1;
    public Class167 aClass167_2096;
    public int anInt214 = 0;
    int anInt919 = Integer.MAX_VALUE;
    int[] anIntArray315;
    int anInt221 = -1;
    int anInt230 = Integer.MIN_VALUE;
    int anInt235 = Integer.MAX_VALUE;
    int anInt222 = Integer.MIN_VALUE;
    int[] anIntArray1082;
    byte[] aByteArray2090;

    MapFunction(int index) {
        aClass167_2096 = Class167.aClass167_2029;
        aClass166_2092 = Class166.aClass166_2024;
        anInt236 = -1;
        this.index = index;
    }

    void decode(Buffer var1, int var2) {
        if (var2 == 1) {
            spriteId = var1.readSmart32();
        } else if (var2 == 2) {
            anInt221 = var1.readSmart32();
        } else if (var2 == 3) {
            aString2091 = var1.method819();
        } else if (var2 == 4) {
            anInt217 = var1.method868();
        } else if (var2 == 5) {
            var1.method868();
        } else if (var2 == 6) {
            anInt214 = var1.readUnsignedByte();
        } else {
            int var3;
            if (var2 == 7) {
                var3 = var1.readUnsignedByte();
                if ((var3 & 1) == 0) {
                }

                if ((var3 & 2) == 2) {
                }
            } else if (var2 == 8) {
                var1.readUnsignedByte();
            } else if (var2 >= 10 && var2 <= 14) {
                aStringArray2095[var2 - 10] = var1.method819();
            } else if (var2 == 15) {
                var3 = var1.readUnsignedByte();
                anIntArray315 = new int[var3 * 2];

                int var4;
                for (var4 = 0; var4 < var3 * 2; ++var4) {
                    anIntArray315[var4] = var1.readShort();
                }

                var1.readInt();
                var4 = var1.readUnsignedByte();
                anIntArray1082 = new int[var4];

                int var5;
                for (var5 = 0; var5 < anIntArray1082.length; ++var5) {
                    anIntArray1082[var5] = var1.readInt();
                }

                aByteArray2090 = new byte[var3];

                for (var5 = 0; var5 < var3; ++var5) {
                    aByteArray2090[var5] = var1.method870();
                }
            } else if (var2 != 16) {
                if (var2 == 17) {
                    aString2094 = var1.method819();
                } else if (var2 == 18) {
                    var1.readSmart32();
                } else if (var2 == 19) {
                    anInt236 = var1.readUnsignedShort();
                } else if (var2 == 21) {
                    var1.readInt();
                } else if (var2 == 22) {
                    var1.readInt();
                } else if (var2 == 23) {
                    var1.readUnsignedByte();
                    var1.readUnsignedByte();
                    var1.readUnsignedByte();
                } else if (var2 == 24) {
                    var1.readShort();
                    var1.readShort();
                } else if (var2 == 25) {
                    var1.readSmart32();
                } else if (var2 == 28) {
                    var1.readUnsignedByte();
                } else if (var2 == 29) {
                    aClass167_2096 = (Class167) EnumOrdinal.getByOrdinal(Class167.method354(), var1.readUnsignedByte());
                } else if (var2 == 30) {
                    Class166[] var6 = new Class166[]{Class166.aClass166_2024, Class166.aClass166_2023, Class166.aClass166_2022};
                    aClass166_2092 = (Class166) EnumOrdinal.getByOrdinal(var6, var1.readUnsignedByte());
                }
            }
        }

    }

    void method935() {
        if (anIntArray315 != null) {
            for (int var1 = 0; var1 < anIntArray315.length; var1 += 2) {
                if (anIntArray315[var1] < anInt919) {
                    anInt919 = anIntArray315[var1];
                } else if (anIntArray315[var1] > anInt230) {
                    anInt230 = anIntArray315[var1];
                }

                if (anIntArray315[var1 + 1] < anInt235) {
                    anInt235 = anIntArray315[var1 + 1];
                } else if (anIntArray315[var1 + 1] > anInt222) {
                    anInt222 = anIntArray315[var1 + 1];
                }
            }
        }

    }

    public int method1118() {
        return index;
    }

    void decode(Buffer var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }
            decode(var1, var2);
        }
    }

    Sprite getSprite(int id) {
        if (id < 0) {
            return null;
        }
        Sprite var2 = spriteCache.get((long) id);
        if (var2 != null) {
            return var2;
        }
        var2 = Class176.method1188(spriteTable, id, 0);
        if (var2 != null) {
            spriteCache.put(var2, (long) id);
        }

        return var2;
    }

    public Sprite getSprite(boolean var1) {
        int id = spriteId;
        return getSprite(id);
    }
}
