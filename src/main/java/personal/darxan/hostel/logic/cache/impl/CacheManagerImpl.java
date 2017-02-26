package personal.darxan.hostel.logic.cache.impl;

import org.springframework.stereotype.Component;
import personal.darxan.hostel.logic.cache.interf.CacheManager;

import java.util.Map;

/**
 * Created by darxan on 2017/2/17.
 */
@Component
public class CacheManagerImpl implements CacheManager {

    private Map<Object,Object> map;

    public CacheManagerImpl(){}

    public Object get(Object object) { return map.get(object);}

    public Object put(Object key, Object value){ return map.put(key, value);}

}
