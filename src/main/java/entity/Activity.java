package entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/9.
 */
public class Activity implements Serializable {

    private String id;
    private String name;
    private int count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}