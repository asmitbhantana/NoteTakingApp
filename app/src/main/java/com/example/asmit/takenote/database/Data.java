package com.example.asmit.takenote.database;

import java.util.UUID;

/**
 * Created by asmit on 9/10/17.
 */

public class Data {

    private String Title;
    private String Desc;
    private UUID uuid;

    public Data()
    {
        setUuid(UUID.randomUUID());
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public UUID getUuid() {
        return uuid;
    }

    private void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
