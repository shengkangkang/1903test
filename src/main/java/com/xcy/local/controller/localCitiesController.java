package com.xcy.local.controller;

import com.xcy.local.dao.localCitiesMapper;
import com.xcy.local.pojo.localCities;
import com.xcy.local.service.localCitiesService;
import com.xcy.local.utils.JedisClient;
import com.xcy.local.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class localCitiesController {

    @Autowired
    private JedisClient jedisClient;

    @Autowired
    localCitiesMapper localCitiesMapper;
    @RequestMapping("/getProvince")
    @ResponseBody
    public List<localCities> selectAllProvince(){
        List<localCities> citiesList = null;
        Boolean isExists = jedisClient.exists("PROVINCE");
        if (isExists){
            String str = jedisClient.get("PROVINCE");
            citiesList = JsonUtils.jsonToList(str,localCities.class);
        } else {
            citiesList = localCitiesMapper.selectAllProvince();
            jedisClient.set("PROVINCE",JsonUtils.objectToJson(citiesList));
        }

        return citiesList;
    }

    @RequestMapping("/getCity")
    @ResponseBody
    public List<localCities> selectAllCity(int id){
        List<localCities> citiesList = null;
        boolean isExists = jedisClient.exists("CITY");
        if (isExists){
            String str = jedisClient.get("CITY");
            citiesList = JsonUtils.jsonToList(str,localCities.class);
        }else {
            citiesList = localCitiesMapper.selectAllCity(id);
            jedisClient.set("CITY",JsonUtils.objectToJson(citiesList));
        }
        return citiesList;
    }

    @RequestMapping("/getCounty")
    @ResponseBody
    public List<localCities> selectAllCounty(int id){
        List<localCities> citiesList = null;
        boolean isExists = jedisClient.exists("COUNTY");
        if (isExists){
            String str = jedisClient.get("COUNTY");
            citiesList = JsonUtils.jsonToList(str,localCities.class);
        }else {
            citiesList = localCitiesMapper.selectAllCounty(id);
            jedisClient.set("COUNTY",JsonUtils.objectToJson(citiesList));
        }
        return citiesList;
    }

}
