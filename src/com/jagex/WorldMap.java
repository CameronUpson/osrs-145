package com.jagex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class WorldMap {
    static final Class180 aClass180_2213;
    static final Class180 aClass180_2210;
    static final Class180 aClass180_2206;

    static {
        aClass180_2213 = Class180.aClass180_2147;
        aClass180_2210 = Class180.aClass180_2149;
        aClass180_2206 = Class180.aClass180_2151;
    }

    final int[] anIntArray2226 = new int[]{1008, 1009, 1010, 1011, 1012};
    int anInt2219 = -1;
    Class190 aClass190_2229;
    WorldMapTransportation aWorldMapTransportation_2211;
    ReferenceTable table;
    HashMap aHashMap2227;
    CompressedImage[] aCompressedImageArray2222;
    HashMap aHashMap2202;
    HashSet aHashSet2238 = new HashSet();
    WorldMapTransportation aWorldMapTransportation_2234;
    WorldMapTransportation aWorldMapTransportation_2231;
    Class7 aClass7_2217;
    float currentScale;
    int anInt2220;
    int anInt2203 = -1;
    int anInt2236 = -1;
    float defaultScale;
    HashSet aHashSet2205 = new HashSet();
    int anInt2232 = -1;
    int anInt2233 = -1;
    int anInt2235 = 3;
    int anInt2209 = 50;
    boolean aBoolean2207 = false;
    HashSet aHashSet2224 = null;
    int anInt2216 = -1;
    int anInt2218 = -1;
    int anInt2208 = -1;
    HashSet aHashSet2228 = new HashSet();
    HashSet aHashSet2223 = new HashSet();
    int anInt2212;
    HashSet aHashSet2201 = new HashSet();
    boolean aBoolean2237 = false;
    int anInt2214 = 0;
    List aList2230;
    Iterator anIterator2221;
    Font font_b12_full;

    public void method1288(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
        if (this.aClass190_2229.method1309()) {
            this.method1303();
            this.method1306();
            if (var3) {
                int var8 = (int) Math.ceil((double) ((float) var6 / this.defaultScale));
                int var9 = (int) Math.ceil((double) ((float) var7 / this.defaultScale));
                List var10 = this.aClass7_2217.method31(this.anInt2220 - var8 / 2 - 1, this.anInt2212 - var9 / 2 - 1, this.anInt2220 + var8 / 2 + 1, this.anInt2212 + var9 / 2 + 1, var4, var5, var6, var7, var1, var2);
                HashSet var11 = new HashSet();

                Iterator var12;
                Class24 var13;
                ScriptEvent var14;
                Class22 var15;
                for (var12 = var10.iterator(); var12.hasNext(); Class25.method174(var14)) {
                    var13 = (Class24) var12.next();
                    var11.add(var13);
                    var14 = new ScriptEvent();
                    var15 = new Class22(var13.anInt160, var13.aSceneOffset_162, var13.aSceneOffset_167);
                    var14.method270(new Object[]{var15, var1, var2});
                    if (this.aHashSet2238.contains(var13)) {
                        var14.method274(Class147.aClass147_1806);
                    } else {
                        var14.method274(Class147.aClass147_1815);
                    }
                }

                var12 = this.aHashSet2238.iterator();

                while (var12.hasNext()) {
                    var13 = (Class24) var12.next();
                    if (!var11.contains(var13)) {
                        var14 = new ScriptEvent();
                        var15 = new Class22(var13.anInt160, var13.aSceneOffset_162, var13.aSceneOffset_167);
                        var14.method270(new Object[]{var15, var1, var2});
                        var14.method274(Class147.aClass147_1807);
                        Class25.method174(var14);
                    }
                }

                this.aHashSet2238 = var11;
            }
        }
    }

    public void method1300(int var1, int var2, boolean var3) {
        if (this.anInt2203 == -1) {
            this.anInt2203 = var1;
        }

        if (this.anInt2219 == -1) {
            this.anInt2219 = var2;
        }

        int var4 = var1 - this.anInt2203;
        int var5 = var2 - this.anInt2219;
        this.anInt2203 = var1;
        this.anInt2219 = var2;
        if (var3 && !this.method1290()) {
            this.anInt2220 -= (int) ((float) var4 / this.currentScale);
            this.anInt2212 += (int) ((float) var5 / this.currentScale);
        }

    }

    void method1303() {
        if (this.defaultScale < this.currentScale) {
            this.defaultScale = Math.min(this.currentScale, this.defaultScale / 30.0F + this.defaultScale);
        }

        if (this.defaultScale > this.currentScale) {
            this.defaultScale = Math.max(this.currentScale, this.defaultScale - this.defaultScale / 30.0F);
        }

    }

    void method1306() {
        if (this.method1290()) {
            int var1 = this.anInt2208 - this.anInt2220;
            int var2 = this.anInt2236 - this.anInt2212;
            if (var1 != 0) {
                var1 /= Math.min(8, Math.abs(var1));
            }

            if (var2 != 0) {
                var2 /= Math.min(8, Math.abs(var2));
            }

            this.anInt2220 += var1;
            this.anInt2212 += var2;
            if (this.anInt2208 == this.anInt2220 && this.anInt2212 == this.anInt2236) {
                this.anInt2208 = -1;
                this.anInt2236 = -1;
            }

        }
    }

    public WorldMapTransportation method1286(int var1, int var2, int var3) {
        Iterator var4 = this.aHashMap2202.values().iterator();

        WorldMapTransportation var5;
        do {
            if (!var4.hasNext()) {
                return null;
            }

            var5 = (WorldMapTransportation) var4.next();
        } while (!var5.method65(var1, var2, var3));

        return var5;
    }

    public Class24 method1283() {
        if (this.anIterator2221 == null) {
            return null;
        }
        return !this.anIterator2221.hasNext() ? null : (Class24) this.anIterator2221.next();
    }

    public void method1297(int var1) {
        WorldMapTransportation var2 = this.method1276(var1);
        if (var2 != null) {
            this.method1289(var2);
        }

    }

    public WorldMapTransportation method1284() {
        return this.aWorldMapTransportation_2234;
    }

    void method1302(WorldMapTransportation var1) {
        this.aWorldMapTransportation_2234 = var1;
        this.aClass7_2217 = new Class7(this.aCompressedImageArray2222, this.aHashMap2227);
        this.aClass190_2229.method1307(this.aWorldMapTransportation_2234.getFileName());
    }

    void method1291(int var1, int var2, int var3) {
        if (this.aWorldMapTransportation_2234 != null) {
            int[] var4 = this.aWorldMapTransportation_2234.method81(var1, var2, var3);
            if (var4 == null) {
                var4 = this.aWorldMapTransportation_2234.method81(this.aWorldMapTransportation_2234.getFloorLevel(), this.aWorldMapTransportation_2234.getBaseX(), this.aWorldMapTransportation_2234.getBaseY());
            }

            this.anInt2220 = var4[0] - this.aWorldMapTransportation_2234.getMinX() * 64;
            this.anInt2212 = var4[1] - this.aWorldMapTransportation_2234.getMinY() * 64;
            this.anInt2208 = -1;
            this.anInt2236 = -1;
            this.defaultScale = this.method1285(this.aWorldMapTransportation_2234.getDefaultScale());
            this.currentScale = this.defaultScale;
            this.aList2230 = null;
            this.anIterator2221 = null;
            this.aClass7_2217.method32();
        }
    }

    public void method1298(int var1, int var2, int var3, int var4, int var5) {
        int[] var6 = new int[4];
        DrawingArea.method1207(var6);
        DrawingArea.clip(var1, var2, var1 + var3, var2 + var4);
        DrawingArea.method1223(var1, var2, var3, var4, -16777216);
        int var7 = this.aClass190_2229.method1308();
        if (var7 < 100) {
            this.method1304(var1, var2, var3, var4, var7);
        } else {
            if (!this.aClass7_2217.method34()) {
                this.aClass7_2217.method35(this.table, this.aWorldMapTransportation_2234.getFileName(), Client.membersWorld);
                if (!this.aClass7_2217.method34()) {
                    return;
                }
            }

            if (this.aHashSet2224 != null) {
                ++this.anInt2218;
                if (this.anInt2218 % this.anInt2209 == 0) {
                    this.anInt2218 = 0;
                    ++this.anInt2216;
                }

                if (this.anInt2216 >= this.anInt2235 && !this.aBoolean2207) {
                    this.aHashSet2224 = null;
                }
            }

            int var8 = (int) Math.ceil((double) ((float) var3 / this.defaultScale));
            int var9 = (int) Math.ceil((double) ((float) var4 / this.defaultScale));
            this.aClass7_2217.method30(this.anInt2220 - var8 / 2, this.anInt2212 - var9 / 2, var8 / 2 + this.anInt2220, var9 / 2 + this.anInt2212, var1, var2, var1 + var3, var4 + var2);
            if (!this.aBoolean2237) {
                boolean var10 = false;
                if (var5 - this.anInt2214 > 100) {
                    this.anInt2214 = var5;
                    var10 = true;
                }

                this.aClass7_2217.method37(this.anInt2220 - var8 / 2, this.anInt2212 - var9 / 2, var8 / 2 + this.anInt2220, this.anInt2212 + var9 / 2, var1, var2, var3 + var1, var2 + var4, this.aHashSet2201, this.aHashSet2224, this.anInt2218, this.anInt2209, var10);
            }

            this.anInt2232 = var8;
            this.anInt2233 = var9;
            DrawingArea.method1213(var6);
        }
    }

    public void method1292(int var1, int var2, int var3, int var4) {
        if (this.aClass190_2229.method1309()) {
            if (!this.aClass7_2217.method34()) {
                this.aClass7_2217.method35(this.table, this.aWorldMapTransportation_2234.getFileName(), Client.membersWorld);
                if (!this.aClass7_2217.method34()) {
                    return;
                }
            }

            this.aClass7_2217.method40(var1, var2, var3, var4, this.aHashSet2224, this.anInt2218, this.anInt2209);
        }
    }

    public void method1287(int var1) {
        this.currentScale = this.method1285(var1);
    }

    void method1304(int var1, int var2, int var3, int var4, int var5) {
        byte var6 = 20;
        int var7 = var3 / 2 + var1;
        int var8 = var4 / 2 + var2 - 18 - var6;
        DrawingArea.method1223(var1, var2, var3, var4, -16777216);
        DrawingArea.drawRectangle(var7 - 152, var8, 304, 34, -65536);
        DrawingArea.method1223(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
        this.font_b12_full.method1161("Loading...", var7, var8 + var6, -1, -1);
    }

    float method1285(int var1) {
        if (var1 == 25) {
            return 1.0F;
        }
        if (var1 == 37) {
            return 1.5F;
        }
        if (var1 == 50) {
            return 2.0F;
        }
        if (var1 == 75) {
            return 3.0F;
        }
        return var1 == 100 ? 4.0F : 8.0F;
    }

    public int method1305() {
        if (1.0D == (double) this.currentScale) {
            return 25;
        }
        if (1.5D == (double) this.currentScale) {
            return 37;
        }
        if ((double) this.currentScale == 2.0D) {
            return 50;
        }
        if ((double) this.currentScale == 3.0D) {
            return 75;
        }
        return 4.0D == (double) this.currentScale ? 100 : 200;
    }

    public void method1301() {
        this.aClass190_2229.method1310();
    }

    public boolean method1274() {
        return this.aClass190_2229.method1309();
    }

    public void initialize(ReferenceTable table, Font b12_full, HashMap fonts, CompressedImage[] var4) {
        this.aCompressedImageArray2222 = var4;
        this.table = table;
        this.font_b12_full = b12_full;
        this.aHashMap2227 = new HashMap();
        this.aHashMap2227.put(Class77.aClass77_827, fonts.get(aClass180_2213));
        this.aHashMap2227.put(Class77.aClass77_837, fonts.get(aClass180_2210));
        this.aHashMap2227.put(Class77.aClass77_830, fonts.get(aClass180_2206));
        this.aClass190_2229 = new Class190(table);
        int var5 = this.table.method1084(Class10.aClass10_70.aString77);
        int[] var6 = this.table.method1087(var5);
        this.aHashMap2202 = new HashMap(var6.length);

        for (int var7 = 0; var7 < var6.length; ++var7) {
            Buffer var8 = new Buffer(this.table.unpack(var5, var6[var7]));
            WorldMapTransportation var9 = new WorldMapTransportation();
            var9.read(var8, var6[var7]);
            this.aHashMap2202.put(var9.getFileName(), var9);
            if (var9.isOnSurface()) {
                this.aWorldMapTransportation_2211 = var9;
            }
        }

        this.method1289(this.aWorldMapTransportation_2211);
        this.aWorldMapTransportation_2231 = null;
    }

    public void method1258(int var1, int var2) {
        if (this.aWorldMapTransportation_2234 != null && this.aWorldMapTransportation_2234.method79(var1, var2)) {
            this.anInt2208 = var1 - this.aWorldMapTransportation_2234.getMinX() * 64;
            this.anInt2236 = var2 - this.aWorldMapTransportation_2234.getMinY() * 64;
        }
    }

    public void method1263(int var1, int var2, int var3) {
        if (this.aWorldMapTransportation_2234 != null) {
            int[] var4 = this.aWorldMapTransportation_2234.method81(var1, var2, var3);
            if (var4 != null) {
                this.method1257(var4[0], var4[1]);
            }

        }
    }

    public int method1264() {
        return this.aWorldMapTransportation_2234 == null ? -1 : this.anInt2220 + this.aWorldMapTransportation_2234.getMinX() * 64;
    }

    public int method1254() {
        return this.aWorldMapTransportation_2234 == null ? -1 : this.anInt2212 + this.aWorldMapTransportation_2234.getMinY() * 64;
    }

    public SceneOffset method1265() {
        return this.aWorldMapTransportation_2234 == null ? null : this.aWorldMapTransportation_2234.method83(this.method1264(), this.method1254());
    }

    public int method1294() {
        return this.aWorldMapTransportation_2234 == null ? -1 : this.aWorldMapTransportation_2234.getFileId();
    }

    public void method1255(int var1) {
        if (var1 >= 1) {
            this.anInt2235 = var1;
        }

    }

    public void method1253() {
        this.anInt2235 = 3;
    }

    public void method1262() {
        this.anInt2209 = 50;
    }

    public void method1259(boolean var1) {
        this.aBoolean2207 = var1;
    }

    public void method1269(int var1) {
        this.aHashSet2224 = new HashSet();
        this.aHashSet2224.add(var1);
        this.anInt2216 = 0;
        this.anInt2218 = 0;
    }

    public void method1271(int var1) {
        this.aHashSet2224 = new HashSet();
        this.anInt2216 = 0;
        this.anInt2218 = 0;

        for (int var2 = 0; var2 < MapFunction.mapFunctions.length; ++var2) {
            if (MapFunction.mapFunctions[var2] != null && var1 == MapFunction.mapFunctions[var2].anInt236) {
                this.aHashSet2224.add(MapFunction.mapFunctions[var2].index);
            }
        }

    }

    public void method1266() {
        this.aHashSet2224 = null;
    }

    public void method1278(boolean var1) {
        this.aBoolean2237 = !var1;
    }

    public void method1261(int var1, boolean var2) {
        if (!var2) {
            this.aHashSet2228.add(var1);
        } else {
            this.aHashSet2228.remove(var1);
        }

        this.method1272();
    }

    public void method1275(int var1, boolean var2) {
        if (!var2) {
            this.aHashSet2223.add(var1);
        } else {
            this.aHashSet2223.remove(var1);
        }

        for (int var3 = 0; var3 < MapFunction.mapFunctions.length; ++var3) {
            if (MapFunction.mapFunctions[var3] != null && MapFunction.mapFunctions[var3].anInt236 == var1) {
                int var4 = MapFunction.mapFunctions[var3].index;
                if (!var2) {
                    this.aHashSet2205.add(var4);
                } else {
                    this.aHashSet2205.remove(var4);
                }
            }
        }

        this.method1272();
    }

    public boolean method1273() {
        return !this.aBoolean2237;
    }

    public boolean method1256(int var1) {
        return !this.aHashSet2223.contains(var1);
    }

    void method1272() {
        this.aHashSet2201.clear();
        this.aHashSet2201.addAll(this.aHashSet2228);
        this.aHashSet2201.addAll(this.aHashSet2205);
    }

    public void method1280(int var1, int var2, int var3, int var4, int var5, int var6) {
        if (this.aClass190_2229.method1309()) {
            int var7 = (int) Math.ceil((double) ((float) var3 / this.defaultScale));
            int var8 = (int) Math.ceil((double) ((float) var4 / this.defaultScale));
            List var9 = this.aClass7_2217.method31(this.anInt2220 - var7 / 2 - 1, this.anInt2212 - var8 / 2 - 1, this.anInt2220 + var7 / 2 + 1, var8 / 2 + this.anInt2212 + 1, var1, var2, var3, var4, var5, var6);
            if (!var9.isEmpty()) {
                Iterator var10 = var9.iterator();

                boolean var13;
                do {
                    if (!var10.hasNext()) {
                        return;
                    }

                    Class24 var11 = (Class24) var10.next();
                    MapFunction var12 = MapFunction.mapFunctions[var11.anInt160];
                    var13 = false;

                    for (int var14 = this.anIntArray2226.length - 1; var14 >= 0; --var14) {
                        if (var12.aStringArray2095[var14] != null) {
                            WorldMapTransportation_Sub1.method125(var12.aStringArray2095[var14], var12.aString2094, this.anIntArray2226[var14], var11.anInt160, var11.aSceneOffset_162.getHash(), var11.aSceneOffset_167.getHash());
                            var13 = true;
                        }
                    }
                } while (!var13);

            }
        }
    }

    public SceneOffset method1279(int var1, SceneOffset var2) {
        if (!this.aClass190_2229.method1309()) {
            return null;
        }
        if (!this.aClass7_2217.method34()) {
            return null;
        }
        if (!this.aWorldMapTransportation_2234.method79(var2.x, var2.y)) {
            return null;
        }
        HashMap var3 = this.aClass7_2217.method36();
        List var4 = (List) var3.get(var1);
        if (var4 != null && !var4.isEmpty()) {
            Class24 var5 = null;
            int var6 = -1;
            Iterator var7 = var4.iterator();

            while (true) {
                Class24 var8;
                int var11;
                do {
                    if (!var7.hasNext()) {
                        return var5.aSceneOffset_167;
                    }

                    var8 = (Class24) var7.next();
                    int var9 = var8.aSceneOffset_167.x - var2.x;
                    int var10 = var8.aSceneOffset_167.y - var2.y;
                    var11 = var9 * var9 + var10 * var10;
                    if (var11 == 0) {
                        return var8.aSceneOffset_167;
                    }
                } while (var11 >= var6 && var5 != null);

                var5 = var8;
                var6 = var11;
            }
        }
        return null;
    }

    public int method1270() {
        return this.anInt2232;
    }

    public boolean method1260(int var1) {
        return !this.aHashSet2228.contains(var1);
    }

    public Class24 method1282() {
        if (!this.aClass190_2229.method1309()) {
            return null;
        }
        if (!this.aClass7_2217.method34()) {
            return null;
        }
        HashMap var1 = this.aClass7_2217.method36();
        this.aList2230 = new java.util.LinkedList();
        Iterator var2 = var1.values().iterator();

        while (var2.hasNext()) {
            List var3 = (List) var2.next();
            this.aList2230.addAll(var3);
        }

        this.anIterator2221 = this.aList2230.iterator();
        return this.method1283();
    }

    public void method1281(int var1, int var2, SceneOffset var3, SceneOffset var4) {
        ScriptEvent var5 = new ScriptEvent();
        Class22 var6 = new Class22(var2, var3, var4);
        var5.method270(new Object[]{var6});
        switch (var1) {
            case 1008:
                var5.method274(Class147.aClass147_1812);
                break;
            case 1009:
                var5.method274(Class147.aClass147_1809);
                break;
            case 1010:
                var5.method274(Class147.aClass147_1804);
                break;
            case 1011:
                var5.method274(Class147.aClass147_1813);
                break;
            case 1012:
                var5.method274(Class147.aClass147_1814);
        }

        Class25.method174(var5);
    }

    boolean method1290() {
        return this.anInt2208 != -1 && this.anInt2236 != -1;
    }

    public int method1267() {
        return this.anInt2233;
    }

    public void method1277(int var1) {
        if (var1 >= 1) {
            this.anInt2209 = var1;
        }

    }

    public WorldMapTransportation method1276(int var1) {
        Iterator var2 = this.aHashMap2202.values().iterator();

        WorldMapTransportation var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = (WorldMapTransportation) var2.next();
        } while (var3.getFileId() != var1);

        return var3;
    }

    public void method1295(int var1, int var2, int var3, boolean var4) {
        WorldMapTransportation var5 = this.method1286(var1, var2, var3);
        if (var5 == null) {
            if (!var4) {
                return;
            }

            var5 = this.aWorldMapTransportation_2211;
        }

        boolean var6 = false;
        if (this.aWorldMapTransportation_2231 != var5 || var4) {
            this.aWorldMapTransportation_2231 = var5;
            this.method1289(var5);
            var6 = true;
        }

        if (var6 || var4) {
            this.method1291(var1, var2, var3);
        }

    }

    public void method1268(int var1, int var2, int var3) {
        if (this.aWorldMapTransportation_2234 != null) {
            int[] var4 = this.aWorldMapTransportation_2234.method81(var1, var2, var3);
            if (var4 != null) {
                this.method1258(var4[0], var4[1]);
            }

        }
    }

    void method1289(WorldMapTransportation var1) {
        if (this.aWorldMapTransportation_2234 == null || this.aWorldMapTransportation_2234 != var1) {
            this.method1302(var1);
            this.method1291(-1, -1, -1);
        }
    }

    public void method1299(WorldMapTransportation var1, SceneOffset var2, SceneOffset var3, boolean var4) {
        if (var1 != null) {
            if (this.aWorldMapTransportation_2234 == null || this.aWorldMapTransportation_2234 != var1) {
                this.method1302(var1);
            }

            if (!var4 && this.aWorldMapTransportation_2234.method65(var2.z, var2.x, var2.y)) {
                this.method1291(var2.z, var2.x, var2.y);
            } else {
                this.method1291(var3.z, var3.x, var3.y);
            }

        }
    }

    public void method1257(int var1, int var2) {
        if (this.aWorldMapTransportation_2234 != null) {
            this.anInt2220 = var1 - this.aWorldMapTransportation_2234.getMinX() * 64;
            this.anInt2212 = var2 - this.aWorldMapTransportation_2234.getMinY() * 64;
            this.anInt2208 = -1;
            this.anInt2236 = -1;
        }
    }
    
    public int getPercentLoaded() {
        return this.table.method1100(this.aWorldMapTransportation_2211.getFileName(), Class10.aClass10_71.aString77) ? 100 : this.table.method1086(this.aWorldMapTransportation_2211.getFileName());
    }
}
