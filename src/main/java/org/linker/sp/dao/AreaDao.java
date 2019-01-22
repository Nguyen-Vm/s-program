package org.linker.sp.dao;

import org.linker.sp.entity.Area;

import java.util.List;

/**
 * @author RWM
 * @date 2018/5/23
 */
public interface AreaDao {
    List<Area> queryAreas();

    Area queryById(int areaId);

    int insertArea(Area area);

    int updateArea(Area area);

    int deleteArea(int areaId);

    void insertBatch(List<Area> areas);
}
