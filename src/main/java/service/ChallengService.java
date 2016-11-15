package service;

import entity.Activity;
import org.springframework.stereotype.Service;
import util.JedisUtil;
import util.SerializeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Created by Administrator on 2016/11/9.
 */
@Service
public class ChallengService {
    public static String ACTIVITY = "activity";
    public JedisUtil jedisUtil = JedisUtil.getInstance();

    public void start(Activity activity){
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        activity.setId(id);
        Long count = 0l;
        count  = jedisUtil.LISTS.llen(ACTIVITY.getBytes());
        System.out.println(jedisUtil.LISTS.rpush(ACTIVITY.getBytes(),SerializeUtil.serialize(activity)));



    }


    public  void action(){
        String start = jedisUtil.getJedis().get(ACTIVITY);
    }


    public  Activity getActivity(){
       return null;
    }

    public List<Activity> getAllActivity(){
        List<byte[]> blist = jedisUtil.LISTS.lrange(ACTIVITY.getBytes(),1,-1);
        List<Activity> list = new ArrayList<>();
        for (int i = 0; i <blist.size() ; i++) {
            list.add((Activity) SerializeUtil.unserialize(blist.get(i)));
        }

        return list;
    }
}
