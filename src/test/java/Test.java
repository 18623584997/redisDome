import entity.Activity;
import util.JedisUtil;
import util.SerializeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/10.
 */
public class Test {

    @org.junit.Test
    public void test(){
        StringBuilder builder = new StringBuilder("this is a book");
        int j = 0;
        for (int i = 0; i <builder.length() ; i++) {

            char temp = builder.charAt(builder.length()-1);
            builder.deleteCharAt(builder.length()-1);
            if(temp == ' '){
                builder.insert(i,' ');
                j=i+1;
            }else{
                builder.insert(j,temp);

            }



        }
        //builder.delete(j+1,builder.length());

        System.out.println(builder);
    }

    @org.junit.Test
    public void test2(){
        StringBuilder s = new StringBuilder("this is a book");
        int j=s.length();
        for(int i=0;i<s.length();i++){
            if(s.charAt(0)==' '){
                j=s.length()-i-1;
                s.delete(0, 1);
                s.insert(j, ' ');
            }else{
                char temp=s.charAt(0);
                s.delete(0, 1);
                s.insert(j-1, temp);
            }
        }
        System.out.println(s);
    }

    @org.junit.Test
    public void test3(){
        String key  = "activity";
        JedisUtil j = JedisUtil.getInstance();
        Activity activity = new Activity();
        j.LISTS.rpush(key.getBytes(), SerializeUtil.serialize(activity));
        j.LISTS.rpush(key.getBytes(), SerializeUtil.serialize(activity));
        j.LISTS.rpush(key.getBytes(), SerializeUtil.serialize(activity));
        j.LISTS.rpush(key.getBytes(), SerializeUtil.serialize(activity));
        System.out.println(j.LISTS.llen(key.getBytes()));

    }


    @org.junit.Test
    public void test4(){
        JedisUtil j = JedisUtil.getInstance();
        String key  = "activity";
        j.LISTS.lpop(key.getBytes());
        System.out.println(j.LISTS.llen(key.getBytes()));

    }
}
