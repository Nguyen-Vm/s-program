package org.linker.sp.service;

import org.linker.sp.entity.Area;

import java.util.List;

public interface AreaService {
    List<Area> getAreaList();

    Area getAreaById(int areaId);

    boolean addArea(Area area);

    boolean modifyArea(Area area);

    boolean deleteArea(int areaId);

    void insertBatch(List<Area> areas);

    void insertForeach(List<Area> areas);
}
