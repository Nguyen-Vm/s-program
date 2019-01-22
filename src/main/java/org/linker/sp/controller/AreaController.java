package org.linker.sp.controller;

import com.google.common.collect.Lists;
import org.linker.sp.entity.Area;
import org.linker.sp.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RWM
 * @date 2018/5/23
 */
@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private Map<String, Object> listArea(){
        Map<String, Object> modelMap = new HashMap<>();
        List<Area> areaList = areaService.getAreaList();
        modelMap.put("list", areaList);
        return modelMap;
    }

    @RequestMapping(value = "/get/{areaId}", method = RequestMethod.GET)
    private Map<String, Object> getAreaById(@PathVariable("areaId") Integer areaId){
        Map<String, Object> modelMap = new HashMap<>();
        Area area = areaService.getAreaById(areaId);
        modelMap.put("area", area);
        return modelMap;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    private Map<String, Object> insertArea(@RequestBody Area area){
        Map<String, Object> modelMap = new HashMap<>();
        boolean result = areaService.addArea(area);
        modelMap.put("result", result);
        return modelMap;
    }

    @RequestMapping(value = "insertBatch", method = RequestMethod.GET)
    private long insertBatch(@RequestParam int n) {
        long start = System.currentTimeMillis();
        List<Area> areas=Lists.newArrayList();
        for (int i = 0; i < n; i++) {
            areas.add(new Area(i+"", i));
        }
        areaService.insertBatch(areas);
        long end = System.currentTimeMillis();
        return end - start;
    }

    @RequestMapping(value = "insertForeach", method = RequestMethod.GET)
    private long insertForeach(@RequestParam int n) {
        long start = System.currentTimeMillis();
        List<Area> areas=Lists.newArrayList();
        for (int i = 0; i < n; i++) {
            areas.add(new Area(i+"", i));
        }
        areaService.insertForeach(areas);
        long end = System.currentTimeMillis();
        return end - start;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    private Map<String, Object> updateArea(@RequestBody Area area){
        Map<String, Object> modelMap = new HashMap<>();
        boolean result = areaService.modifyArea(area);
        modelMap.put("result", result);
        return modelMap;
    }

    @RequestMapping(value = "/delete/{areaId}", method = RequestMethod.GET)
    private Map<String, Object> deleteArea(@PathVariable("areaId") Integer areaId){
        Map<String, Object> modelMap = new HashMap<>();
        boolean result = areaService.deleteArea(areaId);
        modelMap.put("result", result);
        return modelMap;
    }

}
