package com.krry.common;

public class UUIDUtils {
    int UUID;
    public  int build(){
       int y=(int)((Math.random()*9+1)*100000);
        this.UUID=y;
        return y;
    }

    public int getUUID() {
        return UUID;
    }


}
